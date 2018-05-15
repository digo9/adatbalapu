import { Component, OnInit } from '@angular/core';
import { AllasajanlatService } from '../service/allasajanlat.service';
import { Allasajanlat } from '../model/allasajanlat.model';
import { AuthenticationService } from '../auth/authentication.service';

@Component({
  selector: 'app-find-jobs',
  templateUrl: './find-jobs.component.html',
  styleUrls: ['./find-jobs.component.css', '../app.component.css']
})
export class FindJobsComponent implements OnInit {

  allasajanlatok: Allasajanlat[];
  jelentkezettAllasajanlatok: Allasajanlat[];
  hirdetesType = 0;
  isLoggedIn = false;

  constructor(
    private allasajanlatService: AllasajanlatService,
    private authenticationService: AuthenticationService
  ) { }

  ngOnInit() {
    this.clearAll();
    this.allaskeresoIsLoggedIn();

    this.allasajanlatService.getAllasajanlatAll().subscribe(
      (res: any) => {
        this.allasajanlatok = res;
        this.allasajanlatok.forEach((data) => {
          console.log(data);
          this.allasajanlatok.push();
        });
      },
    );
  }

  allaskeresoIsLoggedIn() {
    this.authenticationService.isLoggedIn().then(data => {
      this.isLoggedIn = data;
    });
  }

  clearAll() {
    this.allasajanlatok = [];
    this.jelentkezettAllasajanlatok = [];
  }
}
