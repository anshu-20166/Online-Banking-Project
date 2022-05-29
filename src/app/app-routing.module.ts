import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountviewComponent } from './accountview/accountview.component';
import { AdminAddNewusersComponent } from './admin-add-newusers/admin-add-newusers.component';
import { AdminGetAllUsersComponent } from './admin-get-all-users/admin-get-all-users.component';
import { AdminHelpDeskComponent } from './admin-help-desk/admin-help-desk.component';
import { AdminModuleComponent } from './admin-module/admin-module.component';
import { BalancecheckComponent } from './balancecheck/balancecheck.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { AuthGuard } from './service/auth.guard';
import { ShowatmpinComponent } from './showatmpin/showatmpin.component';
import {FeedbackComponent} from './feedback/feedback.component';
import {BalancetransferComponent} from './balancetransfer/balancetransfer.component';

const routes: Routes = [
  /**
	 * default path
	 */
  { path: '', component: LoginComponent },
  /**
	 * login rout path and its component
	 */
  { path: 'login', component: LoginComponent },
   /**
	 * register rout path and its component
	 */
  { path: 'register', component: RegistrationComponent },
  /**
	 * showatmpin rout path and its component
	 */
  {
    path: 'showatmpin',
    component: ShowatmpinComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard],
  },
   /**
	 * balancecheck rout path and its component
	 */
  {
    path: 'balancecheck',
    component: BalancecheckComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard],
  },
   /**
	 * feedback rout path and its component
	 */
  {
    path: 'feedback',
    component: FeedbackComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard],
  },
   /**
	 * balancetransfer rout path and its component
	 */
  {
    path: 'balancetransfer',
    component: BalancetransferComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard],
  },
   /**
	 * accountview rout path and its component
	 */
  {
    path: 'accountview',
    component: AccountviewComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard],
  },
   /**
	 * admin-getAllUserser rout path and its component
	 */
  {
    path: 'admin-getAllUserser',
    component: AdminGetAllUsersComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard],
  },
   /**
	 * home rout path and its component
	 */

  {
    path: 'home',
    component: HomeComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard],
  },
   /**
	 * admin-module rout path and its component
	 */
  {
    path: 'admin-module',
    component: AdminModuleComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard],
  },
   /**
	 * admin-help-desk rout path and its component
	 */
  {
    path: 'admin-help-desk',
    component: AdminHelpDeskComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard],
  },
   /**
	 * admin-addNewUser rout path and its component
	 */
  {
    path: 'admin-addNewUser',
    component: AdminAddNewusersComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
