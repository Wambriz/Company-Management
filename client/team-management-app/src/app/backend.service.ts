import { Injectable } from '@angular/core';
import { CompanyDto, FullUserDto, ProjectDto, TeamDto, TeamRequestDto } from './models';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  //Dummy Team 1 with Ai Hoshino, Aqua Hoshino, and Ruby Hoshino
  //Example of insantiating an object from our models:
  team1: TeamDto = { // FORMAT: name: type = (data)
    id: 1, //Setting the properties for each instance
    name: "B-Komachi",
    description: "Specialists in Entertainment Media",
    users: [  //users is an array of Basic User DTOs, which is represnted as a JSON object of our basic user DTO
      { //BasicUserDto 1
        id: 2,
        profile: {firstname: "Ai", lastname: "Hoshino", email: "hoshino.ai@bkomachi.com", phone: "5555551234"}, //ProfileDto of BasicUserDto 1
        isAdmin: true,
        active: false,
        status: "Not Active"
      },
      { //BasicUserDto 2
        id: 3,
        profile: {firstname: "Aqua", lastname: "Hoshino", email: "hoshino.aqua@bkomachi.com", phone: "5555552345"}, //ProfileDto of BasicUserDto 2
        isAdmin: false,
        active: true,
        status: "Active"
      },
      { //BasicUserDto 2
        id: 4,
        profile: {firstname: "Ruby", lastname: "Hoshino", email: "hoshino.Ruby@bkomachi.com", phone: "5555553456"}, //ProfileDto of BasicUserDto 3
        isAdmin: false,
        active: true,
        status: "Active"
      },
    ]
  }

  //Dummy Team 2 with Richard Winters, Herbert Sobel, and Robert Sink
  team2: TeamDto = { // FORMAT: name: type = (data)
    id: 5, //Setting the properties for each instance
    name: "Easy Company",
    description: "Specialists in Mil-Tech",
    users: [  //users is an array of Basic User DTOs, which is represnted as a JSON object of our basic user DTO
      { //BasicUserDto 1
        id: 6,
        profile: {firstname: "Richard", lastname: "Winters", email: "richard.winters@101st.com", phone: "1234569999"}, //ProfileDto of BasicUserDto 1
        isAdmin: false,
        active: true,
        status: "Active"
      },
      { //BasicUserDto 2
        id: 7,
        profile: {firstname: "Herbert", lastname: "Sobel", email: "herber.sobel@101st.com", phone: "1234568888"}, //ProfileDto of BasicUserDto 1
        isAdmin: false,
        active: true,
        status: "Active"
      },
      { //BasicUserDto 3
        id: 8,
        profile: {firstname: "Robert", lastname: "Sink", email: "robert.sink@101st.com", phone: "1234567777"}, //ProfileDto of BasicUserDto 1
        isAdmin: true,
        active: true,
        status: "Active"
      },
    ]
  }

  team1Projects: ProjectDto[] = [ //3 projects. This is the kind of response we will recieve from our get projects enpoint: A list of projects
    {
      id: 9,
      name: "Our Sign Is B",
      description: "Hit Single",
      active: false,
      team: this.team1 //Typically, this team attribute would have the JSON notation of a TeamDto, we are just using our dummy variable for readability
    },
    {
      id: 10,
      name: "Star T Rain",
      description: "Fan Favorite",
      active: false,
      team: this.team1
    }, 
    {
      id: 11,
      name: "Super Motor",
      description: "Cult Classic",
      active: false,
      team: this.team1
    }
  ];

  team2Projects: ProjectDto[] = [ //4 Projects
    {
      id: 12,
      name: "Operation Overlord",
      description: "Turning Point",
      active: false,
      team: this.team2
    },
    {
      id: 13,
      name: "Operation Market Garden",
      description: "Unsuccesful project",
      active: false,
      team: this.team2
    }, 
    {
      id: 14,
      name: "Battle of the Bulge",
      description: "Desperate Defense",
      active: false,
      team: this.team2
    }, 
    {
      id: 15,
      name: "Brecourt Manor",
      description: "Premier Example",
      active: false,
      team: this.team2
    }
  ];

  //New Company of Dummy Data
  company2: CompanyDto = {
    id: 16,
    name: "Screaming Eagles",
    description: "A Company about Mil-Tech",
    teams: [this.team2],
    users: [ //users is an array of Basic User DTOs, which is represnted as a JSON object of our basic user DTO
      { //BasicUserDto 1
        id: 6,
        profile: {firstname: "Richard", lastname: "Winters", email: "richard.winters@101st.com", phone: "1234569999"}, //ProfileDto of BasicUserDto 1
        isAdmin: false,
        active: true,
        status: "Active"
      },
      { //BasicUserDto 2
        id: 7,
        profile: {firstname: "Herbert", lastname: "Sobel", email: "herber.sobel@101st.com", phone: "1234568888"}, //ProfileDto of BasicUserDto 1
        isAdmin: false,
        active: true,
        status: "Active"
      },
      { //BasicUserDto 3
        id: 8,
        profile: {firstname: "Robert", lastname: "Sink", email: "robert.sink@101st.com", phone: "1234567777"}, //ProfileDto of BasicUserDto 1
        isAdmin: true,
        active: true,
        status: "Active"
      },
    ]
  }

  company2TeamMembers: FullUserDto[] = [ //Create list of company members of dummy data to make members of project.
    { //FullUserDto 1
      id: 6,
      profile: {firstname: "Richard", lastname: "Winters", email: "richard.winters@101st.com", phone: "1234569999"}, //ProfileDto of BasicUserDto 1
      isAdmin: false,
      active: true,
      status: "Active",
      companies: [
        this.company2
      ],
      teams: [
        this.team2
      ]
    },
    { //FullUserDto 2
      id: 7,
      profile: {firstname: "Herbert", lastname: "Sobel", email: "herber.sobel@101st.com", phone: "1234568888"}, //ProfileDto of BasicUserDto 1
      isAdmin: false,
      active: true,
      status: "Active",
      companies: [
        this.company2
      ],
      teams: [
        this.team2
      ]
    },
    { //FullUserDto 3
      id: 8,
      profile: {firstname: "Robert", lastname: "Sink", email: "robert.sink@101st.com", phone: "1234567777"}, //ProfileDto of BasicUserDto 1
      isAdmin: true,
      active: true,
      status: "Active",
      companies: [
        this.company2
      ],
      teams: [
        this.team2
      ]
    },
  ]

  listOfDummyTeams: TeamDto[] = [this.team1, this.team2]

  constructor() { }
  //This is where we will communicate with our backend and perform other services like unpacking DTOs into our models
  
  //Add a new team to the list of teams
  addDummyTeam(newTeam: TeamDto): void {
    this.listOfDummyTeams.push(newTeam);
  }

  getListOfDummyTeams(): TeamDto[] {
    return this.listOfDummyTeams;
  }

  getTeamProjects(team: TeamDto): ProjectDto[] { //Fetches team projects based on given TeamDto
    //Simply returns dummy data. In real version, we would make a call to API here.
    if (team === this.team1) {
      return this.team1Projects;
    } else if (team === this.team2) {
      return this.team2Projects
    } else {
      return [];
    }
  }

  getActiveMembers(): FullUserDto[] { //Later, this method should accept a company ID when making request to backend for active members of a company
    return this.company2TeamMembers
  }

  createTeam(newTeamRequestDto: TeamRequestDto): void {
    //Here we would communicate with out endpoint, receive a proper TeamDto in return, and THEN add it to our list of teams

    //For now, pretend to do that by manually creating a new TeamDto
    const newTeamDto: TeamDto = {
      id: 999,
      name: newTeamRequestDto.name,
      description: newTeamRequestDto.description,
      users: newTeamRequestDto.users,
    }

    this.addDummyTeam(newTeamDto) //Adding our TeamDto response from the database to our list of teams
  }
}
