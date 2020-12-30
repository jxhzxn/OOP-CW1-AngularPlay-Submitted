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

  constructor(private pointsTableService: PointsTableService) { }


  ngOnInit() {
    this.getClub()
    this.pointsAsc=false;
    this.pointsDes=false;
    this.winsAsc=false;
    this.winsDes=false;
    this.goalsAsc=false;
    this.goalsDes=false;
  }

  public getClub(): void{
    this.pointsTableService.getClub().subscribe((data: any) => {
      document.getElementById('loading').style.display = 'none';
      this.array = data.response;
      console.log(Object.keys(data.response))
    })
  }




  public sortByPointAsc(){
    if(this.pointsAsc==false){
      this.array.sort(function (a,b){
        return a.nofPoints - b.nofPoints
      })
    }else if(this.pointsAsc==true){
      this.getClub()
    }
  }

  public sortByPointDes(){
    if(this.pointsDes==false){
      this.array.sort(function (a,b){
        return b.nofPoints - a.nofPoints
      })
    }else if(this.pointsDes==true){
      this.getClub()
    }
  }

  public sortByWinsAsc(){
    if(this.winsAsc==false){
      this.array.sort(function (a,b){
        return a.nofWins - b.nofWins
      })
    }else if(this.winsAsc==true){
      this.getClub()
    }
  }

  public sortByWinsDes(){
    if(this.winsDes==false){
      this.array.sort(function (a,b){
        return b.nofWins - a.nofWins
      })
    }else if(this.winsAsc==true){
      this.getClub()
    }
  }

  public sortByGoalsAsc(){
    if(this.goalsAsc==false){
      this.array.sort(function (a,b){
        return a.nofGoalsScored - b.nofGoalsScored
      })
    }else if(this.goalsAsc==true){
      this.getClub()
    }
  }

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
