import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { MainPageComponent } from './main-page/main-page.component';
import { Page404Component } from './error-pages/page-404/page-404.component';
import { UsersComponent } from './users/users.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { JobComponent } from './job/job.component';
import { FindJobsComponent } from './find-jobs/find-jobs.component';
import { NewOfferComponent } from './new-offer/new-offer.component';
import { Page403Component } from './error-pages/page-403/page-403.component';
import { Page401Component } from './error-pages/page-401/page-401.component';

const appRoutes: Routes = [
  { path: '', redirectTo: 'fooldal', pathMatch: 'full' },
  { path: 'fooldal', component: MainPageComponent },
  { path: 'regisztracio', component: RegistrationComponent },
  { path: 'bejelentkezes', component: LoginComponent },
  { path: 'allasajanlat', component: JobComponent },
  { path: 'allaskereses', component: FindJobsComponent },
  { path: 'ujajanlat', component: NewOfferComponent },
  { path: '404', component: Page404Component },
  { path: '403', component: Page403Component },
  { path: '401', component: Page401Component },
  { path: '**', redirectTo: '404', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRouting {}
