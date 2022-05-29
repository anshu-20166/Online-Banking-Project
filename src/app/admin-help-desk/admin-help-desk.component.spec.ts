import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminHelpDeskComponent } from './admin-help-desk.component';

describe('AdminHelpDeskComponent', () => {
  let component: AdminHelpDeskComponent;
  let fixture: ComponentFixture<AdminHelpDeskComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminHelpDeskComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminHelpDeskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
