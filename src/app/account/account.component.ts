import { Component } from '@angular/core';
import { AccountService } from './account.service';
import { Account } from './account.model';
import { AuthService } from '../shared/auth.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-account',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterLink],
  templateUrl: './account.component.html',
  styleUrl: './account.component.css'
})
export class AccountComponent {
  constructor(private accountService:AccountService, private auth:AuthService, private router:Router, public authService:AuthService){}
  errormsg=""
 response="";
  accountDetails:Account={
   name:"",
    dob:new Date(),
    email:"",
    phoneNo:"",
    gender:"",
    age:null,
    position:"",
    experience:null,
    address:""
 }
 accountsts=false;
   ngOnInit(): void {
     this.auth.canAccess();}
     addAccountDetails():void{ 
     this.accountService.createAccount(this.accountDetails).subscribe({next:data => {
      console.log("details stored successfully.");
     this.response="Your details are stored successfully."
    },
      error: error => {
           if (error.status === 409) {
            this.errormsg = "User data already exists.You can search and find your detaiils.You can search and find your details by clicking the below";
            console.log("data exist");

         } 
         else{
                this.errormsg = "An error occurred. Please try again later.";
              }
            }
          })

       this.accountDetails = {
         name: "",
         dob: new Date(),
         email: "",
         phoneNo: "",
         gender: "",
         age: null,
         position: "",
         experience: null,
         address: ""
       };
       
  
    }
}
