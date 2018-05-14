import { Component, OnInit } from '@angular/core';
import { Allasajanlat } from '../model/allasajanlat.model';
import { Vegzettseg } from '../model/vegzettseg.model';
import { AllasajanlatService } from '../service/allasajanlat.service';

@Component({
  selector: 'app-new-offer',
  templateUrl: './new-offer.component.html',
  styleUrls: ['./new-offer.component.css']
})
export class NewOfferComponent implements OnInit {

  allasajanlat: Allasajanlat;
  vegzettsegek: Vegzettseg[] = [];

  constructor(
    private allasajanlatService: AllasajanlatService
  ) { }

  ngOnInit() {
    this.allasajanlat = null;
    this.vegzettsegek = null;
  }

  public submitForm() {
    this.allasajanlatService.createAllasajanlat(this.allasajanlat);
    console.log('form submitted');
    console.log('megnevezes: ', this.allasajanlat.megnevezes);
    console.log('leiras: ', this.allasajanlat.leiras);
    console.log('vegzettseg : ', this.allasajanlat.vegzettseg);
    console.log('fizetes : ', this.allasajanlat.fizetes);
  }
}
