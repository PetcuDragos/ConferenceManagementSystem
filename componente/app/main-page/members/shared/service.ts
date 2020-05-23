import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Member} from "./model";
import {Newsletter} from "./model";
import {Message} from "../../../login-page/shared/model";
@Injectable()
export class MemberService {

  constructor(private httpClient: HttpClient) {
  }

  getMembers(): Observable<Member[]> {
    return this.httpClient.get<Array<Member>>("http://localhost:8080/api/members");
  }



  addNewsletter(newsletter: Newsletter): Observable<Message> {
    console.log("new newsletter");
    return this.httpClient.post<Message>("http://localhost:8080/api/newsletter", newsletter);
  }
}
