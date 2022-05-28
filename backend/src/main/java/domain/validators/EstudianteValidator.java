/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.validators;

import br.com.fluentvalidator.AbstractValidator;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import static br.com.fluentvalidator.predicate.StringPredicate.stringMatches;
import static br.com.fluentvalidator.predicate.StringPredicate.stringSize;
import static br.com.fluentvalidator.predicate.StringPredicate.stringSizeLessThanOrEqual;
import domain.Estudiante;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Leo
 */
public class EstudianteValidator extends AbstractValidator<Estudiante> {

    @Override
    public void rules() {
        ruleFor(Estudiante::getCarnet)
            .must(stringSize(6))
            .withMessage("Carnet debe tener 6 caracteres")
            .must(stringMatches("^[aA][a-zA-Z1-9]5[a-zA-Z1-9]{2}[139]$"))
            .withMessage("Carnet debe empezar con a o A, tercer caracter debe ser 5 y el ultimo debe ser 1,3 o 9. Solo se permiten caracteres alfanumericos.");

        ruleFor(Estudiante::getNombre)
            .must(not(stringEmptyOrNull()))
            .withMessage("El nombre no puede ser nulo o vacio")
            .must(stringSizeLessThanOrEqual(100))
            .withMessage("El nombre no debe contener mas de 100 caracteres");

        ruleFor(Estudiante::getCarrera)
            .must(not(stringEmptyOrNull()))
            .withMessage("La carrera no puede ser nula o vacia")
            .must(stringSizeLessThanOrEqual(100))
            .withMessage("La carrera no debe contener mas de 100 caracteres");

        ruleFor(Estudiante::getDireccion)
            .must(not(stringEmptyOrNull()))
            .withMessage("La direccion no puede ser nula o vacia")
            .must(stringSizeLessThanOrEqual(200))
            .withMessage("La direccion no debe contener mas de 200 caracteres");

        ruleFor(Estudiante::getGenero)
            .must(not(stringEmptyOrNull()))
            .withMessage("El genero no puede ser nula o vacia")
            .must(stringMatches("^Masculino|Femenino$"))
            .withMessage("El genero debe ser: Masculino o Femenino");

        ruleFor(Estudiante::getFechaNacimiento)
            .must(this::esMayorDeEdad)
            .when(not(nullValue()))
            .withMessage("Debe ser mayor a 17 anios.");
    }

    //Si es mayor de edad es regla del dominio pero no se debe permitir crear
    //modelos del dominio invalidos.
    private boolean esMayorDeEdad(final String fechaNacimiento) {
        DateTimeFormatter format = DateTimeFormat.forPattern("dd/MM/yyyy");

        DateTime f = format.parseDateTime(fechaNacimiento);

        int yearNacimiento = f.getYear();
        int yearActual = new DateTime().getYear();
        int edad = yearActual - yearNacimiento;
        return edad > 17;
    }
}
