import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BidBuyer } from '../model/buyer-bid';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class BuyBidsService {

  myBuyBids: BidBuyer[]
  successFlag: boolean
  errorFlag: boolean
  constructor(public http: HttpClient, public authService: AuthService) {
    this.myBuyBids = []
    this.successFlag = false
    this.errorFlag = false
  }

  getMyBuyBids() {
    if (!this.authService.currentUser)
      return

    this.http.get<BidBuyer[]>('http://localhost:8080/bids/buy/buyers/' + this.authService.currentUser.userId)
      .subscribe(res => {
        res.map(r => r.bidBuyerDate = new Date(r.bidBuyerDate).toUTCString())
        this.myBuyBids = res
      })
  }

  updatePaymentStatus() {
    if (!this.authService.currentUser)
      return
    this.successFlag = false
    this.errorFlag = false

    this.http.post('http://localhost:8080/bids/buy/update/payment/' + this.authService.currentUser.userId, {})
      .subscribe(res => {
        this.successFlag = true
        this.getMyBuyBids()
      }, err => {
        this.errorFlag = true
      })
  }

}
