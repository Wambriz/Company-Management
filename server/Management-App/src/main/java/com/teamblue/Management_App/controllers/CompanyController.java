package com.teamblue.Management_App.controllers;

import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.dtos.UserRequestDto;
import com.teamblue.Management_App.dtos.TeamDto;
import com.teamblue.Management_App.dtos.TeamRequestDto;
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
        return companyService.getUsersByCompanyId(id);
    }

    @GetMapping("/{id}/teams")
    public List<TeamDto> getTeamsByCompanyId(@PathVariable long id) { //Get Teams using company id path variable
        System.out.println("Made a call to CompanyController");

        //Return List of TeamDto
        return companyService.getTeamsByCompanyId(id);
    }

    @PostMapping("/{id}/user")
    public void createUserByCompanyId(@PathVariable long id, @RequestBody UserRequestDto userRequestDto) {
        System.out.println("A call was made to the controller.");
        companyService.createUserByCompanyId(id, userRequestDto);
    }

    @PostMapping("/{id}/team")
    public TeamDto createTeam(@PathVariable long id, @RequestBody TeamRequestDto newTeam) { //Put new team into DB
        //newTeam is the TeamRequestDto our frontend sends, captured with @RequestBody

        //Return the TeamDto of the Team entity we just saved
        return companyService.createTeam(id, newTeam);

    }


}
