import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[];

  constructor(private userService: UserService,
      private router: Router) { }

  ngOnInit(): void {
    // this.users = [{
    //   "id": 1,
    //   "firstName": "Abhishek",
    //   "lastName": "Rai"
    // },
    // {
    //   "id": 2,
    //   "firstName": "Rohit",
    //   "lastName": "Rai"
    // }];
    this.getUsers();
  }

  private getUsers(){
    this.userService.getUserList().subscribe(data => {
      this.users = data;
    });
  }

  updateUser(id: number){
    this.router.navigate(['update-user', id]);
  }

}
