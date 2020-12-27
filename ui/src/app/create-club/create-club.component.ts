import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-create-club',
  templateUrl: './create-club.component.html',
  styleUrls: ['./create-club.component.css']
})
export class CreateClubComponent{



  title: string;
  postRequestResponse: string;
  clubName: string;
  location: string;
  homeGround: string;
  nof_clubs : number;
  chandira:number;

  constructor(private appService: AppService) {
    this.appService.getWelcomeMessage().subscribe((data: any) => {
      this.title = data.content;
    });
  }

  /**
   * This method is used to test the post request
   */
  public postData(): void {
    this.appService.sendData().subscribe((data: any) => {
      this.postRequestResponse = data.content;
    });
  }

  public createClub(): void{
    if(this.clubName!=null && this.location!=null && this.homeGround!=null){
      this.appService.createClub(this.clubName,this.location,this.homeGround).subscribe((data: any) => {
        this.postRequestResponse = data.content;
        alert("Club Created");
      })
    }else{
      alert("All the Fields Should be Filled");
    }

  }

  public getClub(): void{
    this.appService.getClub().subscribe((data: any) => {
      this.nof_clubs = data.response.length;
      var tested = Object.keys(data);
      console.log(data.response);
    })
  }

  public getNumber():void{
    this.appService.getNofClubs().subscribe((data:any) =>{
      this.chandira=data.content;
    })
  }

}
