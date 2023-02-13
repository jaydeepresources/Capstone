import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { SellBidsService } from '../services/sell-bids.service';

@Component({
  selector: 'app-my-bids',
  templateUrl: './my-bids.component.html',
  styleUrls: ['./my-bids.component.css']
})
export class MyBidsComponent implements OnInit {

  constructor(public bidSellerService: SellBidsService, public authService: AuthService) { }

  ngOnInit(): void {
    this.bidSellerService.getBuyers()
  }

  acceptBid(bidBuyerId: number) {
    this.bidSellerService.updateBuyerBidStatus(bidBuyerId)
  }

}
