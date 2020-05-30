import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Register} from "./model";
import {Message} from "../../login-page/shared/model";

@Injectable()
export class RegisterService {

  constructor(private httpClient: HttpClient) {
  }


  register(register: Register): Observable<Message> {
    console.log("registered");
    return this.httpClient.post<Message>("http://localhost:8080/api/register", register);
  }

}
