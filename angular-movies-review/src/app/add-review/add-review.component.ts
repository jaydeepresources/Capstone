import { Component, OnInit } from '@angular/core';
import { ReviewDetail } from '../model/review-user-movie';
import { AuthService } from '../services/auth.service';
import { MoviesService } from '../services/movies.service';
import { ReviewsService } from '../services/reviews.service';

@Component({
  selector: 'app-add-review',
  templateUrl: './add-review.component.html',
  styleUrls: ['./add-review.component.css']
})
export class AddReviewComponent implements OnInit {
  review: ReviewDetail
  successFlag: boolean
  errorFlag: boolean
  constructor(public authService: AuthService, public reviewsService: ReviewsService, public moviesService: MoviesService) {
    this.review = new ReviewDetail()
    this.successFlag = false
    this.errorFlag = false
  }

  ngOnInit(): void {
  }

  addReviewSubmit(addreviewForm: any | null) {
    if (this.authService.currentUser) {
      this.review.user.userId = this.authService.currentUser.userId
      this.reviewsService.addReview(this.review).subscribe(res => {
        if (res.reviewId > 0) {
          this.successFlag = true
          this.review.reviewDescription = ''
        }
        else
          this.errorFlag = true
      })
    }
  }

}
