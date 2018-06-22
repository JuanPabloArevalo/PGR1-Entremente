/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.model.juegos;

/**
 *
 * @author Administrador
 */
public class RespuestaAtencion {
    private String opcion;
    private String respuestaCorrecta;
    private String palabraClave;

    /**
     * Cosntructor Vacio
     */
    public RespuestaAtencion(){
        
    }
    /**
     * Constructor con datos
     * @param opcion
     * @param respuestaCorrecta
     * @param palabraClave 
     */
    public RespuestaAtencion(String opcion, String respuestaCorrecta, String palabraClave){
        this.opcion = opcion;
        this.respuestaCorrecta = respuestaCorrecta;
        this.palabraClave = palabraClave;
    }
    /**
     * @return the opcion
     */
    public String getOpcion() {
        return opcion;
    }

    /**
     * @param opcion the opcion to set
     */
    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    /**
     * @return the respuestaCorrecta
     */
    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    /**
     * @param respuestaCorrecta the respuestaCorrecta to set
     */
    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    /**
     * @return the palabraClave
     */
    public String getPalabraClave() {
        return palabraClave;
    }

    /**
     * @param palabraClave the palabraClave to set
     */
    public void setPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }
    
    
}
