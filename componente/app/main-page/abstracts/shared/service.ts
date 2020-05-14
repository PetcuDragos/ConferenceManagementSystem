import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Abstract} from "./model";

@Injectable()
export class AbstractService {

  constructor(private httpClient: HttpClient) {
  }

  getAbstractsFromConference(): Observable<Abstract[]> {
    let conference_id = localStorage.getItem("selected_conference_id");
    return this.httpClient.get<Array<Abstract>>("http://localhost:8080/api/abstracts/"+conference_id);
  }
}
