import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeAnnouncmentsComponent } from './home-announcments.component';

describe('HomeAnnouncmentsComponent', () => {
  let component: HomeAnnouncmentsComponent;
  let fixture: ComponentFixture<HomeAnnouncmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [HomeAnnouncmentsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeAnnouncmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
