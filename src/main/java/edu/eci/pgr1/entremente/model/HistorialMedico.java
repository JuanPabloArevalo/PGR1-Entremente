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
public class HistorialMedico {
    private int id;
    private String idPaciente;
    private String nombresPaciente;
    private String idPersonalSalud;
    private String nombresPersonalSalud;
    private String idEnferemedad;
    private String nombreEnfermedad;
    private String codigoEnfermedad;

    /**
     * Constructor Vacio
     */
    public HistorialMedico(){
        
    }
    
    /**
     * Constructor con datos
     * @param id
     * @param idPaciente
     * @param nombresPaciente
     * @param idPersonalSalud
     * @param nombresPersonalSalud
     * @param idEnferemedad
     * @param nombreEnfermedad
     * @param codigoEnfermedad 
     */
    public HistorialMedico(int id, String idPaciente, String nombresPaciente, String idPersonalSalud, String nombresPersonalSalud, String idEnferemedad, String nombreEnfermedad, String codigoEnfermedad){
        this.id = id;
        this.idPaciente = idPaciente;
        this.nombresPaciente = nombresPaciente;
        this.idPersonalSalud = idPersonalSalud;
        this.nombresPersonalSalud = nombresPersonalSalud;
        this.idEnferemedad = idEnferemedad;
        this.nombreEnfermedad = nombreEnfermedad;
        this.codigoEnfermedad = codigoEnfermedad;   
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
     * @return the idPersonalSalud
     */
    public String getIdPersonalSalud() {
        return idPersonalSalud;
    }

    /**
     * @param idPersonalSalud the idPersonalSalud to set
     */
    public void setIdPersonalSalud(String idPersonalSalud) {
        this.idPersonalSalud = idPersonalSalud;
    }

    /**
     * @return the nombresPersonalSalud
     */
    public String getNombresPersonalSalud() {
        return nombresPersonalSalud;
    }

    /**
     * @param nombresPersonalSalud the nombresPersonalSalud to set
     */
    public void setNombresPersonalSalud(String nombresPersonalSalud) {
        this.nombresPersonalSalud = nombresPersonalSalud;
    }

    /**
     * @return the idEnferemedad
     */
    public String getIdEnferemedad() {
        return idEnferemedad;
    }

    /**
     * @param idEnferemedad the idEnferemedad to set
     */
    public void setIdEnferemedad(String idEnferemedad) {
        this.idEnferemedad = idEnferemedad;
    }

    /**
     * @return the nombreEnfermedad
     */
    public String getNombreEnfermedad() {
        return nombreEnfermedad;
    }

    /**
     * @param nombreEnfermedad the nombreEnfermedad to set
     */
    public void setNombreEnfermedad(String nombreEnfermedad) {
        this.nombreEnfermedad = nombreEnfermedad;
    }

    /**
     * @return the codigoEnfermedad
     */
    public String getCodigoEnfermedad() {
        return codigoEnfermedad;
    }

    /**
     * @param codigoEnfermedad the codigoEnfermedad to set
     */
    public void setCodigoEnfermedad(String codigoEnfermedad) {
        this.codigoEnfermedad = codigoEnfermedad;
    }
    
    
    
}
