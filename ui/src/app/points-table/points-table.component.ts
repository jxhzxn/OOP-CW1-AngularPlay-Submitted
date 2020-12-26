import { Component, OnInit } from '@angular/core';
import {PointsTableService} from '../services/points-table.service';

@Component({
  selector: 'app-points-table',
  templateUrl: './points-table.component.html',
  styleUrls: ['./points-table.component.css']
})

export class PointsTableComponent implements OnInit {

  clubName:string;
  // array = {
  //   name:[],
  //   location:[]
  // };

  array = [

  ]

  constructor(private pointsTableService: PointsTableService) { }


  ngOnInit() {
    this.getClub()
  }

  public getClub(): void{
    this.pointsTableService.getClub().subscribe((data: any) => {
      this.array = data.response;
    })
  }



}
