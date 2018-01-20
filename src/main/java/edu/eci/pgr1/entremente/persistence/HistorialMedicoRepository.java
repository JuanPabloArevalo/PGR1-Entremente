/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence;

import edu.eci.pgr1.entremente.model.HistorialMedico;
import edu.eci.pgr1.entremente.model.Mensaje;
import edu.eci.pgr1.entremente.model.Paciente;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public interface HistorialMedicoRepository {
    /**
     * Metodo encargado de adicionar
     * @param historialM
     * @throws PersistenceNotFoundException 
     */
    public void adicionar(HistorialMedico historialM) throws PersistenceNotFoundException;
    
    /**
     * Metodo encargado de eliminar
     * @param historialM
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void eliminar(HistorialMedico historialM) throws PersistenceNotFoundException, PersistenceException;

    /**
     * Metodo encargado de traer todo el historial médico que se han realizado al paciente pasado por paramtetro
     * @param paciente
     * @return 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException 
     */
    public ArrayList<HistorialMedico> traerHistorialMedicoDePaciente(Paciente paciente) throws PersistenceNotFoundException;

}
