package com.teamblue.Management_App.controllers;

import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.dtos.UserRequestDto;
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

    @PostMapping("/{id}/user")
    public void createUserByCompanyId(@PathVariable long id, @RequestBody UserRequestDto userRequestDto) {
        System.out.println("A call was made to the controller.");
        companyService.createUserByCompanyId(id, userRequestDto);
    }


}
