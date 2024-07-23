import { Component, OnInit } from '@angular/core';
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
  showForm: boolean = false;

  constructor(
    private backendService: BackendService
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

  openForm() {
    this.showForm = true;
  }

  closeForm() {
    this.showForm = false;
  }
}
