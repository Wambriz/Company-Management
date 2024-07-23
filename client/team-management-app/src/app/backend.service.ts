import { Injectable } from '@angular/core';
import { ProjectDto, TeamDto } from './models';
import { HttpClient } from '@angular/common/http';
import { delay, Observable, of, throwError } from 'rxjs';
import { CredentialsDto, FullUserDto } from './models';

@Injectable({
  providedIn: 'root',
})
export class BackendService {
  private backendUrl = 'http://localhost:4200/';

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

  // WARNING!!!! DO NOT DELETE! REAL LOGIN METHOD TO BE USED ONCE BACKEND IS EMPLAMENTED////////////////////////////////////////////////////////

  // login(credentials: CredentialsDto): Observable<FullUserDto> {
  //   return this.http.post<FullUserDto>(
  //     this.backendUrl + 'users/login',
  //     credentials
  //   );
  // }

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
        description: "We fix cars",
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
    companies: [],
    teams: [],
  };

  login(credentials: CredentialsDto): Observable<FullUserDto> {
    if (
      credentials.username === 'admin' &&
      credentials.password === 'password'
    ) {
      return of(this.mockAdmin).pipe(delay(1000)); // Simulate network delay
    }
    if (
      credentials.username === 'user' &&
      credentials.password === 'password'
    ) {
      return of(this.mockUser).pipe(delay(1000)); // Simulate network delay
    } else {
      return throwError(() => new Error('Invalid username or password')).pipe(
        delay(1000)
      );
    }
  }
}
