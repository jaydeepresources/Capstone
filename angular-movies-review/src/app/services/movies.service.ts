import { Injectable } from '@angular/core';
import { Movie } from '../model/movie';
import { HttpClient } from '@angular/common/http';
import { MovieCast } from '../model/movie-cast';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {

  movies: Movie[]
  movie: MovieCast | null

  constructor(public httpClient: HttpClient) {
    this.movies = []
    this.movie = new MovieCast()
  }

  getAllMovies() {
    this.httpClient.get<Movie[]>('http://localhost:8080/movies/all').subscribe(res => this.movies = res)
  }

  getMovieById(movieId: string | null) {
    this.httpClient.get<MovieCast>('http://localhost:8080/movies/find/' + movieId).subscribe(res => {
      this.movie = res
    })
  }
}