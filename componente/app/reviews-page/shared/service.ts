import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MyDate} from "../../change-deadline-page/shared/changeDeadline.model";
import {Review} from "./model";

@Injectable()
export class ReviewService {
  abstract_id:number;
  constructor(private httpClient: HttpClient) {
  }

  getReviews(): Observable<Review[]>{
    return this.httpClient.get<Review[]>("http://localhost:8080/api/get_reviews",{params: {abstract_id:this.abstract_id.toString()}});
  }



}
