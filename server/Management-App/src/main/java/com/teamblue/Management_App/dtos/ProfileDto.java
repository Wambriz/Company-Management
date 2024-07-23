package com.teamblue.Management_App.dtos;

import lombok.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfileDto {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
}
