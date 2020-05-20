import { Component, OnInit } from '@angular/core';
import {AbstractService} from "./shared/service";
import {Abstract, AbstractAuthorDto, AbstractDto} from "./shared/model";
import {Router} from "@angular/router";
@Component({
  selector: 'app-abstracts',
  templateUrl: './abstracts.component.html',
  styleUrls: ['./abstracts.component.css']
})
export class AbstractsComponent implements OnInit {
  abstracts: AbstractAuthorDto[];
  abstractDeadline: string;
  paperDeadline:string;
  bidDeadline:string;
  reviewDeadline:string;
  constructor(private abstractService: AbstractService, private router: Router) {
    this.abstracts = [];
    this.abstractDeadline = "not implemented";
    this.paperDeadline = "not implemented";
    this.bidDeadline = "not implemented";
    this.reviewDeadline = "not implemented";

  }

  ngOnInit(): void {
    console.log("init abstracts");
    if(localStorage.getItem("selected_conference_id") != "")
    this.abstractService.getAbstractsFromConference().subscribe(
      abstracts=>{if(abstracts!=null) this.abstracts = abstracts;}
    )
  }

  addAbstract():void{
    this.router.navigate(['create-abstract']);
  }

  changeDeadlines():void{
    console.log("not made yet.")
  }

  bidAbstract():void{
    console.log("not implemented.")
  }

  reviewPaper():void{
    console.log("not implemented.")
  }

}
