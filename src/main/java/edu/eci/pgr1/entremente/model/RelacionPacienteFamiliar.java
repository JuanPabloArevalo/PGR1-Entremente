/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.model;

/**
 *
 * @author Administrador
 */
public class RelacionPacienteFamiliar {
    public static final String ESTADOPENDIENTE = "P";
    public static final String ESTADOACEPTADO = "A";
    private int id;
    private int idPaciente;
    private String nombresPaciente;
    private String apellidosPaciente;
    private int idFamiliar;
    private String nombresFamiliar;
    private String apellidosFamiliar;
    private String estado;
    private String relacion;

    /**
     * Constructor 1
     */
    public RelacionPacienteFamiliar(){
        
    }
    
    /**
     * Constructor 2
     * @param id
     * @param idPaciente
     * @param nombresPaciente
     * @param apellidosPaciente
     * @param idFamiliar
     * @param nombresFamiliar
     * @param apellidosFamiliar
     * @param estado
     * @param relacion 
     */
    public RelacionPacienteFamiliar(int id, int idPaciente, String nombresPaciente, String apellidosPaciente, int idFamiliar, String nombresFamiliar, String apellidosFamiliar, String estado, String relacion){
        this.id = id;
        this.idPaciente = idPaciente;
        this.nombresPaciente = nombresPaciente;
        this.apellidosPaciente = apellidosPaciente;
        this.idFamiliar = idFamiliar;
        this.nombresFamiliar = nombresFamiliar; 
        this.apellidosFamiliar = apellidosFamiliar;
        this.estado = estado;
        this.relacion = relacion;
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
     * @return the idPaciente
     */
    public int getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * @return the nombresPaciente
     */
    public String getNombresPaciente() {
        return nombresPaciente;
    }

    /**
     * @param nombresPaciente the nombresPaciente to set
     */
    public void setNombresPaciente(String nombresPaciente) {
        this.nombresPaciente = nombresPaciente;
    }

    /**
     * @return the apellidosPaciente
     */
    public String getApellidosPaciente() {
        return apellidosPaciente;
    }

    /**
     * @param apellidosPaciente the apellidosPaciente to set
     */
    public void setApellidosPaciente(String apellidosPaciente) {
        this.apellidosPaciente = apellidosPaciente;
    }

    /**
     * @return the idFamiliar
     */
    public int getIdFamiliar() {
        return idFamiliar;
    }

    /**
     * @param idFamiliar the idFamiliar to set
     */
    public void setIdFamiliar(int idFamiliar) {
        this.idFamiliar = idFamiliar;
    }

    /**
     * @return the nombresFamiliar
     */
    public String getNombresFamiliar() {
        return nombresFamiliar;
    }

    /**
     * @param nombresFamiliar the nombresFamiliar to set
     */
    public void setNombresFamiliar(String nombresFamiliar) {
        this.nombresFamiliar = nombresFamiliar;
    }

    /**
     * @return the apellidosFamiliar
     */
    public String getApellidosFamiliar() {
        return apellidosFamiliar;
    }

    /**
     * @param apellidosFamiliar the apellidosFamiliar to set
     */
    public void setApellidosFamiliar(String apellidosFamiliar) {
        this.apellidosFamiliar = apellidosFamiliar;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the relacion
     */
    public String getRelacion() {
        return relacion;
    }

    /**
     * @param relacion the relacion to set
     */
    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }
    
    
}
