import { Component, OnInit } from '@angular/core';
import { AnnouncementDto, CompanyDto } from '../models';
import { BackendService } from '../backend.service';

@Component({
  selector: 'app-home-announcements',
  templateUrl: './home-announcements.component.html',
  styleUrls: ['./home-announcements.component.css']
})
export class HomeAnnouncementsComponent implements OnInit {
  announcements: AnnouncementDto[] = [];

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

}
