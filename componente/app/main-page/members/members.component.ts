import { Component, OnInit } from '@angular/core';
import {MemberService} from "./shared/service";
import {Member} from "./shared/model";

@Component({
  selector: 'app-members',
  templateUrl: './members.component.html',
  styleUrls: ['./members.component.css']
})
export class MembersComponent implements OnInit {
  members: Member[];
  constructor(private memberService: MemberService) { }

  ngOnInit(): void {
    this.memberService.getMembers().subscribe(
      members=>this.members = members
    )
  }

}
