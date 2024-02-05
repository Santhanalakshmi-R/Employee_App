import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AccountComponent } from './account/account.component';
export const routes: Routes = [
    {path:'',component:HomeComponent},
       { path:'register',component:RegisterComponent},
        {path:'login',component:LoginComponent},
        {path:'account',component:AccountComponent},
        { path: 'login/register', redirectTo: 'register' }
];
