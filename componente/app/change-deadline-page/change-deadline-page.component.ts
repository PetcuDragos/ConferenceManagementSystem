import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {ChangeDeadlineService} from "./shared/changeDeadline.service";

@Component({
  selector: 'app-change-deadline-page',
  templateUrl: './change-deadline-page.component.html',
  styleUrls: ['./change-deadline-page.component.css']
})

export class ChangeDeadlinePageComponent implements OnInit {

  constructor(private router: Router, private service: ChangeDeadlineService) {
  }

  ngOnInit(): void {
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
