/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.model.juegos;

import java.util.Set;

/**
 *
 * @author JuanArevaloMerchan
 */
public class PreguntaPercepcion {
    public static final String ESTADOACTIVO = "A";
    public static final String ESTADOINACTIVO = "I";
    
    private int id;
    private String pregunta;
    private String imagen;
    private Set<RespuestaPercepcion> respuestas;
    private int nivel;
    private String personalizado;
    private int idPregunta;
    private String estado;    
        /**
     * Constructor Vacio
     */
    public PreguntaPercepcion(){
    }
    /**
     * Constructor con datos
     * @param id
     * @param pregunta
     * @param imagen
     * @param respuestas
     * @param nivel
     * @param personalizado
     * @param idPregunta 
     * @param estado 
     */
    public PreguntaPercepcion(int id, String pregunta, String imagen, Set<RespuestaPercepcion> respuestas, int nivel, String personalizado, int idPregunta, String estado){
        this.id = id;
        this.pregunta = pregunta;
        this.imagen = imagen;
        this.respuestas = respuestas;
        this.nivel = nivel;
        this.personalizado = personalizado;
        this.idPregunta = idPregunta;
        this.estado = estado;
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
     * @return the respuestas
     */
    public Set<RespuestaPercepcion> getRespuestas() {
        return respuestas;
    }

    /**
     * @param respuestas the respuestas to set
     */
    public void setRespuestas(Set<RespuestaPercepcion> respuestas) {
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
    
    
}
