import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-admin-get-all-users',
  templateUrl: './admin-get-all-users.component.html',
  styleUrls: ['./admin-get-all-users.component.css'],
})
export class AdminGetAllUsersComponent implements OnInit {
  users: any = [];
  constructor(private loginService: LoginService) {}

  ngOnInit(): void {
    /**
     * get the deletes of all users
     * @return users array
     */
    this.loginService.getallUsers().subscribe(
      (response) => {
        console.log(response);
        this.handleResponse(response);
      },
      (error) => {
        console.log('error', error);
      }
    );
  }
  /**
   * add the response users array
   * @return void
   */
  handleResponse(response: any) {
    this.users = response;
  }
  /**
   * delete the user.
   * @return true
   */

  delete(accountNumber: any) {
    alert('Are You Sure .You want to delete the USER?');
    this.loginService.deleteAccount(accountNumber).subscribe(
      (response) => {
        console.log('respnse');
      },
      (error) => {
        console.log('error');
      }
    );
    alert('User deleted successfully');
    window.location.href = '/admin-getAllUserser';
    window.location.reload();
  }
}
