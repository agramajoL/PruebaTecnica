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
public class Carnet1GeneroDramaticoEstrategiaTest {

    public final Carnet1GeneroDramaticoEstrategia c = new Carnet1GeneroDramaticoEstrategia();

    public Carnet1GeneroDramaticoEstrategiaTest() {
    }

    @Test
    void testInscripcionViernesDeclamacionSiguienteViernes() {

        DateTime fechaInscripcion = new DateTime(2022, 6, 3, 0, 0);
        DateTime proximoViernes = new DateTime(2022, 6, 10, 0, 0);

        Assertions.assertEquals(proximoViernes, c.calcularFechaDeclamacion(fechaInscripcion));
    }

    @Test
    void testInscripcionLunesDeclamacionSiguienteLunesTest() {
        DateTime fechaInscripcion = new DateTime(2022, 6, 6, 0, 0);
        DateTime proximoLunes = new DateTime(2022, 6, 13, 0, 0);
        Assertions.assertEquals(proximoLunes, c.calcularFechaDeclamacion(fechaInscripcion));

    }

    @Test
    void testInscripcionSabadoDeclamacionSiguienteViernes() {
        DateTime fechaInscripcion = new DateTime(2022, 5, 28, 0, 0);

        DateTime proximoViernes = new DateTime(2022, 6, 3, 0, 0);
        Assertions.assertEquals(proximoViernes, c.calcularFechaDeclamacion(fechaInscripcion));

    }

    @Test
    void testInscripcionDomingoDeclamacionSiguienteViernes() {

        DateTime fechaInscripcion = new DateTime(2022, 5, 29, 0, 0);

        DateTime proximoViernes = new DateTime(2022, 6, 3, 0, 0);
        Assertions.assertEquals(proximoViernes, c.calcularFechaDeclamacion(fechaInscripcion));

    }
}
