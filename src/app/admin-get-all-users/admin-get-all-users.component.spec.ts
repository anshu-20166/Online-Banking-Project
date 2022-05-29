import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminGetAllUsersComponent } from './admin-get-all-users.component';

describe('AdminGetAllUsersComponent', () => {
  let component: AdminGetAllUsersComponent;
  let fixture: ComponentFixture<AdminGetAllUsersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminGetAllUsersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminGetAllUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
