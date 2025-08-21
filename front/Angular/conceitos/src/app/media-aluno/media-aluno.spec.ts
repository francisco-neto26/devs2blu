import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MediaAluno } from './media-aluno';

describe('MediaAluno', () => {
  let component: MediaAluno;
  let fixture: ComponentFixture<MediaAluno>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MediaAluno]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MediaAluno);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
