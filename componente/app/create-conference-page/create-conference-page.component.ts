import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {CreateConferenceService} from "./shared/createConference.service";

@Component({
  selector: 'app-create-conference-page',
  templateUrl: './create-conference-page.component.html',
  styleUrls: ['./create-conference-page.component.css']
})
export class CreateConferencePageComponent implements OnInit {

  constructor(private router: Router, private createConferenceService: CreateConferenceService) { }

  ngOnInit(): void {
  }

  save(conference_name :string,chair_username: string,co_chair_username:string ,starting_date: Date,ending_date: Date,abstract_deadline: Date,paper_deadline: Date,bidding_deadline : Date,review_deadline:Date): void{
    this.createConferenceService.add(conference_name,chair_username,co_chair_username,starting_date,ending_date,abstract_deadline,paper_deadline,bidding_deadline,review_deadline);
    this.back();
  }

  back() :void {
    this.router.navigate(['']);
  }

  mainpage():void{
    this.router.navigate(['']);
  }

}
