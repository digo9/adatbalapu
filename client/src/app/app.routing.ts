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

const appRoutes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '404', component: Page404Component },
  { path: 'home', component: MainPageComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'login', component: LoginComponent },
  { path: 'joboffer', component: JobComponent },
  { path: 'findjobs', component: FindJobsComponent },
  { path: 'newoffer', component: NewOfferComponent },
  { path: '**', redirectTo: '404', pathMatch: 'full' } // ennek utolsonak kell lenni mert mindent redirectel
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRouting { }
