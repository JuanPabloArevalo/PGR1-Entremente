/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence;

import edu.eci.pgr1.entremente.model.Paciente;
import java.sql.SQLException;
/**
 *
 * @author Administrador
 */
public interface PacienteRepository {
    
    /**
     * Metodo encargado de adicionar un nuevo paciente
     * @param paciente
     * @throws PersistenceNotFoundException 
     */
    public void adicionarPaciente(Paciente paciente) throws PersistenceNotFoundException;
    
    /**
     * Metodo encargado de validar si existe un paciente
     * @param paciente
     * @throws PersistenceNotFoundException 
     */
    public boolean existePaciente(Paciente paciente) throws PersistenceNotFoundException, PersistenceException;
    
}
