import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from './account.model';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  apiUrl="http://localhost:8080/Employee";
  getUrl="http://localhost:8080/Employee/";
   constructor(private httpClient:HttpClient) { }
   createAccount(accountDetails:Account):Observable<any>{
     return this.httpClient.post(this.apiUrl, accountDetails);
   }
}
