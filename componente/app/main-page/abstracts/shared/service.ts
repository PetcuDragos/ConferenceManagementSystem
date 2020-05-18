import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AbstractAuthorDto, AbstractDto} from "./model";

@Injectable()
export class AbstractService {

  constructor(private httpClient: HttpClient) {
  }

  getAbstractsFromConference(): Observable<AbstractAuthorDto[]> {
    let conference_id = localStorage.getItem("selected_conference_id");
    if(conference_id != "")
      return this.httpClient.get<Array<AbstractAuthorDto>>("http://localhost:8080/api/abstract/", {params:{conferenceName: conference_id}});
    else return null;
  }
}
