package com.teamblue.Management_App.services.impl;

import com.teamblue.Management_App.dtos.CredentialsDto;
import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.entities.User;
import com.teamblue.Management_App.mappers.UserMapper;
import com.teamblue.Management_App.repositories.UserRepository;
import com.teamblue.Management_App.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public FullUserDto login(CredentialsDto credentialsDto) {
    	System.out.println("CREDS: "+ credentialsDto + credentialsDto.getUsername());
        User user = userRepository.findByCredentialsUsername(credentialsDto.getUsername());
        System.out.println("ASSIGNED TO USER: "+ userRepository.findByCredentialsUsername(credentialsDto.getUsername()));
        if (user == null || !user.getCredentials().getPassword().equals(credentialsDto.getPassword()) || !user.getActive()) {
            throw new IllegalArgumentException("Invalid credentials or inactive user");
        }
        System.out.println("USER:");
        System.out.println(user);
        System.out.println(userMapper.entityToDto(user));
        return userMapper.entityToDto(user);

    }
}


