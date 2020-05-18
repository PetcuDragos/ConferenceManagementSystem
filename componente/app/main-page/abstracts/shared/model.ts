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
  entity: AbstractDto;
  authorName: string;
}

