/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.services;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.persistence.PacienteRepository;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
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
    public Paciente iniciarSesion(String nombreUsuario, String password) throws PersistenceNotFoundException, PersistenceException{
        return pacienteRepository.traerPaciente(nombreUsuario, password);
    }
    
    
    
    
}
