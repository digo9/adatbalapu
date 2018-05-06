import { Component, OnInit } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { RegisterService } from './registration.service';
import { User } from '../model/user.model';
import { Employer } from '../model/employer.model';
import { Headquarters } from '../model/headquarters.model';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  public profileType = 0;
  closeResult: string;
  user: User;
  employer: Employer;
  headquarters: Headquarters;
  success: boolean;

  constructor(
    private modalService: NgbModal,
    private registerService: RegisterService
  ) {
  }

  ngOnInit() {
    this.clearAll();
  }

  public submitForm() {
    console.log('form submitted');
    // User registration
    if (this.profileType === 0) {
      this.registerService.save(this.user).subscribe(() => {
        this.success = true;
      });
    } else {
      this.employer.headquarters = this.headquarters;
      this.registerService.save(this.employer).subscribe(() => {
        this.success = true;
      });
    }
  }

  open(content) {
    this.modalService.open(content).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
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
