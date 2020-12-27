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

  clubName1:string;
  clubName2:string;
  goal1:number;
  goal2:number;


  array=[]

  ngOnInit() {
    this.getClub()
  }

  // openSnackBar(message: string, action: string) {
  //   this._snackBar.open(message, action, {
  //     duration: 2000,
  //   });
  // }

  public addMatch(): void{

    if(this.goal1==null){
      this.goal1=0;
    }
    if(this.goal2==null){
      this.goal2=0;
    }

    if(this.clubName1 == null || this.clubName2 == null){
      alert("Fill Everything");
    }else{
      this.addMatchService.addMatch(this.clubName1,this.clubName2,this.goal1,this.goal2).subscribe((data: any) => {
        // this.openSnackBar("Match Added","Close");
        alert("Match Added");
        this.clubName1 = null;
        this.clubName2 = null;
        this.goal1 = null;
        this.goal2 = null;
      })
    }

  }

  public getClub(): void{
    this.addMatchService.getClub().subscribe((data: any) => {
      this.array = data.response;
    })
  }

}




