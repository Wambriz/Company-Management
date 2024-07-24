package com.teamblue.Management_App.controllers;

import java.util.List;

import com.teamblue.Management_App.dtos.AnnouncementDto;
import com.teamblue.Management_App.dtos.AnnouncementRequestDto;
import com.teamblue.Management_App.dtos.CompanyDto;
import com.teamblue.Management_App.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    // TODO: ENDPOINTS
    @GetMapping
    public List<CompanyDto> getAllCompanies(){
    	return companyService.getAllCompanies();
    }
    
    @GetMapping("/@{id}/announcements")
    public List<AnnouncementDto> getAllCompanyAnnouncements(@PathVariable Long id){
    	return companyService.getAllCompanyAnnouncements(id);
    }
    
    @PostMapping("/@{id}/announcement")
    @ResponseStatus(HttpStatus.CREATED)
    public AnnouncementDto createAnnouncement(@PathVariable Long id, @RequestBody AnnouncementRequestDto announcementRequestDto) {
    	return companyService.createAnnouncement(id, announcementRequestDto);
    }
}
