import { Component, OnInit } from '@angular/core';
import { PaymentDetails } from '../model/payment-details';
import { AuthService } from '../services/auth.service';
import { BuyBidsService } from '../services/buy-bids.service';

@Component({
  selector: 'app-payment-widget',
  templateUrl: './payment-widget.component.html',
  styleUrls: ['./payment-widget.component.css']
})
export class PaymentWidgetComponent implements OnInit {
  payment: PaymentDetails

  constructor(public buyBidsService: BuyBidsService, public authService: AuthService) {
    this.payment = new PaymentDetails()

  }

  ngOnInit(): void {
  }

  makePayment(paymentForm: any) {
    this.buyBidsService.updatePaymentStatus()
  }

}
