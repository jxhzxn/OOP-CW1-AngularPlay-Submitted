import { TestBed } from '@angular/core/testing';

import { PointsTableService } from './points-table.service';

describe('PointsTableService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PointsTableService = TestBed.get(PointsTableService);
    expect(service).toBeTruthy();
  });
});
