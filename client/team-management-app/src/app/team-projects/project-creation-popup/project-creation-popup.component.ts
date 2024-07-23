import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-project-creation-popup',
  templateUrl: './project-creation-popup.component.html',
  styleUrl: './project-creation-popup.component.css'
})
export class ProjectCreationPopupComponent {
  @Output() close = new EventEmitter<void>(); //This is how we emit a (close) event to the parent.

  closeEvent() { //For when the popup is simply closed (team creation canceled), emit a close event to make the popup dissapear in the parent component
    this.close.emit();
  }

}
