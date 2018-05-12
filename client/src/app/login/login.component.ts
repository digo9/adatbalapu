import {
  Component,
  OnInit,
  ViewEncapsulation,
  EventEmitter,
  Input,
  Output
} from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../auth/authentication.service';
import { COMMONs } from '../app.constants';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation: ViewEncapsulation.Emulated
})
export class LoginComponent implements OnInit {
  username: string;
  password: string;
  loading = false;
  error: string;
  private redirectUrl: string;
  @Input() title: string;
  @Input() modalMode = false;
  @Output() closeMe = new EventEmitter();

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    const params = this.route.snapshot.paramMap;
    if (params.has(COMMONs.REDIRECT_URL_PARAM)) {
      this.redirectUrl = params.get(COMMONs.REDIRECT_URL_PARAM);
    }
  }

  login() {
    this.loading = true;
    this.authenticationService
      .login(this.username, this.password)
      .then(result => {
        // login successful
        console.log('sikeres bejelentkezes');
        if (result) {
          if (this.redirectUrl) {
            this.router.navigate([this.redirectUrl]);
            this.redirectUrl = null;
          } else {
            this.router.navigate(['/']);
            this.closeMe.emit();
          }
        } else {
          console.log('hibas felhasznalonev vagy jelszo');
        }
      });
  }
}
