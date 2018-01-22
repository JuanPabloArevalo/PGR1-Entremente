/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.model;

import java.util.Set;

/**
 *
 * @author JuanArevaloMerchan
 */
public class PreguntaGaleria {
    
    public static final String ESTADOACTIVO = "A";
    public static final String ESTADOINACTIVO = "I";
    
    private String pregunta;
    private String imagen;
    private String informacion;
    private Set<RespuestaGaleria> respuestas;
    private int nivel;
    private String personalizado;
    private int id;
    private int idPregunta;
    /**
     * Constructor Vacio
     */
    public PreguntaGaleria(){
        
    }

    /**
     * Constructor con datos
     * @param pregunta
     * @param imagen
     * @param informacion
     * @param respuestas
     * @param nivel
     * @param personalizado 
     * @param id 
     * @param idPregunta 
     */
    public PreguntaGaleria(String pregunta, String imagen, String informacion, Set<RespuestaGaleria> respuestas, int nivel, String personalizado, int id, int idPregunta){
        this.pregunta = pregunta;
        this.imagen = imagen;
        this.informacion = informacion;
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
     * @return the informacion
     */
    public String getInformacion() {
        return informacion;
    }

    /**
     * @param informacion the informacion to set
     */
    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    /**
     * @return the respuestas
     */
    public Set<RespuestaGaleria> getRespuestas() {
        return respuestas;
    }

    /**
     * @param respuestas the respuestas to set
     */
    public void setRespuestas(Set<RespuestaGaleria> respuestas) {
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
