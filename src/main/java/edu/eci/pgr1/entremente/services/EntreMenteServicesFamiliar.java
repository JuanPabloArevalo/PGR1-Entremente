/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.services;

import edu.eci.pgr1.entremente.model.Familiar;
import edu.eci.pgr1.entremente.model.Relacion;
import edu.eci.pgr1.entremente.persistence.FamiliarRepository;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class EntreMenteServicesFamiliar {
    
    @Autowired
    private FamiliarRepository familiarRepository;
    
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
     * Metodo encargado de modificar un familiar
     * @param familiar
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public void modificarFamiliar(Familiar familiar) throws PersistenceNotFoundException, PersistenceException{
        familiarRepository.modificarFamiliar(familiar);
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
     * Metodo encargado de traer todas las relaciones pendientes de los pacientes del Familiar pasado por parametro
     * @param familiar
     * @return
     * @throws PersistenceNotFoundException 
     */
    public Set<Relacion> getRelacionesPacientePendientesDesdeFamiliar(Familiar familiar) throws PersistenceNotFoundException{
        return familiarRepository.traerRelacionesPacientesDesdeFamiliar(familiar, Relacion.ESTADOPENDIENTE);
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
}
