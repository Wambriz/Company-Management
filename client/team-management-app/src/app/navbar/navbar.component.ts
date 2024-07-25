import { Component, OnInit } from '@angular/core';
import { FullUserDto } from '../models';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  user: FullUserDto | null = null;
  isAdmin: boolean = false;

  ngOnInit(): void {
    const userData = localStorage.getItem('user');
    if (userData) {
      this.user = JSON.parse(userData) as FullUserDto;
      this.isAdmin = this.user.isAdmin;
    }
  }
}
