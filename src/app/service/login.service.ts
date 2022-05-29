import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  url = 'http://localhost:2020';
  constructor(private http: HttpClient) {}
  generateToken(credentials: any) {
    console.log('calling generate Token', credentials);
    return this.http.post(`${this.url}/login`, credentials);
  }
  /**
   * login function
   * @param token
   */
  loginUser(token: any) {
    localStorage.setItem('token', token);
    user1: String;
    const user1 = localStorage.getItem('username') as string;
    user1.replace('"', '');
    localStorage.removeItem('username');
    localStorage.setItem('username', user1);

    return true;
  }
  /**
   * check user login or not
   */

  isLoggedIn() {
    let token = localStorage.getItem('token');
    if (token == undefined || token == '' || token == null) {
      return false;
    } else {
      return true;
    }
  }
  /**
   * logout function
   */
  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('username');
    return true;
  }
  /**
   * @return token
   */
  getToken() {
    return localStorage.getItem('token');
  }
  /**
   * @return username
   */
  getUsername() {
    return localStorage.getItem('username');
  }
  /**
   * Account view.
   * @return the user details
   */

  getUserByUsername() {
    let username = this.getUsername();

    return this.http.get(`${this.url}/users/viewaccount/` + username);
  }
  /**
   * Balance check.
   * @return the balance
   */
  getbalance() {
    let username = this.getUsername();

    return this.http.get(`${this.url}/users/balancecheck/` + username);
  }
  /**
   * Gets the all users.
   *
   * @return the all users
   */

  getallUsers() {
    return this.http.get(`${this.url}/admin/All`);
  }
  /**
   * Gets the all feedback.
   *
   * @return the all feedback
   */
  getAllFeedback() {
    return this.http.get(`${this.url}/admin/AllFeedback`);
  }
  /**
   * Close account.
   * @return true if successful
   */
  closeThisAccount() {
    let username = this.getUsername();
    return this.http.put(`${this.url}/users/closeAccount/` + username, true);
  }
  closeAccountStatus() {
    let username = this.getUsername();
    return this.http.get(`${this.url}/users/closeAccountStatus/` + username);
  }
  /**
   * changeFeedbackStatus.
   * @param id the id
   * @return true if successful
   */
  changeStatus(id: any) {
    return this.http.put(`${this.url}/admin/changeFeedbackStatus/` + id, true);
  }
  /**
   * deleteAccount
   * @param accountNumber the account number
   * @return true if successful
   */
  deleteAccount(accountNumber: any) {
    return this.http.delete(`${this.url}/admin/deleteAccount/` + accountNumber);
  }
  /**
   * Show atm pin.
   *
   * @param pinInput the pin input
   * @return the atm pin
   */
  getatmpin(pinInput: any) {
    // let username = this.getUsername();

    return this.http.post(`${this.url}/users/showatmpin`, pinInput);
  }
  /**
   * Fund transfer.
   *
   * @param fundInput the fund input
   * @return the message
   */
  getfundtransfer(fundInput: any) {
    return this.http.post(`${this.url}/users/fundtransfer`, fundInput);
  }
  /**
   *Adds the feedback.
   * @param feedBackInput the feed back input
   * @return the message
   */
  addFeedback(credentials: any) {
    return this.http.post(`${this.url}/users/addfeedback`, credentials);
  }
}
