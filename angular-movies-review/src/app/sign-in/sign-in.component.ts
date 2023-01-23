import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  user: User
  successFlag: boolean
  errorFlag: boolean

  constructor(public authService: AuthService, public router: Router) {
    this.user = new User()
    this.successFlag = false
    this.errorFlag = false
  }

  ngOnInit() {
  }

  signInSubmit(signInForm: any | null) {

    this.successFlag = false
    this.errorFlag = false

    this.authService.signIn(this.user)
      .subscribe(res => {
        if (res) {
          this.successFlag = true
          this.authService.currentUser = res
          this.authService.loginStatus = true
          this.router.navigateByUrl('')
        }
        else {
          this.errorFlag = true
          this.authService.loginStatus = false
        }
      }, err => {
        this.errorFlag = true
        this.authService.loginStatus = false
      })
  }

}
