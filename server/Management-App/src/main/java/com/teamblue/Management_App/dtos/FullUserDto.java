package com.teamblue.Management_App.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullUserDto {
	@NonNull
	private Long id;
	
	@NonNull
	private ProfileDto profile;
	
	private Boolean isAdmin;
	private Boolean active;
    private String status;
    
    private CompanyDto[] companies;
    private TeamDto[] teams;
}
