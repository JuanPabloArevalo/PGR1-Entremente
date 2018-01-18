/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence;


import edu.eci.pgr1.entremente.model.Mensaje;
import edu.eci.pgr1.entremente.model.Paciente;
import java.util.Set;

/**
 *
 * @author JuanArevaloMerchan
 */
public interface MensajeRepository {
    /**
     * Metodo encargado de adicionar un nuevo mensaje
     * @param mensaje
     * @throws PersistenceNotFoundException 
     */
    public void adicionarMensaje(Mensaje mensaje) throws PersistenceNotFoundException;
    
    /**
     * Metodo encargado de eliminar el mensaje seleccionado
     * @param mensaje
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void eliminarMensaje(Mensaje mensaje) throws PersistenceNotFoundException, PersistenceException;

    /**
     * Metodo encargado de traer todos los mensajes que se han realizado al paciente pasado por paramtetro
     * @param paciente
     * @param puedeVerPaciente (S/N)
     * @return 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException 
     */
    public Set<Mensaje> traerMensajesDePaciente(Paciente paciente, String puedeVerPaciente) throws PersistenceNotFoundException;


}
