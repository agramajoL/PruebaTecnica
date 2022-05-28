import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-listado-de-inscripciones',
  templateUrl: './listado-de-inscripciones.component.html',
  styleUrls: ['./listado-de-inscripciones.component.scss']
})
export class ListadoDeInscripcionesComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}

interface InscripcionViewDTO{
  carnet: String,
  nombre: String,
  carrera: String,
  genero: String,
  telefono: number,
  direccion: String,
  fechaNacimiento: String,
  fechaInscripcion: String,
  fechaDeclamacion: String,
  generoPoesia: String
}
