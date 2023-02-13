import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyBuyBidsComponent } from './my-buy-bids.component';

describe('MyBuyBidsComponent', () => {
  let component: MyBuyBidsComponent;
  let fixture: ComponentFixture<MyBuyBidsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyBuyBidsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyBuyBidsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
