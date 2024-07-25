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
  user: FullUserDto | null = null;
  isAdmin: boolean = false;

  constructor(
    private backendService: BackendService
  ) {}

  ngOnInit(): void {
    const selectedCompanyString = localStorage.getItem('selectedCompany');
    if (selectedCompanyString) {
      const selectedCompany: CompanyDto = JSON.parse(selectedCompanyString);
      console.log("fetching announcements from component.ts")
      this.backendService.fetchAnnouncements(selectedCompany.id).subscribe((announcements) => {
        this.announcements = announcements;
      });
    } else {
      console.error('No company selected.');
    }

    const userData = localStorage.getItem('user');
    if (userData) {
      this.user = JSON.parse(userData) as FullUserDto;
      this.isAdmin = this.user.isAdmin;
    }
  }

  openForm() {
    this.showForm = true;
  }

  closeForm() {
    this.showForm = false;
  }
}
