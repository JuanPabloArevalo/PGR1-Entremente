/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp.juegos;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.juegos.PreguntaCalculo;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import java.util.ArrayList;
import java.util.Set;

import edu.eci.pgr1.entremente.persistence.juegos.JuegoCalculoRepository;

/**
 *
 * @author JuanArevaloMerchan
 */
public class JuegoCalculoRepositoryRandom implements JuegoCalculoRepository{

    @Override
    public Set<PreguntaCalculo> traerPreguntas(int nivel, Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PreguntaCalculo> traerTODASPreguntas(Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarPregunta(PreguntaCalculo pregunta) throws PersistenceNotFoundException, PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    private Operandos traer
    
    
    /**
     * 
     */
    private class Operandos{
        public long operando1;
        public long operando2;
    }
}
