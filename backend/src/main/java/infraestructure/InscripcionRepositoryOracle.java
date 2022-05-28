/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infraestructure;

import application.DTO.InscripcionDTO;
import application.repository.IInscripcionRepository;
import domain.Inscripcion;
import java.util.List;

/**
 *
 * @author Leo
 */
public class InscripcionRepositoryOracle implements IInscripcionRepository {

    @Override
    public void registrarInscripcion(Inscripcion inscripcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InscripcionDTO> getAllInscripciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
