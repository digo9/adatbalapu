import { Component, OnInit } from '@angular/core';
import { Allasajanlat } from '../model/allasajanlat.model';
import { AllasajanlatService } from '../service/allasajanlat.service';
import { FelhasznaloService } from '../service/felhasznalo.service';
import { Allaskereso } from '../model/allaskereso.model';
import { AuthenticationService } from '../auth/authentication.service';
import { Felhasznalo } from '../model/baseuser.model';

@Component({
  selector: 'app-job',
  templateUrl: './job.component.html',
  styleUrls: ['./job.component.css', '../app.component.css']
})
export class JobComponent implements OnInit {


  felhasznalo: Felhasznalo;
  allasajanlat: Allasajanlat;
  jelentkezettAllaskeresok: Allaskereso[];
  isLoggedIn = false;

  constructor(
    private allasajanlatService: AllasajanlatService,
    private felhasznaloService: FelhasznaloService,
    private authenticationService: AuthenticationService
  ) { }

  ngOnInit() {
    this.clearAll();
    this.allaskeresoIsLoggedIn();

    this.allasajanlatService.getAllasajanlatById(14).subscribe(res => {
      this.allasajanlat = res;
    });
  }

  allaskeresoIsLoggedIn() {
    this.authenticationService.isLoggedIn().then(data => {
      this.isLoggedIn = data;
    });
  }

  clearAll() {
    this.allasajanlat = {};
  }

  allaskeresoJelentkezik() {
    console.log('jelentkezes megnyomva');
  }

}
