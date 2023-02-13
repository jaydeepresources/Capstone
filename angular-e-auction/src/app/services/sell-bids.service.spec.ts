import { TestBed } from '@angular/core/testing';

import { SellBidsService } from './sell-bids.service';

describe('SellBidsService', () => {
  let service: SellBidsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SellBidsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
