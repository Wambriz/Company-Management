package com.teamblue.Management_App.services;

import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.dtos.UserRequestDto;

import java.util.List;

public interface CompanyService {

    List<FullUserDto> getUsersByCompanyId(long id);

    void createUserByCompanyId(long id, UserRequestDto userRequestDto);
}
