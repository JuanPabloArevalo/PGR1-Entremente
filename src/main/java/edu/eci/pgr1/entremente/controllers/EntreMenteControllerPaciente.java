/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.controllers;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.Relacion;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.security.SecurityToken;
import edu.eci.pgr1.entremente.services.EntreMenteServicesPaciente;
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
public class EntreMenteControllerPaciente {
    @Autowired
    private EntreMenteServicesPaciente ems = null;
    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/pacientes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarPaciente(@RequestBody Paciente paciente, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                ems.adicionarPaciente(paciente);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            } 
        }         
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/pacientes", method = RequestMethod.PUT)
    public ResponseEntity<?> manejadorPUTModificarPaciente(@RequestBody Paciente paciente, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                ems.modificarPaciente(paciente);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }    
        }
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/pacientes/{usuario}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorIniciarPaciente(@PathVariable("usuario") String nombreU, @PathVariable("password") String password) {
        System.err.println("EENTRO INICIAR SESION");
        try {
            Paciente paciente = ems.iniciarSesionPaciente(nombreU, password);
            paciente.setToken(SecurityToken.getToken(paciente).getAccessToken());
            return new ResponseEntity<>(paciente, HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/pacientes/{dato}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorIniciarPaciente2(@PathVariable("dato") String dato, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                return new ResponseEntity<>(ems.consultarPacientes(dato), HttpStatus.ACCEPTED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/pacientes/progresos/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarProgresoPaciente(@PathVariable("idPaciente") int idPaciente, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                return new ResponseEntity<>(ems.traerProgresoPaciente(idPaciente), HttpStatus.ACCEPTED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/pacientes/relaciones/familiares/pendientes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesPendientesFamiliaresDesdePaciente(@RequestBody Paciente paciente, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                return new ResponseEntity<>(ems.getRelacionesPacientePendientesDesdePaciente(paciente), HttpStatus.CREATED);
            } catch (PersistenceNotFoundException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }   
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/pacientes/relaciones/familiares/aceptadas", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesAceptadasFamiliaresDesdePaciente(@RequestBody Paciente paciente, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                return new ResponseEntity<>(ems.getRelacionesPacienterAceptadasDesdePaciente(paciente), HttpStatus.CREATED);
            } catch (PersistenceNotFoundException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }  
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/pacientes/relaciones/familiares", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorRelacionesAdicionarRelacionDesdePaciente(@RequestBody Relacion relacion, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                ems.adicionarRelacionPacienteDesdePaciente(relacion);
                return new ResponseEntity<>("Se ha enviado la solicitud!", HttpStatus.CREATED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            } 
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/pacientes/relaciones/personalSalud", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorRelacionesAdicionarRelacionDesdePacienteSalud(@RequestBody Relacion relacion, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                ems.adicionarRelacionSaludDesdePaciente(relacion);
                return new ResponseEntity<>("Se ha enviado la solicitud!", HttpStatus.CREATED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            } 
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/pacientes/relaciones/personalSalud/pendientes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesPendientesSaludDesdePaciente(@RequestBody Paciente paciente, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                return new ResponseEntity<>(ems.getRelacionesSaludPendientesDesdePaciente(paciente), HttpStatus.CREATED);
            } catch (PersistenceNotFoundException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }   
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/pacientes/relaciones/personalSalud/aceptadas", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesAceptadasSaludDesdePaciente(@RequestBody Paciente paciente, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                return new ResponseEntity<>(ems.getRelacionesSaludAceptadasDesdePaciente(paciente), HttpStatus.CREATED);
            } catch (PersistenceNotFoundException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }  
        }
    }
}
