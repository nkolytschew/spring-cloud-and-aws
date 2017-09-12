import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpModule} from "@angular/http";
import {RouterModule} from "@angular/router";
import {LoginComponent} from './login/login.component';
import {NavigationComponent} from './navigation/navigation.component';
import {HomeComponent} from './home/home.component';
import {FormsModule} from "@angular/forms";
import {LoginService} from "./services/login.service";
import {ApiService} from "./services/api.service";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavigationComponent,
    HomeComponent
  ],
  imports: [
    HttpModule,
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(
      [
        {path: 'login', component: LoginComponent},
        {path: 'home', component: HomeComponent},
        {path: '', component: HomeComponent}
      ]
    )
  ],
  providers: [
    LoginService,
    ApiService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
