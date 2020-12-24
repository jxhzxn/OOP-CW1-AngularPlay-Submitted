import {Component} from '@angular/core';

import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent{
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
    this.appService.createClub(this.clubName,this.location,this.homeGround).subscribe((data: any) => {
      this.postRequestResponse = data.content;
    })
  }


}
