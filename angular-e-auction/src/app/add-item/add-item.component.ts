import { Component, OnInit } from '@angular/core';
import { BidSeller } from '../model/seller-bid';
import { AddItemService } from '../services/add-item.service';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {
  bidSeller: BidSeller
  constructor(public addItem: AddItemService) {
    this.bidSeller = new BidSeller()
  }

  ngOnInit(): void {
    this.addItem.getCategories()
  }

  addBidSeller(addForm: any) {
    this.addItem.addBidSeller(this.bidSeller)
  }

}
