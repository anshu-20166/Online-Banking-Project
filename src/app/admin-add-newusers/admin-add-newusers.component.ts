import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterService } from '../service/register.service';

@Component({
  selector: 'app-admin-add-newusers',
  templateUrl: './admin-add-newusers.component.html',
  styleUrls: ['./admin-add-newusers.component.css'],
})
export class AdminAddNewusersComponent implements OnInit {
  /**
   object to get all the input by the admin 
   */
  credentials = {
    accountNumber: 0,
    firstName: '',
    lastName: '',
    typeOfAaccount: '',
    phoneNumber: 0,
    atmPin: 0,
    balance: 0,
    dOB: new Date('2019-01-16'),
    homeBranch: '',
    dateOfOpening: new Date('2019-01-16'),
  };

  constructor(private registerService: RegisterService) {}

  ngOnInit(): void {}
  /**
   * save the user to the database.
   * @return void
   */
  onSubmit(): void {
    this.registerService.adminAddNewUser(this.credentials).subscribe();
    console.log(this.credentials);
    alert('New user added successfully');
  }
}
