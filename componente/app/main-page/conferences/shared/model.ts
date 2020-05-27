import {MyDate} from "../../../create-conference-page/shared/createConference.model";


export class Conference{
  id: number;
  name: string;
  abstractDeadline: MyDate;
  paperDeadline: MyDate;
  bidDeadline: MyDate;
  reviewDeadline: MyDate;
  startingDate: MyDate;
  endingDate: MyDate;
  reEvalDate:MyDate;
  submissionDate:MyDate;
  chair_id: number;
  co_chair_id: number;
  pc_members: string[];
  sections: Section[];
}

export class Section{
  name:string;
  sc_name:string;
}

export class ConferenceUser{
  title: string;
  conferenceName: string;

}

export class ConferenceDescription {
  name: string;
  conference: Conference;
  chairName: string;
  co_chairName: string;
  joined:boolean;
}

export class JoinConferenceDto{
  username:string;
  conference_id:number;
  constructor(username:string, conference_id:number) {
    this.conference_id = conference_id;
    this.username = username;
  }
}
