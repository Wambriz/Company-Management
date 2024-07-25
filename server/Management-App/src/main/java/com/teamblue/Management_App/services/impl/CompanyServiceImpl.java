package com.teamblue.Management_App.services.impl;

import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.dtos.TeamDto;
import com.teamblue.Management_App.dtos.TeamRequestDto;
import com.teamblue.Management_App.entities.Company;
import com.teamblue.Management_App.entities.Team;
import com.teamblue.Management_App.mappers.TeamMapper;
import com.teamblue.Management_App.mappers.UserMapper;
import com.teamblue.Management_App.repositories.CompanyRepository;
import com.teamblue.Management_App.repositories.TeamRepository;
import com.teamblue.Management_App.repositories.UserRepository;
import com.teamblue.Management_App.services.CompanyService;
import com.teamblue.Management_App.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final CompanyRepository companyRepository;

    @Override
    public List<FullUserDto> getUsersByCompanyId(long id) {
        System.out.println("Made a call to CompanyServiceImpl");
        return userMapper.entitiesToDtos(userRepository.findUsersByCompanyId(id));
    }

	@Override
	public List<TeamDto> getTeamsByCompanyId(long id) { //Service method to get a company's teams
		//Return a List of TeamDto, which is grabbed from the database, using JPA DerivedQuery
		return teamMapper.entitiesToDtos(teamRepository.findTeamsByCompanyId(id));
	}

    @Override
    public TeamDto createTeam(long companyId, TeamRequestDto newTeam) {
        //First, create a Team entity with TeamRequestDto
        Team newTeamEntity = teamMapper.RequestDtoToEntity(newTeam);

        //Second: Flesh out Entity by assigning it a Company entity
        Company teamCompany = companyRepository.findById(companyId).get(); //Get the company via the ID
        newTeamEntity.setCompany(teamCompany); //Set the company to this entity to establish the relationship

        //Third, Save entity into the DB
        Team savedTeam = teamRepository.saveAndFlush(newTeamEntity);
        return teamMapper.entityToDto(savedTeam);//Return the TeamDto we just pushed up (it will now include the ID)
    }
}
