import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CredentialsDto, FullUserDto } from './models';

@Injectable({
  providedIn: 'root',
})
export class BackendService {
  private backendUrl = 'http://localhost:4200/';

  constructor(private http: HttpClient) {}
  //This is where we will communicate with our backend and perform other services like unpacking DTOs into our models

  login(credentials: CredentialsDto): Observable<FullUserDto> {
    return this.http.post<FullUserDto>(
      this.backendUrl + 'users/login',
      credentials
    );
  }
}
