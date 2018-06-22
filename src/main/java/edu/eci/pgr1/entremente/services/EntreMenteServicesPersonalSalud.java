/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.services;

import edu.eci.pgr1.entremente.model.PersonalSalud;
import edu.eci.pgr1.entremente.model.Relacion;
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
public class EntreMenteServicesPersonalSalud {
    
    
    @Autowired
    private PersonalSaludRepository personalSaludRepository;
    
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
     * Metodo encargado de modificar un Personal Salud
     * @param personalSalud
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public void modificarPersonalSalud(PersonalSalud personalSalud) throws PersistenceNotFoundException, PersistenceException{
        personalSaludRepository.modificarPersonalSalud(personalSalud);
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
     * Metodo encargado de consultar todos los Personales de salud que existan con ese dato
     * @param dato
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public Set<PersonalSalud> consultarSalud(String dato) throws PersistenceNotFoundException, PersistenceException{
        return personalSaludRepository.busquedaPersonalSalud(dato);
    }
    
}
