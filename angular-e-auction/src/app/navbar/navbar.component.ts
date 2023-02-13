import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { ItemsService } from '../services/items.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  itemName: string
  constructor(public authService: AuthService, public itemsService: ItemsService, public router: Router) {
    this.itemName = ''
  }

  ngOnInit(): void {
  }

  searchItem() {
    var arr = this.itemsService.items.filter(item => item.itemName.toLowerCase().includes(this.itemName.toLowerCase()))
  }

  signOut() {
    this.authService.signOut()
  }

}
