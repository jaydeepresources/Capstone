import { TestBed } from '@angular/core/testing';

import { BuyBidsService } from './buy-bids.service';

describe('BuyBidsService', () => {
  let service: BuyBidsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BuyBidsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
