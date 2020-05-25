import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ReviewService} from "./shared/service";
import {Review} from "./shared/model";

@Component({
  selector: 'app-reviews-page',
  templateUrl: './reviews-page.component.html',
  styleUrls: ['./reviews-page.component.css']
})
export class ReviewsPageComponent implements OnInit {

  constructor(private router:Router, private reviewService: ReviewService) { }
  reviews: Review[];
  ngOnInit(): void {
    this.getReviews();
  }

  getReviews(): void{
    this.reviewService.getReviews().subscribe(
      m=>{console.log(m); this.reviews = m;});
  }

  back() :void {
    this.router.navigate(['']);
  }

  mainpage():void{
    this.router.navigate(['']);
  }

}
