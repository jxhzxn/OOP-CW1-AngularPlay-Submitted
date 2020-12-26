import { TestBed } from '@angular/core/testing';

import { AddMatchService } from './add-match.service';

describe('AddMatchService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddMatchService = TestBed.get(AddMatchService);
    expect(service).toBeTruthy();
  });
});
