import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CreateAbstractModel} from "./create.abstract.model";


@Injectable()
export class CreateAbstractService {

  constructor(private httpClient: HttpClient) {}

  addAbstract(title:string,content:string,keywords:string, topics:string,additional_authors:string): Observable<string>{
    var conference_name = localStorage.getItem("selected_conference_id");
    var username = localStorage.getItem("username");
    var c = new CreateAbstractModel(username,conference_name,title,content,keywords,topics,additional_authors);
    return this.httpClient.post<string>("http://localhost:8080/api/createabstract",c as CreateAbstractModel);
  }

}
