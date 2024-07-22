package com.teamblue.Management_App.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "user_table")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String first;
    private String last;
    private String email;
    private String phone;
    private Boolean active;
    private Boolean admin;
    private String status;

    @OneToMany(mappedBy = "author")
    private Set<Announcements> announcements;

    @OneToMany(mappedBy = "user")
    private Set<UserCompany> userCompanies;

    @ManyToMany
    @JoinTable(
            name = "user_team_table",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private Set<Team> teams;
}

