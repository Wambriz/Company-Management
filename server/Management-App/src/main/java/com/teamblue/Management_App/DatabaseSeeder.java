package com.teamblue.Management_App;

import com.teamblue.Management_App.entities.*;
import com.teamblue.Management_App.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private AnnouncementsRepository announcementsRepository;

    @Override
    public void run(String... args) throws Exception {
        seedUsers();
        seedCompanies();
        seedTeams();
        seedProjects();
        seedAnnouncements();
    }

    private void seedUsers() {
        User user1 = new User();
        user1.setUsername("johndoe");
        user1.setPassword("password123");
        user1.setFirst("John");
        user1.setLast("Doe");
        user1.setEmail("john.doe@example.com");
        user1.setPhone("123-456-7890");
        user1.setActive(true);
        user1.setAdmin(false);
        user1.setStatus("active");

        User user2 = new User();
        user2.setUsername("janedoe");
        user2.setPassword("password123");
        user2.setFirst("Jane");
        user2.setLast("Doe");
        user2.setEmail("jane.doe@example.com");
        user2.setPhone("098-765-4321");
        user2.setActive(true);
        user2.setAdmin(true);
        user2.setStatus("active");

        userRepository.saveAll(List.of(user1, user2));
    }

    private void seedCompanies() {
        Company company1 = new Company();
        company1.setName("Tech Corp");
        company1.setDescription("A leading technology company");

        Company company2 = new Company();
        company2.setName("Innovate Inc");
        company2.setDescription("Innovating the future");

        companyRepository.saveAll(List.of(company1, company2));
    }

    private void seedTeams() {
        Team team1 = new Team();
        team1.setName("Development Team");
        team1.setDescription("Handles all development tasks");

        Team team2 = new Team();
        team2.setName("Marketing Team");
        team2.setDescription("Handles all marketing tasks");

        teamRepository.saveAll(List.of(team1, team2));
    }

    private void seedProjects() {
        Project project1 = new Project();
        project1.setName("Project Alpha");
        project1.setDescription("The first project");
        project1.setActive(true);

        Project project2 = new Project();
        project2.setName("Project Beta");
        project2.setDescription("The second project");
        project2.setActive(true);

        projectRepository.saveAll(List.of(project1, project2));
    }

    private void seedAnnouncements() {
        Announcements announcement1 = new Announcements();
        announcement1.setDate(new Timestamp(System.currentTimeMillis()));
        announcement1.setTitle("Welcome");
        announcement1.setMessage("Welcome to the company!");

        Announcements announcement2 = new Announcements();
        announcement2.setDate(new Timestamp(System.currentTimeMillis()));
        announcement2.setTitle("Meeting");
        announcement2.setMessage("All hands meeting tomorrow.");

        announcementsRepository.saveAll(List.of(announcement1, announcement2));
    }
}

