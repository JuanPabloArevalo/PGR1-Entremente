/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.model;

/**
 *
 * @author Juan Pablo Arévalo M.
 */
public class Familiar {
    
    private Integer id;
    private String nombres;
    private String apellidos;
    private String documentoIdentidad;
    private String nombreUsuario;
    private String password;
    private String tipoDocumento;
    private String correo;
    private String token;
    /**
     * Constructor 1
     */
    public Familiar(){
        
    }
    
    /**
     * Constructor 2
     * @param id
     * @param nombres
     * @param apellidos
     * @param documentoIdentidad
     * @param nombreUsuario
     * @param password
     * @param tipoDocumento
     * @param correo 
     */
    public Familiar(Integer id, String nombres, String apellidos, String documentoIdentidad, String nombreUsuario, String password, String tipoDocumento, String correo){
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documentoIdentidad = documentoIdentidad;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.tipoDocumento = tipoDocumento;
        this.correo = correo; 
    }
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the documentoIdentidad
     */
    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    /**
     * @param documentoIdentidad the documentoIdentidad to set
     */
    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the tipoDocumento
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }
    
    
    
}
