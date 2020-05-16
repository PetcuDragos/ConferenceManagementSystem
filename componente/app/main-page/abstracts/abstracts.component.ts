import { Component, OnInit } from '@angular/core';
import {AbstractService} from "./shared/service";
import {Abstract} from "./shared/model";
@Component({
  selector: 'app-abstracts',
  templateUrl: './abstracts.component.html',
  styleUrls: ['./abstracts.component.css']
})
export class AbstractsComponent implements OnInit {
  abstracts: Abstract[];
  constructor(private abstractService: AbstractService) { }

  ngOnInit(): void {
    this.abstractService.getAbstractsFromConference().subscribe(
      abstracts=>this.abstracts = abstracts
    )
  }

}
