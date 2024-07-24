package com.teamblue.Management_App.services.impl;

import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.entities.Company;
import com.teamblue.Management_App.entities.User;
import com.teamblue.Management_App.mappers.UserMapper;
import com.teamblue.Management_App.repositories.CompanyRepository;
import com.teamblue.Management_App.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final UserMapper userMapper;

    @Override
    public List<FullUserDto> getActiveUsersByCompanyId(Long companyId) {
        // Retrieve the company by its ID or throw an exception if not found
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));

        // Get all users from all teams associated with the company
        List<User> users = company.getTeams().stream()
                .flatMap(team -> team.getUsers().stream())
                .filter(User::getActive) // Filter out inactive users
                .collect(Collectors.toList());

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
}

