import { Component } from '@angular/core';
import { RegisterService } from './register.service';
import { Router, RouterLink } from '@angular/router';
import { Register } from './register.model';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { AuthService } from '../shared/auth.service';
@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterLink],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  constructor(private registerService: RegisterService, private auth: AuthService, private router:Router) { }

  new_User: Register = { name: "", email: "", password: "" };
  errormsg = "";
  submit =false;
  showPassword=true;
  add_User(f:NgForm): void {
    console.log(f);
    this.registerService.add_User(this.new_User).subscribe({
      next: data => {
        
        console.log("Registered Successfully");
        
        
        this.router.navigate(['/login']);
        // Redirect to login page upon successful registration
        // Add the necessary routing logic here
      },
      error: error => {
        // Handle error messages from backend
        if (error.status === 409) {
          this.errormsg = "User data already exists.";
        } 
        else{
          this.errormsg = "An error occurred. Please try again later.";
        }
      }
      
    });
  
}}
