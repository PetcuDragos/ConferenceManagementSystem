import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {ProfilePageService} from "./shared/service";
import {ProfilePage} from "./shared/model";
import {Observable} from "rxjs";

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {
  userData: ProfilePage;
  constructor(private profilePageService: ProfilePageService, private router: Router) { }

  ngOnInit(): void {

    this.fillData();
  }

  @Input() error:string;

  fillData(): void{
    //get Data from user
    this.profilePageService.getUserData().subscribe(m => this.userData = m);

  }

  save(fullname, email, affiliation, webpage): void{
    this.profilePageService.save({username: localStorage.getItem("username"), fullName: fullname,
      email: email, affiliation: affiliation, webpage: webpage}).subscribe(t=>{
      if (t.entity != null){
        alert("Saved");
        this.router.navigate(['']);
      }
      else{
        alert(t.error);
      }
    });
  }

  back() :void {
    this.router.navigate(['']);
  }

  mainpage():void{
    this.router.navigate(['']);
  }

}
