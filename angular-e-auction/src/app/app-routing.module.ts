import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddItemComponent } from './add-item/add-item.component';
import { BidDetailsComponent } from './bid-details/bid-details.component';
import { ItemsComponent } from './items/items.component';
import { MyBidsComponent } from './my-bids/my-bids.component';
import { MyBuyBidsComponent } from './my-buy-bids/my-buy-bids.component';
import { PaymentWidgetComponent } from './payment-widget/payment-widget.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';

const routes: Routes = [
  {
    path: '',
    component: ItemsComponent
  },
  {
    path: 'signup',
    component: SignUpComponent
  },
  {
    path: 'signin',
    component: SignInComponent
  },
  {
    path: 'items/add',
    component: AddItemComponent
  },
  {
    path: 'mybids',
    component: MyBidsComponent
  },
  {
    path: 'buy/bids',
    component: MyBuyBidsComponent
  },
  {
    path: 'items/:itemId',
    component: BidDetailsComponent
  },
  {
    path: 'pay',
    component: PaymentWidgetComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
