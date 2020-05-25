import {Component, ElementRef, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {ConferenceService} from "./conferences/shared/service";
import {AbstractService} from "./abstracts/shared/service";
import {ConferenceUser} from "./conferences/shared/model";
import {MemberService} from "./members/shared/service";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {
  conferencesList: ConferenceUser[];

  constructor(private elementRef: ElementRef, private router: Router, private abstractService: AbstractService, private conferenceService: ConferenceService, private memberService: MemberService) {
    this.conferencesList = [];
  }

  @Input() option: number = -1;

  ngOnInit(): void {
    this.populateAll();
    localStorage.setItem("selected_conference_id", "");
    this.option = -1;
  }

  register() {
    this.router.navigate(['register']);
  }

  mainpage(): void {
    this.option = 1;
  }

  login() {
    this.router.navigate(['login']);
  }

  logout() {
    localStorage.removeItem("username");
    localStorage.setItem("state", "false");
    localStorage.clear();
    location.reload();
  }

  isAuthenticated(): boolean {
    if (localStorage.getItem("state") == "true")
      return true;
    return false;
  }

  getUsername(): string {
    return localStorage.getItem("username");
  }

  profile(): void {
    this.router.navigate(["profile"]);
  }

  conferences(): void {
    this.option = 2;
  }

  papers(): void {
    this.option = 3;
  }

  members(): void {
    this.option = 4;
  }

  getOption(): number {
    return this.option;
  }

  userIsChairAtAConference(): boolean {
    return this.conferencesList.filter(c => c.title == "Chair").length > 0;
  }

  userIsPCMemberAtAConference(): boolean {
    return this.conferencesList.filter(c => c.title == "PCMember").length > 0;
  }

  userIsAuthorAtAConference(): boolean {
    return this.conferencesList.filter(c => c.title == "Author").length > 0;
  }

  userIsMemberAtAConference(): boolean {
    return this.conferencesList.filter(c => c.title == "Member").length > 0;
  }

  populateConferenceList(user_title: string): ConferenceUser[] {
    return this.conferencesList.filter(p => p.title == user_title);
  }

  changeSelectedConference(): void {
    var conference_id = this.elementRef.nativeElement.querySelector('select').value;
    console.log(conference_id);
    localStorage.setItem("selected_conference_id", conference_id);
    if (this.option == 1) this.option = 0;
    else this.option = 1;
  }

  userIsSCMember(): boolean {
    return localStorage.getItem("userSCMember") == "true";
  }

  loadCreateConferencePage(): void {
    this.router.navigate(["create-conference"]);
  }

  populateAll(): void {
    if (localStorage.getItem("state") == "true")
      this.conferenceService.getConferencesFromUser().subscribe(c => {
        this.conferencesList = c;
      });
  }

  cautare(searchinput): void {
    if (this.option == 2) {
      var all = document.getElementsByClassName("panel");

      for (var i = 0, max = all.length; i < max; i++) {
        var title = all[i].getElementsByClassName("conference_name");
        if (all[i].getAttribute("hidden") == "true") {
          all[i].removeAttribute("hidden");
        }
      }

      for (var j = 0, max = all.length; j < max; j++) {
        var title = all[j].getElementsByClassName("conference_name");
        if (!title[0].textContent.toLocaleLowerCase().includes(searchinput.toLocaleLowerCase())) {
          all[j].setAttribute("hidden", "true");
        }
      }
    }
    else if (this.option == 4) {
      var all = document.getElementsByClassName("panel");

      for (var i = 0, max = all.length; i < max; i++) {
        var title = all[i].getElementsByClassName("member-name");
        if (all[i].getAttribute("hidden") == "true") {
          all[i].removeAttribute("hidden");
        }
      }

      for (var j = 0, max = all.length; j < max; j++) {
        var title = all[j].getElementsByClassName("member-name");
        var title2 = all[j].getElementsByClassName("member-username");
        if (!title[0].textContent.toLocaleLowerCase().includes(searchinput.toLocaleLowerCase()) && !title2[0].textContent.toLocaleLowerCase().includes(searchinput.toLocaleLowerCase())) {
          all[j].setAttribute("hidden", "true");
        }
      }
    }

  }
}
