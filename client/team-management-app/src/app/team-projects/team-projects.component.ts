import { Component, OnInit } from '@angular/core';
import { BackendService } from '../backend.service';
import { ProjectDto, TeamDto } from '../models';

@Component({
  selector: 'app-team-projects',
  templateUrl: './team-projects.component.html',
  styleUrl: './team-projects.component.css'
})
export class TeamProjectsComponent implements OnInit{
  teamProjects: ProjectDto[] = [];
  currentTeam: TeamDto;
  showCreateProjectPopup: boolean = false;
  
  constructor(private backendService: BackendService){}

  ngOnInit(): void {
    this.currentTeam = this.backendService.getCurrentTeam(); //Fetch the current team we are observing from our service
    this.teamProjects = this.backendService.getTeamProjects(this.currentTeam); //Fetch [ProjectDto] with current TeamDto to display from our service(and therefore our backend)
  }

  //TODO: Create 2 methods for changing the levers that make either of the relevant popups appear, similar to Create a new team
  openProjectPopup() {
    this.showCreateProjectPopup = true;
  }

  closeProjectPopup() {
    this.showCreateProjectPopup = false;
  }
}
