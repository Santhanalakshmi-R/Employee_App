import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from '../account/account.model';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  constructor(private httpClient:HttpClient) { }
  apiUrl="http://localhost:8080/Employee/";
  
   
   getEmpDetails(email:string):Observable<Account>{
    const url = `${this.apiUrl}${email}`;
    return this.httpClient.get<Account>(url);
   }
   updateEmpDetails(email:string,accountDetails:Account):Observable<Account>{
    const url = `${this.apiUrl}${email}`;
    return this.httpClient.put<Account>(url, accountDetails);
}
   deleteEmpDetails(email:string):Observable<any>{
    const url = `${this.apiUrl}${email}`;
    return this.httpClient.delete(url);
}

}