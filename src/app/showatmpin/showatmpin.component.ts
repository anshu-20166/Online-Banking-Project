import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';
@Component({
  selector: 'app-showatmpin',
  templateUrl: './showatmpin.component.html',
  styleUrls: ['./showatmpin.component.css'],
})
export class ShowatmpinComponent implements OnInit {
  /**
   * variable to store accountnumber and username
   */
  pinInput = {
    accountNumber: 0,
    username: this.loginService.getUsername(),
  };

  public loggedIn = false;
  constructor(private loginService: LoginService) {}
  public username = '';
  public pin!: Number;

  ngOnInit(): void {
    this.loggedIn = this.loginService.isLoggedIn();
    this.username = this.loginService.getUsername() as string;
  }

  /**
   * onclick onShowPin function
   * @return atmPin
   */
  onShowPin(): void {
    console.log(this.pinInput);
    this.loginService.getatmpin(this.pinInput).subscribe(
      (data: any) => {
        console.log(data);
        this.pin = data;
        console.log(this.pin);
      },

      (error) => {
        console.log('error' + error);
      }
    );
  }
}
