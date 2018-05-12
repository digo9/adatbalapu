import { Component, OnInit } from '@angular/core';
import { fadeInAnimation } from '../animations/fade-in.animation';
import { AllaskeresoService } from '../service/allaskereso.service';
import { Allaskereso } from '../model/allaskereso.model';
import { AuthenticationService } from '../auth/authentication.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  // make fade in animation available to this component
  animations: [fadeInAnimation],

  // attach the fade in animation to the host (root) element of this component
  // tslint:disable-next-line:use-host-property-decorator
  host: { '[@fadeInAnimation]': '' },
  styleUrls: ['./main-page.component.css'],
  providers: [AllaskeresoService]
})
export class MainPageComponent implements OnInit {
  constructor(
    private allaskeresoService: AllaskeresoService,
    private authService: AuthenticationService
  ) {}
  public allaskereso: Allaskereso;
  public allaskeresoJson;
  public principalStatus;

  ngOnInit() {}

  listAllaskeresokToConsole() {
    this.allaskeresoService.getAllaskeresoById(3).subscribe(response => {
      console.log(response);
      this.allaskereso = response;
      this.allaskeresoJson = JSON.stringify(this.allaskereso);
    });
  }

  getUser() {
    if (this.authService.principal) {
      this.principalStatus = JSON.stringify(this.authService.principal);
    } else {
      this.principalStatus = 'no principal assigned';
    }
  }
}
