import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AddMatchService {

  private addMatchUrl = '/addMatch/';

  constructor(private http: HttpClient) { }


  public addMatch(clubName1:string,clubName2:string,goal1:number,goal2:number) : Observable<any> {
    let url = this.addMatchUrl+clubName1+'/'+clubName2+'/'+goal1+'/'+goal2;
    return this.http.post(url,{});
  }
}
