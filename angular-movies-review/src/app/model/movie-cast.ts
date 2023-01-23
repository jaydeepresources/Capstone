import { Cast } from '../model/cast';

export class MovieCast {

    movieId: number;
    movieName: string;
    movieLanguage: string;
    movieYear: number;
    movieGenre: string;
    movieImg: string;

    cast: any

    constructor() {
        this.movieId = 0
        this.movieName = ''
        this.movieLanguage = ''
        this.movieYear = 0
        this.movieGenre = ''
        this.movieImg = ''
        this.cast = new Cast()
    }

}