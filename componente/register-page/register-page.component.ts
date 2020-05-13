import {Component, Input, OnInit} from '@angular/core';
import {RegisterService} from "./shared/service";
import {Observable} from "rxjs";
import {Message} from "../login-page/shared/model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  constructor(private serviceRegister: RegisterService, private router: Router) { }

  ngOnInit(): void {
  }

  @Input() error:string;

  register(username, password, email) : void{
    this.serviceRegister.login({username:username,password:password,email:email}).subscribe(t=>{
      if (t.entity != null){
        this.error = "successful";
        setTimeout(()=>{this.router.navigate(['']);},2000);
      }
      else{
        this.error = t.error;
      }
    });
  }

}
