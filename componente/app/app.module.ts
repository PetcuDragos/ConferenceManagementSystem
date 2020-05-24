import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainPageComponent } from './main-page/main-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import {HttpClientModule} from "@angular/common/http";
import {LoginService} from "./login-page/shared/service";
import {RegisterService} from "./register-page/shared/service";
import {ProfilePageComponent} from "./profile-page/profile-page.component";
import { AbstractsComponent } from './main-page/abstracts/abstracts.component';
import { ConferencesComponent } from './main-page/conferences/conferences.component';
import { PapersComponent } from './main-page/papers/papers.component';
import { MembersComponent } from './main-page/members/members.component';
import {MemberService} from "./main-page/members/shared/service";
import {PaperService} from "./main-page/papers/shared/service";
import {ConferenceService} from "./main-page/conferences/shared/service";
import {AbstractService} from "./main-page/abstracts/shared/service";
import {ProfilePageService} from "./profile-page/shared/service";
import { CreateConferencePageComponent } from './create-conference-page/create-conference-page.component';
import {CreateConferenceService} from "./create-conference-page/shared/createConference.service";
import { CreateAbstractPageComponent } from './create-abstract-page/create-abstract-page.component';
import {CreateAbstractService} from "./create-abstract-page/shared/create.abstract.service";
import { ReviewAbstractPageComponent } from './review-abstract-page/review-abstract-page.component';
import { AssignReviewersPageComponent } from './assign-reviewers-page/assign-reviewers-page.component';
import { ChangeDeadlinePageComponent } from './change-deadline-page/change-deadline-page.component';
import {ChangeDeadlineService} from "./change-deadline-page/shared/changeDeadline.service";

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    LoginPageComponent,
    RegisterPageComponent,
    ProfilePageComponent,
    AbstractsComponent,
    ConferencesComponent,
    PapersComponent,
    MembersComponent,
    CreateConferencePageComponent,
    CreateAbstractPageComponent,
    ReviewAbstractPageComponent,
    AssignReviewersPageComponent,
    ChangeDeadlinePageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [LoginService, RegisterService, MemberService, PaperService, ConferenceService, AbstractService, ProfilePageService, CreateConferenceService, CreateAbstractService, ChangeDeadlineService],
  bootstrap: [AppComponent]
})
export class AppModule { }
