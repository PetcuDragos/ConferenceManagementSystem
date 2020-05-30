import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {CreateConferenceService} from "./shared/createConference.service";

@Component({
  selector: 'app-create-conference-page',
  templateUrl: './create-conference-page.component.html',
  styleUrls: ['./create-conference-page.component.css']
})
export class CreateConferencePageComponent implements OnInit {

  constructor(private router: Router, private createConferenceService: CreateConferenceService) {
  }

  ngOnInit(): void {
  }

  save(conference_name: string, chair_username: string, co_chair_username: string, starting_date: Date, ending_date: Date, abstract_deadline: Date, paper_deadline: Date, bidding_deadline: Date, reEval_Date:Date, submissionDate:Date, review_deadline: Date): void {
    if (this.check(starting_date, abstract_deadline) && this.check(abstract_deadline, paper_deadline) &&
      this.check(paper_deadline, bidding_deadline) && this.check(bidding_deadline, review_deadline) &&
      this.check(review_deadline, reEval_Date) && this.check(reEval_Date,submissionDate) &&
      this.check(submissionDate, ending_date)) {
      this.createConferenceService.add(conference_name, chair_username, co_chair_username, starting_date, ending_date, abstract_deadline, paper_deadline, bidding_deadline, review_deadline, reEval_Date, submissionDate).subscribe(t=>{
        if (t.entity != null){
          alert("Conference creation was successful");
          this.back();
        }
        else{
          alert(t.error);
        }
      });
    } else {
      document.getElementById("error").innerHTML = "The dates should be chronological.";
    }
  }

  back(): void {
    this.router.navigate(['']);
  }

  mainpage(): void {
    this.router.navigate(['']);
  }

  check(date1: Date, date2: Date): boolean {
    if (date1.getFullYear() < date2.getFullYear())
      return true;
    else if (date1.getFullYear() == date2.getFullYear()) {
      if (date1.getMonth() < date2.getMonth())
        return true;
      else if (date1.getMonth() == date2.getMonth() && date1.getDate() < date2.getDate())
        return true;
    }
    return false;
  }


}
