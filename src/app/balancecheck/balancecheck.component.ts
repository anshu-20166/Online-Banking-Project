import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-balancecheck',
  templateUrl: './balancecheck.component.html',
  styleUrls: ['./balancecheck.component.css'],
})
export class BalancecheckComponent implements OnInit {
  user: any;
  public loggedIn = false;
  public balance!: Number;
  constructor(private loginService: LoginService) {}
  public username = '';

  ngOnInit(): void {
    this.loggedIn = this.loginService.isLoggedIn();
    this.username = this.loginService.getUsername() as string;
  }

  /**
   * to get the balance of the user
   * @return float value
   */
  balancecheck() {
    this.loginService.getbalance().subscribe(
      (data: any) => {
        console.log(data);
        this.balance = data;
      },

      (error) => {
        console.log('error' + error);
      }
    );
  }
}
