import { Component, OnInit } from '@angular/core';
import {MatchesService} from "../services/matches.service";

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})
export class MatchesComponent implements OnInit {

  array=[]

  constructor(private matchesService : MatchesService) { }

  ngOnInit() {
    this.getMatches()
  }

  public getMatches(): void{
    this.matchesService.getMatches().subscribe((data: any) => {
      this.array = data.response;
      console.log(data.response)
    })
  }

}
