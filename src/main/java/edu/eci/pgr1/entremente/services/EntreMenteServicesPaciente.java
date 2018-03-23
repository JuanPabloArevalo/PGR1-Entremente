/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.services;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.Progreso;
import edu.eci.pgr1.entremente.model.Relacion;
import edu.eci.pgr1.entremente.persistence.FamiliarRepository;
import edu.eci.pgr1.entremente.persistence.PacienteRepository;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.persistence.PersonalSaludRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class EntreMenteServicesPaciente {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private FamiliarRepository familiarRepository;
    @Autowired
    private PersonalSaludRepository personalSaludRepository;
    /**
     * Metodo encargado de adicionar un nuevo paciente
     * @param paciente
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public void adicionarPaciente(Paciente paciente) throws PersistenceNotFoundException, PersistenceException{
        boolean existe = pacienteRepository.existePaciente(paciente);
        if(!existe){
            pacienteRepository.adicionarPaciente(paciente);
        }
    }
    
    /**
     * Metodo encargado de modificar un paciente
     * @param paciente
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public void modificarPaciente(Paciente paciente) throws PersistenceNotFoundException, PersistenceException{
        pacienteRepository.modificarPaciente(paciente);
    }
    
    /**
     * Metodo encargado de iniciar sesión, si el usuario se ha autenticado correctamente
     * @param nombreUsuario
     * @param password 
     * @return  
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException  
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException  
     */
    public Paciente iniciarSesionPaciente(String nombreUsuario, String password) throws PersistenceNotFoundException, PersistenceException{
        return pacienteRepository.traerPaciente(nombreUsuario, password);
    }
    
    /**
     * Metodo encargado de traer todas las relaciones pendientes de los familiares del paciente pasado por parametro
     * @param paciente
     * @return
     * @throws PersistenceNotFoundException 
     */
    public Set<Relacion> getRelacionesPacientePendientesDesdePaciente(Paciente paciente) throws PersistenceNotFoundException{
        return pacienteRepository.traerRelacionesFamiliaresDesdePaciente(paciente, Relacion.ESTADOPENDIENTE);
    }  
    
    /**
     * Metodo encargado de traer todas las relaciones aceptadas de los familiares del paciente pasado por parametro
     * @param paciente
     * @return
     * @throws PersistenceNotFoundException 
     */
    public Set<Relacion> getRelacionesPacienterAceptadasDesdePaciente(Paciente paciente) throws PersistenceNotFoundException{
        return pacienteRepository.traerRelacionesFamiliaresDesdePaciente(paciente, Relacion.ESTADOACEPTADO);
    } 
    
    /**
     * Metodo encargado de consultar todos los pacientes que existan con ese dato
     * @param dato
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public Set<Paciente> consultarPacientes(String dato) throws PersistenceNotFoundException, PersistenceException{
        return pacienteRepository.busquedaPacientes(dato);
    }
    
    /**
     * Metodo encargado de adicionar la solicitud del paciente familiar
     * @param relacion
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void adicionarRelacionPacienteDesdePaciente(Relacion relacion) throws PersistenceNotFoundException, PersistenceException{
        boolean existe = familiarRepository.existeRelacionPacienteFamiliar(relacion);
        if(!existe){
            pacienteRepository.adicionarSolicitudPacienteDesdePaciente(relacion);
        }
    }
    
    /**
     * Metodo encargado de adicionar la solicitud del paciente salud
     * @param relacion
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void adicionarRelacionSaludDesdePaciente(Relacion relacion) throws PersistenceNotFoundException, PersistenceException{
        boolean existe = personalSaludRepository.existeRelacionPacienteSalud(relacion);
        if(!existe){
            pacienteRepository.adicionarSolicitudSaludDesdePaciente(relacion);
        }
    }
    
    /**
     * Metodo encargado de traer todas las relaciones pendientes del personal de la salud del paciente pasado por parametro
     * @param paciente
     * @return
     * @throws PersistenceNotFoundException 
     */
    public Set<Relacion> getRelacionesSaludPendientesDesdePaciente(Paciente paciente) throws PersistenceNotFoundException{
        return pacienteRepository.traerRelacionesSaludDesdePaciente(paciente, Relacion.ESTADOPENDIENTE);
    }    
    /**
     * Metodo encargado de traer todas las relaciones aceptadas de Personal salud  del pacientes pasado por parametro
     * @param paciente
     * @return
     * @throws PersistenceNotFoundException 
     */
    public Set<Relacion> getRelacionesSaludAceptadasDesdePaciente(Paciente paciente) throws PersistenceNotFoundException{
        return pacienteRepository.traerRelacionesSaludDesdePaciente(paciente, Relacion.ESTADOACEPTADO);
    }
    
    /**
     * Metodo encargado de traer el progreso del paciente
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public Progreso traerProgresoPaciente(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return pacienteRepository.traerProgresoPaciente(paciente);
    }
}
