import { Component, OnInit } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Szekhely } from '../model/szekhely.model';
import { Munkaltato } from '../model/munkaltato.model';
import { Felhasznalo } from '../model/baseuser.model';
import { Allaskereso } from '../model/allaskereso.model';
import { Oneletrajz } from '../model/oneletrajz.model';
import { Vegzettseg } from '../model/vegzettseg.model';

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
  oneletrajz: Oneletrajz;
  vegzettsegek: Vegzettseg[] = [];
  szekhely: Szekhely;
  success: boolean;

  constructor(private modalService: NgbModal) {}

  ngOnInit() {
    this.clearAll();
  }

  public submitForm() {
    console.log('form submitted');
    console.log('Felhasznalo: ', this.felhasznalo);
    console.log('Munkaltato : ', this.felhasznalo);
    console.log('Szekhely: ', this.felhasznalo);
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
