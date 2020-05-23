import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ChangeDeadlineMessage, ChangeDeadlineModel} from "./changeDeadline.model";
import {MyDate} from "../../create-conference-page/shared/createConference.model";

@Injectable()
export class ChangeDeadlineService{

  constructor(private httpClient: HttpClient) {
  }

  update(abstract_deadline: Date,paper_deadline: Date,bidding_deadline : Date,review_deadline:Date,ending_date: Date): void{
    var id = localStorage.getItem("selected_conference_id");
    var model = new ChangeDeadlineModel();
    model.conference = id;
    model.abstract_deadline = new MyDate(abstract_deadline.getDate(),abstract_deadline.getMonth()+1,abstract_deadline.getFullYear());
    model.paper_deadline = new MyDate(paper_deadline.getDate(),paper_deadline.getMonth()+1,paper_deadline.getFullYear());
    model.bidding_deadline = new MyDate(bidding_deadline.getDate(),bidding_deadline.getMonth()+1,bidding_deadline.getFullYear());
    model.review_deadline = new MyDate(review_deadline.getDate(),review_deadline.getMonth()+1,review_deadline.getFullYear());
    model.ending_date = new MyDate(ending_date.getDate(),ending_date.getMonth()+1,ending_date.getFullYear());
    this.httpClient.put<ChangeDeadlineMessage>("http://localhost:8080/api/change_deadline", model).subscribe(response=>
    {
      console.log("changeDeadine: ", response.error);
      console.log("changeDeadline: ", response.entity);
    });
  }

}
