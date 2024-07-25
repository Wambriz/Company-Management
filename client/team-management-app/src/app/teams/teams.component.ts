import { Component } from '@angular/core';

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrl: './teams.component.css'
})
export class TeamsComponent {
  showTeamCards: boolean = true;

    resetTeamCards() { //Method to reset team cards
      this.showTeamCards = false; // Hide the team cards
      setTimeout(() => this.showTeamCards = true, 0); // Show the team cards again
    }
}
