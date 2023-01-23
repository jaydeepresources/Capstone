import { Movie } from "./movie"
import { User } from "./user"

export class ReviewDetail {
    reviewId: number
    reviewRating: number
    reviewDescription: string
    user: any
    movie: any

    constructor() {
        this.reviewId = 0
        this.reviewRating = 0
        this.reviewDescription = ''
        this.user = new User()
        this.movie = new Movie()
    }

}