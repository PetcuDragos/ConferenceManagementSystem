import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangeDeadlinePageComponent } from './change-deadline-page.component';

describe('ChangeDeadlinePageComponent', () => {
  let component: ChangeDeadlinePageComponent;
  let fixture: ComponentFixture<ChangeDeadlinePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChangeDeadlinePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangeDeadlinePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
