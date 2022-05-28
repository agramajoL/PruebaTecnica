/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.joda.time.DateTime;

/**
 *
 * @author Leo
 */
public class Inscripcion {

    private Estudiante estudiante;
    private String generoPoesia;
    private DateTime fechaInscripcion;
    private DateTime fechaDeclamacion;

    public Inscripcion(Estudiante estudiante, String generoPoesia) {
        this.estudiante = estudiante;
        this.generoPoesia = generoPoesia;
        this.fechaInscripcion = new DateTime();

    }
}
