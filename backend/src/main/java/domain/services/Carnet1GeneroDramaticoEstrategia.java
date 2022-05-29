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
            switch (fechaInscripcion.getDayOfWeek()) {
                case DateTimeConstants.FRIDAY:
                    fechaInscripcion = fechaInscripcion.plusDays(2);
                    break;
                case DateTimeConstants.SATURDAY:
                    fechaInscripcion = fechaInscripcion.plusDays(1);
                    break;
//                case DateTimeConstants.SUNDAY:
//                    fechaInscripcion = fechaInscripcion.plusDays(1);
//                    break;
            }

            fechaInscripcion = fechaInscripcion.plusDays(1);

            add5Days--;
        }

        return fechaInscripcion;
    }

}
