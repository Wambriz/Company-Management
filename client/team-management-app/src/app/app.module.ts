import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TeamsComponent } from './teams/teams.component';
import { TeamCardComponent } from './teams/team-card/team-card.component';
import { LoginComponent } from './login/login.component';
import { SelectCompanyComponent } from './select-company/select-company.component';
import { HomeAnnouncmentsComponent } from './home-announcments/home-announcments.component';
import { CreateTeamCardComponent } from './teams/create-team-card/create-team-card.component';
import { TeamCreationPopupComponent } from './teams/team-creation-popup/team-creation-popup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    TeamsComponent,
    TeamCardComponent,
    AppComponent,
    LoginComponent,
    SelectCompanyComponent,
    HomeAnnouncmentsComponent,
    CreateTeamCardComponent,
    TeamCreationPopupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
