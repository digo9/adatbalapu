import { Component, OnInit } from '@angular/core';
import { Allasajanlat } from '../model/allasajanlat.model';
import { Vegzettseg } from '../model/vegzettseg.model';
import { AllasajanlatService } from '../service/allasajanlat.service';
import { Subject } from 'rxjs/Subject';
import { debounceTime } from 'rxjs/operators';

@Component({
  selector: 'app-new-offer',
  templateUrl: './new-offer.component.html',
  styleUrls: ['./new-offer.component.css', '../app.component.css']
})
export class NewOfferComponent implements OnInit {

  allasajanlat: Allasajanlat;
  vegzettsegek: Vegzettseg[] = [];
  public errorMessage = false;
  public successMessage = false;
  private _error = new Subject<boolean>();
  private _success = new Subject<boolean>();

  constructor(
    private allasajanlatService: AllasajanlatService
  ) { }

  ngOnInit() {
    this.clearAll();
    this._error.subscribe(isMessage => (this.errorMessage = isMessage));
    this._error
      .pipe(debounceTime(5000))
      .subscribe(() => (this.errorMessage = false));

    this._success.subscribe(isMessage => (this.successMessage = isMessage));
    this._success
      .pipe(debounceTime(5000))
      .subscribe(() => (this.successMessage = false));
  }

  clearAll() {
    this.allasajanlat = {};
    this.vegzettsegek = [];
  }

  public submitForm() {
    this.allasajanlatService.createAllasajanlat(this.allasajanlat);
    console.log('form submitted');
    console.log('megnevezes: ', this.allasajanlat.megnevezes);
    console.log('leiras: ', this.allasajanlat.leiras);
    console.log('vegzettseg : ', this.allasajanlat.vegzettseg);
    console.log('fizetes : ', this.allasajanlat.fizetes);

    this.allasajanlatService.createAllasajanlat(this.allasajanlat).subscribe(
      res => {
        console.log(res);
        this._success.next(true);
        this.clearAll();
      },
      err => {
        console.log(err);
        this._error.next(true);
      }
    );
  }
}
