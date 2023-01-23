import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  currentUser: User | null
  loginStatus: boolean
  constructor(public http: HttpClient, public router: Router) {
    this.currentUser = null
    this.loginStatus = false
  }

  signIn(user: User) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization': 'someToken'
      }),
      withCredentials: true
    };
    return this.http.post<User>('http://localhost:8080/users/signin', user)
  }

  signUp(user: User) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization': 'someToken'
      }),
      withCredentials: true
    };
    return this.http.post<User>('http://localhost:8080/users/add', user)
  }

  signOut() {
    this.currentUser = null
    this.loginStatus = false
    this.router.navigateByUrl('/')
  }

}
