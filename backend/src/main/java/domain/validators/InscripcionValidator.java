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
import domain.GenerosPoesia;
import domain.Inscripcion;

/**
 *
 * @author Leo
 */
public class InscripcionValidator extends AbstractValidator<Inscripcion> {

    @Override
    public void rules() {
        ruleFor(Inscripcion::getEstudiante)
            .whenever(not(nullValue()))
            .withValidator(new EstudianteValidator());

        ruleFor(Inscripcion::getGeneroPoesia)
            .must(this::esGeneroPoesiaValido)
            .when(not(stringEmptyOrNull()))
            .withMessage("El genero de poesia debe ser: Dramatico, Epico o Lirica");
    }

    private boolean esGeneroPoesiaValido(final String generoPoesia) {
        if (generoPoesia.equals(GenerosPoesia.DRAMATICO.toString())
            || generoPoesia.equals(GenerosPoesia.LIRICA.toString())
            || generoPoesia.equals(GenerosPoesia.EPICO.toString())) {
            return true;
        }
        return false;
    }
}
