import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Item } from '../model/item';

@Injectable({
  providedIn: 'root'
})
export class ItemsService {

  items: Item[]

  constructor(public http: HttpClient) {
    this.items = []
  }

  getItems() {
    this.http.get<Item[]>('http://localhost:8080/items/all').subscribe(res => {
      this.items = res
    })
  }
}
