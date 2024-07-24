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

    @Autowired
    private UserCompanyRepository userCompanyRepository;

    @Override
    public void run(String... args) throws Exception {
        seedUsers();
        seedCompanies();
        seedTeams();
        seedProjects();
        seedAnnouncements();
        seedUserCompanies();
    }

    private void seedUsers() {
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
        user1.setAdmin(false);
        user1.setStatus("active");

        User user2 = new User();
        Credentials creds2 = new Credentials();
        creds2.setUsername("jane.doe@example.com");
        creds2.setPassword("password123");

        Profile p2 = new Profile();
        p2.setFirstname("Jane");
        p2.setLastname("Doe");
        p2.setEmail("jane.doe@example.com");
        p2.setPhone("098-765-4321");

        user2.setCredentials(creds2);
        user2.setProfile(p2);
        user2.setActive(true);
        user2.setAdmin(true);
        user2.setStatus("active");

        User user3 = new User();
        Credentials creds3 = new Credentials();
        creds3.setUsername("alice.smith@example.com");
        creds3.setPassword("password123");

        Profile p3 = new Profile();
        p3.setFirstname("Alice");
        p3.setLastname("Smith");
        p3.setEmail("alice.smith@example.com");
        p3.setPhone("456-789-0123");

        user3.setCredentials(creds3);
        user3.setProfile(p3);
        user3.setActive(true);
        user3.setAdmin(false);
        user3.setStatus("active");

        userRepository.saveAll(List.of(user1, user2, user3));
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
        Company company1 = companyRepository.findByName("Tech Corp");
        Company company2 = companyRepository.findByName("Innovate Inc");

        Team team1 = new Team();
        team1.setName("Development Team");
        team1.setDescription("Handles all development tasks");
        team1.setCompany(company1);

        Team team2 = new Team();
        team2.setName("Marketing Team");
        team2.setDescription("Handles all marketing tasks");
        team2.setCompany(company1);

        Team team3 = new Team();
        team3.setName("Innovation Team");
        team3.setDescription("Handles all innovation tasks");
        team3.setCompany(company2);

        teamRepository.saveAll(List.of(team1, team2, team3));

        // Assign users to teams
        User user1 = userRepository.findByCredentialsUsername("john.doe@example.com");
        User user2 = userRepository.findByCredentialsUsername("jane.doe@example.com");
        User user3 = userRepository.findByCredentialsUsername("alice.smith@example.com");

        team1.setUsers(List.of(user1));
        team2.setUsers(List.of(user2));
        team3.setUsers(List.of(user3));

        teamRepository.saveAll(List.of(team1, team2, team3));

        // Assign teams to users
        user1.setTeams(List.of(team1));
        user2.setTeams(List.of(team2));
        user3.setTeams(List.of(team3));

        userRepository.saveAll(List.of(user1, user2, user3));
    }

    private void seedProjects() {
        Team team1 = teamRepository.findByName("Development Team");
        Team team2 = teamRepository.findByName("Marketing Team");
        Team team3 = teamRepository.findByName("Innovation Team");

        Project project1 = new Project();
        project1.setName("Project Alpha");
        project1.setDescription("The first project");
        project1.setActive(true);
        project1.setTeam(team1);

        Project project2 = new Project();
        project2.setName("Project Beta");
        project2.setDescription("The second project");
        project2.setActive(true);
        project2.setTeam(team2);

        Project project3 = new Project();
        project3.setName("Project Gamma");
        project3.setDescription("The third project");
        project3.setActive(true);
        project3.setTeam(team3);

        projectRepository.saveAll(List.of(project1, project2, project3));
    }

    private void seedAnnouncements() {
        Company company1 = companyRepository.findByName("Tech Corp");
        Company company2 = companyRepository.findByName("Innovate Inc");
        User author1 = userRepository.findByCredentialsUsername("john.doe@example.com");
        User author2 = userRepository.findByCredentialsUsername("alice.smith@example.com");

        Announcements announcement1 = new Announcements();
        announcement1.setDate(new Timestamp(System.currentTimeMillis()));
        announcement1.setTitle("Welcome");
        announcement1.setMessage("Welcome to the company!");
        announcement1.setCompany(company1);
        announcement1.setAuthor(author1);

        Announcements announcement2 = new Announcements();
        announcement2.setDate(new Timestamp(System.currentTimeMillis()));
        announcement2.setTitle("Meeting");
        announcement2.setMessage("All hands meeting tomorrow.");
        announcement2.setCompany(company1);
        announcement2.setAuthor(author1);

        Announcements announcement3 = new Announcements();
        announcement3.setDate(new Timestamp(System.currentTimeMillis()));
        announcement3.setTitle("Innovation Sprint");
        announcement3.setMessage("Join the innovation sprint next week.");
        announcement3.setCompany(company2);
        announcement3.setAuthor(author2);

        announcementsRepository.saveAll(List.of(announcement1, announcement2, announcement3));
    }

    private void seedUserCompanies() {
        Company company1 = companyRepository.findByName("Tech Corp");
        Company company2 = companyRepository.findByName("Innovate Inc");
        User user1 = userRepository.findByCredentialsUsername("john.doe@example.com");
        User user2 = userRepository.findByCredentialsUsername("jane.doe@example.com");
        User user3 = userRepository.findByCredentialsUsername("alice.smith@example.com");

        UserCompany userCompany1 = new UserCompany();
        userCompany1.setUser(user1);
        userCompany1.setCompany(company1);

        UserCompany userCompany2 = new UserCompany();
        userCompany2.setUser(user2);
        userCompany2.setCompany(company1);

        UserCompany userCompany3 = new UserCompany();
        userCompany3.setUser(user3);
        userCompany3.setCompany(company2);

        userCompanyRepository.saveAll(List.of(userCompany1, userCompany2, userCompany3));
    }
}


