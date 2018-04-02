/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.services;

import edu.eci.pgr1.entremente.model.Enfermedad;
import edu.eci.pgr1.entremente.model.HistorialMedico;
import edu.eci.pgr1.entremente.model.Mensaje;
import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.persistence.EnfermedadRepository;
import edu.eci.pgr1.entremente.persistence.HistorialMedicoRepository;
import edu.eci.pgr1.entremente.persistence.MensajeRepository;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Pablo Arevalo
 */
@Service
public class EntreMenteServices {
    @Autowired
    private MensajeRepository mensajeRepository;
    
    @Autowired
    private HistorialMedicoRepository historialMedico;
    
    @Autowired
    private EnfermedadRepository enfermedad;
    
    /**
     * Metodo encargado de adicionar nuevos mensajes
     * @param mensaje
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void adicionarMensaje(Mensaje mensaje) throws PersistenceNotFoundException, PersistenceException{
        mensajeRepository.adicionarMensaje(mensaje);
    }
    
    /**
     * Metodo encargado de eliminar los mensajes
     * @param mensaje
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void eliminarMensaje(Mensaje mensaje) throws PersistenceNotFoundException, PersistenceException{
        mensajeRepository.eliminarMensaje(mensaje);
    }
    
    /**
     * Metodo encargado de consultar todos los Mensajes del paciente y que pueda ver el paciente
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<Mensaje> consultarTodosMensajes(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return mensajeRepository.traerMensajesDePaciente(paciente, Mensaje.NOPUEDEVERPACIENTE);
    }
    
    /**
     * Metodo encargado de consultar todos los Mensajes del paciente y que pueda ver el paciente
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<Mensaje> consultarMensajesPaciente(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return mensajeRepository.traerMensajesDePaciente(paciente, Mensaje.SIPUEDEVERPACIENTE);
    }
    
    
    
    /**
     * Metodo encargado de adicionar historial médico
     * @param historialM
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void adicionarHistorialMedico(HistorialMedico historialM) throws PersistenceNotFoundException, PersistenceException{
        historialMedico.adicionar(historialM);
    }
    
    /**
     * Metodo encargado de eliminar el historial médico
     * @param historialM
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void eliminarHistorialMedico(HistorialMedico historialM) throws PersistenceNotFoundException, PersistenceException{
        historialMedico.eliminar(historialM);
    }
    
    /**
     * Metodo encargado de consultar todo el historial médico del paciente
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<HistorialMedico> consultarHistorialMedicoPaciente(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return historialMedico.traerHistorialMedicoDePaciente(paciente);
    }
    /**
     * Metodo encargado de cargar las enfermedades
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<Enfermedad> consultarEnfermedades() throws PersistenceNotFoundException, PersistenceException{
        return enfermedad.cargarEnfermedades();
    }  
}
