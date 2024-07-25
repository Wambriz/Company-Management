import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { delay, Observable, of, throwError } from 'rxjs';
import {
  CredentialsDto,
  FullUserDto,
  AnnouncementDto,
  CompanyDto,
  ProjectDto,
  TeamDto,
  TeamRequestDto,
  CreateAnnouncementDto,
  ProjectRequestDto,
  UserRequestDto
} from './models';

@Injectable({
  providedIn: 'root',
})
export class BackendService {
  private backendUrl = 'http://localhost:8080/';
  currentTeam: TeamDto = {id: -1, name: "", description: "", users:[]} //This variable will dynamically change as different team projects are requested

  constructor(private http: HttpClient) {}

  //This is where we will communicate with our backend and perform other services like unpacking DTOs into our models
  getDummyTeam1(): TeamDto {
    //Function signature: name(): return-type {do stuff}
    return this.team1;
  }

  getDummyTeam2(): TeamDto {
    return this.team2;
  }

  getTeamProjects(team: TeamDto): ProjectDto[] {
    //Fetches team projects based on given TeamDto
    //Simply returns dummy data. In real version, we would make a call to API here.
    if (team === this.team1) {
      return this.team1Projects;
    } else if (team === this.team2) {
      return this.team2Projects;
    } else {
      return [];
    }
  }

  // WARNING!!!! DO NOT DELETE! REAL LOGIN AND FETCH ANNOUNCEMENTS METHODS TO BE USED ONCE BACKEND IS EMPLAMENTED////////////////////////////////

  login(credentials: CredentialsDto): Observable<FullUserDto> {
    return this.http.post<FullUserDto>(
      this.backendUrl + 'users/login',
      credentials
    );
  }

  // fetchAnnouncements(id: number): AnnouncementDto[] {
  //   const url = this.backendUrl + `company/${id}/announcements`;
  //   let announcements: AnnouncementDto[] = [];
  //   this.http.get<AnnouncementDto[]>(url).subscribe(
  //     (data) => (announcements = data),
  //     (error) => console.error('Error fetching announcements', error)
  //   ); return announcements;
  // }

  createAnnouncement(id: number, announcement: CreateAnnouncementDto): Observable<AnnouncementDto> {
    const url = this.backendUrl + `company/${id}/announcement`;
    return this.http.post<AnnouncementDto>(url, announcement);
  }

  getUsers(): Observable<FullUserDto[]> {
    const selectedCompany: CompanyDto = JSON.parse(localStorage.getItem('selectedCompany')!);
    const id = selectedCompany.id;
    const url = this.backendUrl + `company/${id}/users`;
    return this.http.get<FullUserDto[]>(url);
  }

