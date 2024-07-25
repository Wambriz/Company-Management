import { Component, OnInit, ViewChild, TemplateRef } from '@angular/core';
import { BackendService } from '../backend.service';
import { FullUserDto } from '../models';

@Component({
  selector: 'app-users-reg',
  templateUrl: './users-reg.component.html',
  styleUrls: ['./users-reg.component.css']
})
export class UsersRegComponent implements OnInit {
  users: FullUserDto[] = [];
  showForm: boolean = false;

  constructor(private backendService: BackendService) {}

  ngOnInit(): void {
    this.backendService.getUsers().subscribe((data: FullUserDto[]) => {
      this.users = data;
    });
  }

  openForm() {
    this.showForm = true;
  }

  closeForm() {
    this.showForm = false;
  }
}
