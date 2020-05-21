import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewAbstractPageComponent } from './review-abstract-page.component';

describe('ReviewAbstractPageComponent', () => {
  let component: ReviewAbstractPageComponent;
  let fixture: ComponentFixture<ReviewAbstractPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReviewAbstractPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReviewAbstractPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
