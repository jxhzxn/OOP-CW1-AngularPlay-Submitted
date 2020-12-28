import {Component, Inject, OnInit} from '@angular/core';
import {AddMatchService} from "../services/add-match.service";
import {matSnackBarAnimations} from "@angular/material/snack-bar";
import {SnackBarOverviewExample} from "../services/custom-alert.service";

@Component({
  selector: 'app-add-match',
  templateUrl: './add-match.component.html',
  styleUrls: ['./add-match.component.css']
})
export class AddMatchComponent implements OnInit {

  constructor(private addMatchService: AddMatchService) { }

  clubName1 = '';
  clubName2 = '';
  goal1:number;
  goal2:number;

  date:object;

  day:number;
  month:number;
  year:number;

  minDate:Date;
  maxDate:Date;


  array=[]

  ngOnInit() {
    this.getClub()
    this.minDate = new Date(2020,9,1)
    this.maxDate = new Date(2020,12,0)
  }

  // openSnackBar(message: string, action: string) {
  //   this._snackBar.open(message, action, {
  //     duration: 2000,
  //   });
  // }

  public addMatch(): void{

    if(this.date.toLocaleString().length>=23){
      this.day = parseInt(this.date.toLocaleString().slice(3,5))
      this.month = parseInt(this.date.toLocaleString().slice(0,2))
      this.year = parseInt(this.date.toLocaleString().slice(6,10))
      console.log(this.day)
      console.log(this.month)
      console.log(this.year);
    }else if(this.date.toLocaleString().length>=22){
      console.log(this.date.toLocaleString())
      this.day = parseInt(this.date.toLocaleString().slice(3,4))
      this.month = parseInt(this.date.toLocaleString().slice(0,2))
      this.year = parseInt(this.date.toLocaleString().slice(5,9))
      console.log(this.day)
      console.log(this.month)
      console.log(this.year);
    }

    if(this.goal1==null){
      this.goal1=0;
    }
    if(this.goal2==null){
      this.goal2=0;
    }

    if(this.clubName1 == null || this.clubName2 == null || this.day == null){
      alert("Fill Everything");
    }else{

      this.addMatchService.addMatch(this.clubName1,this.clubName2,this.goal1,this.goal2,this.day,this.month,this.year).subscribe((data: any) => {
        alert("Match Added");
        this.clubName1 = '';
        this.clubName2 = '';
        this.goal1 = null;
        this.goal2 = null;
        this.day = null;
        this.month = null;
        this.year = null;
      })
    }

  }

  public click(): void{

    if(this.date.toLocaleString().length>=23){
      this.day = parseInt(this.date.toLocaleString().slice(3,5))
      this.month = parseInt(this.date.toLocaleString().slice(0,2))
      this.year = parseInt(this.date.toLocaleString().slice(6,10))
      console.log(this.day)
      console.log(this.month)
      console.log(this.year);
    }else if(this.date.toLocaleString().length>=22){
      console.log(this.date.toLocaleString())
      this.day = parseInt(this.date.toLocaleString().slice(3,4))
      this.month = parseInt(this.date.toLocaleString().slice(0,2))
      this.year = parseInt(this.date.toLocaleString().slice(5,9))
      console.log(this.day)
      console.log(this.month)
      console.log(this.year);
    }


    // console.log(this.day)
    // console.log(this.month)
    // console.log()
  }

  public getClub(): void{
    this.addMatchService.getClub().subscribe((data: any) => {
      this.array = data.response;
    })
  }

}




