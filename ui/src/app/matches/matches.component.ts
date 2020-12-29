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

  constructor(private matchesService : MatchesService) { }

  ngOnInit() {
    this.getMatches()
    this.test=false;
    this.minDate = new Date(2020,9,1)
    this.maxDate = new Date(2020,12,0)
  }

  public getMatches(): void{
      this.matchesService.getMatches().subscribe((data: any) => {
        document.getElementById('loading').style.display = 'none';
        this.array = data.response;
        console.log(data.response)
      })
    }



  public getMatchesSorted(): void{
    this.date=null;
    this.dateChecker=false;
    if(this.test==false){
      this.matchesService.getMatchesSorted().subscribe((data: any) => {
        document.getElementById('loading').style.display = 'none';
        this.array = data.response;
        console.log(data.response)
      })
    }else if(this.test==true){
      this.matchesService.getMatches().subscribe((data: any) => {
        document.getElementById('loading').style.display = 'none';
        this.array = data.response;
        console.log(data.response)
      })
    }
  }

  public dateCheck(): void{
    this.dateChecker=true;
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
    this.matchesService.getMatchesByDate(this.day,this.month,this.year).subscribe((data: any) => {
      document.getElementById('loading').style.display = 'none';
      this.array = data.response;
      if(data.response.length==0){
        Swal.fire('No Matches Found', 'No matches were played on - '+this.day+'/'+this.month+'/'+this.year, 'warning')
      }
      // else{
      //   Swal.fire(data.response.length+' Matches Found', '', 'success')
      // }
    })
  }

}
