import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddNewusersComponent } from './admin-add-newusers.component';

describe('AdminAddNewusersComponent', () => {
  let component: AdminAddNewusersComponent;
  let fixture: ComponentFixture<AdminAddNewusersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAddNewusersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddNewusersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
