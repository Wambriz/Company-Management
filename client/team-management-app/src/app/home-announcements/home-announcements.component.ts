import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AnnouncementDto, CompanyDto, FullUserDto } from '../models';
import { BackendService } from '../backend.service';
import { AnnouncementFormComponent } from './announcement-form/announcement-form.component';

@Component({
  selector: 'app-home-announcements',
  templateUrl: './home-announcements.component.html',
  styleUrls: ['./home-announcements.component.css']
})
export class HomeAnnouncementsComponent implements OnInit {
  announcements: AnnouncementDto[] = [];

  constructor(
    private backendService: BackendService,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    const selectedCompanyString = localStorage.getItem('selectedCompany');
    if (selectedCompanyString) {
      const selectedCompany: CompanyDto = JSON.parse(selectedCompanyString);
      this.announcements = this.backendService.fetchAnnouncements(selectedCompany.id);
    } else {
      console.error('No company selected.');
    }
  }

  openCreateAnnouncementPopup(): void {
    const dialogRef = this.dialog.open(AnnouncementFormComponent);

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.announcements.push(result);
      }
    });
  }
}
