/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.controllers;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.services.EntreMenteServices;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import edu.eci.pgr1.entremente.services.EntreMenteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> manejadorPostAdicionarUsuario(@RequestBody Paciente paciente) {
        try {
            ems.adicionarPaciente(paciente);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
 
    
}
