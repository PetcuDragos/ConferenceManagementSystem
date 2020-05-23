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

  check(date1: Date, date2: Date): boolean{
    if(date1.getFullYear()<date2.getFullYear())
      return true;
    else if(date1.getFullYear()==date2.getFullYear())
    {
      if(date1.getMonth()<date2.getMonth())
        return true;
      else if(date1.getMonth()==date2.getMonth() && date1.getDay()<date2.getDay())
        return true;
    }
    return false;
  }

  save(conference_name :string,chair_username: string,co_chair_username:string ,starting_date: Date,ending_date: Date,abstract_deadline: Date,paper_deadline: Date,bidding_deadline : Date,review_deadline:Date): void{
    if(this.check(starting_date, abstract_deadline) && this.check(abstract_deadline, paper_deadline) && this.check(paper_deadline, bidding_deadline) && this.check(bidding_deadline,review_deadline) && this.check(review_deadline, ending_date)) {
      this.createConferenceService.add(conference_name,chair_username,co_chair_username,starting_date,ending_date,abstract_deadline,paper_deadline,bidding_deadline,review_deadline);
      this.back();
    }
    else{
      document.getElementById("error").innerHTML="The dates should be chronological.";
    }
  }

  back() :void {
    this.router.navigate(['']);
  }

  mainpage():void{
    this.router.navigate(['']);
  }

}
