package com.teamblue.Management_App.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
	
	@NonNull
	private Long id;
	
	@NonNull
    private String name;
	
	@NonNull
    private String description;
	
	private TeamDto[] teams;
	
	private BasicUserDto[] users;
}
