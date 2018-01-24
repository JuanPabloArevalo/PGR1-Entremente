/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.controllers;

import edu.eci.pgr1.entremente.model.Resultado;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.services.EntreMenteServicesJuegos;
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
 * @author JuanArevaloMerchan
 */
@RestController
@RequestMapping(value = "/entremente/V1/juegos")
public class EntreMenteControllerJuegos {
 
    @Autowired
    private EntreMenteServicesJuegos emsj = null;
    
    @RequestMapping(path = "/galeria/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarGaleria(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getPreguntasGaleria(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }    
    
    @RequestMapping(path = "/atencion/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarAtencion(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getPreguntasAtencion(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }  
    
    @RequestMapping(path = "/formas/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarFormas(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getPreguntasFormas(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }  
    
    @RequestMapping(path = "/calculo/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarCalculo(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getPreguntasCalculo(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    } 
    
    @RequestMapping(path = "/percepcion/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarPercepcion(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getPreguntasPercepcion(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    } 
    
    
    
    @RequestMapping(path = "/resultados/atencion", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarResultadoAtencion(@RequestBody Resultado resultado) {
        try {
            emsj.adicionarResultadoAtencion(resultado);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/resultados/calculo", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarResultadoCalculo(@RequestBody Resultado resultado) {
        try {
            emsj.adicionarResultadoCalculemos(resultado);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/resultados/formas", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarResultadoFormas(@RequestBody Resultado resultado) {
        try {
            emsj.adicionarResultadoFormas(resultado);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/resultados/galeria", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarResultadoGaleria(@RequestBody Resultado resultado) {
        try {
            emsj.adicionarResultadoGaleria(resultado);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/resultados/musicoterapia", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarResultadoMusicoTerapia(@RequestBody Resultado resultado) {
        try {
            emsj.adicionarResultadoMusicoterapia(resultado);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/resultados/percepcion", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarResultadoPercepcion(@RequestBody Resultado resultado) {
        try {
            emsj.adicionarResultadoPercepcion(resultado);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/resultados/rutinas", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarResultadoRutinas(@RequestBody Resultado resultado) {
        try {
            emsj.adicionarResultadoRutinas(resultado);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
}
