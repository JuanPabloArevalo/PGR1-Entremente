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
    private Enfermedad enfermedad;
    private String fecha;
    private String rol;
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
     */
    public HistorialMedico(int id, String idPaciente, String nombresPaciente, String idPersonalSalud, String nombresPersonalSalud, Enfermedad enfermedad){
        this.id = id;
        this.idPaciente = idPaciente;
        this.nombresPaciente = nombresPaciente;
        this.idPersonalSalud = idPersonalSalud;
        this.nombresPersonalSalud = nombresPersonalSalud;
        this.enfermedad = enfermedad;   
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
     * @return the enfermedad
     */
    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    /**
     * @param enfermedad the enfermedad to set
     */
    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
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
    
    
}
