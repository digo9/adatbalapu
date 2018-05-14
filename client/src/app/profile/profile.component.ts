import { Component, OnInit } from '@angular/core';
import { Allaskereso } from '../model/allaskereso.model';
import { Munkaltato } from '../model/munkaltato.model';
import { AuthenticationService } from '../auth/authentication.service';
import { Felhasznalo } from '../model/baseuser.model';
import { FelhasznaloService } from '../service/felhasznalo.service';
import { MunkaltatoService } from '../service/munkaltato.service';
import { AllaskeresoService } from '../service/allaskereso.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfilComponent implements OnInit {

  allaskereso: Allaskereso;
  munkaltato: Munkaltato;
  bejelentkezettFelhasznalo: Felhasznalo;
  userDetails: any;
  constructor(
    private authService: AuthenticationService,
    private allaskeresoService: AllaskeresoService,
    private munkaltatoService: MunkaltatoService,
    private felhasznaloService: FelhasznaloService
  ) { }

  ngOnInit() {
    this.getUser();
  }

  getUser() {
    this.bejelentkezettFelhasznalo = this.authService.currentFelhasznalo;
    this.userDetails = JSON.stringify(this.bejelentkezettFelhasznalo);
  }

  submitForm() {
    console.log('submitted Form');
    this.felhasznaloService.updateBemutatkozoAdatok(this.bejelentkezettFelhasznalo);
    if (this.bejelentkezettFelhasznalo.allaskereso) {
      this.allaskeresoService.updateBemutatkozoAdatok(this.bejelentkezettFelhasznalo.allaskereso);
      console.log('submitted allaskereso');
    } else if (this.bejelentkezettFelhasznalo.munkaltato) {
      this.munkaltatoService.updateMunkaltatoAdatok(this.bejelentkezettFelhasznalo.munkaltato);
      console.log('submitted munkaltato');
    }
  }

}
