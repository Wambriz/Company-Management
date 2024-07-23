package com.teamblue.Management_App.services;

import com.teamblue.Management_App.dtos.CredentialsDto;
import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.entities.Credentials;

public interface UserService {
    public FullUserDto login(CredentialsDto credentialsDto);
}
