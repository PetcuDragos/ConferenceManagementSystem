import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignReviewersPageComponent } from './assign-reviewers-page.component';

describe('AssignReviewersPageComponent', () => {
  let component: AssignReviewersPageComponent;
  let fixture: ComponentFixture<AssignReviewersPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssignReviewersPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssignReviewersPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
