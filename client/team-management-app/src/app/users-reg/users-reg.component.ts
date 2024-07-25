import { Component, OnInit, ViewChild, TemplateRef } from '@angular/core';
import { BackendService } from '../backend.service';
import { CompanyDto, FullUserDto } from '../models';

@Component({
  selector: 'app-users-reg',
  templateUrl: './users-reg.component.html',
  styleUrls: ['./users-reg.component.css'],
})
export class UsersRegComponent implements OnInit {
  users: FullUserDto[] = [];
  showForm: boolean = false;

  constructor(private backendService: BackendService) {}

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers(): void {
    const selectedCompanyString = localStorage.getItem('selectedCompany');
    console.log('before update');
    if (selectedCompanyString) {
      const selectedCompany: CompanyDto = JSON.parse(selectedCompanyString);
      this.backendService
        .getUsers(selectedCompany.id)
        .subscribe((data) => {
          this.users = data;
          console.log('after update');
        });
    }
  }

  openForm() {
    this.showForm = true;
  }

  closeForm() {
    this.showForm = false;
  }

  onUserCreated() {
    console.log('made it here');
    this.loadUsers();
    this.showForm = false;
  }
}
