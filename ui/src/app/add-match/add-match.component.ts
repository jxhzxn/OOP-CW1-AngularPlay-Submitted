import {Component, Inject, OnInit} from '@angular/core';
import {AddMatchService} from "../services/add-match.service";
import {matSnackBarAnimations} from "@angular/material/snack-bar";
import {SnackBarOverviewExample} from "../services/custom-alert.service";
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-match',
  templateUrl: './add-match.component.html',
  styleUrls: ['./add-match.component.css']
})
export class AddMatchComponent implements OnInit {

  //creating an instance of addMatchService
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

  lastMatchArray = []

  ngOnInit() {
    this.getClub()  //running the getClub method whenever the Component runs
    this.minDate = new Date(2020,9,1)
    this.maxDate = new Date(2020,12,0)
  }

  //method to add a match
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

    if(this.clubName1==this.clubName2){ //checking whether if both the chosen clubs are same
      Swal.fire('Both are same Clubs', 'Choose two different Clubs', 'warning')
      this.clubName1 = '';
      this.clubName2 = '';
    }else  if(this.goal1<0 || this.goal2<0){  //making the goal count 0 if no number of goals were inserted
      this.goal1 = null;
      this.goal2 = null;
      Swal.fire('Invalid Goal Count', '', 'warning')
    }else{
      //adding the match
      this.addMatchService.addMatch(this.clubName1,this.clubName2,this.goal1,this.goal2,this.day,this.month,this.year).subscribe((data: any) => {
        if(this.clubName1!=this.clubName2){
          //triggering SwalFire Alert
          Swal.fire('Match Added', ''
            // +
            // '<div style="display: flex; justify-content: center; align-items: center; flex-direction: column">' +
            // '<div><h2><b>'+this.clubName1+' ('+this.goal1+') vs '+this.clubName2+' ('+this.goal2+')</b></h2></div>' +
            // '<div style="margin: 0"><h2><b>'+'Played on - '+this.day+'/'+this.month+'/'+this.year+'</b></h2></div>' +
            // '</div>'
            , 'success')
          this.clubName1 = '';
          this.clubName2 = '';
          this.goal1 = null;
          this.goal2 = null;
          this.day = null;
          this.month = null;
          this.year = null;
        }

        // else if(this.clubName1==this.clubName2){
        //   Swal.fire('Both are same Clubs', 'Choose two different Clubs', 'warning')
        //   this.clubName1 = '';
        //   this.clubName2 = '';
        // }

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

  //method to get all the clubs from the Backend
  public getClub(): void{
    this.addMatchService.getClub().subscribe((data: any) => {
      this.array = data.response;
    })
  }

  //method to generate a Match
  public generateMatch(): void{
    this.addMatchService.generateMatch().subscribe((data: any) =>{

      //adding the backend data to the array
      this.lastMatchArray = data.response
      // console.log(data.response.date.day)

      let day = ''+data.response.date.day;
      let month = ''+data.response.date.month;
      let year = ''+data.response.date.year;
      let goal11 = ''+data.response.team1Score;
      let goal22 = ''+data.response.team2Score;

      // console.log(typeof(day))

      //Triggering SwalFire
      Swal.fire('Match Generated', '' +
        '<div style="display: flex; justify-content: center; align-items: center; flex-direction: column">' +
        '<div><h2><b>'+data.response.team1.clubName+' ('+goal11+') vs '+data.response.team2.clubName+' ('+goal22+')</b></h2></div>' +
        '<div style="margin: 0"><h2><b>'+'Played on - '+day+'/'+month+'/'+year+'</b></h2></div>' +
        '</div>'
        , 'success')
    })
  }

}




