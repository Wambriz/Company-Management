package com.teamblue.Management_App.dtos;

import lombok.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfileDto {
    
    private String firstName;
    private String lastName;
    private String phone;
    
    @NonNull
    private String email;
}
