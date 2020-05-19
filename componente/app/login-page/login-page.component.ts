import {Component, Input, OnInit} from '@angular/core';
import {LoginService} from "./shared/service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private serviceLogin: LoginService, private router: Router) { }

  ngOnInit(): void {
  }
  @Input() error: string;

  login(username, password) : void {
    let p;
    this.serviceLogin.login({username:username, password:password}).subscribe(t=>{
      if (t.entity != null){
        localStorage.setItem("state", "true");
        localStorage.setItem("username", t.entity.username);
        localStorage.setItem("selected_conference_id", "");
        console.log("hello" + t.entity.username);
        this.serviceLogin.userIsSCMember().subscribe(t=>{
          if(t) localStorage.setItem("userSCMember", "true");
          else localStorage.setItem("userSCMember", "false");
        });
        this.router.navigate(['']);
      }
      else{
        localStorage.setItem("state", "false");
        alert(t.error);
      }

    });

  }

  mainpage():void{
    this.router.navigate(['']);
  }
  back() :void {
    this.router.navigate(['']);
  }
}
