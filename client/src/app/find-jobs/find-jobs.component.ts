import { Component, OnInit } from '@angular/core';
import { AllasajanlatService } from '../service/allasajanlat.service';
import { Allasajanlat } from '../model/allasajanlat.model';
import { AuthenticationService } from '../auth/authentication.service';
import { ActivatedRoute } from '@angular/router';

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
    private authenticationService: AuthenticationService,
    private activatedRoute: ActivatedRoute
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
      });

    this.allasajanlatService.getAllasajanlatById(this.activatedRoute.snapshot.params.id).subscribe(
      (res: any) => {
        this.jelentkezettAllasajanlatok = res;
        this.jelentkezettAllasajanlatok.forEach((data) => {
          console.log(data);
          this.jelentkezettAllasajanlatok.push();
        });
      });
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
