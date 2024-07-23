import { Component, OnInit } from '@angular/core';
import { TeamDto } from '../../models';
import { BackendService } from '../../backend.service';

@Component({
  selector: 'app-team-card',
  templateUrl: './team-card.component.html',
  styleUrl: './team-card.component.css'
})
export class TeamCardComponent implements OnInit{
listOfTeams: TeamDto[] = []; //This will represent all of the teams fetched from our backend


//INFO: TeamDto comes with id, name, description, and a list of users[], which are a list of [BasicUserDto]
//INFO: BasicUserDto comes with id, ProfileDto{}, isAdmin, active, and status
constructor(private backendService: BackendService) {
  this.listOfTeams = this.backendService.getListOfDummyTeams() //Initializing team variables via service (dummy data for now)
}

ngOnInit(): void { //OnInit actions here

}

getProjectCountByTeamDto(team: TeamDto): number {//This method takes a TeamDto, and returns the number of projects that team is involved with
  //First, get projects from endpoint from given ID
  //Second, return the number of the length of the returned array
  return this.backendService.getTeamProjects(team).length
}

}
