/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infraestructure;

import application.DTO.InscripcionViewDTO;
import application.repository.IInscripcionRepository;
import domain.Inscripcion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class InscripcionRepositoryOracle implements IInscripcionRepository {

    @Override
    public boolean registrarInscripcion(Inscripcion inscripcion) {
        String sql = "INSERT INTO INSCRIPCION(CARNET, NOMBRE, DIRECCION, GENERO, TELEFONO, FECHA_NACIMIENTO, FECHA_INSCRIPCION, FECHA_DECLAMACION, GENERO_POESIA)\n"
            + "VALUES(?, ?, ?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), TO_DATE(?, 'DD/MM/YYYY'),TO_DATE(?, 'DD/MM/YYYY'), ?)";
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection(
                ConfigurationOracle.ORACLE_URL,
                ConfigurationOracle.ORACLE_USER,
                ConfigurationOracle.ORACLE_PASSWORD
            );
            ps = conn.prepareStatement(sql);
            ps.setString(1, inscripcion.getEstudiante().getCarnet());
            ps.setString(2, inscripcion.getEstudiante().getNombre());
            ps.setString(3, inscripcion.getEstudiante().getDireccion());
            ps.setString(4, inscripcion.getEstudiante().getGenero());
            ps.setInt(5, inscripcion.getEstudiante().getTelefono());
            ps.setString(6, inscripcion.getEstudiante().getFechaNacimiento());
            ps.setString(7, inscripcion.getFechaInscripcion());
            ps.setString(8, inscripcion.getFechaDeclamacion());
            ps.setString(9, inscripcion.getGeneroPoesia());
            //ResultSet rs = ps.executeQuery();

            result = ps.execute();
            conn.commit();
        } catch (SQLException sqlException) {
            Logger.getLogger(InscripcionRepositoryOracle.class.getName())
                .log(Level.SEVERE, null, sqlException);

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(InscripcionRepositoryOracle.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return result;
    }

    @Override
    public List<InscripcionViewDTO> getAllInscripciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
