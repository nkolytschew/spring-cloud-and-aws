import {Component, OnInit} from '@angular/core';
import {LoginService} from "../services/login.service";
import {Router} from "@angular/router";
import {CredentialsModel} from "../model/credentials.model";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  hasError: boolean = false;
  credentials: CredentialsModel;

  constructor(private loginService: LoginService,
    private router: Router) {
    this.credentials = new CredentialsModel("", "");
  }

  ngOnInit() {
  }

  login() {
    this.loginService
      .login(this.credentials)
      .subscribe(data => {
          if (data !== null) {
            this.hasError = false;
            this.router.navigateByUrl("/");
          }
        },
        error => {
          console.log("error: " + error);
          this.hasError = true;
        });
  }

}
