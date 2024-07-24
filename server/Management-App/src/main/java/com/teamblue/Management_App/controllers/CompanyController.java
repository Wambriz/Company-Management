package com.teamblue.Management_App.controllers;

import java.util.List;

import com.teamblue.Management_App.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    // TODO: ENDPOINTS
}
