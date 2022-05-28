/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.services;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Leo
 */
public class CarnetOtrosGeneroCualquieraEstrategiaTest {

    private final CarnetOtrosGeneroCualquieraEstrategia c = new CarnetOtrosGeneroCualquieraEstrategia();

    public CarnetOtrosGeneroCualquieraEstrategiaTest() {
    }

    @Test
    public void fechaInscripcionViernesfechaDeclamacionMismoDia() {
        DateTime fechaInscripcion = new DateTime(2022, 5, 27, 0, 0);
        Assertions.assertEquals(fechaInscripcion, c.calcularFechaDeclamacion(fechaInscripcion));
    }

    @Test
    public void fechaInscripcionSabado_fechaDeclamacionProximoViernes() {

        DateTime fechaInscripcion = new DateTime(2022, 5, 21, 0, 0);
        DateTime proximoViernes = new DateTime(2022, 5, 27, 0, 0);
        Assertions.assertEquals(proximoViernes, c.calcularFechaDeclamacion(fechaInscripcion));
    }

}
