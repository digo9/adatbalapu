import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../auth/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  isLoggedIn = false;

  constructor(private authenticationService: AuthenticationService) {}

  ngOnInit() {
    this.authenticationService._isLoggedIn.subscribe(
      isLoged => (this.isLoggedIn = isLoged)
    );
    this.authenticationService.isLoggedIn().then(data => {
      this.isLoggedIn = data;
    });
  }

  private logout(): void {
    this.authenticationService.logout();
  }
}
