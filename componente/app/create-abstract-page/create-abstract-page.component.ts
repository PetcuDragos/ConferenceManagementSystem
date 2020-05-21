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
  }

  save(title:string,content:string,keywords:string, topics:string,additional_authors:string): void{
    this.serviceCreateAbstract.addAbstract(title,content,keywords,topics,additional_authors).subscribe(m=>console.log(m));
  }

  back() :void {
    this.router.navigate(['']);
  }

  mainpage():void{
    this.router.navigate(['']);
  }

}
