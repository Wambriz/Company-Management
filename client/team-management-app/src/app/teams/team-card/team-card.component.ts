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
projectCounts: {[teamId: string]: number} = {} //New map of team id - project counts

//INFO: TeamDto comes with id, name, description, and a list of users[], which are a list of [BasicUserDto]
//INFO: BasicUserDto comes with id, ProfileDto{}, isAdmin, active, and status
constructor(private backendService: BackendService) {
}

async ngOnInit(): Promise<void> { //OnInit actions here
  this.listOfTeams = await this.backendService.getListOfTeams() //Get teams from backend (await on this promise to get the actual value)

  //Also pre-calculate project counts here
  for (let team of this.listOfTeams) { //For every team of this company that we fetched
    const projects = await this.backendService.getTeamProjects(team); //Get their projects from the DB
    this.projectCounts[team.id] = projects.length; //Get their project count and store them into our map of {id: project.length}
  }

}

setCurrentTeam(team: TeamDto) {//When this is called, the currentTeam variable in our service is updated (for our projects elements that come right after)
  this.backendService.setCurrentTeam(team)  //This is our method of passing the current team to our next page, our team-projects component
}
}
