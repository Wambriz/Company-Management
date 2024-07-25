package com.teamblue.Management_App.services.impl;

import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.dtos.UserRequestDto;
import com.teamblue.Management_App.entities.User;
import com.teamblue.Management_App.mappers.UserMapper;
import com.teamblue.Management_App.repositories.CompanyRepository;
import com.teamblue.Management_App.repositories.UserRepository;
import com.teamblue.Management_App.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final UserMapper userMapper;

    @Override
    public List<FullUserDto> getUsersByCompanyId(long id) {
        return userMapper.entitiesToDtos(userRepository.findUsersByCompanyId(id));
    }

    @Override
    public void createUserByCompanyId(long id, UserRequestDto userRequestDto) {
        System.out.println("A call was made to the Service");
        System.out.println("userRequestDto: " + userRequestDto);
        User newUser = userMapper.UserRequestDtoToEntity(userRequestDto);
        System.out.println("newUser: " + newUser);
        newUser.setCompanies(List.of(companyRepository.findById(id)));
        newUser.setStatus("JOINED");
        newUser.setActive(true);
        userRepository.saveAndFlush(newUser);
    }
}
