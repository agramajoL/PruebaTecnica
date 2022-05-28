import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { InscripcionViewDTO } from '../InscripcionViewDTO';
@Component({
  selector: 'app-listado-de-inscripciones',
  templateUrl: './listado-de-inscripciones.component.html',
  styleUrls: ['./listado-de-inscripciones.component.scss']
})
export class ListadoDeInscripcionesComponent implements OnInit {
  inscripciones: Array<InscripcionViewDTO> = [];
  constructor(private http: HttpClient) {
  }
  ngOnInit(): void {
    this.listarTodasLasInscripciones();
  }

  listarTodasLasInscripciones(): void {
    this.http.get<Array<InscripcionViewDTO>>('http://localhost:8080/backend/resources/inscripcion').subscribe(data =>{
      this.inscripciones = data;
      console.log(this.inscripciones);
    })
  }
}
