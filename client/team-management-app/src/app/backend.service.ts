import { Injectable } from '@angular/core';
import { TeamDto } from './models';

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

  constructor() { }
  //This is where we will communicate with our backend and perform other services like unpacking DTOs into our models
  getDummyTeam1(): TeamDto { //Function signature: name(): return-type {do stuff}
    return this.team1;
  }

  getDummyTeam2(): TeamDto {
    return this.team2;
  }
}
