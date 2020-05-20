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
  constructor(private abstractService: AbstractService, private router: Router) {
    this.abstracts = [];
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

}
