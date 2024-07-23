import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BackendService } from '../backend.service';
import { CredentialsDto, FullUserDto } from '../models';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup;
  errorMessage: string | null = null;

  constructor(
    private fb: FormBuilder,
    private backendService: BackendService,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      username: ['', Validators.required], //Validators.required makes the field a requirement -Devin
      password: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.loginForm.invalid) {
      this.errorMessage = 'All fields are required.'; //Sets the error message if Validators detemines this is a invalid login attempt -Devin
      return;
    }

    const credentials: CredentialsDto = this.loginForm.value;

    this.backendService.login(credentials).subscribe({
      next: (user: FullUserDto) => {
        localStorage.setItem('user', JSON.stringify(user)); //Saves User to localStorage -Devin
        if (user.isAdmin) {
          this.router.navigate(['/select-company']); //Navagate to the corrent page based on if the user is an admin or not. -Devin
        } else {
          this.router.navigate(['/home-announcements']);
        }
      },
      error: (err) => {
        this.errorMessage = 'Invalid username or password.';
      }
    });
  }
}
