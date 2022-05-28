/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.services.Carnet1GeneroDramaticoEstrategia;
import domain.services.Carnet3GeneroEpicoEstrategia;
import domain.services.CarnetOtrosGeneroCualquieraEstrategia;
import domain.services.IFechaDeclamacionEstrategia;
import lombok.Getter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Leo
 */
public class Inscripcion {

    @Getter
    Estudiante estudiante;
    @Getter
    String generoPoesia;
    @Getter
    String fechaInscripcion;
    @Getter
    String fechaDeclamacion;

    public Inscripcion(Estudiante estudiante, String generoPoesia) {
        this.estudiante = estudiante;
        this.generoPoesia = generoPoesia;
        this.fechaInscripcion = new DateTime().toString("d/M/Y");
        this.fechaDeclamacion = this.calcularFechaDeclamacion(this.estudiante.getCarnet(), this.generoPoesia);
    }

    String calcularFechaDeclamacion(String carnet, String generoPoesia) {
        IFechaDeclamacionEstrategia contexto;
        if (carnet.endsWith("1") && generoPoesia.equals(GenerosPoesia.DRAMATICO.toString())) {
            contexto = new Carnet1GeneroDramaticoEstrategia();
        } else if (carnet.endsWith("3") && generoPoesia.equals(GenerosPoesia.EPICO.toString())) {
            contexto = new Carnet3GeneroEpicoEstrategia();
        } else {
            contexto = new CarnetOtrosGeneroCualquieraEstrategia();
        }
        DateTimeFormatter format = DateTimeFormat.forPattern("dd/MM/yyyy");

        DateTime fInscripcion = format.parseDateTime(this.fechaInscripcion);
        DateTime fDeclamacion = contexto.calcularFechaDeclamacion(fInscripcion);
        return format.print(fDeclamacion);

    }
}
