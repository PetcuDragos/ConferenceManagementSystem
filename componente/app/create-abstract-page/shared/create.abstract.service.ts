import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CreateAbstractModel} from "./create.abstract.model";


@Injectable()
export class CreateAbstractService {

  constructor(private httpClient: HttpClient) {}

  addAbstract(title:string,content:string,keywords:string, topics:string,additional_authors:string, paper:File): void{
    let ext:string;
    if (paper != null) {
      let file: File = paper;
      let formData: FormData = new FormData();
      formData.append('uploadFile', file, file.name);
      var conference_name = localStorage.getItem("selected_conference_id");
      var username = localStorage.getItem("username");
      ext = file.name.split('.').pop();
      let urltitle = title.trim().toLocaleLowerCase().replace(" ",'_');
      var c = new CreateAbstractModel(username,conference_name,title,content,keywords,topics,additional_authors,urltitle+'.'+ext);
      this.httpClient.post<any>("http://localhost:8080/api/createabstract",c as CreateAbstractModel).subscribe(m=>{
        this.httpClient.post<any>("http://localhost:8080/api/upload", formData)
          .subscribe(m => {
            console.log(m);
          });
      });

    } else {
      console.log("upload file failed");
      var conference_name = localStorage.getItem("selected_conference_id");
      var username = localStorage.getItem("username");
      var c = new CreateAbstractModel(username,conference_name,title,content,keywords,topics,additional_authors,null);
      this.httpClient.post<any>("http://localhost:8080/api/createabstract",c as CreateAbstractModel).subscribe(m=>console.log(m));
    }

  }

}
