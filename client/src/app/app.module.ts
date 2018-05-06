import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { MainPageComponent } from './main-page/main-page.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AppRouting } from './app.routing';
import { Page404Component } from './error-pages/page-404/page-404.component';
import { UsersComponent } from './users/users.component';
import { APIModule } from './_api-module/api.module';
import { LoginComponent } from './login/login.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RegistrationComponent } from './registration/registration.component';
import { FindJobsComponent } from './find-jobs/find-jobs.component';
import { JobComponent } from './job/job.component';
import { NewOfferComponent } from './new-offer/new-offer.component';
import { HttpClientModule } from '@angular/common/http';
import { AllaskeresoService } from './service/allaskereso.service';

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    HeaderComponent,
    FooterComponent,
    Page404Component,
    UsersComponent,
    LoginComponent,
    RegistrationComponent,
    FindJobsComponent,
    JobComponent,
    NewOfferComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRouting,
    APIModule,
    FormsModule,
    NgbModule.forRoot(),
    HttpClientModule
  ],
  providers: [AllaskeresoService],
  bootstrap: [AppComponent]
})
export class AppModule {}
