package com.teamblue.Management_App.services;

import com.teamblue.Management_App.dtos.*;
import java.util.List;

public interface CompanyService {
    List<FullUserDto> getActiveUsersByCompanyId(Long companyId);
	AnnouncementDto createAnnouncement(Long id, AnnouncementRequestDto announcementRequestDto);
	List<AnnouncementDto> getAllCompanyAnnouncements(Long id);
	List<CompanyDto> getAllCompanies();
	List<FullUserDto> getUsersByCompanyId(long id);
	List<ProjectDto> getCompanyTeamProjects(long comp_id, long team_id);
	CompanyDto getCompanyById(Long id);

  ProjectDto updateProject(Long companyId, Long teamId, ProjectDto projectDto);

}

