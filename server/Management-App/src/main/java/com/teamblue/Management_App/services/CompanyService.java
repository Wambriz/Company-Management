package com.teamblue.Management_App.services;

import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.dtos.TeamDto;

import java.util.List;

public interface CompanyService {

    List<FullUserDto> getUsersByCompanyId(long id);

	List<TeamDto> getTeamsByCompanyId(long id); //New method to grab a teams of a company
}
