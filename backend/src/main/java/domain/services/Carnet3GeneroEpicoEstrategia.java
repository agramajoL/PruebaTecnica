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
public class Carnet3GeneroEpicoEstrategia implements IFechaDeclamacionEstrategia {

    @Override
    public DateTime calcularFechaDeclamacion(DateTime fechaInscripcion) {
        DateTime ultimoDiaDelMes = fechaInscripcion.dayOfMonth().withMaximumValue();
        while (ultimoDiaDelMes.getDayOfWeek() == DateTimeConstants.SATURDAY
            || ultimoDiaDelMes.getDayOfWeek() == DateTimeConstants.SUNDAY) {
            ultimoDiaDelMes = ultimoDiaDelMes.minusDays(1);
        }
        return ultimoDiaDelMes;

    }
}
