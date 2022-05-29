import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterService } from '../service/register.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {
  credentials = {
    userName: '',
    accountNo: '',
    password: '',
    password2: '',
  };

  constructor(private registerService: RegisterService) {}

  ngOnInit(): void {}
  /**
   * to check account number and save details of new user
   * @return boolean
   */
  onSubmit(): void {
    console.log(this.credentials);
    if (this.credentials.password === this.credentials.password2) {
      this.registerService.validateNewUser(this.credentials).subscribe(
        (response: any) => {
          console.log('sucessfully exceuted', response);

          if (response == 2) {
            alert('Successfully registered...login again');
            window.location.href = '/login';
          } else if (response == 1) {
            alert('This username already exists');
          } else if (response == 3) {
            alert('This Account Number is already Registered!! Go to Login ');
          } else {
            alert('enter valid data');
            this.credentials.userName = '';
            this.credentials.accountNo = '';
            this.credentials.password = '';
            this.credentials.password2 = '';
          }
        },

        (error) => {
          console.log('error occured' + error);
        }
      );
    } else {
      alert('both password dont match...enter again ');
      this.credentials.password = '';
      this.credentials.password2 = '';
    }
  }
}
