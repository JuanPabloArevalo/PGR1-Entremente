/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.services;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.PreguntaAtencion;
import edu.eci.pgr1.entremente.model.PreguntaGaleria;
import edu.eci.pgr1.entremente.model.Relacion;
import edu.eci.pgr1.entremente.persistence.JuegoAtencionRepository;
import edu.eci.pgr1.entremente.persistence.PacienteRepository;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import java.util.ArrayList;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eci.pgr1.entremente.persistence.JuegoGaleriaRepository;

/**
 *
 * @author JuanArevaloMerchan
 */
@Service
public class EntreMenteServicesJuegos {
    
    @Autowired
    private JuegoGaleriaRepository galeria;
    @Autowired
    private JuegoAtencionRepository atencion;    
    /**
     * Metodo encargado de traer todas las preguntas del juego Galeria
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<Set<PreguntaGaleria>> getPreguntasGaleria(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        ArrayList<Set<PreguntaGaleria>> arreglo = new ArrayList<>();
        arreglo.add(galeria.traerPreguntas(1, paciente));
        arreglo.add(galeria.traerPreguntas(2, paciente));
        arreglo.add(galeria.traerPreguntas(3, paciente));
        arreglo.add(galeria.traerPreguntas(4, paciente));
        return arreglo;
    }
    
    /**
     * Metodo encargado de traer todas las preguntas del juego Atencion
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<Set<PreguntaAtencion>> getPreguntasAtencion(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        ArrayList<Set<PreguntaAtencion>> arreglo = new ArrayList<>();
        arreglo.add(atencion.traerPreguntas(1, paciente));
        arreglo.add(atencion.traerPreguntas(2, paciente));
        arreglo.add(atencion.traerPreguntas(3, paciente));
        arreglo.add(atencion.traerPreguntas(4, paciente));
        return arreglo;
    }
    
    
}
