package com.teamblue.Management_App.controllers;

import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/{id}/users")
    public List<FullUserDto> getUsersByCompany(@PathVariable Long id) {
        return companyService.getActiveUsersByCompanyId(id);
    }
}

