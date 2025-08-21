import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConversorMoedas } from './conversor-moedas';

describe('ConversorMoedas', () => {
  let component: ConversorMoedas;
  let fixture: ComponentFixture<ConversorMoedas>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConversorMoedas]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConversorMoedas);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
