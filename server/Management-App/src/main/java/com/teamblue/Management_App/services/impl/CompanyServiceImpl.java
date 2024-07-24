package com.teamblue.Management_App.services.impl;

import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.mappers.UserMapper;
import com.teamblue.Management_App.repositories.CompanyRepository;
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

    @Override
    public List<FullUserDto> getUsersByCompanyId(long id) {
        System.out.println("Made a call to CompanyServiceImpl");
        return userMapper.entitiesToDtos(userRepository.findUsersByCompanyId(id));
    }
}
