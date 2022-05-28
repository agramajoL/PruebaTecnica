/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.mappers;

import application.DTO.EstudianteDTO;
import application.DTO.InscripcionDTO;
import application.DTO.InscripcionViewDTO;
import application.commands.RegistrarInscripcionCommand;
import domain.Estudiante;
import domain.Inscripcion;

/**
 *
 * @author Leo
 */
public class RegistrarInscripcionCommandMapper {

    public RegistrarInscripcionCommand mapFrom(InscripcionDTO iDTO) {
        RegistrarInscripcionCommand command = new RegistrarInscripcionCommand(
            iDTO.getEstudiante().getCarnet(),
            iDTO.getEstudiante().getNombre(),
            iDTO.getEstudiante().getDireccion(),
            iDTO.getEstudiante().getGenero(),
            iDTO.getEstudiante().getFechaNacimiento(),
            iDTO.getEstudiante().getCarrera(),
            iDTO.getGeneroPoesia()
        );

        return command;
    }

    public Inscripcion mapFrom(RegistrarInscripcionCommand cmd) {
        Estudiante estudiante = new Estudiante(
            cmd.getCarnet(),
            cmd.getNombre(),
            cmd.getDireccion(),
            cmd.getGenero(),
            cmd.getFechaNacimiento(),
            cmd.getCarrera()
        );
        Inscripcion inscripcion = new Inscripcion(estudiante, cmd.getGeneroPoesia());

        return inscripcion;
    }

    public InscripcionViewDTO mapFrom(Inscripcion i) {
        EstudianteDTO eDTO = new EstudianteDTO(
            i.getEstudiante().getCarnet(),
            i.getEstudiante().getNombre(),
            i.getEstudiante().getDireccion(),
            i.getEstudiante().getGenero(),
            i.getEstudiante().getFechaNacimiento(),
            i.getEstudiante().getCarrera()
        );

        InscripcionViewDTO ivDTO = new InscripcionViewDTO(eDTO,
            i.getGeneroPoesia(),
            i.getFechaInscripcion(),
            i.getFechaDeclamacion()
        );

        return ivDTO;

    }

}
