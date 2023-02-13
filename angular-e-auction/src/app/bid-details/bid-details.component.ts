import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BidBuyer } from '../model/buyer-bid';
import { AuthService } from '../services/auth.service';
import { SellBidsService } from '../services/sell-bids.service';

@Component({
  selector: 'app-bid-details',
  templateUrl: './bid-details.component.html',
  styleUrls: ['./bid-details.component.css']
})
export class BidDetailsComponent implements OnInit {

  itemId: string | null
  bidBuyer: BidBuyer
  successFlag: boolean
  errorFlag: boolean

  constructor(public activatedRoute: ActivatedRoute, public sellBidsService: SellBidsService, public authService: AuthService) {
    this.itemId = ''
    this.bidBuyer = new BidBuyer()
    this.successFlag = false
    this.errorFlag = false
  }

  ngOnInit(): void {
    this.itemId = this.activatedRoute.snapshot.paramMap.get('itemId')
    this.sellBidsService.getSellerBidByItem(this.itemId)
    this.bidBuyer.bidPrice = 0
  }

  addBuyerBid() {
    this.successFlag = false
    this.errorFlag = false
    if (this.authService.currentUser) {
      this.bidBuyer.bidBuyerDate = new Date().toUTCString()
      this.bidBuyer.buyer.userId = this.authService.currentUser.userId
      this.bidBuyer.bidSeller.bidSellerId = this.sellBidsService.bidSeller.bidSellerId
      this.sellBidsService.addBidforBuy(this.bidBuyer).subscribe(res => this.successFlag = true, err => this.errorFlag = true)
    }

  }

}
