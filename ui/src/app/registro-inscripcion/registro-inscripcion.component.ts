import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { InscripcionViewDTO } from '../InscripcionViewDTO';
@Component({
  selector: 'app-registro-inscripcion',
  templateUrl: './registro-inscripcion.component.html',
  styleUrls: ['./registro-inscripcion.component.scss']
})
export class RegistroInscripcionComponent implements OnInit {

  registroInscripcionForm = this.fb.group({
    carnet: ['', [Validators.required, Validators.maxLength(6), Validators.pattern("^[aA][a-zA-Z1-9]5[a-zA-Z1-9]{2}[139]$")]],
    nombre: ['', [Validators.required, Validators.maxLength(100)]],
    carrera: ['', [Validators.required, Validators.maxLength(100)]],
    direccion: ['', [Validators.required, Validators.maxLength(200)]],
    genero: ['', [Validators.required]],
    fechaNacimiento: ['', [Validators.required]],
    telefono: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(8)]],
    generoPoesia: ['', [Validators.required]]
  });
  constructor(private fb: FormBuilder,
    private http: HttpClient) { }

  generos: Array<String> = ["Masculino", "Femenino"];
  generosPoesia: Array<String> = ["Epico", "Dramatico", "Lirica"];

  ngOnInit(): void {
  }

  onSubmit(){
    console.log(this.registroInscripcionForm.value);
    this.http.post<InscripcionViewDTO>('http://localhost:8080/backend/resources/inscripcion', this.registroInscripcionForm.value).subscribe(data => {
      console.log(data);
      alert("Registro exitoso, fecha de declamacion: " + data.fechaDeclamacion);
    })
    
  }

}
