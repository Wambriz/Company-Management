
package com.teamblue.Management_App.services;

import com.teamblue.Management_App.dtos.AnnouncementDto;
import com.teamblue.Management_App.dtos.AnnouncementRequestDto;
import com.teamblue.Management_App.dtos.CompanyDto;
import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.dtos.ProjectDto;

import java.util.List;

public interface CompanyService {
    List<FullUserDto> getActiveUsersByCompanyId(Long companyId);
	AnnouncementDto createAnnouncement(Long id, AnnouncementRequestDto announcementRequestDto);
	List<AnnouncementDto> getAllCompanyAnnouncements(Long id);
	List<CompanyDto> getAllCompanies();
	List<FullUserDto> getUsersByCompanyId(long id);
	List<ProjectDto> getCompanyTeamProjects(long comp_id, long team_id);
	CompanyDto getCompanyById(Long id);
}

