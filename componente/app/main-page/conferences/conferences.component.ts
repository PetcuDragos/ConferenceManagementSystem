import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ConferenceDescription} from "./shared/model";
import {ConferenceService} from "./shared/service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-conferences',
  templateUrl: './conferences.component.html',
  styleUrls: ['./conferences.component.css']
})
export class ConferencesComponent implements OnInit {
  conferences: ConferenceDescription[];
  @Output() someEvent = new EventEmitter<string>();
  constructor(private conferenceService: ConferenceService, private router:Router) { }

  ngOnInit(): void {
    this.conferenceService.getConferencesChairCoChair().subscribe(
      conferences=>this.conferences = conferences
    );
  }

  joinConference(conferencel: ConferenceDescription, conference_id: number): void {
    this.conferenceService.joinConference(conference_id).subscribe(m=>{
      conferencel.joined=true;
    this.someEvent.next("");});
  }







}
