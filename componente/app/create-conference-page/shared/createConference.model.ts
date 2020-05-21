//did by dragos.
export class MyDate{
  day:number;
  month:number;
  year:number;

  constructor(day:number, month:number, year:number) {
    this.day = day;
    this.month = month;
    this.year = year;
  }
}

export class createConferenceModel{
  conference_name :string;
  chair_username: string;
  co_chair_username:string;
  starting_date: MyDate;
  ending_date: MyDate;
  abstract_deadline: MyDate;
  paper_deadline: MyDate;
  bidding_deadline : MyDate;
  review_deadline:MyDate;
  constructor(){};
}

export class createConferenceMessage{
  entity: createConferenceModel;
  error: string;
}
