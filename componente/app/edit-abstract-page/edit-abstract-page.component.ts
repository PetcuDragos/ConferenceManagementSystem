import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {EditAbstractService} from "./shared/service";

@Component({
  selector: 'app-edit-abstract-page',
  templateUrl: './edit-abstract-page.component.html',
  styleUrls: ['./edit-abstract-page.component.css']
})
export class EditAbstractPageComponent implements OnInit {

  constructor(private router: Router, private serviceEditAbstract: EditAbstractService) { }

  ngOnInit(): void {
  }

  save(title:string,content:string,keywords:string, topics:string,additional_authors:string): void{
    this.serviceEditAbstract.editAbstract(title,content,keywords,topics,additional_authors).subscribe(m=>console.log(m));
  }

  back() :void {
    this.router.navigate(['']);
  }

  mainpage():void{
    this.router.navigate(['']);
  }

}
