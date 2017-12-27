/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence;

import edu.eci.pgr1.entremente.model.Familiar;
import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.RelacionPacienteFamiliar;
import java.util.Set;
/**
 *
 * @author Juan Pablo Arévalo
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
    
    /**
     * Metodo encargado de buscar los pacientes que contengan por el valor pasado
     * @param valor
     * @return
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public Set<Paciente> busquedaPacientes(String valor) throws PersistenceNotFoundException, PersistenceException;
        /**
     * Metodo encargado de traer todas las relaciones pendientes de los familiares
     * @param paciente
     * @param estado
     * @return 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException 
     */
    public Set<RelacionPacienteFamiliar> traerRelacionesFamiliaresDesdePaciente(Paciente paciente, String estado) throws PersistenceNotFoundException;

    /**
     * Metodo encargado de adicionar la solicitud de la realcion paciente-familiar
     * @param relacion
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void adicionarSolicitudPacienteDesdePaciente(RelacionPacienteFamiliar relacion) throws PersistenceNotFoundException, PersistenceException;
    
    
}
