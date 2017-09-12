import {Component, OnInit} from '@angular/core';
import {LoginService} from "../services/login.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit {

  constructor(private loginService: LoginService,
    private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    this.loginService
      .logout()
      .subscribe(() => this.router.navigateByUrl("/"));
  }

}
