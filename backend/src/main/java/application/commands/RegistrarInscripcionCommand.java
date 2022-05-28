/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.joda.time.DateTime;

/**
 *
 * @author Leo
 */
@AllArgsConstructor
public class RegistrarInscripcionCommand {

    /**
     * Por que se repite con el DTO? El DTO es un contrato con la API, las API
     * puede cambiar por ejemplo: nombre sea nombre, apellido. Para mantener
     * compatibilidad solamente se cambia el DTO.
     */
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
    @Getter
    private String generoPoesia;
}
