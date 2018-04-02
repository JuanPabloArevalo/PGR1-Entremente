/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.controllers;

import edu.eci.pgr1.entremente.model.HistorialMedico;
import edu.eci.pgr1.entremente.model.Mensaje;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.security.SecurityToken;
import edu.eci.pgr1.entremente.security.Token;
import edu.eci.pgr1.entremente.services.EntreMenteServices;
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
 * @author Juan Pablo Arévalo
 */
@RestController
@RequestMapping(value = "/entremente/V1")
public class EntreMenteController {
    
    @Autowired
    private EntreMenteServices ems = null;
    
    
//MENSAJES   
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/mensajes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorMensajesAdicionar(@RequestBody Mensaje mensaje, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                ems.adicionarMensaje(mensaje);
                return new ResponseEntity<>("Se ha enviado el mensaje", HttpStatus.CREATED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }    
        }
    }
    
    
//MENSAJES    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/mensajes/", method = RequestMethod.DELETE)
    public ResponseEntity<?> manejadorMensajesEliminar(@RequestBody Mensaje mensaje, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                ems.eliminarMensaje(mensaje);
                return new ResponseEntity<>("Se ha eliminado el mensaje!", HttpStatus.CREATED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }    
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/mensajes/pacientes/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarMensajes(@PathVariable("idPaciente") int idPaciente, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                return new ResponseEntity<>(ems.consultarMensajesPaciente(idPaciente), HttpStatus.ACCEPTED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/mensajes/otros/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarTodosMensajes(@PathVariable("idPaciente") int idPaciente, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                return new ResponseEntity<>(ems.consultarTodosMensajes(idPaciente), HttpStatus.ACCEPTED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }
        }
    }
    
    
//Historial Médico 
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/historialMedico", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorHisotrialMedicoAdicionar(@RequestBody HistorialMedico historialMedico, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                ems.adicionarHistorialMedico(historialMedico);
                return new ResponseEntity<>("Se ha adicionado la enfermedad al historial médico del paciente", HttpStatus.CREATED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }    
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/historialMedico", method = RequestMethod.DELETE)
    public ResponseEntity<?> manejadorHistorialMedicoEliminar(@RequestBody HistorialMedico historialMedico, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                ems.eliminarHistorialMedico(historialMedico);
                return new ResponseEntity<>("Se ha eliminado la enfermedad del historial médico del paciente!", HttpStatus.CREATED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }    
        }
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/historialMedico/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarHistorialMedico(@PathVariable("idPaciente") int idPaciente, @RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                return new ResponseEntity<>(ems.consultarHistorialMedicoPaciente(idPaciente), HttpStatus.ACCEPTED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }
        }
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/enfermedades", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorEnfermedadesCargar(@RequestHeader(value=SecurityToken.TOKEN_HEADER, required = false) String token) {
        if(!SecurityToken.isTokenValid(token)){
            return new ResponseEntity<>(SecurityToken.NOT_AUTHORIZED_MESSAGE,HttpStatus.UNAUTHORIZED);
        }
        else{
            try {
                return new ResponseEntity<>(ems.consultarEnfermedades(), HttpStatus.ACCEPTED);
            } catch (PersistenceNotFoundException | PersistenceException ex) {
                Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }
        }
    }
    
    
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/invitado", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorIniciarInvitado() {
        return new ResponseEntity<>(new Token(SecurityToken.getToken().getAccessToken()), HttpStatus.ACCEPTED);
    }
}
