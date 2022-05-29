import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  url = 'http://localhost:2020';
  constructor(private http: HttpClient) {}
  /**
	 * Register user.
	 * @param registerInput the register input
	 * @return 1,when user is created
	 */
  validateNewUser(credentials: any) {
    console.log('reached service');
    return this.http.post(`${this.url}/users/register`, credentials);
  }
  /**
	 * Adds the new user.
	 * @param newUser the new user
	 * @return the response entity
	 */
  adminAddNewUser(credentials:any) {
    return this.http.post(`${this.url}/admin/AddNewUser`, credentials);
  }
}
