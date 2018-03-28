import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { MainPageComponent } from './main-page/main-page.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AppRouting } from './app.routing';
import { Page404Component } from './error-pages/page-404/page-404.component';
import { UsersComponent } from './users/users.component';
import { APIModule } from './_api-module/api.module';


@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    HeaderComponent,
    FooterComponent,
    Page404Component,
    UsersComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRouting,
    APIModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
