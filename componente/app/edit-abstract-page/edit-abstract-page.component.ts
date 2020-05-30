import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {EditAbstractService} from "./shared/service";
import {CreateAbstractModel} from "./shared/model";

@Component({
  selector: 'app-edit-abstract-page',
  templateUrl: './edit-abstract-page.component.html',
  styleUrls: ['./edit-abstract-page.component.css']
})
export class EditAbstractPageComponent implements OnInit {
  abstr: CreateAbstractModel;
  constructor(private router: Router, private serviceEditAbstract: EditAbstractService) { }

  ngOnInit(): void {
    this.getAbstract();
  }
  getAbstract():void{
    this.serviceEditAbstract.getAbstract().subscribe(m=> {this.abstr = m;
      (<HTMLInputElement>document.getElementById("name")).value=this.abstr.title;
      (<HTMLInputElement>document.getElementById("content")).value=this.abstr.content;
      (<HTMLInputElement>document.getElementById("keywords")).value=this.abstr.keywords;
      (<HTMLInputElement>document.getElementById("additional_authors")).value=this.abstr.additional_authors;
      (<HTMLInputElement>document.getElementById("topics")).value=this.abstr.topics;
    })
  }

  save(title:string,content:string,keywords:string, topics:string,additional_authors:string): void{
    this.serviceEditAbstract.editAbstract(title,content,keywords,topics,additional_authors,this.paper);
  }

  back() :void {
    this.router.navigate(['']);
  }

  mainpage():void{
    this.router.navigate(['']);
  }

  paper: File;
  uploadFile($event) {
    console.log($event.target.files[0]); // outputs the first file
    this.paper = $event.target.files[0];

  }

}
