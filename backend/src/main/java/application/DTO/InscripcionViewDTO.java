/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author Leo
 */
@AllArgsConstructor
public class InscripcionViewDTO {

    @Getter
    private EstudianteDTO estudianteDTO;
    @Getter
    private String generoPoesia;
    @Getter
    private String fechaInscripcion;
    @Getter
    private String fechaDeclamacion;

}
