export class date{
  day: number;
  month: number;
  year: number;
}

export class Conference{
  conference_id: number;
  name: string;
  abstractDeadline: date;
  paperDeadline: date;
  bidDeadline: date;
  reviewDeadline: date;
  startingDate: date;
  endingDate: date;
  chair_id: number;
  co_chair_id: number;
}

export class ConferenceUser{
  title: string;
  conference: Conference;
}
