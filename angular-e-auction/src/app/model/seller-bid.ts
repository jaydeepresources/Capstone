import { Item } from "./item"
import { User } from "./user"

export class BidSeller {
    bidSellerId: number
    bidSellerDate: string
    item: any
    user: any

    constructor() {
        this.bidSellerId = 0
        this.bidSellerDate = ''
        this.item = new Item()
        this.user = new User()
    }
}