import { Component, OnInit } from '@angular/core';
import {AbstractService} from "./shared/service";
import {Abstract, AbstractAuthorDto, AbstractDto} from "./shared/model";
@Component({
  selector: 'app-abstracts',
  templateUrl: './abstracts.component.html',
  styleUrls: ['./abstracts.component.css']
})
export class AbstractsComponent implements OnInit {
  abstracts: AbstractAuthorDto[];
  constructor(private abstractService: AbstractService) {
    this.abstracts = [];
  }

  ngOnInit(): void {
    console.log("ffewfew")
    if(localStorage.getItem("selected_conference_id") != "")
    this.abstractService.getAbstractsFromConference().subscribe(
      abstracts=>{if(abstracts!=null) this.abstracts = abstracts;}
    )
  }

}
