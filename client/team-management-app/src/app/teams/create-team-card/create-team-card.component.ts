import { Component } from '@angular/core';

@Component({
  selector: 'app-create-team-card',
  templateUrl: './create-team-card.component.html',
  styleUrl: './create-team-card.component.css'
})
export class CreateTeamCardComponent {
showCreateTeamPopup: Boolean = false; //Do not show popup by default


//Controls for showing/dissapearing the popup
openPopup() {
  this.showCreateTeamPopup = true;
}
closePopup() {
  this.showCreateTeamPopup = false;
}
}
