/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence;


import edu.eci.pgr1.entremente.model.Resultado;

/**
 *
 * @author JuanArevaloMerchan
 */
public interface ResultadoRepository {
    /**
     * Metodo encargado de adicionar un nuevo resultado
     * @param resultado
     * @throws PersistenceNotFoundException 
     */
    public void adicionarResultado(Resultado resultado) throws PersistenceNotFoundException;
}
