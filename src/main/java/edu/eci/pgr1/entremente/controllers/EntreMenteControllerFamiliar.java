/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.controllers;

import edu.eci.pgr1.entremente.model.Familiar;
import edu.eci.pgr1.entremente.model.Relacion;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.security.SecurityToken;
import edu.eci.pgr1.entremente.services.EntreMenteServicesFamiliar;
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
public class EntreMenteControllerFamiliar {
    @Autowired
    private EntreMenteServicesFamiliar ems = null;
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/familiares", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarFamiliar(@RequestBody Familiar familiar, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                ems.adicionarFamiliar(familiar);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }  
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/familiares", method = RequestMethod.PUT)
    public ResponseEntity<?> manejadorPUTModificarFamiliar(@RequestBody Familiar familiar, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                ems.modificarFamiliar(familiar);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }  
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/familiares/{usuario}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorIniciarFamiliar(@PathVariable("usuario") String nombreU, @PathVariable("password") String password) {
        try {
            Familiar familiar = ems.iniciarSesionFamiliar(nombreU, password);
            familiar.setToken(SecurityToken.getToken(familiar).getAccessToken());
            return new ResponseEntity<>(familiar, HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/familiares/relaciones/pacientes/pendientes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesFamliaresPacientesPendientes(@RequestBody Familiar familiar, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                return new ResponseEntity<>(ems.getRelacionesPacientePendientesDesdeFamiliar(familiar), HttpStatus.CREATED);
            } catch (PersistenceNotFoundException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            } 
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/familiares/relaciones/pacientes/aceptadas", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesFamliaresPacientesAceptadas(@RequestBody Familiar familiar, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                return new ResponseEntity<>(ems.getRelacionesPacienterAceptadasDesdeFamiliar(familiar), HttpStatus.CREATED);
            } catch (PersistenceNotFoundException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }  
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/familiares/relaciones/pacientes", method = RequestMethod.PUT)
    public ResponseEntity<?> manejadorRelacionesFamliaresPacientesAceptadar(@RequestBody Relacion relacion, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                ems.aceptarSolicitudPaciente(relacion);
                return new ResponseEntity<>("Se ha aceptado la solicitud!", HttpStatus.CREATED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }    
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/familiares/relaciones/pacientes", method = RequestMethod.DELETE)
    public ResponseEntity<?> manejadorRelacionesFamliaresPacientesEliminar(@RequestBody Relacion relacion, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                ems.eliminarSolicitudPaciente(relacion);
                return new ResponseEntity<>("Se ha eliminado la solicitud!", HttpStatus.CREATED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }   
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/familiares/relaciones/pacientes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorRelacionesFamliaresPacientesAdicionar(@RequestBody Relacion relacion, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                ems.adicionarRelacionPacienteDesdeFamiliar(relacion);
                return new ResponseEntity<>("Se ha enviado la solicitud!", HttpStatus.CREATED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }    
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/familiares/{dato}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarFamliares(@PathVariable("dato") String dato, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                return new ResponseEntity<>(ems.consultarFamiliares(dato), HttpStatus.ACCEPTED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }
        }
    }
}
