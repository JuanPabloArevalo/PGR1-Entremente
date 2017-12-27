/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.controllers;

import edu.eci.pgr1.entremente.model.Familiar;
import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.PersonalSalud;
import edu.eci.pgr1.entremente.model.RelacionPacienteFamiliar;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.services.EntreMenteServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan Pablo Arévalo
 */
@RestController
@RequestMapping(value = "/entremente/V1")
public class EntreMenteController {
    
    @Autowired
    private EntreMenteServices ems = null;
    
    
///PACIENTE    
    @RequestMapping(path = "/pacientes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarPaciente(@RequestBody Paciente paciente) {
        try {
            ems.adicionarPaciente(paciente);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    
    
    @RequestMapping(path = "/pacientes/{usuario}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorIniciarPaciente(@PathVariable("usuario") String nombreU, @PathVariable("password") String password) {
        try {
            return new ResponseEntity<>(ems.iniciarSesionPaciente(nombreU, password), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(path = "/pacientes/{dato}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorIniciarPaciente(@PathVariable("dato") String dato) {
        try {
            return new ResponseEntity<>(ems.consultarPacientes(dato), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    

//FAMILIARES    
    @RequestMapping(path = "/familiares", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarFamiliar(@RequestBody Familiar familiar) {
        try {
            ems.adicionarFamiliar(familiar);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/familiares/{usuario}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorIniciarFamiliar(@PathVariable("usuario") String nombreU, @PathVariable("password") String password) {
        try {
            return new ResponseEntity<>(ems.iniciarSesionFamiliar(nombreU, password), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(path = "/familiares/relaciones/pacientes/pendientes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesFamliaresPacientesPendientes(@RequestBody Familiar familiar) {
        try {
            return new ResponseEntity<>(ems.getRelacionesPacientePendientesDesdeFamiliar(familiar), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/familiares/relaciones/pacientes/aceptadas", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesFamliaresPacientesAceptadas(@RequestBody Familiar familiar) {
        try {
            return new ResponseEntity<>(ems.getRelacionesPacienterAceptadasDesdeFamiliar(familiar), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/familiares/relaciones/pacientes", method = RequestMethod.PUT)
    public ResponseEntity<?> manejadorRelacionesFamliaresPacientesAceptadar(@RequestBody RelacionPacienteFamiliar relacion) {
        try {
            ems.aceptarSolicitudPaciente(relacion);
            return new ResponseEntity<>("Se ha aceptado la solicitud!", HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }    
    }
    
    @RequestMapping(path = "/familiares/relaciones/pacientes", method = RequestMethod.DELETE)
    public ResponseEntity<?> manejadorRelacionesFamliaresPacientesEliminar(@RequestBody RelacionPacienteFamiliar relacion) {
        try {
            ems.eliminarSolicitudPaciente(relacion);
            return new ResponseEntity<>("Se ha eliminado la solicitud!", HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }    
    }
    
    @RequestMapping(path = "/familiares/relaciones/pacientes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorRelacionesFamliaresPacientesAdicionar(@RequestBody RelacionPacienteFamiliar relacion) {
        try {
            ems.adicionarRelacionPacienteDesdeFamiliar(relacion);
            return new ResponseEntity<>("Se ha enviado la solicitud!", HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }    
    }
    
//PERSONAL SALUD 
    @RequestMapping(path = "/personalSalud", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarPersonalSalud(@RequestBody PersonalSalud personalSalud) {
        try {
            ems.adicionarPersonalSalud(personalSalud);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    
    
    @RequestMapping(path = "/personalSalud/{usuario}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorIniciarPersonalSalud(@PathVariable("usuario") String nombreU, @PathVariable("password") String password) {
        try {
            return new ResponseEntity<>(ems.iniciarSesionPersonalSalud(nombreU, password), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }    
}
