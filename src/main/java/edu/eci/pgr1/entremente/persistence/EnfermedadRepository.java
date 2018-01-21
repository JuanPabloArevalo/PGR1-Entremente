/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence;

import edu.eci.pgr1.entremente.model.Enfermedad;
import java.util.ArrayList;

/**
 *
 * @author JuanArevaloMerchan
 */
public interface EnfermedadRepository {
    /**
     * Metodo encargado de cargar todas las enfermedades
     * @return 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException 
     */
    public ArrayList<Enfermedad> cargarEnfermedades() throws PersistenceNotFoundException;
}
