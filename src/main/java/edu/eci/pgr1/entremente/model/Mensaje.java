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
public class Mensaje {
    public static final String SIPUEDEVERPACIENTE = "S";
    public static final String NOPUEDEVERPACIENTE = "N";
    private int id;
    private String idPaciente;
    private String idPersonalSalud;
    private String idFamiliar;
    private String fecha;
    private String mensaje;
    private String tipo;
    private String rol;
    private String puedeVerPac;
    private String nombreRemitente;
    private String checkBox;
    
    /**
     * Constructor Vacio
     */
    public Mensaje(){
        
    }
    /**.
     * Constructor con datos
     * @param id
     * @param idPaciente
     * @param idPersonalSalud
     * @param idFamiliar
     * @param fecha
     * @param mensaje
     * @param tipo
     * @param rol
     * @param puedeVerPac
     * @param nombreRemitente
     * @param checkBox
     */
    public Mensaje(int id, String idPaciente, String idPersonalSalud, String idFamiliar, String fecha, String mensaje, String tipo, String rol, String puedeVerPac, String nombreRemitente, String checkBox){
        this.id = id;
        this.idPaciente = idPaciente;
        this.idPersonalSalud = idPersonalSalud;
        this.idFamiliar = idFamiliar;
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.rol = rol;
        this.puedeVerPac = puedeVerPac;
        this.nombreRemitente = nombreRemitente;
        this.checkBox = checkBox;
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
     * @return the idFamiliar
     */
    public String getIdFamiliar() {
        return idFamiliar;
    }

    /**
     * @param idFamiliar the idFamiliar to set
     */
    public void setIdFamiliar(String idFamiliar) {
        this.idFamiliar = idFamiliar;
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
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * @return the puedeVerPac
     */
    public String getPuedeVerPac() {
        return puedeVerPac;
    }

    /**
     * @param puedeVerPac the puedeVerPac to set
     */
    public void setPuedeVerPac(String puedeVerPac) {
        this.puedeVerPac = puedeVerPac;
    }

    /**
     * @return the nombreRemitente
     */
    public String getNombreRemitente() {
        return nombreRemitente;
    }

    /**
     * @param nombreRemitente the nombreRemitente to set
     */
    public void setNombreRemitente(String nombreRemitente) {
        this.nombreRemitente = nombreRemitente;
    }

    /**
     * @return the checkBox
     */
    public String getCheckBox() {
        return checkBox;
    }

    /**
     * @param checkBox the checkBox to set
     */
    public void setCheckBox(String checkBox) {
        this.checkBox = checkBox;
    }
    
    
}
