import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {CreateConferenceService} from "./shared/createConference.service";

@Component({
  selector: 'app-create-conference-page',
  templateUrl: './create-conference-page.component.html',
  styleUrls: ['./create-conference-page.component.css']
})
export class CreateConferencePageComponent implements OnInit {

  constructor(private router: Router, private createConferenceService: CreateConferenceService) { }

  ngOnInit(): void {
  }

  save(): void{
    this.createConferenceService.add();
  }

  back() :void {
    this.router.navigate(['']);
  }

  mainpage():void{
    this.router.navigate(['']);
  }

}
