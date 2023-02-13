import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { ItemsService } from '../services/items.service';
import { SellBidsService } from '../services/sell-bids.service';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  constructor(public itemsService: ItemsService, public bidSellerService: SellBidsService, public authService: AuthService) { }

  ngOnInit(): void {
    this.itemsService.getItems()
  }

  getMyBidItems() {
    this.bidSellerService.getSellerBidsByUser(this.authService.currentUser!.userId)
  }

  resetItems() {
    this.itemsService.getItems()
  }

}
