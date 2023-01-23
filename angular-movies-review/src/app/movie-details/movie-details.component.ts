import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MoviesService } from '../services/movies.service';
import { ReviewsService } from '../services/reviews.service';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})

export class MovieDetailsComponent implements OnInit {
  movieId: string | null
  constructor(public activatedRoute: ActivatedRoute, public moviesService: MoviesService, public reviewsService: ReviewsService) {
    this.movieId = ''
  }

  ngOnInit(): void {

    this.movieId = this.activatedRoute.snapshot.paramMap.get("movieId");

    this.moviesService.getMovieById(this.movieId)
    this.reviewsService.getReviewsForMovie(this.movieId)
  }

}
