import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-project-edit-popup',
  templateUrl: './project-edit-popup.component.html',
  styleUrl: './project-edit-popup.component.css'
})
export class ProjectEditPopupComponent {
  @Output() close = new EventEmitter<void>(); //This is how we emit a (close) event to the parent.

  closeEvent() { //For when the popup is simply closed (team creation canceled), emit a close event to make the popup dissapear in the parent component
    this.close.emit();
  }

}
