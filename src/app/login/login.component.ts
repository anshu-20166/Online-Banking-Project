import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  credentials = {
    username: '',
    password: '',
  };

  constructor(private loginService: LoginService) {}

  ngOnInit(): void {}
  /**
   * to check credentials and authentication
   * @return void
   */
  onSubmit() {
    if (this.credentials.username != '' && this.credentials.password != '') {
      console.log('we have to submit form to server', this.credentials);
      localStorage.setItem('username', this.credentials.username);
      localStorage.removeItem('token');
      this.loginService.generateToken(this.credentials).subscribe(
        (response: any) => {
          console.log(response);
          console.log('successfully executed' + response.token);
          this.loginService.loginUser(response.token);
          console.log('hello');
          //for admin login username is Admin45
          if (this.credentials.username === 'Admin45') {
            console.log('hello admin');
            window.location.href = '/admin-module';
          } else {
            window.location.href = '/home';
            console.log('hello user');
          }

          // window.location.href = '/admin-module';
        },
        (error) => {
          alert('Invalid Username and Password');
          console.log('error occured here' + error);
        }
      );
    } else {
      console.log('form submitted');
    }
  }
}
