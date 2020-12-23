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

  public createPerson(): void{
    this.appService.createPerson(this.clubName,this.location,this.homeGround).subscribe((data: any) => {
      this.postRequestResponse = data.content;
    })
  }

}
