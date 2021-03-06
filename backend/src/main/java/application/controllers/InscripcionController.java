/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.controllers;

import application.DTO.InscripcionViewDTO;
import application.commands.RegistrarInscripcionCommand;
import application.commands.RegistrarInscripcionCommandHandler;
import application.repository.IInscripcionRepository;
import br.com.fluentvalidator.context.Error;
import infraestructure.InscripcionRepositoryOracle;
import io.vavr.control.Either;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Leo
 */
@Path("inscripcion")
public class InscripcionController {

    private final IInscripcionRepository repository = new InscripcionRepositoryOracle();

    @POST()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarInscripcionCommand(RegistrarInscripcionCommand command) {
        RegistrarInscripcionCommandHandler handler = new RegistrarInscripcionCommandHandler(repository);
        Either<InscripcionViewDTO, Collection<Error>> resultado = handler.handleCommand(command);
        if (resultado.isRight()) {
            return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(resultado.get())
                .build();
        }
        return Response
            .status(Response.Status.CREATED)
            .entity(resultado.getLeft())
            .build();
    }

    @GET()
    public Response listarTodasInscripcionesQuery() {
        List<InscripcionViewDTO> resultado = this.repository.getAllInscripciones();
        return Response
            .status(Response.Status.CREATED)
            .entity(resultado)
            .build();
    }

}
