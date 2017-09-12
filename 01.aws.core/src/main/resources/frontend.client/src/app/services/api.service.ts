import {Injectable} from '@angular/core';
import {Headers} from "@angular/http";
import {CredentialsModel} from "../model/credentials.model";

@Injectable()
export class ApiService {

  private loginHeaders: Headers;

  constructor() {
    this.loginHeaders = new Headers();
  }

  getHeaders(): Headers {
    console.log("auth: " + this.loginHeaders.get("Authorization"));
    return this.loginHeaders
  }

  setHeaders(credentials: CredentialsModel) {
    this.loginHeaders.append('Authorization',
      'Basic ' + btoa(`${credentials.username}:${credentials.password}`));
  }
}
