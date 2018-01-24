/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.services;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.juegos.PreguntaAtencion;
import edu.eci.pgr1.entremente.model.juegos.PreguntaCalculo;
import edu.eci.pgr1.entremente.model.juegos.PreguntaFormas;
import edu.eci.pgr1.entremente.model.juegos.PreguntaGaleria;
import edu.eci.pgr1.entremente.model.juegos.PreguntaPercepcion;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoAtencionRepository;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoCalculoRepository;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoFormasRepository;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import java.util.ArrayList;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoGaleriaRepository;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoPercepcionRepository;

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
    @Autowired
    private JuegoFormasRepository formas;  
    @Autowired
    private JuegoCalculoRepository calculo;  
    @Autowired
    private JuegoPercepcionRepository percepcion;  
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
    
    /**
     * Metodo encargado de traer todas las preguntas del juego Formas
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<Set<PreguntaFormas>> getPreguntasFormas(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        ArrayList<Set<PreguntaFormas>> arreglo = new ArrayList<>();
        arreglo.add(formas.traerPreguntas(1, paciente));
        arreglo.add(formas.traerPreguntas(2, paciente));
        arreglo.add(formas.traerPreguntas(3, paciente));
        arreglo.add(formas.traerPreguntas(4, paciente));
        return arreglo;
    }

    /**
     * Metodo encargado de traer todas las preguntas del juego Calculo
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<Set<PreguntaCalculo>> getPreguntasCalculo(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        ArrayList<Set<PreguntaCalculo>> arreglo = new ArrayList<>();
        arreglo.add(calculo.traerPreguntas(1, paciente));
        arreglo.add(calculo.traerPreguntas(2, paciente));
        arreglo.add(calculo.traerPreguntas(3, paciente));
        arreglo.add(calculo.traerPreguntas(4, paciente));
        return arreglo;
    }   
    
    /**
     * Metodo encargado de traer todas las preguntas del juego Percepcion
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<Set<PreguntaPercepcion>> getPreguntasPercepcion(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        ArrayList<Set<PreguntaPercepcion>> arreglo = new ArrayList<>();
        arreglo.add(percepcion.traerPreguntas(1, paciente));
        arreglo.add(percepcion.traerPreguntas(2, paciente));
        arreglo.add(percepcion.traerPreguntas(3, paciente));
        return arreglo;
    }    
}
