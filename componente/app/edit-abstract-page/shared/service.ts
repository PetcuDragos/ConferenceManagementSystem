import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CreateAbstractModel} from "../../create-abstract-page/shared/create.abstract.model";


@Injectable()
export class EditAbstractService {

  constructor(private httpClient: HttpClient) {}

  editAbstract(title:string,content:string,keywords:string, topics:string,additional_authors:string): Observable<any>{
    var conference_name = localStorage.getItem("selected_conference_id");
    var username = localStorage.getItem("username");
    var c = new CreateAbstractModel(username,conference_name,title,content,keywords,topics,additional_authors);
    return this.httpClient.post<any>("http://localhost:8080/api/editabstract",c as CreateAbstractModel);
  }

}
