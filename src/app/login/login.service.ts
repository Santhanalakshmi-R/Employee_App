import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private apiUrl="http://localhost:8080/Register/login"
  constructor(private httpClient: HttpClient) { }
  login(email:any,password:any):Observable<any> {
    const formData=new FormData();
    formData.append('email',email);
    formData.append('password',password);
    return this.httpClient.post(this.apiUrl,formData, {responseType: 'text' })
  }
}
