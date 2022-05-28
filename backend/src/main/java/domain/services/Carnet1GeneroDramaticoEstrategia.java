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
public class Carnet1GeneroDramaticoEstrategia implements IFechaDeclamacionEstrategia {

    /**
     * La fecha de declamacion es a los 5 dias habiles de la inscripcion.
     *
     * @param fechaInscripcion
     * @return
     */
    @Override
    public DateTime calcularFechaDeclamacion(DateTime fechaInscripcion) {

        int add5Days = 5;
        while (add5Days != 0) {
            if (fechaInscripcion.getDayOfWeek() == DateTimeConstants.FRIDAY) {
                fechaInscripcion = fechaInscripcion.plusDays(3);

            } else {
                fechaInscripcion = fechaInscripcion.plusDays(1);
            }

            add5Days--;
        }

        return fechaInscripcion;
    }

}
