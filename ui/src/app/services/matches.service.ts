import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class MatchesService {

  private getMatchesUrl = '/matches';
  private getMatchesSortedUrl = '/matchesSorted';
  private getMatchesByDateUrl = '/matchesByDate';

  constructor(private http: HttpClient) { }

  public getMatches() {
    return this.http.get(this.getMatchesUrl)
  }

  public getMatchesSorted() {
    return this.http.get(this.getMatchesSortedUrl)
  }

  public getMatchesByDate(day:number,month:number,year:number) {
    let url = this.getMatchesByDateUrl+'/'+day+'/'+month+'/'+year;
    return this.http.get(url)
  }
}
