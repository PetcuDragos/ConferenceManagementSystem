import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AbstractAuthorDto, CreateBidDto, PCMemberDto} from "./model";
import {MyDate} from "../../../create-conference-page/shared/createConference.model";

@Injectable()
export class AbstractService {
  pcmember: boolean;
  chair: boolean;
  author: boolean;

  constructor(private httpClient: HttpClient) {
    this.isUserPCMemberForConference();
    this.isUserChairForConference();
    this.isUserAuthor();
  }

  getAbstractsFromConference(): Observable<AbstractAuthorDto[]> {
    let conference_id = localStorage.getItem("selected_conference_id");
    if (conference_id != "")
      return this.httpClient.get<Array<AbstractAuthorDto>>("http://localhost:8080/api/abstract/", {params: {conferenceName: conference_id, username: localStorage.getItem("username")}});
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

  //TODO: A
  isUserAuthor(): void {
    this.httpClient.post<boolean>("http://localhost:8080/api/isauthor", {
      username: localStorage.getItem("username"),
      conference_name: localStorage.getItem("selected_conference_id")
    }).subscribe(isAuthor => this.author = isAuthor);
  }

  addPCMember(username: string): Observable<boolean> {
    return this.httpClient.post<boolean>("http://localhost:8080/api/addpcmember", {
      username: username,
      conference_name: localStorage.getItem("selected_conference_id")
    });
  }

  addBid(abs_id: number, result: number): void {
    var b = new CreateBidDto();
    b.pc_name = localStorage.getItem("username");
    b.abstract_id = abs_id;
    b.result = result;
    b.date = new MyDate(new Date().getDate(), new Date().getMonth()+1, new Date().getFullYear());
    b.conference_name = localStorage.getItem("selected_conference_id");
    console.log(b);

    this.httpClient.post<any>("http://localhost:8080/api/createbid",b).subscribe(m => {});
  }

  downloadPaper(abstract_url:string){


    this.httpClient.get("http://localhost:8080/api/download_paper", {responseType: 'blob', params: {abstract_url: abstract_url}}).subscribe(m=>{
      console.log(m);

      var newBlob = new Blob([m], { type: "application/pdf" });

      if (window.navigator && window.navigator.msSaveOrOpenBlob) {
        window.navigator.msSaveOrOpenBlob(newBlob);
        return;
      }

      const data = window.URL.createObjectURL(newBlob);

      var link = document.createElement('a');
      link.href = data;
      link.download = "kar.pdf";
      link.dispatchEvent(new MouseEvent('click', { bubbles: true, cancelable: true, view: window }));

      setTimeout(function () {
        window.URL.revokeObjectURL(data);
        link.remove();
      }, 500);


    });
  }

  getPCMembers(abstract_id:number):Observable<PCMemberDto[]>{
    return this.httpClient.post<PCMemberDto[]>("http://localhost:8080/api/get_reviewers",{
      conference_name: localStorage.getItem("selected_conference_id"),
      abstract_id:abstract_id
    });
  }

  assignPCMember(abstract_id:number, pc_id:number): Observable<any>{
    return this.httpClient.post<any>("http://localhost:8080/api/addreviewer",{
      abstract_id:abstract_id.toString(),
      pc_id:pc_id.toString()
    })
  }

  askForReEval(abstract_id:number):Observable<any>{
    return this.httpClient.post<any>("http://localhost:8080/api/askforreeval",abstract_id);
  }

  acceptPaper(abstract_id:number):Observable<any>{
    return this.httpClient.post<any>("http://localhost:8080/api/acceptpaper",abstract_id);
  }

  declinePaper(abstract_id:number):Observable<any>{
    return this.httpClient.post<any>("http://localhost:8080/api/declinepaper",abstract_id);
  }

  addSection(pc_username:string, section_name:string):Observable<any>{
    return this.httpClient.post<any>("http://localhost:8080/api/addsection",{
      conference_name: localStorage.getItem("selected_conference_id"),
       pc_username:pc_username,
    section_name:section_name
    });
  }

  joinSectionPaper(abstract_id:number, section_name:string):Observable<any>{
    return this.httpClient.post<any>("http://localhost:8080/api/joinsectionpaper",{
      conference_name: localStorage.getItem("selected_conference_id"),
      abstract_id:abstract_id,
    section_name:section_name,
    username:localStorage.getItem("username")
    });
  }
}
