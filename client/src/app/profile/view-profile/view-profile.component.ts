import { Component, OnInit } from '@angular/core';
import { FelhasznaloService } from '../../service/felhasznalo.service';
import { MunkaltatoService } from '../../service/munkaltato.service';
import { AllaskeresoService } from '../../service/allaskereso.service';
import { Felhasznalo } from '../../model/baseuser.model';
import { ActivatedRoute } from '@angular/router';

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
    private allaskeresoService: AllaskeresoService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {
    this.clearAll();
    this.felhasznaloService.getFelhasznaloById(this.activatedRoute.snapshot.params.id).subscribe(res => {
      this.felhasznalo = res;
    });

  }

  clearAll() {
    this.felhasznalo = {};
  }

}
