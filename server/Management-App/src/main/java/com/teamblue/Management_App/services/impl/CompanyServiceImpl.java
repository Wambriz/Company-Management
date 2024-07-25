package com.teamblue.Management_App.services.impl;

import com.teamblue.Management_App.dtos.*;
import com.teamblue.Management_App.entities.*;
import com.teamblue.Management_App.exception.BadRequestException;
import com.teamblue.Management_App.mappers.AnnouncementMapper;
import com.teamblue.Management_App.mappers.CompanyMapper;
import com.teamblue.Management_App.mappers.ProjectMapper;
import com.teamblue.Management_App.mappers.UserMapper;
import com.teamblue.Management_App.repositories.*;
import com.teamblue.Management_App.services.CompanyService;
import com.teamblue.Management_App.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final UserMapper userMapper;
    private final AnnouncementMapper announcementMapper;
    private final AnnouncementsRepository announcementRepository;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public List<FullUserDto> getActiveUsersByCompanyId(Long companyId) {
        // Retrieve the company by its ID or throw an exception if not found
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));

        // Get all users from all teams associated with the company
        List<User> users = company.getTeams().stream()
                .flatMap(team -> team.getUsers().stream())
                .filter(User::getActive) // Filter out inactive users
                .toList();

        // Convert the list of User entities to a list of FullUserDto objects
        return users.stream()
                .map(user -> {
                    // Map the User entity to FullUserDto
                    FullUserDto dto = userMapper.entityToDto(user);
                    // Set the companies field to an empty list
                    dto.setCompanies(List.of());
                    return dto;
                })
                .collect(Collectors.toList());
    }
  
    @Override
    public List<FullUserDto> getUsersByCompanyId(long id) {
        System.out.println("Made a call to CompanyServiceImpl");
        return userMapper.entitiesToFullUserDtos(userRepository.findUsersByCompanyId(id));
    }

    @Override
    public List<AnnouncementDto> getAllCompanyAnnouncements(Long id){
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));
        if (!company.getActive()) {
            throw new BadRequestException("Company is not active");
        }
        List<Announcements> announcements = company.getAnnouncements();
        return announcementMapper.entitiesToDtos(announcements);

    }

    @Override
    public List<CompanyDto> getAllCompanies(){
        return companyMapper.dtosToEntities(companyRepository.findAll());
    }


    @Override
    public AnnouncementDto createAnnouncement(Long id, AnnouncementRequestDto announcementRequestDto) {
        // Find company by id
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));
        if (!company.getActive()) {
            throw new BadRequestException("Company is not active");
        }
        // Create new announcement object
        Announcements announce = announcementMapper.dtoToEntity(announcementRequestDto);
        announce.setCompany(company);
        announce.setIsDeleted(false);

        // Set the author from the user repository
        User author = userRepository.findById(announcementRequestDto.getAuthor().getId())
                .orElseThrow(() -> new IllegalArgumentException("Author not found"));
        announce.setAuthor(author);

        System.out.println("Announcement: " + announce);
        // Update and Save Company
        List<Announcements> companyAnnouncements = company.getAnnouncements();
        companyAnnouncements.add(announce);
        company.setAnnouncements(companyAnnouncements);
        companyRepository.saveAndFlush(company);

        return announcementMapper.entityToDto(announcementRepository.saveAndFlush(announce));
    }

    @Override
    public ProjectDto updateProject(Long companyId, Long teamId, ProjectDto projectDto) {
        // find company by ID
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new IllegalArgumentException("Company not found"));
        // find team by ID
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new IllegalArgumentException("Team not found"));

        // Ensure the team belongs to the company
        if (!company.getTeams().contains(team)) {
            throw new IllegalArgumentException("Team does not belong to the company");
        }

        // find project by id
        Project project = projectRepository.findById(projectDto.getId()).orElseThrow(() -> new IllegalArgumentException("Project not found"));

        // Ensure the project belongs to the team
        if (!team.getProjects().contains(project)) {
            throw new IllegalArgumentException("Project does not belong to the team");
        }

        // Update the project entity with the new details
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setActive(projectDto.getActive());

        // Save the updated project
        Project updatedProject = projectRepository.saveAndFlush(project);

        // Convert the updated project entity to ProjectDto
        return projectMapper.entityToDto(updatedProject);
    }
}

