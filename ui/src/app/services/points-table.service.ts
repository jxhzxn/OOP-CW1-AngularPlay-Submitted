import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PointsTableService {

  jxhzxn: string;

  private serviceUrl = '/api/summary';
  private dataPostTestUrl = '/api/postTest';
  private createUrl = '/api/createPerson/';
  private getNofClubsUrl = '/api/getNofClubs';
  private getClubUrl = '/footballClubs';

  constructor(private http: HttpClient) {
  }

  /**
   * Makes a http get request to retrieve the welcome message from the backend service.
   */

  public getWelcomeMessage() {
    return this.http.get(this.serviceUrl).pipe(
      map(response => response)
    );
  }

  /**
   * Makes a http post request to send some data to backend & get response.
   */

  public sendData(): Observable<any> {
    return this.http.post(this.dataPostTestUrl, {});
  }

  public createClub(clubName:string, location:string, homeGround:string) : Observable<any> {
    let url = this.createUrl+clubName+'/'+location+'/'+homeGround;
    return this.http.post(url,{});
  }

  public getNofClubs() : Observable<any>{
    return this.http.post(this.getNofClubsUrl, {});
  }

  public getClub() {
    return this.http.get(this.getClubUrl)
  }
}
