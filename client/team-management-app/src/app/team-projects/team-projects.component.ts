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
  showEditProjectPopup: boolean = false;
  projectData: ProjectDto; //We will pass this variable down to the edit project child popup

  
  constructor(private backendService: BackendService){}

  async ngOnInit(): Promise<void> {
    this.currentTeam = this.backendService.getCurrentTeam(); //Fetch the current team we are observing from our service
    this.teamProjects = await this.backendService.getTeamProjects(this.currentTeam); //Fetch [ProjectDto] with current TeamDto to display from our service(and therefore our backend)
  }

  openProjectPopup() {
    this.showCreateProjectPopup = true;
  }

  closeProjectPopup() {
    this.updateTeamProjectsFromDatabase() //Once popup is closed, re-fetch list of projects from DB (in case of update)
    this.showCreateProjectPopup = false;
  }

  openEditProjectPopup(project: ProjectDto) {
    this.projectData = project; //Saving the project being edited for our popup to fetch/manipulate
    this.showEditProjectPopup = true;
  }

  closeEditProjectPopup() {
    this.updateTeamProjectsFromDatabase() //Once popup is closed, re-fetch list of projects from DB (in case of update)
    this.showEditProjectPopup = false;

  }

  async updateTeamProjectsFromDatabase() {
    this.teamProjects = await this.backendService.getTeamProjects(this.currentTeam); //Fetch newest version of projects in the database
  }

  projectStatus(status: boolean): string {
    if (status) {
      return "Active";
    } else {
      return "Inactive"
    }
  }
}
