import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListadoDeInscripcionesComponent } from './listado-de-inscripciones/listado-de-inscripciones.component';
import { PaginaNoEncontradaComponent } from './pagina-no-encontrada/pagina-no-encontrada.component';
import { RegistroInscripcionComponent } from './registro-inscripcion/registro-inscripcion.component';

const routes: Routes = [
  {path: 'registro', component: RegistroInscripcionComponent},
  {path: 'listado', component: ListadoDeInscripcionesComponent},
  {path: '', redirectTo: '/registro', pathMatch: 'full'},
  {path: '**', component: PaginaNoEncontradaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
