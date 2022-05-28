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
public class Carnet3GeneroEpicoEstrategiaTest {

    private final Carnet3GeneroEpicoEstrategia c = new Carnet3GeneroEpicoEstrategia();

    public Carnet3GeneroEpicoEstrategiaTest() {
    }

    @Test
    public void inscripcionMayo2022_Martes31() {
        DateTime fechaInscripcion = new DateTime(2022, 5, 1, 0, 0);
        DateTime ultimoDiaDelMes = new DateTime(2022, 5, 31, 0, 0);

        Assertions.assertEquals(ultimoDiaDelMes, c.calcularFechaDeclamacion(fechaInscripcion));

    }

    @Test
    public void inscripcionOctubre2021_Viernes29() {
        DateTime fechaInscripcion = new DateTime(2021, 10, 1, 0, 0);
        DateTime ultimoViernesDelMes = new DateTime(2021, 10, 29, 0, 0);

        Assertions.assertEquals(ultimoViernesDelMes, c.calcularFechaDeclamacion(fechaInscripcion));

    }

    @Test
    public void inscripcionOctubre2021_Sabado31() {
        DateTime fechaInscripcion = new DateTime(2021, 10, 1, 0, 0);
        DateTime ultimoDiaDelMes = new DateTime(2021, 10, 31, 0, 0);
        Assertions.assertNotEquals(ultimoDiaDelMes, c.calcularFechaDeclamacion(fechaInscripcion));
    }

}
