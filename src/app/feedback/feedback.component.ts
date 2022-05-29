import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css'],
})
export class FeedbackComponent implements OnInit {
  credentials = {
    username: '', //username
    feedback: '', // feedback
    status: 0, // status of the issue
  };

  public loggedIn = false;
  constructor(private loginService: LoginService) {}
  public response = 0;

  ngOnInit(): void {
    this.loggedIn = this.loginService.isLoggedIn();
    this.credentials.username = this.loginService.getUsername() as string;
  }

  onSubmit(): void {
    console.log(this.credentials);
    /**
     * save the user  feedback to the database.
     * @return boolean value
     */
    this.loginService.addFeedback(this.credentials).subscribe(
      (response: any) => {
        this.response = response;
        console.log('successfully submitted');
      },
      (error) => {
        console.log('error' + error);
      }
    );
  }
}
