/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.model.juegos;

import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author JuanArevaloMerchan
 */
public class PreguntaMusicoterapia {
    
    public static final String ESTADOACTIVO = "A";
    public static final String ESTADOINACTIVO = "I";
    
    private String pregunta;
    private String video;
    private ArrayList<RespuestaMusicoterapia> respuestas;
    private int nivel;
    private String personalizado;
    private int id;
    private int idPregunta;
    private String estado;
    /**
     * Constructor Vacio
     */
    public PreguntaMusicoterapia(){
        
    }

    /**
     * Constructor con datos
     * @param pregunta
     * @param video
     * @param informacion
     * @param respuestas
     * @param nivel
     * @param personalizado 
     * @param id 
     * @param idPregunta 
     * @param estado 
     */
    public PreguntaMusicoterapia(String pregunta, String video, String informacion, ArrayList<RespuestaMusicoterapia> respuestas, int nivel, String personalizado, int id, int idPregunta, String estado){
        this.pregunta = pregunta;
        this.video = video;
        this.respuestas = respuestas;
        this.nivel = nivel;
        this.personalizado = personalizado;
        this.id = id;
        this.idPregunta = idPregunta;
        this.estado = estado;
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
    public String getVideo() {
        return video;
    }

    /**
     * @param video the imagen to set
     */
    public void setVideo(String video) {
        this.video = video;
    }

    /**
     * @return the respuestas
     */
    public ArrayList<RespuestaMusicoterapia> getRespuestas() {
        return respuestas;
    }

    /**
     * @param respuestas the respuestas to set
     */
    public void setRespuestas(ArrayList<RespuestaMusicoterapia> respuestas) {
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
