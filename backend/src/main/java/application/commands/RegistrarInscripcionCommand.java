/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Leo
 */
@AllArgsConstructor
@NoArgsConstructor
public class RegistrarInscripcionCommand {

    /**
     * Por que se repite con el DTO? El DTO es un contrato con la API, las API
     * puede cambiar por ejemplo: nombre sea nombre, apellido. Para mantener
     * compatibilidad solamente se cambia el DTO.
     */
    @Getter
    @Setter
    private String carnet;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String direccion;
    @Getter
    @Setter
    private String genero;
    @Getter
    @Setter
    private String fechaNacimiento;
    @Getter
    @Setter
    private String carrera;
    @Getter
    @Setter
    private int telefono;

    @Getter
    @Setter
    private String generoPoesia;

}
