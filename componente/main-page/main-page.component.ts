import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  constructor(private router: Router) { }

  @Input() option : number = 1;

  ngOnInit(): void {
  }

  register(){
    this.router.navigate(['register']);
  }

  mainpage():void{
    this.router.navigate(['']);
  }

    login(){
    this.router.navigate(['login']);
  }

  logout(){
    localStorage.removeItem("username");
    localStorage.setItem("state", "false");
    localStorage.clear();
  }

  isAuthenticated(): boolean{
    if(localStorage.getItem("state")=="true")
      return true;
    return false;
  }

  getUsername(): string{
    return localStorage.getItem("username");
  }

  profile(): void{
    this.router.navigate(["profile"]);
  }

  populateConferenceList():void{

  }
  conferences():void{
    this.option = 2;
  }

  papers():void{
    this.option = 3;
  }

  members():void{
    this.option = 4;
  }

  getOption():number{
    return this.option;
  }
}
