import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Conference, ConferenceDescription, ConferenceUser} from "./model";

@Injectable()
export class ConferenceService {

  constructor(private httpClient: HttpClient) {
  }

  getConferences(): Observable<Conference[]> {
    return this.httpClient.get<Array<Conference>>("http://localhost:8080/api/conferences");
  }
  getConferencesFromUser(): Observable<ConferenceUser[]> {
    if(localStorage.getItem("username") != null) {
      let user = localStorage.getItem("username");
      return this.httpClient.post<Array<ConferenceUser>>("http://localhost:8080/api/conferences/", user);
    }
    return null;
  }
  getConferencesChairCoChair(): Observable<ConferenceDescription[]> {
    if(localStorage.getItem("username") != null) {
      let user = localStorage.getItem("username");
      return this.httpClient.get<Array<ConferenceDescription>>("http://localhost:8080/api/conferences/");
    }
    return null;
  }
}
