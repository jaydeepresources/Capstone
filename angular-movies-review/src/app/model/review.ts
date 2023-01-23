import { User } from "./user"

export class Review {
    reviewId: number
    reviewRating: number
    reviewDescription: string
    user: any

    constructor() {
        this.reviewId = 0
        this.reviewRating = 0
        this.reviewDescription = ''
        this.user = new User()
    }
}