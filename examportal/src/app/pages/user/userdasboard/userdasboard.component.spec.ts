import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserdasboardComponent } from './userdasboard.component';

describe('UserdasboardComponent', () => {
  let component: UserdasboardComponent;
  let fixture: ComponentFixture<UserdasboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserdasboardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UserdasboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
