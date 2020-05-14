import { Component, OnInit } from '@angular/core';
import {Conference} from "./shared/model";
import {ConferenceService} from "./shared/service";

@Component({
  selector: 'app-conferences',
  templateUrl: './conferences.component.html',
  styleUrls: ['./conferences.component.css']
})
export class ConferencesComponent implements OnInit {
  conferences: Conference[];
  constructor(private conferenceService: ConferenceService) { }

  ngOnInit(): void {
    this.conferenceService.getConferences().subscribe(
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
