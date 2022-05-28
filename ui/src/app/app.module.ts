import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistroInscripcionComponent } from './registro-inscripcion/registro-inscripcion.component';
import { ListadoDeInscripcionesComponent } from './listado-de-inscripciones/listado-de-inscripciones.component';
import { PaginaNoEncontradaComponent } from './pagina-no-encontrada/pagina-no-encontrada.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTableModule} from '@angular/material/table'; 
import {MatFormFieldModule} from '@angular/material/form-field'; 
@NgModule({
  declarations: [
    AppComponent,
    RegistroInscripcionComponent,
    ListadoDeInscripcionesComponent,
    PaginaNoEncontradaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatTableModule
  ],
  exports: [
    MatFormFieldModule,
    MatTableModule
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
