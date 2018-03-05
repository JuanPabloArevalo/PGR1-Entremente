/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.model.juegos;

/**
 *
 * @author JuanArevaloMerchan
 */
public class RespuestaQueUsar {
    public static final String CORRECTA = "S";
    public static final String INCORRECTA = "N";
    
    private String opcion;
    private String respuestaCorrecta;
    
    /**
     * Constructor Vacio
     */
    public RespuestaQueUsar(){
        
    }
    /**
     * Constructor con datos
     * @param opcion
     * @param respuestaCorrecta 
     */
    public RespuestaQueUsar(String opcion, String respuestaCorrecta){
        this.opcion = opcion;
        this.respuestaCorrecta = respuestaCorrecta;
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
}
