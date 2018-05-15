import { Component, OnInit } from '@angular/core';
import { FelhasznaloService } from '../../service/felhasznalo.service';
import { MunkaltatoService } from '../../service/munkaltato.service';
import { AllaskeresoService } from '../../service/allaskereso.service';
import { Felhasznalo } from '../../model/baseuser.model';

@Component({
  selector: 'app-view-profile',
  templateUrl: './view-profile.component.html',
  styleUrls: ['./view-profile.component.css', '../../app.component.css']
})
export class ViewProfileComponent implements OnInit {

  felhasznalo: Felhasznalo;

  constructor(
    private felhasznaloService: FelhasznaloService,
    private munkaltatoService: MunkaltatoService,
    private allaskeresoService: AllaskeresoService
  ) { }

  ngOnInit() {
    this.clearAll();
    this.felhasznaloService.getFelhasznaloById(1).subscribe(res => {
      this.felhasznalo = res;
    });
  }

  clearAll() {
    this.felhasznalo = {};
  }

}
