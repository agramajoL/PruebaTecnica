/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.validators;

import br.com.fluentvalidator.context.ValidationResult;
import domain.Estudiante;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Leo
 */
public class EstudianteValidatorTest {

    public EstudianteValidatorTest() {
    }

    /**
     * Test of rules method, of class EstudianteValidator.
     */
    @Test
    public void estudianteSeaValido() {
        Estudiante estudianteValido = new Estudiante("Ab5ee1", "Alvaro Gramajo", "direccion tal", "Masculino", "13/01/1998", "Ingenieria en Sistemas", 12344321);

        EstudianteValidator ev = new EstudianteValidator();
        ValidationResult result = ev.validate(estudianteValido);
        assertTrue(result.isValid());

    }

    @Test
    public void carnetNoContengaCaracteresNoAlfanumericos() {
        Estudiante estudianteValido = new Estudiante("Ab5e01", "Alvaro Gramajo", "direccion tal", "Masculino", "13/01/1998", "Ingenieria en Sistemas", 12344321);
        EstudianteValidator ev = new EstudianteValidator();
        ValidationResult result = ev.validate(estudianteValido);
        assertFalse(result.isValid());
        assertThat(result.getErrors(), not(empty()));

        //assertThat(result.getErrors(), hasItem(hasProperty("field", containsString("carnet"))));
        assertThat(result.getErrors(), hasItem(hasProperty("attemptedValue", equalTo(estudianteValido.getCarnet()))));
        assertThat(result.getErrors(), hasItem(hasProperty("message", containsString("Carnet debe empezar con a o A, tercer caracter debe ser 5 y el ultimo debe ser 1,3 o 9. Solo se permiten caracteres alfanumericos."))));

    }

    @Test
    public void estudianteDebeSerMayorDeEdad() {
        Estudiante estudianteValido = new Estudiante("Ab5e01", "Alvaro Gramajo", "direccion tal", "Masculino", "27/05/2005", "Ingenieria en Sistemas", 12344321);

        EstudianteValidator ev = new EstudianteValidator();
        ValidationResult result = ev.validate(estudianteValido);
        assertFalse(result.isValid());
        assertThat(result.getErrors(), not(empty()));

        //assertThat(result.getErrors(), hasItem(hasProperty("field", containsString("carnet"))));
        assertThat(result.getErrors(), hasItem(hasProperty("attemptedValue", equalTo(estudianteValido.getFechaNacimiento()))));
        assertThat(result.getErrors(), hasItem(hasProperty("message", containsString("Debe ser mayor a 17 anios."))));

    }

}
