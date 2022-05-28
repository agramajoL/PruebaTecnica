/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.validators;

import br.com.fluentvalidator.context.ValidationResult;
import domain.Estudiante;
import domain.Inscripcion;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import org.joda.time.DateTime;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Leo
 */
public class InscripcionValidatorTest {

    public InscripcionValidatorTest() {
    }

    @Test
    public void generoPoesiaDebeSerValido() {
        Estudiante estudianteValido = new Estudiante("Ab5ee1", "Alvaro Gramajo", "direccion tal", "Masculino", new DateTime(1998, 1, 13, 0, 0), "Ingenieria en Sistemas");
        Inscripcion inscripcion = new Inscripcion(estudianteValido, "Fantasia");
        InscripcionValidator iv = new InscripcionValidator();
        ValidationResult result = iv.validate(inscripcion);
        assertFalse(result.isValid());
        assertThat(result.getErrors(), not(empty()));
        assertThat(result.getErrors(), hasItem(hasProperty("attemptedValue", equalTo(inscripcion.getGeneroPoesia()))));
        assertThat(result.getErrors(), hasItem(hasProperty("message", containsString("El genero de poesia debe ser: Dramatico, Epico o Lirica"))));
    }

}
