package com.teamblue.Management_App.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "company_table")
@Data
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "company")
    private Set<Announcements> announcements;

    @OneToMany(mappedBy = "company")
    private Set<Team> teams;
}

