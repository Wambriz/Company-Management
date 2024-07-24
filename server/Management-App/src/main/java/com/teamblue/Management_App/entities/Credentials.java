package com.teamblue.Management_App.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Embeddable
@Data
@NoArgsConstructor
public class Credentials {
	
	@NonNull
    private String username;
	
	@NonNull
    private String password;
}
