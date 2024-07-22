package com.teamblue.Management_App.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
	
	@NonNull
    private Long id;

	@NonNull
    private String name;
    private String description;
    
    @NonNull
    private Boolean active;
    
    @NonNull
    private TeamDto team;
}
