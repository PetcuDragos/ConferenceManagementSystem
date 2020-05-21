import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Message, MyUser} from "./model";

@Injectable()
export class LoginService {

  constructor(private httpClient: HttpClient) {
  }

  login(user: MyUser): Observable<Message> {
    console.log("entered client add ts");
    return this.httpClient.post<Message>("http://localhost:8080/api/login", user);
  }

  userIsSCMember():Observable<boolean>{
    return this.httpClient.get<boolean>("http://localhost:8080/api/scmembers",{params:{username: localStorage.getItem("username")}});
  }

}
