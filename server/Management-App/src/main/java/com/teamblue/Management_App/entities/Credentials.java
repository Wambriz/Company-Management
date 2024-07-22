package com.teamblue.Management_App.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable 
@NoArgsConstructor
@Data
public class Credentials {
    private String username;
    private String password;
}
