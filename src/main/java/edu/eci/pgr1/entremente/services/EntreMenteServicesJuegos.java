/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.services;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.PreguntaGaleria;
import edu.eci.pgr1.entremente.model.Relacion;
import edu.eci.pgr1.entremente.persistence.GaleriaRepository;
import edu.eci.pgr1.entremente.persistence.PacienteRepository;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JuanArevaloMerchan
 */
@Service
public class EntreMenteServicesJuegos {
    
    @Autowired
    private GaleriaRepository galeria;
    
    /**
     * Metodo encargado de traer todas las preguntas segun Nivel y paciente pasado por parametro
     * @param nivel
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     */
    public Set<PreguntaGaleria> getPreguntas(int nivel, int idPaciente) throws PersistenceNotFoundException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return galeria.traerPreguntas(nivel, paciente);
    }
}
