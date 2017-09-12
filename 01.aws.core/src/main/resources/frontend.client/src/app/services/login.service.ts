import {Injectable} from '@angular/core';
import {Http, Response, Headers} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/observable/throw";
import {ApiService} from "./api.service";
import {CredentialsModel} from "../model/credentials.model";

@Injectable()
export class LoginService {

  private authenticated: boolean;

  constructor(private http: Http, private apiService: ApiService) {
    this.authenticated = false;
  }

  login(credentials: CredentialsModel): Observable<any> {
    const uri = "/user";
    console.log("username: " + credentials.username);
    console.log("password: " + credentials.password);
    this.apiService.setHeaders(credentials);

    return this.http
      .get(uri, {headers: this.apiService.getHeaders()})
      .map((res: Response) => {
        const data = res.json();
        if (data !== null) {
          this.authenticated = true;
        }
        return data || {};
      })
      .catch((error: any) => {
        this.authenticated = false;
        let errMsg: string;
        if (error instanceof Response) {
          const body = error.json() || '';
          const err = body.error || JSON.stringify(body);
          errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
        } else {
          errMsg = error.message ? error.message : error.toString();
        }
        console.error("error: " + errMsg);
        return Observable.throw(errMsg);
      });
  }

  isAuthenticated(): boolean {
    return this.authenticated;
  }

  logout() {
    const uri = "/logout";
    return this.http
      .post(uri, {}, this.apiService.getHeaders())
      .map(() => {
        this.authenticated = false;
        this.apiService.setHeaders(new CredentialsModel("", ""));
      })
      .catch((error: any) => {
        this.authenticated = false;
        let errMsg: string;
        if (error instanceof Response) {
          const body = error.json() || '';
          const err = body.error || JSON.stringify(body);
          errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
        } else {
          errMsg = error.message ? error.message : error.toString();
        }
        console.error("error: " + errMsg);
        return Observable.throw(errMsg);
      });
  }
}
