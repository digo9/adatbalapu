import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { MainPageComponent } from './main-page/main-page.component';
import { Page404Component } from './error-pages/page-404/page-404.component';
import { UsersComponent } from './users/users.component';


const appRoutes: Routes = [
    { path: '', redirectTo: 'fooldal', pathMatch: 'full' },
    { path: '404', component: Page404Component },
    { path: 'fooldal', component: MainPageComponent },
    { path: 'users', component: UsersComponent },
    { path: '**', redirectTo: '404', pathMatch: 'full' },  // ennek utolsonak kell lenni mert mindent redirectel
];

@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRouting { }
