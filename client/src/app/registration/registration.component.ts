import { Component, OnInit } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Szekhely } from '../model/szekhely.model';
import { Munkaltato } from '../model/munkaltato.model';
import { BaseUser } from '../model/baseuser.model';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  public profileType = 0;
  closeResult: string;
  user: BaseUser;
  employer: Munkaltato;
  headquarters: Szekhely;
  success: boolean;

  constructor(private modalService: NgbModal) {}

  ngOnInit() {
    this.clearAll();
  }

  public submitForm() {
    console.log('form submitted');
    // User registration
    if (this.profileType === 0) {
    } else {
      this.employer.szekhelyId = this.headquarters.id;
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
    this.user = {};
    this.employer = {};
    this.headquarters = {};
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
