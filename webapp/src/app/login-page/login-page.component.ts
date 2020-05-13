import {Component, Input, OnInit} from '@angular/core';
import {LoginService} from "./shared/service";
import {Router} from "@angular/router";
import {Globals} from "../globals";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private serviceLogin: LoginService, private router: Router, private globals : Globals) { }

  ngOnInit(): void {
  }
  @Input() error: string;

  login(username, password) : void {
    let p;
    this.serviceLogin.login({username:username, password:password}).subscribe(t=>{
      this.globals.state = true;
      if (t.entity != null){
        console.log("hello" + t.entity.username);
        this.globals.username = t.entity.username;
        this.router.navigate(['']);
      }
      else{
        this.error = t.error;
      }

    });

  }

}
