import { Component, OnInit } from '@angular/core';
import { AllasajanlatService } from '../service/allasajanlat.service';
import { Allasajanlat } from '../model/allasajanlat.model';

@Component({
  selector: 'app-find-jobs',
  templateUrl: './find-jobs.component.html',
  styleUrls: ['./find-jobs.component.css', '../app.component.css']
})
export class FindJobsComponent implements OnInit {

  allasajanlatok: Allasajanlat[] = [];

  constructor(
    private allasajanlatService: AllasajanlatService
  ) { }

  ngOnInit() {
    this.allasajanlatService.getAllasajanlatAll().subscribe(
      (res: any) => {
        this.allasajanlatok = res;
        this.allasajanlatok.forEach((data) => {
          console.log(data);
          this.allasajanlatok.push();
        });
      },
    );
  }
}
