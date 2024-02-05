import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private apiUrl="http://localhost:8080/Register/post";
  constructor(private httpClient: HttpClient) { }

  add_User(UserData: any): Observable<any> {
    
    return this.httpClient.post<any>(this.apiUrl, UserData,);
}
}
