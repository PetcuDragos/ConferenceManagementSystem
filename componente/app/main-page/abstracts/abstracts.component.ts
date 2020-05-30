import { Component, OnInit } from '@angular/core';
import {AbstractService} from "./shared/service";
import {Abstract, AbstractAuthorDto, AbstractDto, PCMemberDto} from "./shared/model";
import {Router} from "@angular/router";
import {ConferenceService} from "../conferences/shared/service";
import {Conference} from "../conferences/shared/model";
import {CreateAbstractModel} from "../../create-abstract-page/shared/create.abstract.model";
import {ReviewAbstractService} from "../../review-abstract-page/shared/service";
import {ReviewService} from "../../reviews-page/shared/service";
import {EditAbstractService} from "../../edit-abstract-page/shared/service";
@Component({
  selector: 'app-abstracts',
  templateUrl: './abstracts.component.html',
  styleUrls: ['./abstracts.component.css']
})
export class AbstractsComponent implements OnInit {
  abstracts: AbstractAuthorDto[];
  conference:Conference;
  pcmember_option:boolean;
  addSection_option:boolean;
  constructor(private abstractService: AbstractService, private router: Router, private conferenceService:ConferenceService, private reviewAbstractService: ReviewAbstractService, private reviewService: ReviewService, private editAbstractService: EditAbstractService) {
    this.pcmember_option = false;
    this.addSection_option = false;
    this.abstracts = [];
    this.conference=null;
    this.pcmembers = [];
  }

