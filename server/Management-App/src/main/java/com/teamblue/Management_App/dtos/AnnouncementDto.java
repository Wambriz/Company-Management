package com.teamblue.Management_App.dtos;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDto {
	
	@NonNull
	private Long id;
	
	@NonNull
    private Timestamp date;
	
	@NonNull
    private String title;
	
    private String message;
    
    @NonNull
    private BasicUserDto author;
}
