/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.controllers;

import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.services.EntreMenteServices;
import edu.eci.pgr1.entremente.services.EntreMenteServicesJuegos;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JuanArevaloMerchan
 */
@RestController
@RequestMapping(value = "/entremente/V1/juegos")
public class EntreMenteControllerJuegos {
 
    @Autowired
    private EntreMenteServicesJuegos emsj = null;
    
    @RequestMapping(path = "/galeria/{idPaciente}/{nivel}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarGaleria(@PathVariable("idPaciente") int idPaciente, @PathVariable("nivel") int nivel) {
        try {
            return new ResponseEntity<>(emsj.getPreguntas(nivel, idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }    
}
