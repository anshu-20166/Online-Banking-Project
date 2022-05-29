import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowatmpinComponent } from './showatmpin.component';

describe('ShowatmpinComponent', () => {
  let component: ShowatmpinComponent;
  let fixture: ComponentFixture<ShowatmpinComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowatmpinComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowatmpinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
