import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Conference} from "./model";

@Injectable()
export class MemberService {

  constructor(private httpClient: HttpClient) {
  }

  getConferences(): Observable<Conference[]> {
    return this.httpClient.get<Array<Conference>>("http://localhost:8080/api/conference");
  }
  getConferencesFromUser(): Observable<Conference[]> {
    let user = localStorage.getItem("username");
    return this.httpClient.get<Array<Conference>>("http://localhost:8080/api/conference/"+user);
  }
}
