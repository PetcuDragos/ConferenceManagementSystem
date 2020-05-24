import {MyDate} from "../../../create-conference-page/shared/createConference.model";

export class Abstract{
  abstract_id: number;
  title: string;
  content: string;
}

export class AbstractDto{
  keywords: string;
  topics:string;
  name:string;
  additionalAuthors:string;
  content:string;
  author_id:number;
  conference_id:number;
}

export class AbstractAuthorDto{
  abstract_id: number;
  entity: AbstractDto;
  authorName: string;
}

export class CreateBidDto{
   abstract_id: number;
   date : MyDate;
   pc_name: string;
   result: number;
}

