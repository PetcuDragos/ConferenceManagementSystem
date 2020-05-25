import {MyDate} from "../../../create-conference-page/shared/createConference.model";

export class Abstract{
  abstract_id: number;
  title: string;
  content: string;
}

export class AbstractDto{
  id:number;
  keywords: string;
  topics:string;
  name:string;
  additionalAuthors:string;
  content:string;
  author_id:number;
  conference_id:number;
}

export class AbstractAuthorDto{
  entity: AbstractDto;
  authorName: string;
  bidded:boolean;
  reviewed:boolean;
  url:string;
}

export class CreateBidDto{
  abstract_id: number;
  conference_name:string;
  date : MyDate;
  pc_name: string;
  result: number;
}

