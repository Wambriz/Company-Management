import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TeamsComponent } from './teams/teams.component';
import { TeamCardComponent } from './teams/team-card/team-card.component';
import { LoginComponent } from './login/login.component';
import { SelectCompanyComponent } from './select-company/select-company.component';
import { HomeAnnouncementsComponent } from './home-announcements/home-announcements.component';
import { CreateTeamCardComponent } from './teams/create-team-card/create-team-card.component';
import { TeamCreationPopupComponent } from './teams/team-creation-popup/team-creation-popup.component';
import { BackendService } from './backend.service';
import { RouterModule, Routes } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';
import { TeamProjectsComponent } from './team-projects/team-projects.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { AnnouncementFormComponent } from './home-announcements/announcement-form/announcement-form.component';
import { UsersRegComponent } from './users-reg/users-reg.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'select-company', component: SelectCompanyComponent },
  { path: 'home-announcements', component: HomeAnnouncementsComponent },
  { path: 'teams', component: TeamsComponent },
  { path: 'projects', component: TeamProjectsComponent },
  { path: 'users-reg', component: UsersRegComponent},
  { path: '', redirectTo: '/login', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    TeamsComponent,
    TeamCardComponent,
    AppComponent,
    LoginComponent,
    SelectCompanyComponent,
    HomeAnnouncementsComponent,
    CreateTeamCardComponent,
    TeamCreationPopupComponent,
    NavbarComponent,
    TeamProjectsComponent,
    TeamCreationPopupComponent,
    AnnouncementFormComponent,
    UsersRegComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
  ],
  providers: [
    provideClientHydration(),
    BackendService,
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
