package com.teamblue.Management_App.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean active;
    private boolean admin;
    private String status;

    // TODO: Map relationship to announcements
    // @OneToMany
    private Set<Announcements> announcements;

    // TODO: Map relationship to announcements
    // @OneToMany
    private Set<UserCompany> userCompanies;

    // TODO: Map many to many
    // @ManyToMany
    private Set<Team> teams;
}
