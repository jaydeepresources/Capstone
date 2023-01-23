import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

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

  signUpSubmit(signUpForm: any | null) {

    this.successFlag = false
    this.errorFlag = false

    this.authService.signUp(this.user)
      .subscribe((res) => {
        if (res !== null) {
          this.successFlag = true
          this.authService.loginStatus = true
          this.authService.currentUser = this.user
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