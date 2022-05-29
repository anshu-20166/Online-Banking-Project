import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-admin-help-desk',
  templateUrl: './admin-help-desk.component.html',
  styleUrls: ['./admin-help-desk.component.css'],
})
export class AdminHelpDeskComponent implements OnInit {
  feedback: any = [];
  constructor(private loginService: LoginService) {}

  ngOnInit(): void {
    /**
     * to get all the feedback of the users
     * @return feedback array
     */
    this.loginService.getAllFeedback().subscribe(
      (response) => {
        console.log(response);
        this.handleResponse(response);
      },
      (error) => {
        console.log('error', error);
      }
    );
  }
  handleResponse(response: any) {
    this.feedback = response;
    //console.log('feedback' + this.feedback);
  }
  /**
   * to change status of the feedback if issue get resolved
   * @return void
   * @param id
   */
  changeStatus(id: any) {
    console.log('ts');
    this.loginService.changeStatus(id).subscribe((Response) => {
      console.log(Response);
    });
    alert('status changed successfully');
    window.location.href = '/admin-help-desk';
  }
}
