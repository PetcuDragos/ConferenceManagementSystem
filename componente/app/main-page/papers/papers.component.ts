import { Component, OnInit } from '@angular/core';
import {PaperService} from "./shared/service";
import {Paper} from "./shared/model";
import {AbstractService} from "../abstracts/shared/service";

@Component({
  selector: 'app-papers',
  templateUrl: './papers.component.html',
  styleUrls: ['./papers.component.css']
})
export class PapersComponent implements OnInit {
  papers:Paper[];
  constructor(private paperService : PaperService, private abstractService: AbstractService) { }

  ngOnInit(): void {
    this.paperService.getPapers().subscribe(
      papers=>this.papers = papers
    );
  }

  download(url:string){
    this.abstractService.downloadPaper(url);
  }

}
