import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-balancetransfer',
  templateUrl: './balancetransfer.component.html',
  styleUrls: ['./balancetransfer.component.css'],
})
export class BalancetransferComponent implements OnInit {
  fundInput = {
    accountNumber1: 0, //sender account number
    accountNumber2: 0, //recevier account number
    amount: 0, // balance to be tranferred
  };

  public loggedIn = false;
  constructor(private loginService: LoginService) {}
  public username = '';
  public value: any;

  ngOnInit(): void {
    this.loggedIn = this.loginService.isLoggedIn();
    this.username = this.loginService.getUsername() as string;
  }
  /**
   * to tansfer amount from one account to another
   * @return void
   */
  onSubmit(): void {
    this.loginService.getfundtransfer(this.fundInput).subscribe(
      (data: any) => {
        console.log(data);
        this.value = data;
      },

      (error) => {
        console.log('error' + error);
      }
    );
  }
}
