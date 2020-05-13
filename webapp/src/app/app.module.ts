import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainPageComponent } from './main-page/main-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import {HttpClientModule} from "@angular/common/http";
import {LoginService} from "./login-page/shared/service";
import {Globals} from "./globals";
import {RegisterService} from "./register-page/shared/service";

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    LoginPageComponent,
    RegisterPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [LoginService, Globals, RegisterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
