import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateConferencePageComponent } from './create-conference-page.component';

describe('CreateConferencePageComponent', () => {
  let component: CreateConferencePageComponent;
  let fixture: ComponentFixture<CreateConferencePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateConferencePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateConferencePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
