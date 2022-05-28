/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repository;

import application.DTO.InscripcionViewDTO;
import domain.Inscripcion;
import java.util.List;

/**
 *
 * @author Leo
 */
public interface IInscripcionRepository {

    public boolean registrarInscripcion(Inscripcion inscripcion);

    public List<InscripcionViewDTO> getAllInscripciones();
}
