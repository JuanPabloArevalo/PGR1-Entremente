/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.model;

/**
 *
 * @author JuanArevaloMerchan
 */
public class Progreso {
    public static final int PREGUNTAS_ACERTADAS_POR_NIVEL = 20;
    private int porcentaje;
    private int nivel;
    private int preguntasAcertadas;
    
    
    /**
     * COnstructor 
     */
    public Progreso(){
    }
    
    /**
     * Constructor
     * @param porcentaje
     * @param nivel
     * @param preguntasAcertadas 
     */
    public Progreso(int porcentaje, int nivel, int preguntasAcertadas){
        this.porcentaje = porcentaje;
        this.nivel = nivel;
        this.preguntasAcertadas = preguntasAcertadas;
    }

    /**
     * @return the porcentaje
     */
    public int getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the preguntasAcertadas
     */
    public int getPreguntasAcertadas() {
        return preguntasAcertadas;
    }

    /**
     * @param preguntasAcertadas the preguntasAcertadas to set
     */
    public void setPreguntasAcertadas(int preguntasAcertadas) {
        this.preguntasAcertadas = preguntasAcertadas;
    }
    
    /**
     * Metodo encargado de calcular el nivel en el que va el paciente
     */
    private void calcularNivel(){
        this.nivel = preguntasAcertadas/PREGUNTAS_ACERTADAS_POR_NIVEL;
    }
    
    /**
     * Metodo encargado de calcular el porcentaje
     */
    private void calcularPorcentaje(){
        this.porcentaje = preguntasAcertadas - (nivel*PREGUNTAS_ACERTADAS_POR_NIVEL);
        this.porcentaje = (porcentaje * 100)/PREGUNTAS_ACERTADAS_POR_NIVEL;
    }
    
    /**
     * MEtodo encargado de calcular todo
     */
    public void calcularTodo(){
        calcularNivel();
        calcularPorcentaje();
    }
}
