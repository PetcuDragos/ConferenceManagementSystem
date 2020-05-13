import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Globals} from "../globals";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  constructor(private router: Router, private globals : Globals) { }

  ngOnInit(): void {
  }

  register(){
    this.router.navigate(['register']);
  }

  login(){
    this.router.navigate(['login']);
  }

  logout(){
      this.globals.state = false;
      this.globals.username = "";
  }

  isAuthenticated(): boolean{
    return this.globals.state;
  }

  getUsername(): string{
    return this.globals.username;
  }

  profile() : void {
    this.router.navigate(['profile']);
  }
}
