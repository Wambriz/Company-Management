package com.teamblue.Management_App;

import com.teamblue.Management_App.entities.*;
import com.teamblue.Management_App.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        company1.setName("Infinite Improbability Enterprises");
        company1.setDescription("Turning the Unthinkable into the Inevitable Since the Beginning of the Universe");

        Company company2 = new Company();
        company2.setName("Pan Galactic Solutions");
        company2.setDescription("Mixing the Perfect Blend of Logic and Lunacy for Your Everyday Needs.");

        Company company3 = new Company();
        company3.setName("Hitchhiker's Hitch Co.");
        company3.setDescription("Because the Answer to Everything is Always 42% Off.");

        Company company4 = new Company();
        company4.setName("Babel Communications Ltd.");
        company4.setDescription("Bridging Galaxies, One Babel Fish at a Time.");

        Company company5 = new Company();
        company5.setName("TowelTech Innovations");
        company5.setDescription("Don't Panic! We've Got You Covered, Literally.");

        companyRepository.saveAll(List.of(company1, company2, company3, company4, company5));
    }

    private void seedUsers() {
        Company company1 = companyRepository.findByName("Infinite Improbability Enterprises");
        Company company2 = companyRepository.findByName("Pan Galactic Solutions");
        Company company3 = companyRepository.findByName("Hitchhiker's Hitch Co.");
        Company company4 = companyRepository.findByName("Babel Communications Ltd.");
        Company company5 = companyRepository.findByName("TowelTech Innovations");

        User user1 = new User();
        Credentials creds1 = new Credentials();
        creds1.setUsername("zaphod@improbability.com");
        creds1.setPassword("password123");
        user1.setCredentials(creds1);
        Profile p1 = new Profile();
        p1.setFirstname("Zaphod");
        p1.setLastname("Beeblebrox");
        p1.setEmail("zaphod@improbability.com");
        p1.setPhone("931-555-0101");
        user1.setProfile(p1);
        user1.setActive(true);
        user1.setIsAdmin(true);
        user1.setStatus("JOINED"); // Changed status from "active"
        user1.setCompanies(List.of(company1, company2, company3, company4, company5));

        User user2 = new User();
        Credentials creds2 = new Credentials();
        creds2.setUsername("ford@improbability.com");
        creds2.setPassword("password123");
        user2.setCredentials(creds2);
        Profile p2 = new Profile();
        p2.setFirstname("Ford");
        p2.setLastname("Prefect");
        p2.setEmail("ford@improbability.com");
        p2.setPhone("931-555-0102");
        user2.setProfile(p2);
        user2.setActive(true);
        user2.setIsAdmin(false);
        user2.setStatus("JOINED"); // Changed status from "active"
        user2.setCompanies(List.of(company1));

        User user3 = new User();
        Credentials creds3 = new Credentials();
        creds3.setUsername("trillian@improbability.com");
        creds3.setPassword("password123");
        user3.setCredentials(creds3);
        Profile p3 = new Profile();
        p3.setFirstname("Trillian");
        p3.setLastname("Astra");
        p3.setEmail("trillian@improbability.com");
        p3.setPhone("931-555-0103");
        user3.setProfile(p3);
        user3.setActive(true);
        user3.setIsAdmin(false);
        user3.setStatus("JOINED"); // Changed status from "active"
        user3.setCompanies(List.of(company1));

        User user4 = new User();
        Credentials creds4 = new Credentials();
        creds4.setUsername("arthur@pangalactic.com");
        creds4.setPassword("password123");
        user4.setCredentials(creds4);
        Profile p4 = new Profile();
        p4.setFirstname("Arthur");
        p4.setLastname("Dent");
        p4.setEmail("arthur@pangalactic.com");
        p4.setPhone("931-555-0201");
        user4.setProfile(p4);
        user4.setActive(true);
        user4.setIsAdmin(true);
        user4.setStatus("JOINED"); // Changed status from "active"
        user4.setCompanies(List.of(company2));

        User user5 = new User();
        Credentials creds5 = new Credentials();
        creds5.setUsername("marvin@pangalactic.com");
        creds5.setPassword("password123");
        user5.setCredentials(creds5);
        Profile p5 = new Profile();
        p5.setFirstname("Marvin");
        p5.setLastname("Paranoid");
        p5.setEmail("marvin@pangalactic.com");
        p5.setPhone("931-555-0202");
        user5.setProfile(p5);
        user5.setActive(true);
        user5.setIsAdmin(false);
        user5.setStatus("JOINED"); // Changed status from "active"
        user5.setCompanies(List.of(company2));

        User user6 = new User();
        Credentials creds6 = new Credentials();
        creds6.setUsername("zarniwoop@pangalactic.com");
        creds6.setPassword("password123");
        user6.setCredentials(creds6);
        Profile p6 = new Profile();
        p6.setFirstname("Zarniwoop");
        p6.setLastname("Nothingth");
        p6.setEmail("zarniwoop@pangalactic.com");
        p6.setPhone("931-555-0203");
        user6.setProfile(p6);
        user6.setActive(true);
        user6.setIsAdmin(false);
        user6.setStatus("JOINED"); // Changed status from "active"
        user6.setCompanies(List.of(company2));

        User user7 = new User();
        Credentials creds7 = new Credentials();
        creds7.setUsername("slarti@hitchco.com");
        creds7.setPassword("password123");
        user7.setCredentials(creds7);
        Profile p7 = new Profile();
        p7.setFirstname("Slartibartfast");
        p7.setLastname("Fasti");
        p7.setEmail("slarti@hitchco.com");
        p7.setPhone("931-555-0301");
        user7.setProfile(p7);
        user7.setActive(true);
        user7.setIsAdmin(true);
        user7.setStatus("JOINED"); // Changed status from "active"
        user7.setCompanies(List.of(company3));

        User user8 = new User();
        Credentials creds8 = new Credentials();
        creds8.setUsername("lunkwill@hitchco.com");
        creds8.setPassword("password123");
        user8.setCredentials(creds8);
        Profile p8 = new Profile();
        p8.setFirstname("Lunkwill");
        p8.setLastname("Fook");
        p8.setEmail("lunkwill@hitchco.com");
        p8.setPhone("931-555-0302");
        user8.setProfile(p8);
        user8.setActive(true);
        user8.setIsAdmin(false);
        user8.setStatus("JOINED"); // Changed status from "active"
        user8.setCompanies(List.of(company3));

        User user9 = new User();
        Credentials creds9 = new Credentials();
        creds9.setUsername("majikthise@hitchco.com");
        creds9.setPassword("password123");
        user9.setCredentials(creds9);
        Profile p9 = new Profile();
        p9.setFirstname("Majikthise");
        p9.setLastname("Philosopher");
        p9.setEmail("majikthise@hitchco.com");
        p9.setPhone("931-555-0303");
        user9.setProfile(p9);
        user9.setActive(true);
        user9.setIsAdmin(false);
        user9.setStatus("JOINED"); // Changed status from "active"
        user9.setCompanies(List.of(company3));

        User user10 = new User();
        Credentials creds10 = new Credentials();
        creds10.setUsername("deepthought@babelcom.com");
        creds10.setPassword("password123");
        user10.setCredentials(creds10);
        Profile p10 = new Profile();
        p10.setFirstname("Deep");
        p10.setLastname("Thought");
        p10.setEmail("deepthought@babelcom.com");
        p10.setPhone("931-555-0401");
        user10.setProfile(p2);
        user10.setActive(true);
        user10.setIsAdmin(true);
        user10.setStatus("JOINED"); // Changed status from "active"
        user10.setCompanies(List.of(company4));

        User user11 = new User();
        Credentials creds11 = new Credentials();
        creds11.setUsername("eddie@babelcom.com");
        creds11.setPassword("password123");
        user11.setCredentials(creds11);
        Profile p11 = new Profile();
        p11.setFirstname("Eddie");
        p11.setLastname("Voice");
        p11.setEmail("eddie@babelcom.com");
        p11.setPhone("931-555-0402");
        user11.setProfile(p11);
        user11.setActive(true);
        user11.setIsAdmin(false);
        user11.setStatus("JOINED"); // Changed status from "active"
        user11.setCompanies(List.of(company4));

        User user12 = new User();
        Credentials creds12 = new Credentials();
        creds12.setUsername("veet@babelcom.com");
        creds12.setPassword("password123");
        user12.setCredentials(creds12);
        Profile p12 = new Profile();
        p12.setFirstname("Veet");
        p12.setLastname("Voojagig");
        p12.setEmail("veet@babelcom.com");
        p12.setPhone("931-555-0403");
        user12.setProfile(p12);
        user12.setActive(true);
        user12.setIsAdmin(false);
        user12.setStatus("JOINED"); // Changed status from "active"
        user12.setCompanies(List.of(company4));

        User user13 = new User();
        Credentials creds13 = new Credentials();
        creds13.setUsername("agrajag@toweltech.com");
        creds13.setPassword("password123");
        user13.setCredentials(creds13);
        Profile p13 = new Profile();
        p13.setFirstname("Agrajag");
        p13.setLastname("Catastrophe");
        p13.setEmail("agrajag@toweltech.com");
        p13.setPhone("931-555-0501");
        user13.setProfile(p13);
        user13.setActive(true);
        user13.setIsAdmin(true);
        user13.setStatus("JOINED"); // Changed status from "active"
        user13.setCompanies(List.of(company5));

        User user14 = new User();
        Credentials creds14 = new Credentials();
        creds14.setUsername("vogon@toweltech.com");
        creds14.setPassword("password123");
        user14.setCredentials(creds14);
        Profile p14 = new Profile();
        p14.setFirstname("Vogon");
        p14.setLastname("CJeltz");
        p14.setEmail("vogon@toweltech.com");
        p14.setPhone("931-555-0502");
        user14.setProfile(p14);
        user14.setActive(true);
        user14.setIsAdmin(false);
        user14.setStatus("JOINED"); // Changed status from "active"
        user14.setCompanies(List.of(company5));

        User user15 = new User();
        Credentials creds15 = new Credentials();
        creds15.setUsername("prostetnic@toweltech.com");
        creds15.setPassword("password123");
        user15.setCredentials(creds15);
        Profile p15 = new Profile();
        p15.setFirstname("Prostetnic");
        p15.setLastname("Vogon");
        p15.setEmail("prostetnic@toweltech.com");
        p15.setPhone("931-555-0503");
        user15.setProfile(p15);
        user15.setActive(true);
        user15.setIsAdmin(false);
        user15.setStatus("JOINED"); // Changed status from "active"
        user15.setCompanies(List.of(company5));

        userRepository.saveAll(List.of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12, user13, user14, user15));
    }

    private void seedTeams() {
        Company company1 = companyRepository.findByName("Infinite Improbability Enterprises");
        Company company2 = companyRepository.findByName("Pan Galactic Solutions");
        Company company3 = companyRepository.findByName("Hitchhiker's Hitch Co.");
        Company company4 = companyRepository.findByName("Babel Communications Ltd.");
        Company company5 = companyRepository.findByName("TowelTech Innovations");

        User user1 = userRepository.findByCredentialsUsername("zaphod@improbability.com");
        User user2 = userRepository.findByCredentialsUsername("ford@improbability.com");
        User user3 = userRepository.findByCredentialsUsername("trillian@improbability.com");
        User user4 = userRepository.findByCredentialsUsername("arthur@pangalactic.com");
        User user5 = userRepository.findByCredentialsUsername("marvin@pangalactic.com");
        User user6 = userRepository.findByCredentialsUsername("zarniwoop@pangalactic.com");
        User user7 = userRepository.findByCredentialsUsername("slarti@hitchco.com");
        User user8 = userRepository.findByCredentialsUsername("lunkwill@hitchco.com");
        User user9 = userRepository.findByCredentialsUsername("majikthise@hitchco.com");
        User user10 = userRepository.findByCredentialsUsername("deepthought@babelcom.com");
        User user11 = userRepository.findByCredentialsUsername("eddie@babelcom.com");
        User user12 = userRepository.findByCredentialsUsername("veet@babelcom.com");
        User user13 = userRepository.findByCredentialsUsername("agrajag@toweltech.com");
        User user14 = userRepository.findByCredentialsUsername("vogon@toweltech.com");
        User user15 = userRepository.findByCredentialsUsername("prostetnic@toweltech.com");

        Team team1 = new Team();
        team1.setName("Infinite Thinkers");
        team1.setDescription("A team dedicated to brainstorming improbably brilliant ideas.");
        team1.setCompany(company1);
        team1.setUsers(List.of(user1, user2, user3)); // Associate users with team

        Team team2 = new Team();
        team2.setName("Quantum Leapers");
        team2.setDescription("Focusing on experimental projects and quantum computing.");
        team2.setCompany(company1);
        team2.setUsers(List.of(user1, user3)); // Associate users with team

        Team team3 = new Team();
        team3.setName("Galactic Mixologists");
        team3.setDescription("Experts in creating out-of-this-world solutions to cosmic problems.");
        team3.setCompany(company2);
        team3.setUsers(List.of(user4, user5, user6)); // Associate users with team

        Team team4 = new Team();
        team4.setName("Reality Benders");
        team4.setDescription("Innovators pushing the boundaries of reality and technology.");
        team4.setCompany(company2);
        team4.setUsers(List.of(user4, user6)); // Associate users with team

        Team team5 = new Team();
        team5.setName("Planet Designers");
        team5.setDescription("Crafting the finest custom planets and celestial bodies.");
        team5.setCompany(company3);
        team5.setUsers(List.of(user7, user8, user9)); // Associate users with team

        Team team6 = new Team();
        team6.setName("Philosopher's Guild");
        team6.setDescription("A group dedicated to the philosophical aspects of space travel.");
        team6.setCompany(company3);
        team6.setUsers(List.of(user7, user9)); // Associate users with team

        Team team7 = new Team();
        team7.setName("Universal Translators");
        team7.setDescription("Masters of communication across the galaxy.");
        team7.setCompany(company4);
        team7.setUsers(List.of(user10, user11, user12)); // Associate users with team

        Team team8 = new Team();
        team8.setName("Language Innovators");
        team8.setDescription("Pioneers in developing new languages and communication methods.");
        team8.setCompany(company4);
        team8.setUsers(List.of(user10, user12)); // Associate users with team

        Team team9 = new Team();
        team9.setName("Towel Engineers");
        team9.setDescription("Innovating the most versatile and practical towel-based technology.");
        team9.setCompany(company5);
        team9.setUsers(List.of(user13, user14, user15)); // Associate users with team

        Team team10 = new Team();
        team10.setName("Vogon Poetry Lovers");
        team10.setDescription("A team that appreciates the finest (and most excruciating) poetry in the universe.");
        team10.setCompany(company5);
        team10.setUsers(List.of(user14, user15)); // Associate users with team

        teamRepository.saveAll(List.of(team1, team2, team3, team4, team5, team6, team7, team8, team9, team10));

        // Update users to include the teams
        user1.setTeams(List.of(team1, team2));
        user2.setTeams(List.of(team1));
        user3.setTeams(List.of(team1, team2));
        user4.setTeams(List.of(team3, team4));
        user5.setTeams(List.of(team3));
        user6.setTeams(List.of(team3, team4));
        user7.setTeams(List.of(team5, team6));
        user8.setTeams(List.of(team5));
        user9.setTeams(List.of(team5, team6));
        user10.setTeams(List.of(team7, team8));
        user11.setTeams(List.of(team7));
        user12.setTeams(List.of(team7, team8));
        user13.setTeams(List.of(team9));
        user14.setTeams(List.of(team9, team10));
        user15.setTeams(List.of(team9, team10));
        userRepository.saveAll(List.of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10));
    }

    private void seedProjects() {
        Team team1 = teamRepository.findByName("Infinite Thinkers");
        Team team2 = teamRepository.findByName("Quantum Leapers");
        Team team3 = teamRepository.findByName("Galactic Mixologists");
        Team team4 = teamRepository.findByName("Reality Benders");
        Team team5 = teamRepository.findByName("Planet Designers");
        Team team6 = teamRepository.findByName("Philosopher's Guild");
        Team team7 = teamRepository.findByName("Universal Translators");
        Team team8 = teamRepository.findByName("Language Innovators");
        Team team9 = teamRepository.findByName("Towel Engineers");
        Team team10 = teamRepository.findByName("Vogon Poetry Lovers");


        Project project1 = new Project();
        project1.setName("Improbability Drive Optimization");
        project1.setDescription("Enhancing the functionality and efficiency of the Infinite Improbability Drive.");
        project1.setActive(true);
        project1.setTeam(team1);

        Project project2 = new Project();
        project2.setName("Pan-Galactic Gargle Blaster Recipe Improvement");
        project2.setDescription("Creating a new, more potent version of the famous drink.");
        project2.setActive(false);
        project2.setTeam(team1);

        Project project3 = new Project();
        project3.setName(" Quantum Reality Stabilizer");
        project3.setDescription("Developing a device to stabilize quantum fluctuations in real-time.");
        project3.setActive(true);
        project3.setTeam(team2);

        Project project4 = new Project();
        project4.setName("Interdimensional Portals");
        project4.setDescription("Researching safe and efficient ways to create portals to other dimensions.");
        project4.setActive(false);
        project4.setTeam(team2);

        Project project5 = new Project();
        project5.setName("Pan-Galactic Energy Solutions");
        project5.setDescription("Innovating new energy sources from across the galaxy.");
        project5.setActive(true);
        project5.setTeam(team3);

        Project project6 = new Project();
        project6.setName("Cosmic Culinary Creations");
        project6.setDescription("Experimenting with unique ingredients to create intergalactic dishes.");
        project6.setActive(false);
        project6.setTeam(team3);

        Project project7 = new Project();
        project7.setName("Virtual Universe Simulator");
        project7.setDescription("Creating a simulation of various universes for scientific and recreational purposes.");
        project7.setActive(true);
        project7.setTeam(team4);

        Project project8 = new Project();
        project8.setName("Temporal Adjustment Mechanism");
        project8.setDescription("Developing a device to manipulate time for minor adjustments and corrections.");
        project8.setActive(false);
        project8.setTeam(team4);

        Project project9 = new Project();
        project9.setName("Custom Planetary Design");
        project9.setDescription("Designing bespoke planets for clients with specific requirements.");
        project9.setActive(true);
        project9.setTeam(team5);

        Project project10 = new Project();
        project10.setName("Planetary Magrathea Revival");
        project10.setDescription("Reviving the ancient planet-building techniques of Magrathea.");
        project10.setActive(false);
        project10.setTeam(team5);

        Project project11 = new Project();
        project11.setName("Ultimate Question Research");
        project11.setDescription("Conducting research to find the Ultimate Question to Life, the Universe, and Everything.");
        project11.setActive(true);
        project11.setTeam(team6);

        Project project12 = new Project();
        project12.setName("Existential Vacuum Cleaner");
        project12.setDescription("Exploring the philosophical implications of a device that cleans existential crises.");
        project12.setActive(false);
        project12.setTeam(team6);

        Project project13 = new Project();
        project13.setName("Babel Fish 2.0");
        project13.setDescription("Upgrading the Babel Fish for more accurate and broader translations.");
        project13.setActive(true);
        project13.setTeam(team7);

        Project project14 = new Project();
        project14.setName("Galactic Rosetta Stone");
        project14.setDescription("Creating a comprehensive translation tool for all known galactic languages.");
        project14.setActive(false);
        project14.setTeam(team7);

        Project project15 = new Project();
        project15.setName(" Universal Grammar Framework");
        project15.setDescription("Developing a framework for understanding and creating new languages.");
        project15.setActive(true);
        project15.setTeam(team8);

        Project project16 = new Project();
        project16.setName("Intergalactic Puns and Wordplay Database");
        project16.setDescription("Compiling a database of puns and wordplay from across the universe.");
        project16.setActive(false);
        project16.setTeam(team8);

        Project project17 = new Project();
        project17.setName("Towel Durability Enhancement");
        project17.setDescription("Increasing the durability and versatility of towels for interstellar travelers.");
        project17.setActive(true);
        project17.setTeam(team9);

        Project project18 = new Project();
        project18.setName("Compact Towel Technology");
        project18.setDescription("Developing towels that can compact to microscopic sizes for easy storage.");
        project18.setActive(false);
        project18.setTeam(team9);

        Project project19 = new Project();
        project19.setName("Vogon Poetry Appreciation Initiative");
        project19.setDescription("Promoting the appreciation of Vogon poetry across the galaxy.");
        project19.setActive(true);
        project19.setTeam(team10);

        Project project20 = new Project();
        project20.setName("Vogon Poetry Preservation");
        project20.setDescription("Ensuring the preservation and continuation of Vogon poetry traditions.");
        project20.setActive(false);
        project20.setTeam(team10);

        projectRepository.saveAll(List.of(project1, project2, project3, project4, project5, project6, project7, project8, project9, project10, project11, project12, project13, project14, project15, project16, project17, project18, project19, project20));
    }

    private void seedAnnouncements() {
        Company company1 = companyRepository.findByName("Infinite Improbability Enterprises");
        Company company2 = companyRepository.findByName("Pan Galactic Solutions");
        Company company3 = companyRepository.findByName("Hitchhiker's Hitch Co.");
        Company company4 = companyRepository.findByName("Babel Communications Ltd.");
        Company company5 = companyRepository.findByName("TowelTech Innovations");
        User author1 = userRepository.findByCredentialsUsername("zaphod@improbability.com");
        User author2 = userRepository.findByCredentialsUsername("arthur@pangalactic.com");
        User author3 = userRepository.findByCredentialsUsername("slarti@hitchco.com");
        User author4 = userRepository.findByCredentialsUsername("deepthought@babelcom.com");
        User author5 = userRepository.findByCredentialsUsername("agrajag@toweltech.com");

        Announcements announcement1 = new Announcements();
        announcement1.setTitle("New Improbability Drive Settings");
        announcement1.setMessage("Hey team, we've updated the settings on the Improbability Drive to enhance improbability! Be prepared for some unexpected outcomes. Keep your towels handy!");
        announcement1.setCompany(company1);
        announcement1.setAuthor(author1);
        announcement1.setIsDeleted(false);

        Announcements announcement2 = new Announcements();
        announcement2.setTitle("Infinite Brainstorm Session");
        announcement2.setMessage("Join us for an infinite brainstorming session this Friday. Bring your wildest ideas and a strong cup of Pan-Galactic Gargle Blaster. Let's make the improbable possible!");
        announcement2.setCompany(company1);
        announcement2.setAuthor(author1);
        announcement2.setIsDeleted(false);

        Announcements announcement3 = new Announcements();
        announcement3.setTitle("Galactic Energy Solutions Kickoff");
        announcement3.setMessage("Exciting news! We're kicking off our Pan-Galactic Energy Solutions project. Let's harness some cosmic energy and make the universe a brighter place. Don't forget your towels!");
        announcement3.setCompany(company2);
        announcement3.setAuthor(author2);
        announcement3.setIsDeleted(false);

        Announcements announcement4 = new Announcements();
        announcement4.setTitle("Reality Bending Safety Protocols");
        announcement4.setMessage("As we delve deeper into reality-bending technology, please adhere to the new safety protocols. Remember, reality is flexible, but safety isn't. Always keep a towel close!");
        announcement4.setCompany(company2);
        announcement4.setAuthor(author2);
        announcement4.setIsDeleted(false);

        Announcements announcement5 = new Announcements();
        announcement5.setTitle("Custom Planetary Designs Available");
        announcement5.setMessage("We're thrilled to announce the launch of our Custom Planetary Design service! Now you can order planets tailored to your specific needs. Whether it's fjords or deserts, we’ve got you covered.");
        announcement5.setCompany(company3);
        announcement5.setAuthor(author3);
        announcement5.setIsDeleted(false);

        Announcements announcement6 = new Announcements();
        announcement6.setTitle("Magrathean Techniques Workshop");
        announcement6.setMessage("Attention, team! We're hosting a workshop on ancient Magrathean planet-building techniques. It's time to bring some classic craftsmanship back into the galaxy. Bring your creative spirit—and your towel!");
        announcement6.setCompany(company3);
        announcement6.setAuthor(author3);
        announcement6.setIsDeleted(false);

        Announcements announcement7 = new Announcements();
        announcement7.setTitle("Babel Fish 2.0 Development");
        announcement7.setMessage("We're excited to announce the development of Babel Fish 2.0! This new version promises even better translation accuracy. Get ready to communicate like never before!");
        announcement7.setCompany(company4);
        announcement7.setAuthor(author4);
        announcement7.setIsDeleted(false);

        Announcements announcement8 = new Announcements();
        announcement8.setTitle("Galactic Language Symposium");
        announcement8.setMessage("Join us for a symposium on galactic languages. We'll explore the latest in translation technology and share our progress on the Galactic Rosetta Stone. Remember, every language has a unique beauty, much like Vogon poetry.");
        announcement8.setCompany(company4);
        announcement8.setAuthor(author4);
        announcement8.setIsDeleted(false);

        Announcements announcement9 = new Announcements();
        announcement9.setTitle("Introducing the Ultimate Towel");
        announcement9.setMessage("We're proud to unveil our latest innovation: the Ultimate Towel. It's more durable, more versatile, and more compact than ever before. It's the only towel you'll ever need!");
        announcement9.setCompany(company5);
        announcement9.setAuthor(author5);
        announcement9.setIsDeleted(false);

        Announcements announcement10 = new Announcements();
        announcement10.setTitle("Vogon Poetry Appreciation Event");
        announcement10.setMessage("Calling all Vogon poetry lovers! We're hosting an appreciation event next week. Whether you're a longtime fan or new to the art form, join us to celebrate the finest (and most challenging) poetry in the galaxy. Bring your towels and your earplugs!");
        announcement10.setCompany(company5);
        announcement10.setAuthor(author5);
        announcement10.setIsDeleted(false);

        announcementsRepository.saveAll(List.of(announcement1, announcement2, announcement3, announcement4, announcement5, announcement6, announcement7, announcement8, announcement9, announcement10));
    }
}



