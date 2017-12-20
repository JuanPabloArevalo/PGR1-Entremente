/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.controllers;

import edu.eci.pgr1.entremente.model.Usuario;
import edu.eci.pgr1.entremente.services.EntreMenteServices;
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
    
    @RequestMapping(path = "/usuarios", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarUsuario(@RequestBody Usuario usuario) {
//        try {
//            sws.addUsuarios(usuario);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (PersistenceNotFoundException ex) {
//            Logger.getLogger(SharingweatherAPIController.class.getName()).log(Level.SEVERE, null, ex);
            
//        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
    
    
}
