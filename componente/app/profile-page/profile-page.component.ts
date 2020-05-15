import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {ProfilePageService} from "./shared/service";

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {

  constructor(private profilePageService: ProfilePageService, private router: Router) { }

  ngOnInit(): void {
  }

  @Input() error:string;

  save(fullname, email, affiliation, webpage): void{
    this.profilePageService.save({username: localStorage.getItem("username"), fullName: fullname,
      email: email, affiliation: affiliation, webpage: webpage}).subscribe(t=>{
      if (t.entity != null){
        alert("Saved");
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
