package edu.eci.pgr1.entremente.persistence;

import edu.eci.pgr1.entremente.model.PersonalSalud;

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
    
}
