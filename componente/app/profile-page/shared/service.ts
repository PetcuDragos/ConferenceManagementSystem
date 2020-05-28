import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {ProfilePage} from "./model";
import {Observable} from "rxjs";
import {Message} from "../../login-page/shared/model";

@Injectable()
export class ProfilePageService{
  constructor(private httpClient: HttpClient) {
  }

  save(profilePage: ProfilePage): Observable<Message>{
    console.log("profile page saving");
    return this.httpClient.post<Message>("http://localhost:8080/api/profile", profilePage);
  }
}
