import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BidBuyer } from '../model/buyer-bid';
import { BidSeller } from '../model/seller-bid';
import { ItemsService } from './items.service';

@Injectable({
  providedIn: 'root'
})
export class SellBidsService {

  bidSeller: BidSeller

  myBids: BidSeller[]
  bidBuyers: BidBuyer[]

  existsFlag: boolean

  constructor(public http: HttpClient, public itemsService: ItemsService) {
    this.bidSeller = new BidSeller()
    this.myBids = []
    this.bidBuyers = []
    this.existsFlag = false
  }

  getSellerBidByItem(itemId: string | null) {
    this.http.get<BidSeller>('http://localhost:8080/bids/sell/items/' + itemId).subscribe(res => {
      res.bidSellerDate = new Date(res.bidSellerDate).toUTCString()
      this.bidSeller = res
    })
  }

  getSellerBidsByUser(userId: number | null) {
    this.http.get<BidSeller[]>('http://localhost:8080/bids/sell/users/' + userId).subscribe(res => {
      res.map(bid => {
        bid.bidSellerDate = new Date(bid.bidSellerDate).toUTCString()
      })
      this.myBids = res
      this.itemsService.items = this.myBids.map(myBid => myBid.item)
    })
  }

  addBidforBuy(bidBuyer: BidBuyer) {
    return this.http.post('http://localhost:8080/bids/buy/add', bidBuyer)
  }

  getBuyers() {
    if (this.bidSeller.bidSellerId === 0)
      return

    this.http.get<BidBuyer[]>('http://localhost:8080/bids/buy/all/' + this.bidSeller.bidSellerId).subscribe(res => {
      res.map(r => r.bidBuyerDate = new Date(r.bidBuyerDate).toUTCString())
      this.bidBuyers = res
      this.ifApprovedExists()
    })
  }

  ifApprovedExists() {
    this.existsFlag = (this.bidBuyers.filter(b => b.bidStatus === 'approved').length > 0) ? false : true
  }

  updateBuyerBidStatus(bidBuyerId: number) {
    this.http.post('http://localhost:8080/bids/buy/update/' + bidBuyerId, {}).subscribe(res => {
      this.getBuyers()
    }, err => {

    })
  }

}