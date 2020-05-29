import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {CreateAbstractService} from "./shared/create.abstract.service";

@Component({
  selector: 'app-create-abstract-page',
  templateUrl: './create-abstract-page.component.html',
  styleUrls: ['./create-abstract-page.component.css']
})
export class CreateAbstractPageComponent implements OnInit {


  constructor(private router: Router, private serviceCreateAbstract: CreateAbstractService) { }

  ngOnInit(): void {
    this.paper = null;
  }


  save(title:string,content:string,keywords:string, topics:string,additional_authors:string): void{
    this.serviceCreateAbstract.addAbstract(title,content,keywords,topics,additional_authors, this.paper);
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
