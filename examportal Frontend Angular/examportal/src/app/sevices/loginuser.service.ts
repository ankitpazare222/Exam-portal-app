import { HttpClient  } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { isPlatformBrowser } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class LoginuserService {
  postlogindetailsURL='http://localhost:9003/generate-token'
  getCurrentuserURL='http://localhost:9003/current-user'
  constructor(private httpclient:HttpClient) { }

  postlogindetails(logindata:any):Observable<any>{
    return this.httpclient.post(`${this.postlogindetailsURL}`,logindata);
  }

  getCurrentuser():Observable<any>{
    return this.httpclient.get(`${this.getCurrentuserURL}`);
  }


  // login user : set in local storage
  // public loginuser(token: string){
  //   localStorage.setItem('token',token);
  //   return true

  // }
  public loginuser(token: string){
    if (typeof window !== 'undefined') {
      localStorage.setItem('token', token);
    }
    return true;
  }
  // is login:user is login or not

  // public isloggedin(){
  //   let tokenstr =localStorage.getItem('token');
  //   if (tokenstr==undefined || tokenstr=='' ||tokenstr ==null) {
  //     return false;
      
  //   }
  //   else{
  //     return true ;
  //   }
  // }
  public isloggedin(): boolean {
    if (typeof window !== 'undefined') {
      let tokenstr = localStorage.getItem('token');
      return !(tokenstr === undefined || tokenstr === '' || tokenstr === null);
    }
    return false;
  }

  // remove token from local storage

  // public logout(){
  //   localStorage.removeItem('token')
  //   localStorage.removeItem('user')
  //   return true;
  // }

  public logout(): boolean {
    if (typeof window !== 'undefined') {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
    }
    return true;
  }

  // get token
  // public gettoken(){
  //   return localStorage.getItem('token');

  // }

  public gettoken(): string | null {
    if (typeof window !== 'undefined') {
      return localStorage.getItem('token');
    }
    return null;
  }

  // set usserdetails
//   public setUser(user:any){
//  localStorage.setItem('user',JSON.stringify(user));
//   }

public setUser(user: any): void {
  if (typeof window !== 'undefined') {
    localStorage.setItem('user', JSON.stringify(user));
  }
}

  // public getUser(){
  //   let userstr= localStorage.getItem('user');
  //   if (userstr !==null ) {
  //     return JSON.parse(userstr);

      
  //   }
  //   else{
  //     this.logout();
  //     return null
  //   }

  // }

  public getUser(): any {
    if (typeof window !== 'undefined') {
      let userstr = localStorage.getItem('user');
      if (userstr !== null) {
        return JSON.parse(userstr);
      }
      this.logout();
    }
    return null;
  }

  // public getUserRole(){
  //   let user=this.getUser();
  //   return user.email;
  // }

  public getUserRole(): string | null {
    const user = this.getUser();
    return user ? user.email : null;
  }

}
