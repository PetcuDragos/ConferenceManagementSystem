import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {ChangeDeadlineService} from "./shared/changeDeadline.service";
import {ChangeDeadlineModel, MyDate} from "./shared/changeDeadline.model";

@Component({
  selector: 'app-change-deadline-page',
  templateUrl: './change-deadline-page.component.html',
  styleUrls: ['./change-deadline-page.component.css']
})

export class ChangeDeadlinePageComponent implements OnInit {

  curentDates: ChangeDeadlineModel;
  private ending_date: MyDate;
  private submissionDate: MyDate;
  private reEval_deadline: MyDate;
  private review_deadline: MyDate;
  private bidding_deadline: MyDate;
  private paper_deadline: MyDate;
  private abstract_deadline: MyDate;
  private starting_date: MyDate;


  constructor(private router: Router, private service: ChangeDeadlineService) {
  }

  ngOnInit(): void {
    this.getCurentDates();

    //(<HTMLInputElement>document.getElementById("ending_date")).valueAsDate=this.MyDateToDate(this.curentDates.ending_date);
  }

  MyDateToDate(date: MyDate): Date{
    return new Date(date.year,date.month-1,date.day);
  }

  getCurentDates(): void{
    this.service.getCurentDates().subscribe(m => {
      this.curentDates = m;
      console.log(this.curentDates);
      (<HTMLInputElement>document.getElementById("abstract_deadline")).valueAsDate=this.MyDateToDate(this.curentDates.abstract_deadline);
      (<HTMLInputElement>document.getElementById("paper_deadline")).valueAsDate=this.MyDateToDate(this.curentDates.paper_deadline);
      (<HTMLInputElement>document.getElementById("bidding_deadline")).valueAsDate=this.MyDateToDate(this.curentDates.bidding_deadline);
      (<HTMLInputElement>document.getElementById("review_deadline")).valueAsDate=this.MyDateToDate(this.curentDates.review_deadline);
      (<HTMLInputElement>document.getElementById("reEval_deadline")).valueAsDate=this.MyDateToDate(this.curentDates.reEval_date);
      (<HTMLInputElement>document.getElementById("submission_deadline")).valueAsDate=this.MyDateToDate(this.curentDates.submissionDate);
      (<HTMLInputElement>document.getElementById("ending_date")).valueAsDate=this.MyDateToDate(this.curentDates.ending_date);

    });

  }

  check(date1: Date, date2: Date): boolean{
    if(date1.getFullYear()<date2.getFullYear())
      return true;
    else if(date1.getFullYear()==date2.getFullYear())
    {
      if(date1.getMonth()<date2.getMonth())
        return true;
      else if(date1.getMonth()==date2.getMonth() && date1.getDate()<date2.getDate())
          return true;
    }
    return false;
  }


  save(abstract_deadline: Date, paper_deadline: Date, bidding_deadline: Date, review_deadline: Date, reEval_deadline:Date, submissionDate:Date, ending_date: Date): void {
    console.log("change deadline components.ts");
    if(this.check(abstract_deadline, paper_deadline) && this.check(paper_deadline, bidding_deadline) && this.check(bidding_deadline,review_deadline) && this.check(review_deadline, reEval_deadline) && this.check(reEval_deadline,submissionDate) && this.check(submissionDate,ending_date)) {
      this.service.update(abstract_deadline, paper_deadline, bidding_deadline, review_deadline, reEval_deadline, submissionDate, ending_date);
      document.getElementById("error").innerHTML="";
      this.back();
    }
    else{
      document.getElementById("error").innerHTML="The dates should be chronological.";
    }
  }

  back(): void {
    this.router.navigate(['']);
  }

  mainpage(): void {
    this.router.navigate(['']);
  }

}
