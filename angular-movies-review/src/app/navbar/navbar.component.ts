import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from '../model/movie';
import { MovieCast } from '../model/movie-cast';
import { AuthService } from '../services/auth.service';
import { MoviesService } from '../services/movies.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  movieName: string
  constructor(public moviesService: MoviesService, public authService: AuthService, public router: Router) {
    this.movieName = ''
  }

  ngOnInit(): void {
  }

  searchMovie() {
    let movie: Movie = new Movie()

    movie = this.moviesService.movies.filter(movie => movie.movieName.toLowerCase() === this.movieName.toLowerCase())[0]
    this.movieName = ''
    if (movie) {
      this.moviesService.getMovieById(movie.movieId + '')
      this.router.navigateByUrl("/movies/" + movie.movieId)
    }
    else {
      this.moviesService.movie = null
      this.router.navigateByUrl("/movies/" + -1)
    }

  }

  signOut() {
    this.authService.signOut()
  }

}
