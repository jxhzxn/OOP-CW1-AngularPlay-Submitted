import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class MatchesService {

  private getMatchesUrl = '/api/summary';

  constructor(private http: HttpClient) { }

  public getMatches() {
    return this.http.get(this.getMatchesUrl)
  }
}
