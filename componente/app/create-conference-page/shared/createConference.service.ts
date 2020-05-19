import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class CreateConferenceService{

  constructor(private httpClient: HttpClient) {
  }

  add(): void{
    console.log("not implemented yet");
  }

}
