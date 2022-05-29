import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BalancecheckComponent } from './balancecheck.component';

describe('BalancecheckComponent', () => {
  let component: BalancecheckComponent;
  let fixture: ComponentFixture<BalancecheckComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BalancecheckComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BalancecheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
