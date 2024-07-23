import { Component, OnInit } from '@angular/core';
import { BackendService } from '../backend.service';
import { FullUserDto } from '../models';

@Component({
  selector: 'app-users-reg',
  templateUrl: './users-reg.component.html',
  styleUrl: './users-reg.component.css'
})
export class UsersRegComponent implements OnInit{
  users: FullUserDto[] = [];

  constructor(private backendService: BackendService) {}

  ngOnInit(): void {
    this.backendService.getUsers().subscribe((data: FullUserDto[]) => {
      this.users = data;
    })
  }

}
