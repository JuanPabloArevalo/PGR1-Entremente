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
public class Enfermedad {
    
    private int id;
    private String nombre;
    private String codigo;
    
    /**
     * Constructor vacio
     */
    public Enfermedad(){
        
    }
    
    /**
     * Constructor con datos
     * @param id
     * @param nombre
     * @param codigo 
     */
    public Enfermedad(int id, String nombre, String codigo){
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
}
