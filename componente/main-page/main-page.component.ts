import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {ConferenceService} from "./conferences/shared/service";
import {AbstractService} from "./abstracts/shared/service";
import {Conference} from "../../../../componente/main-page/conferences/shared/model";
import {ConferenceUser} from "./conferences/shared/model";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {
    conferencesList: ConferenceUser[];
  constructor(private router: Router, private abstractService: AbstractService, private conferenceService: ConferenceService) { }

  @Input() option : number = 1;

  ngOnInit(): void {
    if(localStorage.getItem("state")=="true")
      this.conferenceService.getConferencesFromUser().subscribe(c=>{
      this.conferencesList = c;
    });
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

  userIsChairAtAConference():boolean{
    return false;
  }
  userIsPCMemberAtAConference():boolean{
    return false;
  }
  userIsAuthorAtAConference():boolean{
    return false;
  }
  userIsMemberAtAConference():boolean{
    return false;
  }

  populateConferenceList(user_title: string):ConferenceUser[]{
    return this.conferencesList.filter(p=>p.title == user_title);
  }

  changeSelectedConference(conference_id: number):void{
    localStorage.setItem("selected_conference_id",conference_id.toString());
  }
}
