import { Component, OnInit } from '@angular/core';
import { UserController } from '../_api-module/usercontroller.generated';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css'],
  providers: [UserController]
})
export class UsersComponent implements OnInit {

  constructor(private userController: UserController) { }

  ngOnInit() {
    this.userController.getUsersGet().subscribe(response => console.log(response));
  }

}
