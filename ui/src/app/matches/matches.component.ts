import { Component, OnInit } from '@angular/core';
import {MatchesService} from "../services/matches.service";
import Swal from 'sweetalert2';

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})
export class MatchesComponent implements OnInit {

  array=[]
  test:boolean;

  dateChecker=false;

  date:object;

  day:number;
  month:number;
  year:number;

  minDate:Date;
  maxDate:Date;

  //creating the instance of matchService
  constructor(private matchesService : MatchesService) { }

  //triggering the methods whenever the component loads
  ngOnInit() {
    this.getMatches() //getting the matches whenever the component loads
    this.test=false;
    this.minDate = new Date(2020,9,1)
    this.maxDate = new Date(2020,12,0)
  }

  //method to get all the matches
  public getMatches(): void{
      this.matchesService.getMatches().subscribe((data: any) => {
        document.getElementById('loading').style.display = 'none';  //hiding the loader when the http request arrives
        this.array = data.response; //adding the returned JSON Object to Array
        // console.log(data.response)
      })
    }

  //Get all the matches Sorted
  public getMatchesSorted(): void{
    this.date=null;
    this.dateChecker=false;
    if(this.test==false){
      this.matchesService.getMatchesSorted().subscribe((data: any) => {
        document.getElementById('loading').style.display = 'none';  //hiding the loader when the http request arrives
        this.array = data.response; //adding the returned JSON Object to array
        // console.log(data.response)
      })
    }else if(this.test==true){
      this.matchesService.getMatches().subscribe((data: any) => {
        document.getElementById('loading').style.display = 'none';  //hiding the loader when the http request arrives
        this.array = data.response; //adding the returned JSON Object to array
        // console.log(data.response)
      })
    }
  }

  //method to get the matches played on a specific date
  public dateCheck(): void{
    this.array = [];
    document.getElementById('loading').style.display = '';  //making the loader run
    this.dateChecker=true;
    if(this.date.toLocaleString().length>=23){
      //slicing the date from the Calendar Picker according to the format
      this.day = parseInt(this.date.toLocaleString().slice(3,5))
      this.month = parseInt(this.date.toLocaleString().slice(0,2))
      this.year = parseInt(this.date.toLocaleString().slice(6,10))
      // console.log(this.day)
      // console.log(this.month)
      // console.log(this.year);
    }else if(this.date.toLocaleString().length>=22){
      // console.log(this.date.toLocaleString())
      this.day = parseInt(this.date.toLocaleString().slice(3,4))
      this.month = parseInt(this.date.toLocaleString().slice(0,2))
      this.year = parseInt(this.date.toLocaleString().slice(5,9))
      // console.log(this.day)
      // console.log(this.month)
      // console.log(this.year);
    }
    this.matchesService.getMatchesByDate(this.day,this.month,this.year).subscribe((data: any) => { //getting the matches from a method from matchService
      document.getElementById('loading').style.display = 'none';  //hiding the loader when the http request comes
      this.array = data.response; //adding the returned data to an array
      if(data.response.length==0){
        Swal.fire('No Matches Found', 'No matches were played on - '+this.day+'/'+this.month+'/'+this.year, 'warning')
      }
      // else{
      //   Swal.fire(data.response.length+' Matches Found', '', 'success')
      // }
    })
  }

}
