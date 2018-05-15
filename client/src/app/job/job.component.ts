import { Component, OnInit } from '@angular/core';
import { Allasajanlat } from '../model/allasajanlat.model';
import { AllasajanlatService } from '../service/allasajanlat.service';
import { FelhasznaloService } from '../service/felhasznalo.service';
import { Allaskereso } from '../model/allaskereso.model';
import { AuthenticationService } from '../auth/authentication.service';
import { Felhasznalo } from '../model/baseuser.model';
import { ActivatedRoute } from '@angular/router';

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
    private authenticationService: AuthenticationService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {
    this.clearAll();
    this.allaskeresoIsLoggedIn();
    this.allasajanlatService.getAssignedUsers(this.activatedRoute.snapshot.params.id).subscribe(
      (res: any) => {
        this.jelentkezettAllaskeresok = res;
        this.jelentkezettAllaskeresok.forEach((data) => {
          console.log(data);
          this.jelentkezettAllaskeresok.push();
        });
      });

    this.allasajanlatService.getAllasajanlatById(this.activatedRoute.snapshot.params.id).subscribe(res => {
      this.allasajanlat = res;
      console.log(this.allasajanlat.munkaltato.szekhely);
    });
  }

  allaskeresoIsLoggedIn() {
    this.authenticationService.isLoggedIn().then(data => {
      this.isLoggedIn = data;
    });
  }

  clearAll() {
    this.allasajanlat = {};
    this.jelentkezettAllaskeresok = [];
  }

  allaskeresoJelentkezik() {
    console.log('jelentkezes megnyomva');
  }

}
