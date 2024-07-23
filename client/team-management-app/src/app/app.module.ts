import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatDialogModule} from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field'
import { MatInputModule } from '@angular/material/input'
import { MatButtonModule } from '@angular/material/button'

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
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { AnnouncementFormComponent } from './home-announcements/announcement-form/announcement-form.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'select-company', component: SelectCompanyComponent },
  { path: 'home-announcements', component: HomeAnnouncementsComponent },
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
    AnnouncementFormComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule
  ],
  providers: [
    provideClientHydration(),
    BackendService,
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
