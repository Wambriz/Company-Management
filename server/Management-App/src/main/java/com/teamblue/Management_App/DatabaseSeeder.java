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
        seedCompanies();
        seedUsers();
        seedTeams();
        seedProjects();
        seedAnnouncements();
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

    private void seedUsers() {
        Company company1 = companyRepository.findByName("Tech Corp");
        Company company2 = companyRepository.findByName("Innovate Inc");

        User user1 = new User();
        Credentials creds1 = new Credentials();
        creds1.setUsername("john.doe@example.com");
        creds1.setPassword("password123");
        user1.setCredentials(creds1);
        Profile p1 = new Profile();
        p1.setFirstname("John");
        p1.setLastname("Doe");
        p1.setEmail("john.doe@example.com");
        p1.setPhone("123-456-7890");
        user1.setProfile(p1);
        user1.setActive(true);
        user1.setIsAdmin(false);
        user1.setStatus("active");
        user1.setCompanies(List.of(company1));

        User user2 = new User();
        Credentials creds2 = new Credentials();
        creds2.setUsername("jane.doe@example.com");
        creds2.setPassword("password123");
        user2.setCredentials(creds2);
        Profile p2 = new Profile();
        p2.setFirstname(" Jane");
        p2.setLastname("Doe");
        p2.setEmail("jane.doe@example.com");
        p2.setPhone("098-765-4321");
        user2.setProfile(p2);
        user2.setActive(true);
        user2.setIsAdmin(true);
        user2.setStatus("active");
        user2.setCompanies(List.of(company1, company2));

        userRepository.saveAll(List.of(user1, user2));
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
//        announcement1.setDate(new Timestamp(System.currentTimeMillis()));
        announcement1.setTitle("Welcome");
        announcement1.setMessage("Welcome to the company!");

        Announcements announcement2 = new Announcements();
//        announcement2.setDate(new Timestamp(System.currentTimeMillis()));
        announcement2.setTitle("Meeting");
        announcement2.setMessage("All hands meeting tomorrow.");

        announcementsRepository.saveAll(List.of(announcement1, announcement2));
    }

}

