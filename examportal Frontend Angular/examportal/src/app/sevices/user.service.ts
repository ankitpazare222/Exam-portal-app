import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  saveuserdataURL='http://localhost:9003/user/';
  // postlogindetailsURL='http://localhost:9003/generate-token'
  constructor(private httpclient:HttpClient) { }

  saveuserdata(user:any):Observable<any>{
    return this.httpclient.post(`${this.saveuserdataURL}`,user);
  }

  // postlogindetails(logindata:any):Observable<any>{
  //   return this.httpclient.post(`${this.postlogindetailsURL}`,logindata);
  // }
  



}
