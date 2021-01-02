import { Component, OnInit } from '@angular/core';
import {PointsTableService} from '../services/points-table.service';

@Component({
  selector: 'app-points-table',
  templateUrl: './points-table.component.html',
  styleUrls: ['./points-table.component.css']
})

export class PointsTableComponent implements OnInit {

  clubName:string;
  pointsAsc:boolean;
  pointsDes:boolean;
  winsAsc:boolean;
  winsDes:boolean;
  goalsAsc:boolean;
  goalsDes:boolean;

  array = []

  //creating pointsTableService instance
  constructor(private pointsTableService: PointsTableService) { }


  //triggering the methods whenever the component loads
  ngOnInit() {
    this.getClub()
    this.pointsAsc=false;
    this.pointsDes=false;
    this.winsAsc=false;
    this.winsDes=false;
    this.goalsAsc=false;
    this.goalsDes=false;
  }

  //method to get all the clubs
  public getClub(): void{
    this.pointsTableService.getClub().subscribe((data: any) => {  //triggering the method which is in pointsTableService
      document.getElementById('loading').style.display = 'none';  //stopping the loader
      this.array = data.response;
      // console.log(Object.keys(data.response))
    })
  }

  //method to sort the table by points in Ascending order
  public sortByPointAsc(){
    if(this.pointsAsc==false){
      this.array.sort(function (a,b){
        return a.nofPoints - b.nofPoints
      })
    }else if(this.pointsAsc==true){
      this.getClub()
    }
  }

  //method to sort the table by points in Descending order
  public sortByPointDes(){
    if(this.pointsDes==false){
      this.array.sort(function (a,b){
        return b.nofPoints - a.nofPoints
      })
    }else if(this.pointsDes==true){
      this.getClub()
    }
  }

  //method to sort the table by wins in Ascending order
  public sortByWinsAsc(){
    if(this.winsAsc==false){
      this.array.sort(function (a,b){
        return a.nofWins - b.nofWins
      })
    }else if(this.winsAsc==true){
      this.getClub()
    }
  }

  //method to sort the table by wins in Descending order
  public sortByWinsDes(){
    if(this.winsDes==false){
      this.array.sort(function (a,b){
        return b.nofWins - a.nofWins
      })
    }else if(this.winsAsc==true){
      this.getClub()
    }
  }

  //method to sort the table by goals in Ascending order
  public sortByGoalsAsc(){
    if(this.goalsAsc==false){
      this.array.sort(function (a,b){
        return a.nofGoalsScored - b.nofGoalsScored
      })
    }else if(this.goalsAsc==true){
      this.getClub()
    }
  }

  //method to sort the table by goals in Descending order
  public sortByGoalsDes(){
    if(this.goalsDes==false){
      this.array.sort(function (a,b){
        return b.nofGoalsScored - a.nofGoalsScored
      })
    }else if(this.goalsDes==true){
      this.getClub()
    }
  }


}
