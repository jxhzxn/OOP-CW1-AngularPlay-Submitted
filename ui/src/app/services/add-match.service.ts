import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AddMatchService {

  //urls which are in the routes file
  private addMatchUrl = '/addMatch/';
  private getClubUrl = '/footballClubs';
  private generateMatchUrl = '/generateMatch';

  //creating an instance of the HttpClient
  constructor(private http: HttpClient) { }

  //method to add a match
  public addMatch(clubName1:string,clubName2:string,goal1:number,goal2:number,day:number,month:number,year:number) : Observable<any> {
    let url = this.addMatchUrl+clubName1+'/'+clubName2+'/'+goal1+'/'+goal2+'/'+day+'/'+month+'/'+year;
    return this.http.post(url,{});
  }

  //method to get all the clubs
  public getClub() {
    return this.http.get(this.getClubUrl)
  }

  //method to generate a match
  public generateMatch(){
    return this.http.post(this.generateMatchUrl,{});
  }
}
