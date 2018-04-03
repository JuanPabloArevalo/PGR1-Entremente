/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.controllers;

import edu.eci.pgr1.entremente.model.PersonalSalud;
import edu.eci.pgr1.entremente.model.Relacion;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.security.SecurityToken;
import edu.eci.pgr1.entremente.security.Sha1;
import edu.eci.pgr1.entremente.services.EntreMenteServicesPersonalSalud;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrador
 */
@RestController
@RequestMapping(value = "/entremente/V1")
public class EntreMenteControllerPersonalSalud {
    
    @Autowired
    private EntreMenteServicesPersonalSalud ems = null;
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/personalSalud", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarPersonalSalud(@RequestBody PersonalSalud personalSalud) {
        personalSalud.setPassword(Sha1.sha1(personalSalud.getPassword()));
        try {
            ems.adicionarPersonalSalud(personalSalud);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }     
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/personalSalud", method = RequestMethod.PUT)
    public ResponseEntity<?> manejadorPUTModificarPersonalSalud(@RequestBody PersonalSalud personalSalud, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                ems.modificarPersonalSalud(personalSalud);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }    
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/personalSalud/{usuario}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorIniciarPersonalSalud(@PathVariable("usuario") String nombreU, @PathVariable("password") String password) {
        try {
            PersonalSalud personalSalud = ems.iniciarSesionPersonalSalud(nombreU, Sha1.sha1(password));
            personalSalud.setToken(SecurityToken.getToken(personalSalud).getAccessToken());
            return new ResponseEntity<>(personalSalud, HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }   
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/personalSalud/relaciones/pacientes/pendientes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesSaludPacientesPendientes(@RequestBody PersonalSalud personalSalud, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                return new ResponseEntity<>(ems.getRelacionesPacientePendientesDesdeSalud(personalSalud), HttpStatus.CREATED);
            } catch (PersistenceNotFoundException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }    
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/personalSalud/relaciones/pacientes/aceptadas", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesSaludPacientesAceptadas(@RequestBody PersonalSalud personalSalud, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                return new ResponseEntity<>(ems.getRelacionesPacienterAceptadasDesdeSalud(personalSalud), HttpStatus.CREATED);
            } catch (PersistenceNotFoundException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }  
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/personalSalud/relaciones/pacientes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorRelacionesSaludPacientesAdicionar(@RequestBody Relacion relacion, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                ems.adicionarRelacionPacienteDesdeSalud(relacion);
                return new ResponseEntity<>("Se ha enviado la solicitud!", HttpStatus.CREATED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }    
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/personalSalud/relaciones/pacientes", method = RequestMethod.PUT)
    public ResponseEntity<?> manejadorRelacionesSaludPacientesAceptadar(@RequestBody Relacion relacion, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                ems.aceptarSolicitudPacientePersonalSalud(relacion);
                return new ResponseEntity<>("Se ha aceptado la solicitud!", HttpStatus.CREATED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            } 
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/personalSalud/relaciones/pacientes", method = RequestMethod.DELETE)
    public ResponseEntity<?> manejadorRelacionesSaludPacientesEliminar(@RequestBody Relacion relacion, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                ems.eliminarSolicitudPacientePersonalSalud(relacion);
                return new ResponseEntity<>("Se ha eliminado la solicitud!", HttpStatus.CREATED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }  
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/personalSalud/{dato}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarSalud(@PathVariable("dato") String dato, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                return new ResponseEntity<>(ems.consultarSalud(dato), HttpStatus.ACCEPTED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }
        }
    }
    
}
