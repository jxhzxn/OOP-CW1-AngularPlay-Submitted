import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";
import Swal from 'sweetalert2';

@Component({
  selector: 'app-create-club',
  templateUrl: './create-club.component.html',
  styleUrls: ['./create-club.component.css']
})
export class CreateClubComponent implements OnInit{

  title: string;
  postRequestResponse: string;
  clubName = '';
  location = '';
  homeGround = '';
  nof_clubs : number;
  clubArray = [];

  //creating an instance of appService
  constructor(private appService: AppService) {
    this.appService.getWelcomeMessage().subscribe((data: any) => {
      this.title = data.content;
    });
  }

  //triggering the methods whenever the component loads
  ngOnInit() {
    this.clubCheck()
  }


  public postData(): void {
    this.appService.sendData().subscribe((data: any) => {
      this.postRequestResponse = data.content;
    });
  }

  //method to create a Club
  public createClub(): void{
    for(var x=0; x<=this.clubArray.length-1; x++){
      console.log(this.clubArray[x].clubName)
      if(this.clubArray[x].clubName==this.clubName){  //checking whether a club already exists with the same name
        Swal.fire('"'+this.clubName+'" is Already Added', '', 'warning'); //triggering swalFire
        this.homeGround = '';
        this.location = '';
        this.clubName = '';
        return;
      }
    }
    if(this.clubName!=null && this.location!=null && this.homeGround!=null){
      this.appService.createClub(this.clubName,this.location,this.homeGround).subscribe((data: any) => {  //triggering the createClub method of appService
        this.postRequestResponse = data.content;
        Swal.fire('Club Created', ''
          // +
          // '<div style="display: flex; justify-content: center; align-items: center; flex-direction: column">' +
          // '<h2><b>'+'Club Name - '+this.clubName+'</b></h2>' +
          // '<h2><b>'+'Location - '+this.location+'</b></h2>' +
          // '<h2><b>'+'Home Ground - '+this.homeGround+'</b></h2>' +
          // '</div>'
          , 'success')
        this.homeGround = '';
        this.location = '';
        this.clubName = '';
      })
    }else{
      Swal.fire('Complete Filling', 'All the fields should be filled', 'warning')
    }

  }

  public clubCheck(): void{
    this.appService.getClub().subscribe((data: any) => {
      this.clubArray = data.response;
    })
  }


}
