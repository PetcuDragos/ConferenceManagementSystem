import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CreateAbstractModel} from "../../create-abstract-page/shared/create.abstract.model";
import {ReviewAbstractModel} from "./model";
import {MyDate} from "../../change-deadline-page/shared/changeDeadline.model";

@Injectable()
export class ReviewAbstractService {
  abstract_id:number;
  constructor(private httpClient: HttpClient) {
  }

  reviewAbstract(content:string, result:number): Observable<any>{
    var date = new MyDate();
    var currentDate = new Date();
    date.day = currentDate.getDate();
    date.month = currentDate.getMonth()+1;
    date.year = currentDate.getFullYear();
    var c = new ReviewAbstractModel(localStorage.getItem("selected_conference_id"),this.abstract_id,content,result,localStorage.getItem("username"),date);
    return this.httpClient.post<any>("http://localhost:8080/api/updatereview",c);
  }



}
