/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entrementeapi;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author Administrador
 */
@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.pgr1.entremente"})
public class EntreMenteAPI {
     public static void main(String[] args) {
         try {
             SpringApplication.run(EntreMenteAPI.class, args);
         } catch (Exception ex) {
             Logger.getLogger(EntreMenteAPI.class.getName()).log(Level.SEVERE, null, ex);
         }
         
    }
}
