import { BidSeller } from "./seller-bid"
import { User } from "./user"

export class BidBuyer {
    bidBuyerId: number
    bidBuyerDate: string
    bidPrice: number
    bidStatus: string
    paymentStatus: string
    buyer: any
    bidSeller: any

    constructor() {
        this.bidBuyerId = 0
        this.bidBuyerDate = ""
        this.bidPrice = 0
        this.bidStatus = "pending"
        this.paymentStatus = "pending"
        this.buyer = new User()
        this.bidSeller = new BidSeller()
    }
}