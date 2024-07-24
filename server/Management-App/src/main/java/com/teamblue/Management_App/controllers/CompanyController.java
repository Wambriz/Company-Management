package com.teamblue.Management_App.controllers;

import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.dtos.TeamDto;
import com.teamblue.Management_App.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/{id}/users")
    public List<FullUserDto> getUsersByCompanyId(@PathVariable long id) {
        System.out.println("Made a call to CompanyController");
        return companyService.getUsersByCompanyId(id);
    }
    
    @GetMapping("/{id}/teams")
    public List<TeamDto> getTeamsByCompanyId(@PathVariable long id) { //Get Teams using company id path variable
        System.out.println("Made a call to CompanyController");
        
        //Return List of TeamDto
        return companyService.getTeamsByCompanyId(id);
    }


}
