import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Paper} from "./model";

@Injectable()
export class PaperService {

  constructor(private httpClient: HttpClient) {
  }

  getPapers(): Observable<Paper[]> {
    return this.httpClient.get<Array<Paper>>("http://localhost:8080/api/papers");
  }


}
