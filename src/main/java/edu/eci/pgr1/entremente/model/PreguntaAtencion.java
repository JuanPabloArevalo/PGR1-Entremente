/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.model;

import java.util.Set;

/**
 *
 * @author Administrador
 */
public class PreguntaAtencion {
    public static final String ESTADOACTIVO = "A";
    public static final String ESTADOINACTIVO = "I";
    
    private int id;
    private String pregunta;
    private String imagen;
    private String palabraClave;
    private Set<RespuestaAtencion> respuestas;
    private int nivel;
    private String personalizado;
    private int idPregunta;

    /**
     * Constructor Vacio
     */
    public PreguntaAtencion(){
    }
    /**
     * Constructor con datos
     * @param id
     * @param pregunta
     * @param imagen
     * @param palabraClave
     * @param respuestas
     * @param nivel
     * @param personalizado
     * @param idPregunta 
     */
    public PreguntaAtencion(int id, String pregunta, String imagen, String palabraClave, Set<RespuestaAtencion> respuestas, int nivel, String personalizado, int idPregunta){
        this.id = id;
        this.pregunta = pregunta;
        this.imagen = imagen;
        this.palabraClave = palabraClave;
        this.respuestas = respuestas;
        this.nivel = nivel;
        this.personalizado = personalizado;
        this.idPregunta = idPregunta;
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
     * @return the pregunta
     */
    public String getPregunta() {
        return pregunta;
    }

    /**
     * @param pregunta the pregunta to set
     */
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the palabraCLave
     */
    public String getPalabraClave() {
        return palabraClave;
    }

    /**
     * @param palabraClave the palabraCLave to set
     */
    public void setPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }

    /**
     * @return the respuestas
     */
    public Set<RespuestaAtencion> getRespuestas() {
        return respuestas;
    }

    /**
     * @param respuestas the respuestas to set
     */
    public void setRespuestas(Set<RespuestaAtencion> respuestas) {
        this.respuestas = respuestas;
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
     * @return the personalizado
     */
    public String getPersonalizado() {
        return personalizado;
    }

    /**
     * @param personalizado the personalizado to set
     */
    public void setPersonalizado(String personalizado) {
        this.personalizado = personalizado;
    }

    /**
     * @return the idPregunta
     */
    public int getIdPregunta() {
        return idPregunta;
    }

    /**
     * @param idPregunta the idPregunta to set
     */
    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }
    
    
    
}
