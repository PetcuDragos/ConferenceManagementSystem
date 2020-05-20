import { Component, OnInit } from '@angular/core';
import {AbstractService} from "./shared/service";
import {Abstract, AbstractAuthorDto, AbstractDto} from "./shared/model";
import {Router} from "@angular/router";
import {ConferenceService} from "../conferences/shared/service";
import {Conference} from "../conferences/shared/model";
@Component({
  selector: 'app-abstracts',
  templateUrl: './abstracts.component.html',
  styleUrls: ['./abstracts.component.css']
})
export class AbstractsComponent implements OnInit {
  abstracts: AbstractAuthorDto[];
  conference:Conference;
  pcmember:boolean;
  chair:boolean;
  constructor(private abstractService: AbstractService, private router: Router, private conferenceService:ConferenceService) {
    this.abstracts = [];
    this.conference=null;
  }

  ngOnInit(): void {
    console.log("init abstracts");
    if(localStorage.getItem("selected_conference_id") != "")
    this.abstractService.getAbstractsFromConference().subscribe(
      abstracts=>{if(abstracts!=null) this.abstracts = abstracts;
      this.getConferenceDetails();
      this.abstractService.isUserChairForConference();
      this.abstractService.isUserPCMemberForConference();}
    )
  }

  getConferenceDetails(){
    this.conferenceService.getConferenceFromName(localStorage.getItem("selected_conference_id")).subscribe(m=>{
      this.conference = m;
    });
  }


  hasAnyConference():boolean{
    return localStorage.getItem("selected_conference_id")!="";
  }

  addAbstract():void{
    this.router.navigate(['create-abstract']);
  }

  changeDeadlines():void{
    console.log("not made yet.")
  }

  bidAbstract():void{
    console.log("not implemented.")
  }

  reviewPaper():void{
    console.log("not implemented.")
  }

  getAbstractDeadline():string{
    if(this.conference!= null)
      return this.conference.abstractDeadline.day.toString() + '/' + this.conference.abstractDeadline.month.toString() + '/' + this.conference.abstractDeadline.year.toString();
    return "none";
  }
  getPaperDeadline():string{
    if(this.conference!= null)
    return this.conference.paperDeadline.day.toString() + '/' + this.conference.paperDeadline.month.toString() + '/' + this.conference.paperDeadline.year.toString();
    return "none";
  }
  getBidDeadline():string{
    if(this.conference!= null)
    return this.conference.bidDeadline.day.toString() + '/' + this.conference.bidDeadline.month.toString() + '/' + this.conference.bidDeadline.year.toString();
    return "none";
  }
  getReviewDeadline():string{
    if(this.conference!= null)
    return this.conference.reviewDeadline.day.toString() + '/' + this.conference.reviewDeadline.month.toString() + '/' + this.conference.reviewDeadline.year.toString();
    return "none";
  }

  isUserPCMemberForConference(): boolean{
    return this.abstractService.pcmember;
  }
  isUserChairForConference(): boolean{
    return this.abstractService.chair;
  }



}
