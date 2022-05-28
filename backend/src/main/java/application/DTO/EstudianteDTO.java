/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author Leo
 */
@AllArgsConstructor
public class EstudianteDTO {

    @Getter
    private String carnet;
    @Getter
    private String nombre;
    @Getter
    private String direccion;
    @Getter
    private String genero;
    @Getter
    private String fechaNacimiento;
    @Getter
    private String carrera;
    @Getter
    private int telefono;
}
