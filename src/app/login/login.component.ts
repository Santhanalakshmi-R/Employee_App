import { Component } from '@angular/core';
import { AuthService } from '../shared/auth.service';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { LoginService } from './login.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule,FormsModule,HttpClientModule,RouterLink,RouterOutlet],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  submit=false;
  valid=false;
  errormsg="";
  constructor(private loginService: LoginService, private router:Router, private auth:AuthService) { }

  login(): void {
    this.loginService.login(this.email, this.password)
      .subscribe(
        response => {
          if(response=="You logged in successfully."){
        //  this.email = '';
        //  this.password = '';
          this.auth.sts = true;
          this.router.navigate(['']);}
          else{
            this.auth.sts = false;
            console.log("login failed")
            this.errormsg="Please enter a valid email address and password.";
          }
        },
        error => {
          console.error('Login failed:', error);
        }
      );
  }
}
