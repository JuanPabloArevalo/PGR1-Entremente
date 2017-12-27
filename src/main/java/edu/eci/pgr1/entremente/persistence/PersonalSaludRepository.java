package edu.eci.pgr1.entremente.persistence;

import edu.eci.pgr1.entremente.model.Familiar;
import edu.eci.pgr1.entremente.model.PersonalSalud;
import edu.eci.pgr1.entremente.model.Relacion;
import java.util.Set;

/**
 *
 * @author Juan Pablo Arévalo
 */
public interface PersonalSaludRepository {
        /**
     * Metodo encargado de adicionar un nuevo personal de la salud
     * @param personal
     * @throws PersistenceNotFoundException 
     */
    public void adicionarPersonalSalud(PersonalSalud personal) throws PersistenceNotFoundException;
    
    /**
     * Metodo encargado de validar si existe un personal de la salud
     * @param personal
     * @return 
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public boolean existePersonalSalud(PersonalSalud personal) throws PersistenceNotFoundException, PersistenceException;
    
    /**
     * Metodo encargado de traer el personal de la salud, dado el nombre de usuario  y la contraseña
     * @param nombreUsuarios
     * @param password
     * @return
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public PersonalSalud traerPersonalSalud(String nombreUsuarios, String password) throws PersistenceNotFoundException, PersistenceException;
    
    
    /**
     * Metodo encargado de buscar los personales de la salud que contengan por el valor pasado
     * @param valor
     * @return
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public Set<PersonalSalud> busquedaPersonalSalud(String valor) throws PersistenceNotFoundException, PersistenceException;
    
    /**
     * Metodo encargado de traer todas las relaciones pendientes de los pacientes
     * @param personalSalud
     * @param estado
     * @return 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException 
     */
    public Set<Relacion> traerRelacionesPacientesDesdeSalud(PersonalSalud personalSalud, String estado) throws PersistenceNotFoundException;

    /**
     * Metodo encargado de adicionar la solicitud de la realcion paciente-salud
     * @param relacion
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void adicionarSolicitudPacienteDesdeSalud(Relacion relacion) throws PersistenceNotFoundException, PersistenceException;
    
    /**
     * Metodo encargado de validar si existe la solicitud de la realcion paciente-salud
     * @param relacion
     * @return 
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public boolean existeRelacionPacienteSalud(Relacion relacion) throws PersistenceNotFoundException, PersistenceException;
        
    /**
     * Metodo encargado de aceptar la solicitud de la realcion paciente-personalSalud
     * @param relacion
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void aceptarSolicitudPaciente(Relacion relacion) throws PersistenceNotFoundException, PersistenceException;

    /**
     * Metodo encargado de eliminar la solicitud de la realcion paciente-personalSalud
     * @param relacion
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void eliminarSolicitudPaciente(Relacion relacion) throws PersistenceNotFoundException, PersistenceException;











}
