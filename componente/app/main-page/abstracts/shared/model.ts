import {MyDate} from "../../../create-conference-page/shared/createConference.model";
import {Section} from "../../conferences/shared/model";

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
  show_reviewers:boolean;
  canReview:boolean;
  reviewers: string[];
  sections: Section[];
  askForReEval:boolean;
  acceptAbstractButton:boolean;
  addSectionButton:boolean;
  joinSection:boolean;
}

export class CreateBidDto{
  abstract_id: number;
  conference_name:string;
  date : MyDate;
  pc_name: string;
  result: number;
}

export class PCMemberDto{
  username:string;
  pc_id:number;
}

