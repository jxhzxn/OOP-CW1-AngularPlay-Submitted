import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class MatchesService {

  //urls which are in the routes file
  private getMatchesUrl = '/matches';
  private getMatchesSortedUrl = '/matchesSorted';
  private getMatchesByDateUrl = '/matchesByDate';

  //creating an instance of HttpClient
  constructor(private http: HttpClient) { }

  //method to get all the matches
  public getMatches() {
    return this.http.get(this.getMatchesUrl)
  }

  //method get all the matches sorted
  public getMatchesSorted() {
    return this.http.get(this.getMatchesSortedUrl)
  }

  //method to get the matches played on a particular date
  public getMatchesByDate(day:number,month:number,year:number) {
    let url = this.getMatchesByDateUrl+'/'+day+'/'+month+'/'+year;
    return this.http.get(url)
  }
}
