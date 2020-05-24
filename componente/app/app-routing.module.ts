import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MainPageComponent} from "./main-page/main-page.component";
import {LoginPageComponent} from "./login-page/login-page.component";
import {RegisterPageComponent} from "./register-page/register-page.component";
import {ProfilePageComponent} from "./profile-page/profile-page.component";
import {CreateConferencePageComponent} from "./create-conference-page/create-conference-page.component";
import {AbstractsComponent} from "./main-page/abstracts/abstracts.component";
import {CreateAbstractPageComponent} from "./create-abstract-page/create-abstract-page.component";
import {ChangeDeadlinePageComponent} from "./change-deadline-page/change-deadline-page.component";



const routes: Routes = [
  {path: '', component: MainPageComponent},
  {path: 'login', component: LoginPageComponent},
  {path: 'register', component: RegisterPageComponent},
  {path: 'profile', component: ProfilePageComponent},
  {path: 'create-conference', component: CreateConferencePageComponent},
  {path: 'create-abstract', component: CreateAbstractPageComponent},
  {path: 'change-deadline', component: ChangeDeadlinePageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    onSameUrlNavigation: 'reload',
    scrollPositionRestoration: 'top'
  })],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
