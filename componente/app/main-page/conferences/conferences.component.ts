import { Component, OnInit } from '@angular/core';
import {Conference, ConferenceDescription} from "./shared/model";
import {ConferenceService} from "./shared/service";
import {ConferenceUser} from "../../../../../componente/app/main-page/conferences/shared/model";

@Component({
  selector: 'app-conferences',
  templateUrl: './conferences.component.html',
  styleUrls: ['./conferences.component.css']
})
export class ConferencesComponent implements OnInit {
  conferences: ConferenceDescription[];
  constructor(private conferenceService: ConferenceService) { }

  ngOnInit(): void {
    this.conferenceService.getConferencesChairCoChair().subscribe(
      conferences=>this.conferences = conferences
    );
  }

  notJoinedConference(conference_id: number):boolean{
    // todo
    return false;
}
  joinConference(conference_id: number): void{
    //todo
  }


}
