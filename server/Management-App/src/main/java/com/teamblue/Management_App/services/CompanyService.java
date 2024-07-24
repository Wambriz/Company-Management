package com.teamblue.Management_App.services;

import com.teamblue.Management_App.dtos.FullUserDto;

import java.util.List;

public interface CompanyService {
    List<FullUserDto> getActiveUsersByCompanyId(Long companyId);
}
