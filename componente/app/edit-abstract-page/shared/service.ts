import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CreateAbstractModel} from "../../create-abstract-page/shared/create.abstract.model";
import {Observable} from "rxjs";
import {Router} from "@angular/router";


@Injectable()
export class EditAbstractService {
  id:number;

  constructor(private httpClient: HttpClient, private router:Router) {
    this.id = null;
  }

  getAbstract(): Observable<any>{
    return this.httpClient.get<any>("http://localhost:8080/api/getabstract",{params: {username: localStorage.getItem("username"), conference: localStorage.getItem("selected_conference_id")}})
  }

  editAbstract(title: string, content: string, keywords: string, topics: string, additional_authors: string, paper: File): void {
    if (paper != null) {
      let formData: FormData = new FormData();
      let url = title.trim().toLocaleLowerCase().replace(" ", '_') + '.' + paper.name.split('.').pop();
      formData.append('uploadFile', paper);
      formData.append("url", url);
      console.log("part2");
      var conference_name = localStorage.getItem("selected_conference_id");
      var username = localStorage.getItem("username");
      var c = new CreateAbstractModel(username, conference_name, title, content, keywords, topics, additional_authors, url);
      c.id = this.id;
      this.id = null;
      this.httpClient.post<any>("http://localhost:8080/api/editabstract", c as CreateAbstractModel).subscribe(m => {
        this.httpClient.post<any>("http://localhost:8080/api/upload", formData).subscribe(m => {
          if(m=="success") alert("Upload was successful!");
          if(m=="error") alert("There has been an error with uploading the file.");
          this.router.navigate(['']);
        });

      });
    } else {
      console.log("upload file failed");
      var conference_name = localStorage.getItem("selected_conference_id");
      var username = localStorage.getItem("username");
      var c = new CreateAbstractModel(username, conference_name, title, content, keywords, topics, additional_authors, null);
      this.httpClient.post<any>("http://localhost:8080/api/editabstract", c as CreateAbstractModel).subscribe(m => {
      });
    }
  }
}
