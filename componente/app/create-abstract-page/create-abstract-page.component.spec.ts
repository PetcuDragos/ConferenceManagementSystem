import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAbstractPageComponent } from './create-abstract-page.component';

describe('CreateAbstractPageComponent', () => {
  let component: CreateAbstractPageComponent;
  let fixture: ComponentFixture<CreateAbstractPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateAbstractPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateAbstractPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
