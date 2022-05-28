/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.services;

import org.joda.time.DateTime;

/**
 *
 * @author Leo
 */
public interface IFechaDeclamacionEstrategia {

    public DateTime calcularFechaDeclamacion(DateTime fechaInscripcion);
}
