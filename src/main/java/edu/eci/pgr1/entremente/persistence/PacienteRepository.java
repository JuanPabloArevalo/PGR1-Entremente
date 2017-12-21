/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence;

import edu.eci.pgr1.entremente.model.Paciente;
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
     * @return 
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public boolean existePaciente(Paciente paciente) throws PersistenceNotFoundException, PersistenceException;
    
    /**
     * Metodo encargado de traer el paciente, dado el nombre de usuario  y la contraseña
     * @param nombreUsuarios
     * @param password
     * @return
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public Paciente traerPaciente(String nombreUsuarios, String password) throws PersistenceNotFoundException, PersistenceException;
    
}
