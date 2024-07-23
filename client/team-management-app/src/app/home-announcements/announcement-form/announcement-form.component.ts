import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BackendService } from '../../backend.service';
import { CreateAnnouncementDto, FullUserDto } from '../../models';

@Component({
  selector: 'app-announcement-form',
  templateUrl: './announcement-form.component.html',
  styleUrls: ['./announcement-form.component.css']
})
export class AnnouncementFormComponent {
  createAnnouncementForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private backendService: BackendService,
    private dialogRef: MatDialogRef<AnnouncementFormComponent>
  ) {
    this.createAnnouncementForm = this.fb.group({
      title: ['', Validators.required],
      message: ['', Validators.required]
    });
  }

  submitAnnouncement(): void {
    if (this.createAnnouncementForm.valid) {
      const selectedCompanyString = localStorage.getItem('selectedCompany');
      const userString = localStorage.getItem('user');

      if (selectedCompanyString && userString) {
        const selectedCompany = JSON.parse(selectedCompanyString);
        const user: FullUserDto = JSON.parse(userString);
        
        const newAnnouncement: CreateAnnouncementDto = {
          title: this.createAnnouncementForm.value.title,
          message: this.createAnnouncementForm.value.message,
          author: user
        };

        this.backendService.createAnnouncement(selectedCompany.id, newAnnouncement)
          .subscribe(response => {
            this.dialogRef.close(response);
          }, error => {
            console.error('Error creating announcement', error);
          });
      } else {
        console.error('No company selected or user not found.');
      }
    }
  }

  close(): void {
    this.dialogRef.close();
  }
}
