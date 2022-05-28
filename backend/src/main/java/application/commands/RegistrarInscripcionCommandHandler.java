/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.commands;

import application.DTO.InscripcionViewDTO;
import application.mappers.RegistrarInscripcionCommandMapper;
import application.repository.IInscripcionRepository;
import br.com.fluentvalidator.Validator;
import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;
import domain.Inscripcion;
import domain.validators.InscripcionValidator;
import io.vavr.control.Either;
import java.util.Collection;
import lombok.AllArgsConstructor;

/**
 *
 * @author Leo
 */
@AllArgsConstructor
public class RegistrarInscripcionCommandHandler {

    private IInscripcionRepository repository;
    private final RegistrarInscripcionCommandMapper mapper = new RegistrarInscripcionCommandMapper();
    private final Validator<Inscripcion> inscripcionValidator = new InscripcionValidator();

    public Either<InscripcionViewDTO, Collection<Error>> handleCommand(RegistrarInscripcionCommand command) {
        Inscripcion inscripcion
            = mapper.mapFrom(command);
        ValidationResult result = this.inscripcionValidator.validate(inscripcion);

        if (!result.isValid()) {
            return Either.right(result.getErrors());
        }

        this.repository.registrarInscripcion(inscripcion);

        return Either.left(mapper.mapFrom(inscripcion));

    }

}
