/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.model;

import java.util.HashSet;

/**
 *
 * @author Juan Pablo Arévalo
 */
public class PreguntaCalculo {
    private String operacion;
    private HashSet<Respuesta> respuestas = new HashSet<>();

    /**
     * Contructor vacio
     */
    public PreguntaCalculo(){}
    
    /**
     * Constructor 2
     * @param operacion
     * @param respuestas 
     */
    public PreguntaCalculo(String operacion, HashSet<Respuesta> respuestas){
        this.operacion = operacion;
        this.respuestas = respuestas;
    }
    
    /**
     * @return the operacion
     */
    public String getOperacion() {
        return operacion;
    }

    /**
     * @param operacion the operacion to set
     */
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    /**
     * @return the respuestas
     */
    public HashSet<Respuesta> getRespuestas() {
        return respuestas;
    }

    /**
     * @param respuestas the respuestas to set
     */
    public void setRespuestas(HashSet<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
    
    /**
     * Metodo encargado de adiconar una nueva respuesta
     * @param respuesta 
     */
    public void adicionarRespuesta(Respuesta respuesta){
        this.respuestas.add(respuesta);
    }
    
}
