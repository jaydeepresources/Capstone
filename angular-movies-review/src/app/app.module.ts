import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { MovieDetailsComponent } from './movie-details/movie-details.component';
import { FormsModule } from '@angular/forms';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AddReviewComponent } from './add-review/add-review.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SignInComponent,
    HomeComponent,
    MovieDetailsComponent,
    SignUpComponent,
    AddReviewComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
