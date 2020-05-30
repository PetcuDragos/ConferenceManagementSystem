import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ReviewAbstractService} from "./shared/service";

@Component({
  selector: 'app-review-abstract-page',
  templateUrl: './review-abstract-page.component.html',
  styleUrls: ['./review-abstract-page.component.css']
})
export class ReviewAbstractPageComponent implements OnInit {

  constructor(private router: Router, private reviewAbstractService: ReviewAbstractService) { }

  ngOnInit(): void {
  }

  save(content:string,result:string): void{
    this.reviewAbstractService.reviewAbstract(content, +result).subscribe(
      m=>{console.log(m);
      this.mainpage();});
  }

  back() :void {
    this.router.navigate(['']);
  }

  mainpage():void{
    this.router.navigate(['']);
  }

}
