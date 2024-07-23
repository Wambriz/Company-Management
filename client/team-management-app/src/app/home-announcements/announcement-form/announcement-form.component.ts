import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BackendService } from '../../backend.service';

@Component({
  selector: 'app-announcement-form',
  templateUrl: './announcement-form.component.html',
  styleUrls: ['./announcement-form.component.scss']
})
export class AnnouncementFormComponent {
  createAnnouncementForm: FormGroup;

  @Output() close = new EventEmitter<void>();

  constructor(
    private fb: FormBuilder,
    private backendService: BackendService
  ) {
    this.createAnnouncementForm = this.fb.group({
      title: ['', Validators.required],
      message: ['', Validators.required]
    });
  }

  submitAnnouncement() {
    if (this.createAnnouncementForm.valid) {
      const selectedCompanyString = localStorage.getItem('selectedCompany');
      const authorString = localStorage.getItem('user');
      const author = authorString ? JSON.parse(authorString) : null;

      let companyId = -1; //Negative 1 should return an error from the backend incase there is no company
      if (selectedCompanyString) {
        const selectedCompany = JSON.parse(selectedCompanyString);
        companyId = selectedCompany.id;
      }

      const announcement = {
        ...this.createAnnouncementForm.value,
        author: author ? author.name : 'Unknown'
      };

      this.backendService.createAnnouncement(companyId, announcement).subscribe(response => {
        console.log('Annoucement created successfuly', response);
        this.close.emit();
      });
    }
  }

  closeForm() {
    this.close.emit();
  }
}