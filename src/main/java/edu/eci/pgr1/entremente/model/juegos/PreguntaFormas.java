/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.model.juegos;

import edu.eci.pgr1.entremente.model.juegos.RespuestaFormas;
import java.util.Set;

/**
 *
 * @author JuanArevaloMerchan
 */
public class PreguntaFormas {
    public static final String ESTADOACTIVO = "A";
    public static final String ESTADOINACTIVO = "I";
    
    private String pregunta;
    private String imagen;
    private Set<RespuestaFormas> respuestas;
    private int nivel;
    private String personalizado;
    private int id;
    private int idPregunta;
    
    /**
     * Constructor Vacio
     */
    public PreguntaFormas(){
        
    }

    /**
     * Constructor con datos
     * @param pregunta
     * @param imagen
     * @param respuestas
     * @param nivel
     * @param personalizado 
     * @param id 
     * @param idPregunta 
     */
    public PreguntaFormas(String pregunta, String imagen, Set<RespuestaFormas> respuestas, int nivel, String personalizado, int id, int idPregunta){
        this.pregunta = pregunta;
        this.imagen = imagen;
        this.respuestas = respuestas;
        this.nivel = nivel;
        this.personalizado = personalizado;
        this.id = id;
        this.idPregunta = idPregunta;
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
    public Set<RespuestaFormas> getRespuestas() {
        return respuestas;
    }

    /**
     * @param respuestas the respuestas to set
     */
    public void setRespuestas(Set<RespuestaFormas> respuestas) {
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
