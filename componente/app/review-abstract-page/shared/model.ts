import {MyDate} from "../../change-deadline-page/shared/changeDeadline.model";

export class ReviewAbstractModel{
  conference_name:string;
  abstract_id:number;
  content:string;
  result:number;
  username: string;
  date: MyDate;
  constructor(conference_name:string, abstract_id:number, content:string, result:number, username:string, date:MyDate) {
    this.conference_name = conference_name;
    this.abstract_id = abstract_id;
    this.content = content;
    this.result = result;
    this.username = username;
    this.date = date;
  }
}