  ngOnInit(): void {
    this.pcmembers = [];
    console.log("init abstracts");
    if(localStorage.getItem("selected_conference_id") != "")
    this.abstractService.getAbstractsFromConference().subscribe(
      abstracts=>{if(abstracts!=null) this.abstracts = abstracts;
      this.getConferenceDetails();
      this.abstractService.isUserChairForConference();
      this.abstractService.isUserPCMemberForConference();
      this.abstractService.isUserAuthor()}
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

  //TODO: A4
  alreadyPostedAbstract(): boolean {
    var username = localStorage.getItem("username");
    return this.abstracts.filter(p=>p.authorName==username).length > 0;
  }

  changeDeadlines():void{
    this.router.navigate(['change-deadline']);
    console.log("not made yet.")
  }

  bidAbstract(abs: AbstractAuthorDto, selectedOption:string):void{
    //ugly and highly coupled
    console.log(selectedOption);
    abs.bidded=true;
    this.abstractService.addBid(abs.entity.id,+selectedOption);

  }

  reviewPaper(abstract_id:number):void{
      this.reviewAbstractService.abstract_id = abstract_id;
      this.router.navigate(['review-abstract']);
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
  getReEvalDeadline():string{
    if(this.conference!= null)
      return this.conference.reEvalDate.day.toString() + '/' + this.conference.reEvalDate.month.toString() + '/' + this.conference.reEvalDate.year.toString();
    return "none";
  }
  getSubmissionDeadline():string{
    if(this.conference!= null)
      return this.conference.submissionDate.day.toString() + '/' + this.conference.submissionDate.month.toString() + '/' + this.conference.submissionDate.year.toString();
    return "none";
  }

  isUserPCMemberForConference(): boolean{
    return this.abstractService.pcmember;
  }
  isUserChairForConference(): boolean{
    return this.abstractService.chair;
  }


  addPCMemberOption():void{
    this.pcmember_option = true;
  }

  addPCMember(username:string):void{
    this.abstractService.addPCMember(username).subscribe(m=>{
      if(m==true) alert("Success!");
      else alert("There has been an error, are you sure he/she is a member?");
      console.log(m);});
  }

  getUsername():string{
    return localStorage.getItem("username");
  }

  editAbstract(abstract_id:number):void{
    this.editAbstractService.id = abstract_id;
    this.router.navigate(['edit-abstract']);
  }

  canPostAbstract():boolean{
    var date1 = new Date();
    if (date1.getFullYear() < this.conference.abstractDeadline.year)
      return true;
    else if (date1.getFullYear() == this.conference.abstractDeadline.year) {
      if (date1.getMonth()+1 < this.conference.abstractDeadline.month)
        return true;
      else if (date1.getMonth()+1 == this.conference.abstractDeadline.month && date1.getDate() < this.conference.abstractDeadline.day)
        return true;
    }
    return false;
  }

  canBid():boolean{
    var date1 = new Date();
    if (date1.getFullYear() < this.conference.bidDeadline.year)
      return true;
    else if (date1.getFullYear() == this.conference.bidDeadline.year) {
      if (date1.getMonth()+1 < this.conference.bidDeadline.month)
        return true;
      else if (date1.getMonth()+1 == this.conference.bidDeadline.month && date1.getDate() < this.conference.bidDeadline.day)
        return true;
    }
    return false;
  }

  canSubmission():boolean{
    var date1 = new Date();
    if (date1.getFullYear() < this.conference.submissionDate.year)
      return true;
    else if (date1.getFullYear() == this.conference.submissionDate.year) {
      if (date1.getMonth()+1 < this.conference.submissionDate.month)
        return true;
      else if (date1.getMonth()+1 == this.conference.submissionDate.month && date1.getDate() < this.conference.submissionDate.day)
        return true;
    }
    return false;
  }

  addSubmissionOption():void{
    this.addSection_option = true;
  }

  canReview():boolean{
    var date1 = new Date();
    if (date1.getFullYear() < this.conference.reviewDeadline.year)
      return true;
    else if (date1.getFullYear() == this.conference.reviewDeadline.year) {
      if (date1.getMonth()+1 < this.conference.reviewDeadline.month)
        return true;
      else if (date1.getMonth()+1 == this.conference.reviewDeadline.month && date1.getDate() < this.conference.reviewDeadline.day)
        return true;
    }
    return false;
  }

  canReEval():boolean{
    var date1 = new Date();
    console.log(date1.getFullYear(),date1.getMonth()+1,date1.getDate());
    if (date1.getFullYear() < this.conference.reEvalDate.year)
      return true;
    else if (date1.getFullYear() == this.conference.reEvalDate.year) {
      if (date1.getMonth()+1 < this.conference.reEvalDate.month)
        return true;
      else if (date1.getMonth()+1 == this.conference.reEvalDate.month && date1.getDate() < this.conference.reEvalDate.day)
        return true;
    }
    return false;
  }

  canChangePaper():boolean{
    var date1 = new Date();
    if (date1.getFullYear() < this.conference.paperDeadline.year)
      return true;
    else if (date1.getFullYear() == this.conference.paperDeadline.year) {
      if (date1.getMonth()+1 < this.conference.paperDeadline.month)
        return true;
      else if (date1.getMonth()+1 == this.conference.paperDeadline.month && date1.getDate() < this.conference.paperDeadline.day)
        return true;
    }
    return false;
  }

  notEnded():boolean{
    var date1 = new Date();
    if (date1.getFullYear() < this.conference.endingDate.year)
      return true;
    else if (date1.getFullYear() == this.conference.endingDate.year) {
      if (date1.getMonth()+1 < this.conference.endingDate.month)
        return true;
      else if (date1.getMonth()+1 == this.conference.endingDate.month && date1.getDate() < this.conference.endingDate.day)
        return true;
    }
    return false;
  }


  seeReviews(abstract_id:number){
    this.reviewService.abstract_id = abstract_id;
    this.router.navigate(['reviews']);
}
  downloadPaper(abstract_url:string){
    this.abstractService.downloadPaper(abstract_url);
  }

  pcmembers: PCMemberDto[];
  getPCMembers(abstract_entity:AbstractAuthorDto, abstract_id:number):void{
    this.abstracts.forEach(p=>p.show_reviewers=false);
    this.abstractService.getPCMembers(abstract_id).subscribe(m=>{this.pcmembers=m;
    this.abstracts.filter(a=>a.entity.id==abstract_id)[0].show_reviewers = true;
    abstract_entity.show_reviewers = true;
    });
  }

  assignReviewer(abstract_entity:AbstractAuthorDto, abstract_id:number,pc_id:number):void{
    this.abstractService.assignPCMember(abstract_id, pc_id).subscribe(m=>{
      abstract_entity.show_reviewers = false;})
  }

  askForReEval(abstract_entity:AbstractAuthorDto, abstract_id:number):void{
    this.abstractService.askForReEval(abstract_id).subscribe(m=>{abstract_entity.askForReEval = true;});
  }

  acceptPaper(abstract_entity:AbstractAuthorDto,abstract_id:number):void{
    this.abstractService.acceptPaper(abstract_id).subscribe(m=>{abstract_entity.acceptAbstractButton = true;});
  }

  declinePaper(abstract_entity:AbstractAuthorDto, abstract_id:number):void{
    this.abstractService.declinePaper(abstract_id).subscribe(m=>{abstract_entity.acceptAbstractButton = true;});
  }

  addSection(pc_username:string, section_name:string):void{
    this.abstractService.addSection(pc_username,section_name).subscribe(m=>{});
  }

  joinSectionPaper(abstract_entity: AbstractAuthorDto, abstract_id:number, section_name:string):void{
    this.abstractService.joinSectionPaper(abstract_id, section_name).subscribe(m=>{abstract_entity.joinSection = true;});
  }

  uploadFile($event) {
    console.log($event.target.files[0]); // outputs the first file
    var paper = $event.target.files[0];
  }
}