  createUser(user: UserRequestDto, id: number): Observable<any> {
    return this.http.post(this.backendUrl + `company/${id}/user`, user);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  //Dummy Team 1 with Ai Hoshino, Aqua Hoshino, and Ruby Hoshino
  //Example of insantiating an object from our models:
  team1: TeamDto = {
    // FORMAT: name: type = (data)
    id: 1, //Setting the properties for each instance
    name: 'B-Komachi',
    description: 'Specialists in Entertainment Media',
    users: [
      //users is an array of Basic User DTOs, which is represnted as a JSON object of our basic user DTO
      {
        //BasicUserDto 1
        id: 2,
        profile: {
          firstname: 'Ai',
          lastname: 'Hoshino',
          email: 'hoshino.ai@bkomachi.com',
          phone: '5555551234',
        }, //ProfileDto of BasicUserDto 1
        isAdmin: true,
        active: false,
        status: 'Not Active',
      },
      {
        //BasicUserDto 2
        id: 3,
        profile: {
          firstname: 'Aqua',
          lastname: 'Hoshino',
          email: 'hoshino.aqua@bkomachi.com',
          phone: '5555552345',
        }, //ProfileDto of BasicUserDto 2
        isAdmin: false,
        active: true,
        status: 'Active',
      },
      {
        //BasicUserDto 2
        id: 4,
        profile: {
          firstname: 'Ruby',
          lastname: 'Hoshino',
          email: 'hoshino.Ruby@bkomachi.com',
          phone: '5555553456',
        }, //ProfileDto of BasicUserDto 3
        isAdmin: false,
        active: true,
        status: 'Active',
      },
    ],
  };

  //Dummy Team 2 with Richard Winters, Herbert Sobel, and Robert Sink
  team2: TeamDto = {
    // FORMAT: name: type = (data)
    id: 5, //Setting the properties for each instance
    name: 'Easy Company',
    description: 'Specialists in Mil-Tech',
    users: [
      //users is an array of Basic User DTOs, which is represnted as a JSON object of our basic user DTO
      {
        //BasicUserDto 1
        id: 6,
        profile: {
          firstname: 'Richard',
          lastname: 'Winters',
          email: 'richard.winters@101st.com',
          phone: '1234569999',
        }, //ProfileDto of BasicUserDto 1
        isAdmin: false,
        active: true,
        status: 'Active',
      },
      {
        //BasicUserDto 2
        id: 7,
        profile: {
          firstname: 'Herbert',
          lastname: 'Sobel',
          email: 'herber.sobel@101st.com',
          phone: '1234568888',
        }, //ProfileDto of BasicUserDto 1
        isAdmin: false,
        active: true,
        status: 'Active',
      },
      {
        //BasicUserDto 3
        id: 8,
        profile: {
          firstname: 'Robert',
          lastname: 'Sink',
          email: 'robert.sink@101st.com',
          phone: '1234567777',
        }, //ProfileDto of BasicUserDto 1
        isAdmin: true,
        active: true,
        status: 'Active',
      },
    ],
  };

  team1Projects: ProjectDto[] = [
    //3 projects. This is the kind of response we will recieve from our get projects enpoint: A list of projects
    {
      id: 9,
      name: 'Our Sign Is B',
      description: 'Hit Single',
      active: false,
      team: this.team1, //Typically, this team attribute would have the JSON notation of a TeamDto, we are just using our dummy variable for readability
    },
    {
      id: 10,
      name: 'Star T Rain',
      description: 'Fan Favorite',
      active: false,
      team: this.team1,
    },
    {
      id: 11,
      name: 'Super Motor',
      description: 'Cult Classic',
      active: false,
      team: this.team1,
    },
  ];

  team2Projects: ProjectDto[] = [
    //4 Projects
    {
      id: 12,
      name: 'Operation Overlord',
      description: 'Turning Point',
      active: false,
      team: this.team2,
    },
    {
      id: 13,
      name: 'Operation Market Garden',
      description: 'Unsuccesful project',
      active: false,
      team: this.team2,
    },
    {
      id: 14,
      name: 'Battle of the Bulge',
      description: 'Desperate Defense',
      active: false,
      team: this.team2,
    },
    {
      id: 15,
      name: 'Brecourt Manor',
      description: 'Premier Example',
      active: false,
      team: this.team2,
    },
  ];

  //New Company of Dummy Data
  company2: CompanyDto = {
    id: 16,
    name: 'Screaming Eagles',
    description: 'A Company about Mil-Tech',
    teams: [this.team2],
    users: [
      //users is an array of Basic User DTOs, which is represnted as a JSON object of our basic user DTO
      {
        //BasicUserDto 1
        id: 6,
        profile: {
          firstname: 'Richard',
          lastname: 'Winters',
          email: 'richard.winters@101st.com',
          phone: '1234569999',
        }, //ProfileDto of BasicUserDto 1
        isAdmin: false,
        active: true,
        status: 'Active',
      },
      {
        //BasicUserDto 2
        id: 7,
        profile: {
          firstname: 'Herbert',
          lastname: 'Sobel',
          email: 'herber.sobel@101st.com',
          phone: '1234568888',
        }, //ProfileDto of BasicUserDto 1
        isAdmin: false,
        active: true,
        status: 'Active',
      },
      {
        //BasicUserDto 3
        id: 8,
        profile: {
          firstname: 'Robert',
          lastname: 'Sink',
          email: 'robert.sink@101st.com',
          phone: '1234567777',
        }, //ProfileDto of BasicUserDto 1
        isAdmin: true,
        active: true,
        status: 'Active',
      },
    ],
  };

  company2TeamMembers: FullUserDto[] = [
    //Create list of company members of dummy data to make members of project.
    {
      //FullUserDto 1
      id: 6,
      profile: {
        firstname: 'Richard',
        lastname: 'Winters',
        email: 'richard.winters@101st.com',
        phone: '1234569999',
      }, //ProfileDto of BasicUserDto 1
      isAdmin: false,
      active: true,
      status: 'Active',
      companies: [this.company2],
      teams: [this.team2],
    },
    {
      //FullUserDto 2
      id: 7,
      profile: {
        firstname: 'Herbert',
        lastname: 'Sobel',
        email: 'herber.sobel@101st.com',
        phone: '1234568888',
      }, //ProfileDto of BasicUserDto 1
      isAdmin: false,
      active: true,
      status: 'Active',
      companies: [this.company2],
      teams: [this.team2],
    },
    {
      //FullUserDto 3
      id: 8,
      profile: {
        firstname: 'Robert',
        lastname: 'Sink',
        email: 'robert.sink@101st.com',
        phone: '1234567777',
      }, //ProfileDto of BasicUserDto 1
      isAdmin: true,
      active: true,
      status: 'Active',
      companies: [this.company2],
      teams: [this.team2],
    },
  ];

  listOfDummyTeams: TeamDto[] = [this.team1, this.team2];

  //Add a new team to the list of teams
  addDummyTeam(newTeam: TeamDto): void {
    this.listOfDummyTeams.push(newTeam);
  }

  getListOfDummyTeams(): TeamDto[] {
    return this.listOfDummyTeams;
  }
  // Devin test block
  //
  //POST /users/login test
  private mockAdmin: FullUserDto = {
    id: 1,
    profile: {
      firstname: 'Ai',
      lastname: 'Hoshino',
      email: 'hoshino.ai@bkomachi.com',
      phone: '5555551234',
    }, //User profile stollen from Josue =)
    isAdmin: true,
    active: true,
    status: 'active',
    companies: [
      {
        id: 1,
        name: "Carter's",
        description: "We make kid's cloths",
        teams: [],
        users: [],
      },
      {
        id: 2,
        name: "Lee's",
        description: 'We fix cars',
        teams: [],
        users: [],
      },
    ],
    teams: [],
  };

  private mockUser: FullUserDto = {
    id: 1,
    profile: {
      firstname: 'Aqua',
      lastname: 'Hoshino',
      email: 'hoshino.aqua@bkomachi.com',
      phone: '5555552345',
    }, //User profile stollen from Josue =)
    isAdmin: false,
    active: true,
    status: 'active',
    companies: [
      {
        id: 1,
        name: "Carter's",
        description: "We make kid's cloths",
        teams: [],
        users: [],
      },
    ],
    teams: [],
  };

  private mockAnnouncements: AnnouncementDto[] = [
    {
      id: 1,
      date: 1721747368975,
      title: 'Announcement 1',
      message: 'This is the first announcement.',
      author: {
        id: 1,
        profile: {
          firstname: 'John',
          lastname: 'Doe',
          email: 'john.doe@example.com',
          phone: '123-456-7890',
        },
        isAdmin: true,
        active: true,
        status: 'Active',
      },
    },
    {
      id: 2,
      date: 1721747389451,
      title: 'Announcement 2',
      message: 'This is the second announcement.',
      author: {
        id: 2,
        profile: {
          firstname: 'Jane',
          lastname: 'Smith',
          email: 'jane.smith@example.com',
          phone: '987-654-3210',
        },
        isAdmin: false,
        active: true,
        status: 'Active',
      },
    },
  ];

  // login(credentials: CredentialsDto): Observable<FullUserDto> {
  //   if (
  //     credentials.username === 'admin' &&
  //     credentials.password === 'password'
  //   ) {
  //     return of(this.mockAdmin).pipe(delay(1000)); // Simulate network delay
  //   }
  //   if (
  //     credentials.username === 'user' &&
  //     credentials.password === 'password'
  //   ) {
  //     return of(this.mockUser).pipe(delay(1000)); // Simulate network delay
  //   } else {
  //     return throwError(() => new Error('Invalid username or password')).pipe(
  //       delay(1000)
  //     );
  //   }
  // }

  getActiveMembers(): FullUserDto[] {
    //Later, this method should accept a company ID when making request to backend for active members of a company
    return this.company2TeamMembers;
  }

  createTeam(newTeamRequestDto: TeamRequestDto): void {
    //Here we would communicate with out endpoint, save our new team, and then
    //Make another call to fetch a list of teams.

    //For now, pretend to do that by manually creating a new TeamDto
    const newTeamDto: TeamDto = {
      id: 999,
      name: newTeamRequestDto.name,
      description: newTeamRequestDto.description,
      users: newTeamRequestDto.users,
    };

    this.addDummyTeam(newTeamDto); //Adding our TeamDto response from the database to our list of teams
  }

  createProject(newProjectRequestDto: ProjectRequestDto): void {
    //Here we would communicate with our endpoint, save our new project, and then
    //make another call to fetch the list of projects

    //For now, pretend to do that by manually creating a new TeamDto
    const newProjectDto: ProjectDto = {
      id: 999,
      name: newProjectRequestDto.name,
      description: newProjectRequestDto.description,
      active: newProjectRequestDto.active,
      team: this.currentTeam
    };

    //Adding our new project to our current list of team projects 
    this.getTeamProjects(this.currentTeam).push(newProjectDto);  //(Later our getTeamProjects method will simply fetch the list of projects in the DB)
  }
  updateProject(newProjectDto: ProjectDto): ProjectDto {
    //At this point, we would send our ProjectDto to our backend, which would save our updated project to the DB, and return the result.

    //After that, out getTeamProjects() would successfully fetch the updated projects from the database when used. 

    //For now, simply update the project from the list of team projects by adding it directly (Incorrect behavior, but intentional for the sake of simplicty/time)
    this.getTeamProjects(this.currentTeam).push(newProjectDto);
    return newProjectDto;
  }
  fetchAnnouncements(companyId: number): AnnouncementDto[] {
    console.log('Using test data for announcements');
    return this.mockAnnouncements;
  }
  getCurrentTeam(): TeamDto{
    return this.currentTeam
  }
  setCurrentTeam(teamDto: TeamDto) { //Assign current team with a new TeamDto
    this.currentTeam = teamDto;
  }
}