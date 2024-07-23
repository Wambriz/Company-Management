package com.teamblue.Management_App.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "user_table")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Credentials credentials;
    
    @Embedded
    private Profile profile;
    
//    private String username;
//    private String password;
//    private String first;
//    private String last;
//    private String email;
//    private String phone;
    private Boolean active;
    private Boolean admin;
    private String status;

    @OneToMany(mappedBy = "author")
    private List<Announcements> announcements;

    @OneToMany(mappedBy = "user")
    private List<UserCompany> userCompanies;

    @ManyToMany
    @JoinTable(
            name = "user_team_table",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private List<Team> teams;
}

