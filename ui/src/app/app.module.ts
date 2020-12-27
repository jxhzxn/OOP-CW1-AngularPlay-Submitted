import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HTTP_INTERCEPTORS, HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { RouteExampleComponent } from './route-example/route-example.component';

import { AppService } from './app.service';
import { AppHttpInterceptorService } from './http-interceptor.service';
import {FormsModule} from "@angular/forms";
import { NavbarComponent } from './navbar/navbar.component';
import { PointsTableComponent } from './points-table/points-table.component';
import { CreateClubComponent } from './create-club/create-club.component';

import {MatTableModule} from '@angular/material';
import {MatSelectModule} from '@angular/material/select';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddMatchComponent } from './add-match/add-match.component';
import { MatchesComponent } from './matches/matches.component';



const material = [
  MatTableModule,
  MatSelectModule
]

const routes: Routes = [
  { path:'', component: PointsTableComponent },
  { path:'createClub', component: CreateClubComponent },
  { path:'addMatch', component: AddMatchComponent},
  { path:'matches', component: MatchesComponent},
  {
    path: 'java',
    component: RouteExampleComponent,
    data: { technology: 'Java' }
  },
  {
    path: 'play',
    component: RouteExampleComponent,
    data: { technology: 'Play' }
  },
  {
    path: 'angular',
    component: RouteExampleComponent,
    data: { technology: 'Angular' }
  },
  {
    path: '**',
    redirectTo: '/play',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    RouteExampleComponent,
    NavbarComponent,
    PointsTableComponent,
    CreateClubComponent,
    AddMatchComponent,
    MatchesComponent
  ],
  imports: [
    BrowserModule,
    MatTableModule,
    FormsModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'Csrf-Token',
      headerName: 'Csrf-Token',
    }),
    RouterModule.forRoot(routes),
    BrowserAnimationsModule,
    MatSelectModule
  ],
  providers: [
    AppService,
    {
      multi: true,
      provide: HTTP_INTERCEPTORS,
      useClass: AppHttpInterceptorService
    }
  ],
  exports: [
    RouterModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
