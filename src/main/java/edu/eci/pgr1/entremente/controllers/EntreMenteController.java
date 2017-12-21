/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.controllers;

import edu.eci.pgr1.entremente.model.Familiar;
import edu.eci.pgr1.entremente.model.Paciente;
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
    
 
    
}
