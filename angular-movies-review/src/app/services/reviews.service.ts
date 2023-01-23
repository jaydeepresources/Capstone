import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Review } from '../model/review';
import { ReviewDetail } from '../model/review-user-movie';

@Injectable({
  providedIn: 'root'
})
export class ReviewsService {

  reviews: Review[]

  constructor(public httpClient: HttpClient) {
    this.reviews = []
  }

  getReviewsForMovie(reviewId: string | null) {
    this.httpClient.get<Review[]>('http://localhost:8080/reviews/movies/' + reviewId).subscribe(res => this.reviews = res)
  }

  addReview(review: ReviewDetail) {
    return this.httpClient.post<Review>('http://localhost:8080/reviews/add', review)
  }
}
