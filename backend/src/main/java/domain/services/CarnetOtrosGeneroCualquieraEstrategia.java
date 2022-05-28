/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.services;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

/**
 *
 * @author Leo
 */
public class CarnetOtrosGeneroCualquieraEstrategia implements IFechaDeclamacionEstrategia {

    @Override
    public DateTime calcularFechaDeclamacion(DateTime fechaInscripcion) {
        if (fechaInscripcion.getDayOfWeek() < DateTimeConstants.FRIDAY) {
            return fechaInscripcion.withDayOfWeek(DateTimeConstants.FRIDAY);
        } else {
            return fechaInscripcion.plusWeeks(1).withDayOfWeek(DateTimeConstants.FRIDAY);
        }
    }
}
