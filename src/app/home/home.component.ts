import { Component } from '@angular/core';
import { AuthService } from '../shared/auth.service';
import { CommonModule } from '@angular/common';
import { routes } from '../app.routes';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterOutlet } from '@angular/router';
import { Account } from '../account/account.model';
import { HomeService } from './home.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterLink,FormsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  constructor(public auth:AuthService, private homeService:HomeService){}
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
  updatedTask:Account|null=null;
  email="";
  sts=false;
  errormsg="";
 searcherror="";
 updatests="";
  search(){
    this.searcherror="";
    this.accountDetails.email="";
    this.homeService.getEmpDetails(this.email).subscribe((details)=>{
      
      this.accountDetails.name=details.name,
     
      this.accountDetails.email=details.email,
      this.accountDetails.phoneNo=details.phoneNo,
      this.accountDetails.gender=details.gender,
      this.accountDetails.age=details.age,
      this.accountDetails.position=details.position,
      this.accountDetails.experience=details.experience,
      this.accountDetails.address=details.address

      let date = new Date(details.dob);
const formattedDate = date.toISOString().split('T')[0]; // Extracts yyyy-MM-dd

console.log(formattedDate);
this.sts=true;
    },
    (error)=>{
      console.log("email not found");
      this.searcherror="Email not found.Please create an account by clicking the belowlink";
      this.sts=false;
      this.accountDetails.email="";
    }
    )
   this.accountDetails.email="";
  }
  editsts=false;
  edit(){
    this.editsts=true;
  }
  update(){
    this.homeService.updateEmpDetails(this.accountDetails.email,this.accountDetails).subscribe((details) => {
      this.accountDetails.name=details.name,
      this.accountDetails.phoneNo=details.phoneNo,
      this.accountDetails.email=details.email,
      this.accountDetails.phoneNo=details.phoneNo,
      this.accountDetails.gender=details.gender,
      this.accountDetails.age=details.age,
      this.accountDetails.position=details.position,
      this.accountDetails.experience=details.experience,
      this.accountDetails.address=details.address
  
    },
    
    );
    this.updatests="Your data updated successfully!"
    this.editsts=false;
  }
  delete(){
    this.updatests=""
    if(confirm("Are you sure to delete?"))
    this.homeService.deleteEmpDetails(this.email).subscribe((result) => {
      console.log(result);
    });
    this.sts=false;

  }
  
 
  

   ngOnInit(): void {
     this.auth.canAccess();}
     
     
    
}

// (response) => {
//   // If email exists, response contains the employee data
//   console.log(response);
// },
// (error) => {
//   // If email does not exist, error handling here
//   console.error('Email not found:', error.error);
// }
// );*/