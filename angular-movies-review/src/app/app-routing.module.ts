import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddReviewComponent } from './add-review/add-review.component';
import { HomeComponent } from './home/home.component';
import { MovieDetailsComponent } from './movie-details/movie-details.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'signup',
    component: SignUpComponent
  },
  {
    path: 'signin',
    component: SignInComponent
  },
  {
    path: 'movies/:movieId',
    component: MovieDetailsComponent
  },
  {
    path: 'reviews/add',
    component: AddReviewComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
