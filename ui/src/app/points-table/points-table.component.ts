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
  }

  public getClub(): void{
    this.pointsTableService.getClub().subscribe((data: any) => {
      this.pointsTableService.jxhzxn
      this.clubName = data.response[1].clubName;
      var test = data.response.length;
      this.array = data.response;
      for(var i=0;i<=test-1;i++){
        // this.array.push(data.response[i].clubName)
        // this.array.push('name:',data.response[i].clubName, 'location:',data.response[i].location);
        // this.array.push('location:',data.response[i].location);

        // this.array.name.push(data.response[i].clubName)
        // this.array.location.push(data.response[i].location)
      }

      console.log(this.array);
    })
  }



}
