import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  sts=false;
  actsts=false;
  constructor(private router:Router){}
  
  isAuthenticated(): boolean {
    return this.sts; 
  }
  
  canAccess(): void {
    if (!this.isAuthenticated()) {
      this.router.navigate(['']);
    }
  }
}
