import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../services/auth.service';
import { BidSeller } from '../model/seller-bid';
import { Category } from '../model/category';
@Injectable({
  providedIn: 'root'
})
export class AddItemService {
  categories: Category[]
  successFlag: boolean
  errorFlag: boolean
  constructor(public authService: AuthService, public http: HttpClient) {
    this.successFlag = false
    this.errorFlag = false
    this.categories = []
  }

  addBidSeller(bidSeller: BidSeller) {
    if (!this.authService.currentUser)
      return
    bidSeller.user.userId = this.authService.currentUser.userId
    bidSeller.bidSellerDate = new Date().toUTCString()
    this.successFlag = false
    this.errorFlag = false
    this.http.post('http://localhost:8080/bids/sell/add', bidSeller).subscribe(res => {
      if (res)
        this.successFlag = true
    }, err => {
      this.errorFlag = true
    })

  }

  getCategories() {
    this.http.get<Category[]>('http://localhost:8080/categories/all').subscribe(res => this.categories = res)
  }
}
