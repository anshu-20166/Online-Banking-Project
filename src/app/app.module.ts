import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginService } from './service/login.service';
import { AuthGuard } from './service/auth.guard';
import { AuthInterceptor } from './AuthInterceptor';
import { AccountviewComponent } from './accountview/accountview.component';
import { ShowatmpinComponent } from './showatmpin/showatmpin.component';
import { BalancecheckComponent } from './balancecheck/balancecheck.component';
import { RouterModule, Routes } from '@angular/router';
import { AdminModuleComponent } from './admin-module/admin-module.component';
import { AdminGetAllUsersComponent } from './admin-get-all-users/admin-get-all-users.component';
import { AdminHelpDeskComponent } from './admin-help-desk/admin-help-desk.component';
import { AdminAddNewusersComponent } from './admin-add-newusers/admin-add-newusers.component';
import {FeedbackComponent} from './feedback/feedback.component';
import { BalancetransferComponent } from './balancetransfer/balancetransfer.component';
import { FooterComponent } from './footer/footer.component';
import { NavbarComponent } from './navbar/navbar.component';
import {NavBarAdminComponent} from './nav-bar-admin/nav-bar-admin.component';
/**
 * all components declaration
 */
@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginComponent,
    HomeComponent,
    AccountviewComponent,
    ShowatmpinComponent,
    BalancecheckComponent,
    FeedbackComponent,
    AdminModuleComponent,
    AdminGetAllUsersComponent,
    AdminHelpDeskComponent,
    AdminAddNewusersComponent,
    BalancetransferComponent,
    FooterComponent,
    NavbarComponent,
    NavBarAdminComponent,
  ],
  /**
   * all modules required in our project
   */
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  /**
   * all service required in our project
   */
  providers: [
    LoginService,
    AuthGuard,
    [{ provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }],
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
