/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp.juegos;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.juegos.PreguntaCalculo;
import edu.eci.pgr1.entremente.model.juegos.RespuestaCalculo;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import java.util.ArrayList;
import java.util.Set;

import edu.eci.pgr1.entremente.persistence.juegos.JuegoCalculoRepository;
import java.util.HashSet;
import java.util.Random;
import org.springframework.stereotype.Service;

/**
 *
 * @author JuanArevaloMerchan
 */
@Service
public class JuegoCalculoRepositoryRandom implements JuegoCalculoRepository{

    private static final int OPERACION_SUMA = 0;
    private static final int OPERACION_RESTA = 1;
    @Override
    public Set<PreguntaCalculo> traerPreguntas(int nivel, Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        if(nivel==1){
            return generarPreguntasNivel1();
        }
        else{
            return null;
        }
    }

    @Override
    public ArrayList<PreguntaCalculo> traerTODASPreguntas(Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarPregunta(PreguntaCalculo pregunta) throws PersistenceNotFoundException, PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    private Operandos traer
    
    
    private Set<PreguntaCalculo> generarPreguntasNivel1(){
        Set<PreguntaCalculo> preguntas = new HashSet<>();
        Set<RespuestaCalculo> respuestas = null;
        PreguntaCalculo pregunta = null;
        RespuestaCalculo respuestaA = null;
        RespuestaCalculo respuestaB = null;
        RespuestaCalculo respuestaC = null;
        RespuestaCalculo respuestaD = null;
        Operandos operandos;
        int operacion;
        long respuestaCorrecta = 0;
        Respuestas respuestasIn;
        for(int i=0; i<11; i++){
            operandos = getOperandosAleatorio1Cifra();
            operacion = operacionNivel1();
            pregunta = new PreguntaCalculo();
            pregunta.setEstado("A");
            pregunta.setId(i);
            pregunta.setIdPregunta(i);
            pregunta.setNivel(1);
            pregunta.setPersonalizado("N");
            
            respuestaA = new RespuestaCalculo();
            respuestaA.setRespuestaCorrecta("S");
            if(operacion==OPERACION_SUMA){
                pregunta.setOperacion(operandos.operando1+"+"+operandos.operando2);
                respuestaCorrecta = operandos.operando1+operandos.operando2;
                
            }
            else if(operacion==OPERACION_RESTA){
                pregunta.setOperacion(operandos.operando1+"-"+operandos.operando2);
                respuestaCorrecta = operandos.operando1-operandos.operando2;
            }
            respuestaA.setOpcion(String.valueOf(respuestaCorrecta));
            respuestasIn = getRespuestasAleatoreasNivel1(respuestaCorrecta);
            
            respuestaB = new RespuestaCalculo();
            respuestaB.setOpcion(String.valueOf(respuestasIn.respuesta1));
            respuestaB.setRespuestaCorrecta("N");
            respuestaC = new RespuestaCalculo();
            respuestaC.setOpcion(String.valueOf(respuestasIn.respuesta2));
            respuestaC.setRespuestaCorrecta("N");
            respuestaD = new RespuestaCalculo();
            respuestaD.setOpcion(String.valueOf(respuestasIn.respuesta3));
            respuestaD.setRespuestaCorrecta("N");
            respuestas = new HashSet<>();
            respuestas.add(respuestaA);
            respuestas.add(respuestaB);
            respuestas.add(respuestaC);
            respuestas.add(respuestaD);
            pregunta.setRespuestas(respuestas);
            preguntas.add(pregunta);
        }
        
        return preguntas;
    }
    
    /**
     * Get Operandos, donde operando1 es mayor o igual a operando2
     * @return 
     */
    private Operandos getOperandosAleatorio1Cifra(){
        Random aleatorio = new Random(System.nanoTime());
        int valorEntero = aleatorio.nextInt(15);
        aleatorio.setSeed(System.nanoTime());
        int valorEntero2 = aleatorio.nextInt(15);
        aleatorio.setSeed(System.nanoTime());
        Operandos operandos = new Operandos();
        if(valorEntero>=valorEntero2){
            operandos.operando1 = valorEntero;
            operandos.operando2 = valorEntero2;
        }
        else{
            operandos.operando1 = valorEntero2;
            operandos.operando2 = valorEntero;
        }
        return operandos;
    }
    
    private Respuestas getRespuestasAleatoreasNivel1(long respuestaCorrecta){
        int i = 0;
        Respuestas resp = new Respuestas();
        int respuesta;
        while(i<=3){
            respuesta = getNumeroAleatorioRespuestaNivel1();
            if(respuesta!=respuestaCorrecta && respuesta!= resp.respuesta1 && respuesta!= resp.respuesta2 && respuesta!= resp.respuesta3){
                switch (i) {
                    case 0:
                        resp.respuesta1 = respuesta;
                        break;
                    case 1:
                        resp.respuesta2 = respuesta;
                        break;
                    default:
                        resp.respuesta3 = respuesta;
                        break;
                }
                i++;
            }
        }
        return resp;
    }
    
    /**
     * Trae la operacion
     * @return int<br>
     * <b>0</b>: suma <br>
     * <b>1</b>: resta <br>
     */
    private int operacionNivel1(){
        Random aleatorio = new Random(System.nanoTime());
        int valorEntero = aleatorio.nextInt(2);
        aleatorio.setSeed(System.nanoTime());
        return valorEntero;
    }
    
        /**
     * Trae la operacion
     * @return int<br>
     * <b>0</b>: suma <br>
     * <b>1</b>: resta <br>
     */
    private int getNumeroAleatorioRespuestaNivel1(){
        Random aleatorio = new Random(System.nanoTime());
        int valorEntero = aleatorio.nextInt(30);
        aleatorio.setSeed(System.nanoTime());
        return valorEntero;
    }
    
    /**
     * 
     */
    private class Operandos{
        public long operando1;
        public long operando2;
    }
    
    private class Respuestas{
        public long respuesta1;
        public long respuesta2;
        public long respuesta3;
        
        public Respuestas(){
            respuesta1 = -1;
            respuesta2 = -1;
            respuesta3 = -1;
        }
    }
}
