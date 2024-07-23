package com.teamblue.Management_App.controllers;

import java.util.List;

import com.teamblue.Management_App.dtos.CredentialsDto;
import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.entities.Credentials;
import com.teamblue.Management_App.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<FullUserDto> login(@RequestBody CredentialsDto credentialsDto) {
        FullUserDto user = userService.login(credentialsDto);
        return ResponseEntity.ok(user);
    }
}
