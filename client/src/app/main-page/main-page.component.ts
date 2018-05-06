import { Component, OnInit } from '@angular/core';
import { fadeInAnimation } from '../animations/fade-in.animation';
import { AllaskeresoService } from '../service/allaskereso.service';
import { Allaskereso } from '../model/allaskereso.model';

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
  constructor(private allaskeresoService: AllaskeresoService) {}
  allaskereso: Allaskereso;

  ngOnInit() {
    this.listAllaskeresokToConsole();
  }

  listAllaskeresokToConsole() {
    this.allaskeresoService.getAllaskeresoById(3).subscribe(response => {
      console.log(response);
      this.allaskereso = response;
      console.log(this.allaskereso);
    });
  }
}
