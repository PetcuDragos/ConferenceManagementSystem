import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AbstractAuthorDto, CreateBidDto} from "./model";
import {MyDate} from "../../../create-conference-page/shared/createConference.model";

@Injectable()
export class AbstractService {
  pcmember: boolean;
  chair: boolean;

  constructor(private httpClient: HttpClient) {
    this.isUserPCMemberForConference();
    this.isUserChairForConference();
  }

  getAbstractsFromConference(): Observable<AbstractAuthorDto[]> {
    let conference_id = localStorage.getItem("selected_conference_id");
    if (conference_id != "")
      return this.httpClient.get<Array<AbstractAuthorDto>>("http://localhost:8080/api/abstract/", {params: {conferenceName: conference_id}});
    else return null;
  }

  isUserPCMemberForConference(): void {
    this.httpClient.post<boolean>("http://localhost:8080/api/ispcmember", {
      username: localStorage.getItem("username"),
      conference_name: localStorage.getItem("selected_conference_id")
    }).subscribe(m => {
      this.pcmember = m;
    });
  }

  isUserChairForConference(): void {
    this.httpClient.post<boolean>("http://localhost:8080/api/ischair", {
      username: localStorage.getItem("username"),
      conference_name: localStorage.getItem("selected_conference_id")
    }).subscribe(m => {
      this.chair = m;
    });
  }

  addPCMember(username: string): Observable<boolean> {
    return this.httpClient.post<boolean>("http://localhost:8080/api/addpcmember", {
      username: username,
      conference_name: localStorage.getItem("selected_conference_id")
    });
  }

  addBid(abs_id: number, result: number): void {
    var b = new CreateBidDto()
      b.pc_name = localStorage.getItem("username");
      b.abstract_id = abs_id;
      b.result = result;
      b.date = new MyDate(new Date().getDate(), new Date().getMonth()+1, new Date().getFullYear());
    console.log(b);

     this.httpClient.post<any>("http://localhost:8080/api/createbid",b).subscribe(m => {});
  }
}
