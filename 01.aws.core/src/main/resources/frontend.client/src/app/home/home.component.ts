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
    this.doStuff();
  }

  hello;
  hellos;
  something;

  doStuff(): void {
    const uri = "/api/resource";
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

    const hello = "v1/api/hello";
    this.http.get(hello)
      .subscribe(
        data => this.hello = data.json(),
        error => console.log("error: " + error));

    const hellos = "v1/api/hellos";
    this.http.get(hellos)
      .subscribe(
        data => this.hellos = data.json(),
        error => console.log("error: " + error));

    const something = "v1/api/something/blablabla";
    this.http.get(something)
      .subscribe(
        data => this.something = data.json(),
        error => console.log("error: " + error));

  }

}
