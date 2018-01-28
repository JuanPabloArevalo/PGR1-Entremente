/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.juegos;


import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.Resultado;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import java.util.ArrayList;

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
    
    /**
     * Metodo encargado de traer los resultados, ordenados por dias.
     * @param paciente
     * @param fechaInicial
     * @param fechaFinal
     * @param tipoJuego
     * @return
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public ArrayList<Resultado> traerResultadosDias(Paciente paciente, String fechaInicial, String fechaFinal, String tipoJuego) throws PersistenceNotFoundException, PersistenceException;
    
    /**
     * Metodo encargado de traer los resultados, ordenados por dias.
     * @param paciente
     * @param fechaInicial
     * @param fechaFinal
     * @param tipoJuego
     * @return
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public ArrayList<Resultado> traerResultadosMeses(Paciente paciente, String fechaInicial, String fechaFinal, String tipoJuego) throws PersistenceNotFoundException, PersistenceException;
    
    /**
     * Metodo encargado de traer los resultados, ordenados por dias.
     * @param paciente
     * @param fechaInicial
     * @param fechaFinal
     * @param tipoJuego
     * @return
     * @throws PersistenceNotFoundException
     * @throws PersistenceException 
     */
    public ArrayList<Resultado> traerResultadosAnios(Paciente paciente, String fechaInicial, String fechaFinal, String tipoJuego) throws PersistenceNotFoundException, PersistenceException;
            
    
    
}
