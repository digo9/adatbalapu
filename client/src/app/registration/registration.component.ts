import { Component, OnInit } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Szekhely } from '../model/szekhely.model';
import { Munkaltato } from '../model/munkaltato.model';
import { Felhasznalo } from '../model/baseuser.model';
import { Allaskereso } from '../model/allaskereso.model';
import { Oneletrajz } from '../model/oneletrajz.model';
import { Vegzettseg } from '../model/vegzettseg.model';
import { AllaskeresoService } from '../service/allaskereso.service';
import { Subject } from 'rxjs/Subject';
import { debounceTime } from 'rxjs/operators';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  public profileType = 0;
  closeResult: string;
  felhasznalo: Felhasznalo;
  munkaltato: Munkaltato;
  public allaskereso: Allaskereso;
  public oneletrajz: Oneletrajz;
  public vegzettsegek: Vegzettseg[] = [];
  public szekhely: Szekhely;
  success: boolean;
  public errorMessage = false;
  public successMessage = false;
  private _error = new Subject<boolean>();
  private _success = new Subject<boolean>();

  constructor(
    private modalService: NgbModal,
    private allaskeresoService: AllaskeresoService
  ) {
    this.allaskereso = new Allaskereso();
    this.oneletrajz = new Oneletrajz();
    this.szekhely = new Szekhely();
  }

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

  public submitForm() {
    console.log('form submitted');
    console.log('Felhasznalo: ', this.felhasznalo);
    console.log('Munkaltato : ', this.munkaltato);
    console.log('Szekhely: ', this.szekhely);
    console.log('allaskereso: ', this.allaskereso);
    console.log('Oneletrajz: ', this.oneletrajz);
    this.allaskereso.felhasznalo = this.felhasznalo;
    this.allaskereso.oneletrajz = this.oneletrajz;
    this.allaskeresoService.createAllaskereso(this.allaskereso).subscribe(
      res => {
        console.log(res);
        this._success.next(true);
      },
      err => {
        console.log(err);
        this._error.next(true);
      }
    );
    // User registration
    if (this.profileType === 0) {
    } else {
      this.munkaltato.szekhely.push(this.szekhely);
    }
  }

  open(content) {
    this.modalService.open(content).result.then(
      result => {
        this.closeResult = `Closed with: ${result}`;
      },
      reason => {
        this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
      }
    );
  }

  clearAll() {
    this.felhasznalo = {};
    this.munkaltato = {};
    this.szekhely = {};
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }
}
