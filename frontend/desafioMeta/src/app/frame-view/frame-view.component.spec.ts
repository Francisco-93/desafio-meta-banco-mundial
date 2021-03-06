import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FrameViewComponent } from './frame-view.component';

describe('FrameViewComponent', () => {
  let component: FrameViewComponent;
  let fixture: ComponentFixture<FrameViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FrameViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FrameViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
