import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { InscripcionViewDTO } from '../InscripcionViewDTO';
@Component({
  selector: 'app-listado-de-inscripciones',
  templateUrl: './listado-de-inscripciones.component.html',
  styleUrls: ['./listado-de-inscripciones.component.scss']
})
export class ListadoDeInscripcionesComponent implements OnInit {
  displayedColumns: string[] = ['carnet', 'nombre', 'telefono', 'direccion', 'genero', 'fechaNacimiento', 'fechaInscripcion', 'fechaDeclamacion', 'generoPoesia'];
  dataSource: any;
  inscripciones: InscripcionViewDTO[] = [];
  constructor(private http: HttpClient) {
  }
  ngOnInit(): void {
    this.listarTodasLasInscripciones();

  }

  listarTodasLasInscripciones(): void {
    this.http.get<Array<InscripcionViewDTO>>('http://localhost:8080/backend/resources/inscripcion').subscribe(data =>{
      this.dataSource = new MatTableDataSource(data);
      this.inscripciones = data;
      console.log(data);
    })
  }

  applyFilter(event: Event){
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
