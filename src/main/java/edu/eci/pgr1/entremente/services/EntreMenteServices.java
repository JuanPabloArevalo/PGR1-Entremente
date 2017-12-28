/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.services;

import edu.eci.pgr1.entremente.model.Familiar;
import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.PersonalSalud;
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
 * @author Juan Pablo Arevalo
 */
@Service
public class EntreMenteServices {
    
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
     * Metodo encargado de adicionar un nuevo familiar
     * @param familiar
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public void adicionarFamiliar(Familiar familiar) throws PersistenceNotFoundException, PersistenceException{
        boolean existe = familiarRepository.existeFamiliar(familiar);
        if(!existe){
            familiarRepository.adicionarFamiliar(familiar);
        }
    }
    
    /**
     * Metodo encargado de iniciar sesión, si el usuario se ha autenticado correctamente del familiar
     * @param nombreUsuario
     * @param password 
     * @return  
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException  
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException  
     */
    public Familiar iniciarSesionFamiliar(String nombreUsuario, String password) throws PersistenceNotFoundException, PersistenceException{
        return familiarRepository.traerFamiliar(nombreUsuario, password);
    }
    
    
    /**
     * Metodo encargado de adicionar un nuevo Personal Salud
     * @param personalSalud
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public void adicionarPersonalSalud(PersonalSalud personalSalud) throws PersistenceNotFoundException, PersistenceException{
        boolean existe = personalSaludRepository.existePersonalSalud(personalSalud);
        if(!existe){
            personalSaludRepository.adicionarPersonalSalud(personalSalud);
        }
    }
    
    /**
     * Metodo encargado de iniciar sesión, si el usuario se ha autenticado correctamente del personal de salud
     * @param nombreUsuario
     * @param password 
     * @return  
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException  
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException  
     */
    public PersonalSalud iniciarSesionPersonalSalud(String nombreUsuario, String password) throws PersistenceNotFoundException, PersistenceException{
        return personalSaludRepository.traerPersonalSalud(nombreUsuario, password);
    }
    
    /**
     * Metodo encargado de traer todas las relaciones pendientes de los pacientes del Familiar pasado por parametro
     * @param familiar
     * @return
     * @throws PersistenceNotFoundException 
     */
    public Set<Relacion> getRelacionesPacientePendientesDesdeFamiliar(Familiar familiar) throws PersistenceNotFoundException{
        return familiarRepository.traerRelacionesPacientesDesdeFamiliar(familiar, Relacion.ESTADOPENDIENTE);
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
     * Metodo encargado de traer todas las relaciones aceptadas de los pacientes del Familiar pasado por parametro
     * @param familiar
     * @return
     * @throws PersistenceNotFoundException 
     */
    public Set<Relacion> getRelacionesPacienterAceptadasDesdeFamiliar(Familiar familiar) throws PersistenceNotFoundException{
        return familiarRepository.traerRelacionesPacientesDesdeFamiliar(familiar, Relacion.ESTADOACEPTADO);
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
     * Metodo encargado de consultar todos los familiares que existan con ese dato
     * @param dato
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public Set<Familiar> consultarFamiliares(String dato) throws PersistenceNotFoundException, PersistenceException{
        return familiarRepository.busquedaFamiliares(dato);
    }
    
    /**
     * Metodo encargado de aceptar la solicitud del paciente familiar
     * @param relacion
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void aceptarSolicitudPaciente(Relacion relacion) throws PersistenceNotFoundException, PersistenceException{
        familiarRepository.aceptarSolicitudPaciente(relacion);
    }
    
    /**
     * Metodo encargado de eliminar la solicitud del paciente familiar
     * @param relacion
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void eliminarSolicitudPaciente(Relacion relacion) throws PersistenceNotFoundException, PersistenceException{
        familiarRepository.eliminarSolicitudPaciente(relacion);
    }
   
    /**
     * Metodo encargado de adicionar la solicitud del paciente familiar
     * @param relacion
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void adicionarRelacionPacienteDesdeFamiliar(Relacion relacion) throws PersistenceNotFoundException, PersistenceException{
        boolean existe = familiarRepository.existeRelacionPacienteFamiliar(relacion);
        if(!existe){
            familiarRepository.adicionarSolicitudPacienteDesdeFamiliar(relacion);
        }
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
     * Metodo encargado de traer todas las relaciones pendientes del personal de la salud del paciente pasado por parametro
     * @param personalSalud
     * @return
     * @throws PersistenceNotFoundException 
     */
    public Set<Relacion> getRelacionesPacientePendientesDesdeSalud(PersonalSalud personalSalud) throws PersistenceNotFoundException{
        return personalSaludRepository.traerRelacionesPacientesDesdeSalud(personalSalud, Relacion.ESTADOPENDIENTE);
    }    
    /**
     * Metodo encargado de traer todas las relaciones aceptadas de los pacientes del Personal pasado por parametro
     * @param personalSalud
     * @return
     * @throws PersistenceNotFoundException 
     */
    public Set<Relacion> getRelacionesPacienterAceptadasDesdeSalud(PersonalSalud personalSalud) throws PersistenceNotFoundException{
        return personalSaludRepository.traerRelacionesPacientesDesdeSalud(personalSalud, Relacion.ESTADOACEPTADO);
    }
    
    /**
     * Metodo encargado de adicionar la solicitud del paciente familiar
     * @param relacion
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void adicionarRelacionPacienteDesdeSalud(Relacion relacion) throws PersistenceNotFoundException, PersistenceException{
        boolean existe = personalSaludRepository.existeRelacionPacienteSalud(relacion);
        if(!existe){
            personalSaludRepository.adicionarSolicitudPacienteDesdeSalud(relacion);
        }
    }
    
    
    /**
     * Metodo encargado de aceptar la solicitud del paciente personal salud
     * @param relacion
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void aceptarSolicitudPacientePersonalSalud(Relacion relacion) throws PersistenceNotFoundException, PersistenceException{
        personalSaludRepository.aceptarSolicitudPaciente(relacion);
    }
    
    /**
     * Metodo encargado de eliminar la solicitud del paciente personal Salud
     * @param relacion
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public void eliminarSolicitudPacientePersonalSalud(Relacion relacion) throws PersistenceNotFoundException, PersistenceException{
        personalSaludRepository.eliminarSolicitudPaciente(relacion);
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
    
    
    
}
