import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  public loggedIn = false;
  public response = 0;

  constructor(private loginService: LoginService) {}
  public username = '';

  ngOnInit(): void {
    this.loggedIn = this.loginService.isLoggedIn();
    this.username = this.loginService.getUsername() as string;

    /**
     * to check if the request to close account is send or not
     * @return 1 if sent 0 if not sent
     */
    this.loginService.closeAccountStatus().subscribe(
      (response: any) => {
        this.response = response;
        console.log('successful');
        console.log(response);
      },
      (error) => {
        console.log('error');
        console.log(error);
      }
    );
  }

  /**
   * user request to close the account
   * @return true
   */
  closeAccount() {
    alert('are u sure !!');
    this.loginService.closeThisAccount().subscribe();
    alert('request sent successfully !! ');
    window.location.href = '/home';
  }
}
