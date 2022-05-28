/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.joda.time.DateTime;

/**
 *
 * @author Leo
 */
@AllArgsConstructor
public class Estudiante {

    @Getter
    private String carnet;
    @Getter
    private String nombre;
    @Getter
    private String direccion;
    @Getter
    private String genero;
    @Getter
    private DateTime fechaNacimiento;
    @Getter
    private String carrera;

}
