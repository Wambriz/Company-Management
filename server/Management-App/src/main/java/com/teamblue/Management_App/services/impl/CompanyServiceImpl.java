package com.teamblue.Management_App.services.impl;

import com.teamblue.Management_App.dtos.AnnouncementDto;
import com.teamblue.Management_App.dtos.AnnouncementRequestDto;
import com.teamblue.Management_App.dtos.CompanyDto;
import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.entities.Announcements;
import com.teamblue.Management_App.entities.Company;
import com.teamblue.Management_App.entities.User;
import com.teamblue.Management_App.exception.BadRequestException;
import com.teamblue.Management_App.mappers.AnnouncementMapper;
import com.teamblue.Management_App.mappers.CompanyMapper;
import com.teamblue.Management_App.mappers.UserMapper;
import com.teamblue.Management_App.repositories.AnnouncementsRepository;
import com.teamblue.Management_App.repositories.CompanyRepository;
import com.teamblue.Management_App.repositories.UserRepository;
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
        return userMapper.entitiesToDtos(userRepository.findUsersByCompanyId(id));
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
}

