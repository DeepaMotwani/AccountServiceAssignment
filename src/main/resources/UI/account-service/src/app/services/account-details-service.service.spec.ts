import { TestBed } from '@angular/core/testing';

import { AccountDetailsServiceService } from './account-details-service.service';

describe('AccountDetailsServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AccountDetailsServiceService = TestBed.get(AccountDetailsServiceService);
    expect(service).toBeTruthy();
  });
});
