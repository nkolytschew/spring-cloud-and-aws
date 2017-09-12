import {Component, OnInit} from '@angular/core';
import {Http, Response} from "@angular/http";
import "rxjs/add/operator/map";
import {ApiService} from "../services/api.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  greeting = {id: "", content: ""};
  authenticated: boolean = false;

  constructor(private http: Http, private apiService: ApiService) {
  }

  ngOnInit() {
  }

  doStuff(): void {
    const uri = "/resource";
    this.http
      .get(uri, this.apiService.getHeaders())
      .map((res: Response) => {
        const data = res.json();
        return data || {};
      })
      .subscribe(data => {
          this.greeting = data;
          if (this.greeting !== null) {
            this.authenticated = true;
          }
        },
        error => {
          console.log("error: " + error);
          this.authenticated = false;
        });
  }

}
