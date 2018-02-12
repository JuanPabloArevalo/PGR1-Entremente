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
public class Resultado {
    public static final String TIPOJUEGOGALERIA = "G";
    public static final String TIPOJUEGOATENCION = "A";
    public static final String TIPOJUEGOFORMAS = "F";
    public static final String TIPOJUEGOCALCULEMOS = "C";
    public static final String TIPOJUEGOPERCEPCION = "P";
    public static final String TIPOJUEGOMUSICOTERAPIA = "M";
    public static final String TIPOJUEGORUTINA = "R";
    public static final String TIPOJUEGOGRUPOFAMILIAR = "X";
    
    private int id;
    private String tipoJuego;
    private String idPaciente;
    private String fecha;
    private int acertadas;
    private int erroneas;
    private double tiempo;
    private int nivelMaximo;

    /**
     * Constructor Vacio
     */
    public Resultado(){
        
    }
    /**
     * Constructor con datos
     * @param tipoJuego
     * @param idPaciente
     * @param fecha
     * @param acertadas
     * @param erroneas
     * @param tiempo
     * @param nivelMaximo 
     */
    public Resultado(String tipoJuego, String idPaciente, String fecha, int acertadas, int erroneas, double tiempo, int nivelMaximo){
        this.tipoJuego = tipoJuego;
        this.idPaciente = idPaciente;
        this.fecha = fecha;
        this.acertadas = acertadas;
        this.erroneas = erroneas;
        this.tiempo = tiempo;
        this.nivelMaximo = nivelMaximo;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tipoJuego
     */
    public String getTipoJuego() {
        return tipoJuego;
    }

    /**
     * @param tipoJuego the tipoJuego to set
     */
    public void setTipoJuego(String tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    /**
     * @return the idPaciente
     */
    public String getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the acertadas
     */
    public int getAcertadas() {
        return acertadas;
    }

    /**
     * @param acertadas the acertadas to set
     */
    public void setAcertadas(int acertadas) {
        this.acertadas = acertadas;
    }

    /**
     * @return the erroneas
     */
    public int getErroneas() {
        return erroneas;
    }

    /**
     * @param erroneas the erroneas to set
     */
    public void setErroneas(int erroneas) {
        this.erroneas = erroneas;
    }

    /**
     * @return the tiempo
     */
    public double getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * @return the nivelMaximo
     */
    public int getNivelMaximo() {
        return nivelMaximo;
    }

    /**
     * @param nivelMaximo the nivelMaximo to set
     */
    public void setNivelMaximo(int nivelMaximo) {
        this.nivelMaximo = nivelMaximo;
    }
    
    
}
