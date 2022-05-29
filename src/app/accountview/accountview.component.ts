import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-accountview',
  templateUrl: './accountview.component.html',
  styleUrls: ['./accountview.component.css'],
})
export class AccountviewComponent implements OnInit {
  //All the data
  firstName!: String;
  lastName!: String;
  accountNumber!: Number;
  homeBranch!: String;
  dOB!: Date;
  dateOfOpening!: Date;
  phoneNumber!: Number;
  typeOfAaccount!: String;

  constructor(private loginService: LoginService) {}

  ngOnInit(): void {
    /**
     * to fetch details of user to show on account view.
     * @return user_details
     */
    this.loginService.getUserByUsername().subscribe(
      (data: any) => {
        console.log(data);
        this.firstName = data.firstName;
        this.accountNumber = data.accountNumber;
        this.lastName = data.lastName;
        this.homeBranch = data.homeBranch;
        this.phoneNumber = data.phoneNumber;
        this.typeOfAaccount = data.typeOfAaccount;
        this.dateOfOpening = data.dateOfOpening;
        this.dOB = data.dOB;
      },

      (error) => {
        console.log('error' + error);
      }
    );
  }
}
