import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoDeInscripcionesComponent } from './listado-de-inscripciones.component';

describe('ListadoDeInscripcionesComponent', () => {
  let component: ListadoDeInscripcionesComponent;
  let fixture: ComponentFixture<ListadoDeInscripcionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListadoDeInscripcionesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListadoDeInscripcionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
