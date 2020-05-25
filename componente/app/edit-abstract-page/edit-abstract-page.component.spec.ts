import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditAbstractPageComponent } from './edit-abstract-page.component';

describe('EditAbstractPageComponent', () => {
  let component: EditAbstractPageComponent;
  let fixture: ComponentFixture<EditAbstractPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditAbstractPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditAbstractPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
