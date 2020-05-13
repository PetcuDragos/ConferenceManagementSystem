import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AbstractsComponent } from './abstracts.component';

describe('AbstractsComponent', () => {
  let component: AbstractsComponent;
  let fixture: ComponentFixture<AbstractsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AbstractsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AbstractsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
