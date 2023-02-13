import { Component, OnInit } from '@angular/core';
import { PaymentDetails } from '../model/payment-details';
import { AuthService } from '../services/auth.service';
import { BuyBidsService } from '../services/buy-bids.service';

@Component({
  selector: 'app-my-buy-bids',
  templateUrl: './my-buy-bids.component.html',
  styleUrls: ['./my-buy-bids.component.css']
})
export class MyBuyBidsComponent implements OnInit {

  constructor(public buyBidsService: BuyBidsService, public authService: AuthService) {

  }

  ngOnInit(): void {
    if (!this.authService.currentUser)
      return
    this.buyBidsService.getMyBuyBids()
  }



}
