import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { SignUpComponent } from './sign-up/sign-up.component';
import { MyBidsComponent } from './my-bids/my-bids.component';
import { ItemsComponent } from './items/items.component';
import { BidDetailsComponent } from './bid-details/bid-details.component';
import { MyBuyBidsComponent } from './my-buy-bids/my-buy-bids.component';
import { PaymentWidgetComponent } from './payment-widget/payment-widget.component';
import { AddItemComponent } from './add-item/add-item.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SignInComponent,
    SignUpComponent,
    MyBidsComponent,
    ItemsComponent,
    BidDetailsComponent,
    MyBuyBidsComponent,
    PaymentWidgetComponent,
    AddItemComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
