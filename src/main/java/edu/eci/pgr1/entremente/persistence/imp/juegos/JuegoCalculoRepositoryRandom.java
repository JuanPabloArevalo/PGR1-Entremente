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
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
    private static final int OPERACION_MULTIPLICACION = 2;
    private static final int OPERACION_DIVISION = 3;
    private List<Integer> givenList = Arrays.asList(8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 60, 80, 100, 102);
    private List<Integer> givenListLvl4 = Arrays.asList(3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 60, 63,66, 69, 72, 75, 78,87, 90, 99, 102);
       
    @Override
    public Set<PreguntaCalculo> traerPreguntas(int nivel, Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        switch (nivel) {
            case 1:
                return generarPreguntasNivel1();
            case 2:
                return generarPreguntasNivel2();
            case 3:
                return generarPreguntasNivel3();
            case 4:
                return generarPreguntasNivel4();
            default:
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
    
    /**
     * Metodo encargado de generar las preguntas del nivel 1
     * @return 
     */
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
        long respuestaOpuesta = 0;
        Respuestas respuestasIn;
        for(int i=0; i<11; i++){
            operandos = getOperandosAleatorioNivel1();
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
                respuestaOpuesta = operandos.operando1-operandos.operando2;
            }
            else if(operacion==OPERACION_RESTA){
                pregunta.setOperacion(operandos.operando1+"-"+operandos.operando2);
                respuestaCorrecta = operandos.operando1-operandos.operando2;
                respuestaOpuesta = operandos.operando1+operandos.operando2;
            }
            respuestaA.setOpcion(String.valueOf(respuestaCorrecta));
            respuestasIn = getRespuestasAleatoreas(respuestaCorrecta,1, respuestaOpuesta);
            
            respuestaB = new RespuestaCalculo();
            respuestaB.setOpcion(String.valueOf(respuestaOpuesta));
            respuestaB.setRespuestaCorrecta("N");
            respuestaC = new RespuestaCalculo();
            respuestaC.setOpcion(String.valueOf(respuestasIn.respuesta1));
            respuestaC.setRespuestaCorrecta("N");
            respuestaD = new RespuestaCalculo();
            respuestaD.setOpcion(String.valueOf(respuestasIn.respuesta2));
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
     * Metodo encargado de generar las preguntas del nivel 2
     * @return 
     */
    private Set<PreguntaCalculo> generarPreguntasNivel2(){
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
        long respuestaOpuesta = 0;
        Respuestas respuestasIn;
        for(int i=0; i<11; i++){
            operacion = operacionNivel2();
            if(operacion==OPERACION_MULTIPLICACION){
                operandos = getOperandosAleatorioNivel2Multiplicacion();
            }
            else{
                operandos = getOperandosAleatorioNivel2();
            }
            pregunta = new PreguntaCalculo();
            pregunta.setEstado("A");
            pregunta.setId(i);
            pregunta.setIdPregunta(i);
            pregunta.setNivel(2);
            pregunta.setPersonalizado("N");
            
            respuestaA = new RespuestaCalculo();
            respuestaA.setRespuestaCorrecta("S");
            switch (operacion) {
                case OPERACION_SUMA:
                    pregunta.setOperacion(operandos.operando1+"+"+operandos.operando2);
                    respuestaCorrecta = operandos.operando1+operandos.operando2;
                    respuestaOpuesta = operandos.operando1-operandos.operando2;
                    break;
                case OPERACION_RESTA:
                    pregunta.setOperacion(operandos.operando1+"-"+operandos.operando2);
                    respuestaCorrecta = operandos.operando1-operandos.operando2;
                    respuestaOpuesta = operandos.operando1+operandos.operando2;
                    break;
                case OPERACION_MULTIPLICACION:
                    pregunta.setOperacion(operandos.operando1+"X"+operandos.operando2);
                    respuestaCorrecta = operandos.operando1*operandos.operando2;
                    respuestaOpuesta = operandos.operando1+operandos.operando2;
                    break;
                default:
                    break;
            }
            respuestaA.setOpcion(String.valueOf(respuestaCorrecta));
            respuestasIn = getRespuestasAleatoreas(respuestaCorrecta,2, respuestaOpuesta);
            
            respuestaB = new RespuestaCalculo();
            respuestaB.setOpcion(String.valueOf(respuestaOpuesta));
            respuestaB.setRespuestaCorrecta("N");
            respuestaC = new RespuestaCalculo();
            respuestaC.setOpcion(String.valueOf(respuestasIn.respuesta2));
            respuestaC.setRespuestaCorrecta("N");
            respuestaD = new RespuestaCalculo();
            respuestaD.setOpcion(String.valueOf(respuestasIn.respuesta1));
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
     * Metodo encargado de generar las preguntas del nivel 3
     * @return 
     */
    private Set<PreguntaCalculo> generarPreguntasNivel3(){
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
        long respuestaOpuesta = 0;
        Respuestas respuestasIn;
        for(int i=0; i<11; i++){
            operacion = operacionNivel3Y4();
            switch (operacion) {
                case OPERACION_MULTIPLICACION:
                    operandos = getOperandosAleatorioNivel3Multiplicacion();
                    break;
                case OPERACION_DIVISION:
                    operandos = getOperandosAleatorioNivel3Division();
                    break;
                default:
                    operandos = getOperandosAleatorioNivel3();
                    break;
            }
            pregunta = new PreguntaCalculo();
            pregunta.setEstado("A");
            pregunta.setId(i);
            pregunta.setIdPregunta(i);
            pregunta.setNivel(3);
            pregunta.setPersonalizado("N");
            
            respuestaA = new RespuestaCalculo();
            respuestaA.setRespuestaCorrecta("S");
            switch (operacion) {
                case OPERACION_SUMA:
                    pregunta.setOperacion(operandos.operando1+"+"+operandos.operando2);
                    respuestaCorrecta = operandos.operando1+operandos.operando2;
                    respuestaOpuesta = operandos.operando1-operandos.operando2;
                    break;
                case OPERACION_RESTA:
                    pregunta.setOperacion(operandos.operando1+"-"+operandos.operando2);
                    respuestaCorrecta = operandos.operando1-operandos.operando2;
                    respuestaOpuesta = operandos.operando1+operandos.operando2;
                    break;
                case OPERACION_MULTIPLICACION:
                    pregunta.setOperacion(operandos.operando1+"X"+operandos.operando2);
                    respuestaCorrecta = operandos.operando1*operandos.operando2;
                    respuestaOpuesta = operandos.operando1+operandos.operando2;
                    break;
                case OPERACION_DIVISION:
                    pregunta.setOperacion(operandos.operando1+"/"+operandos.operando2);
                    respuestaCorrecta = operandos.operando1/operandos.operando2;
                    respuestaOpuesta = operandos.operando1*operandos.operando2;
                    break;
                default:
                    break;
            }
            respuestaA.setOpcion(String.valueOf(respuestaCorrecta));
            respuestasIn = getRespuestasAleatoreas(respuestaCorrecta,3, respuestaOpuesta);
            
            respuestaB = new RespuestaCalculo();
            respuestaB.setOpcion(String.valueOf(respuestaOpuesta));
            respuestaB.setRespuestaCorrecta("N");
            respuestaC = new RespuestaCalculo();
            respuestaC.setOpcion(String.valueOf(respuestasIn.respuesta2));
            respuestaC.setRespuestaCorrecta("N");
            respuestaD = new RespuestaCalculo();
            respuestaD.setOpcion(String.valueOf(respuestasIn.respuesta1));
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
     * Metodo encargado de generar las preguntas del nivel 3
     * @return 
     */
    private Set<PreguntaCalculo> generarPreguntasNivel4(){
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
        long respuestaOpuesta = 0;
        Respuestas respuestasIn;
        for(int i=0; i<11; i++){
            operacion = operacionNivel3Y4();
            switch (operacion) {
                case OPERACION_MULTIPLICACION:
                    operandos = getOperandosAleatorioNivel4Multiplicacion();
                    break;
                case OPERACION_DIVISION:
                    operandos = getOperandosAleatorioNivel4Division();
                    break;
                default:
                    operandos = getOperandosAleatorioNivel4();
                    break;
            }
            pregunta = new PreguntaCalculo();
            pregunta.setEstado("A");
            pregunta.setId(i);
            pregunta.setIdPregunta(i);
            pregunta.setNivel(4);
            pregunta.setPersonalizado("N");
            
            respuestaA = new RespuestaCalculo();
            respuestaA.setRespuestaCorrecta("S");
            switch (operacion) {
                case OPERACION_SUMA:
                    pregunta.setOperacion(operandos.operando1+"+"+operandos.operando2);
                    respuestaCorrecta = operandos.operando1+operandos.operando2;
                    respuestaOpuesta = operandos.operando1-operandos.operando2;
                    break;
                case OPERACION_RESTA:
                    pregunta.setOperacion(operandos.operando1+"-"+operandos.operando2);
                    respuestaCorrecta = operandos.operando1-operandos.operando2;
                    respuestaOpuesta = operandos.operando1+operandos.operando2;
                    break;
                case OPERACION_MULTIPLICACION:
                    pregunta.setOperacion(operandos.operando1+"X"+operandos.operando2);
                    respuestaCorrecta = operandos.operando1*operandos.operando2;
                    respuestaOpuesta = operandos.operando1+operandos.operando2;
                    break;
                case OPERACION_DIVISION:
                    pregunta.setOperacion(operandos.operando1+"/"+operandos.operando2);
                    respuestaCorrecta = operandos.operando1/operandos.operando2;
                    respuestaOpuesta = operandos.operando1*operandos.operando2;
                    break;
                default:
                    break;
            }
            respuestaA.setOpcion(String.valueOf(respuestaCorrecta));
            respuestasIn = getRespuestasAleatoreas(respuestaCorrecta,4, respuestaOpuesta);
            
            respuestaB = new RespuestaCalculo();
            respuestaB.setOpcion(String.valueOf(respuestaOpuesta));
            respuestaB.setRespuestaCorrecta("N");
            respuestaC = new RespuestaCalculo();
            respuestaC.setOpcion(String.valueOf(respuestasIn.respuesta1));
            respuestaC.setRespuestaCorrecta("N");
            respuestaD = new RespuestaCalculo();
            respuestaD.setOpcion(String.valueOf(respuestasIn.respuesta2));
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
    private Operandos getOperandosAleatorioNivel1(){
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

    /**
     * Get Operandos, donde operando1 es mayor o igual a operando2
     * @return 
     */
    private Operandos getOperandosAleatorioNivel2(){
        Random aleatorio = new Random(System.nanoTime());
        int valorEntero = aleatorio.nextInt(30);
        aleatorio.setSeed(System.nanoTime());
        int valorEntero2 = aleatorio.nextInt(30);
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
    
    
    /**
     * Get Operandos, donde operando1 es mayor o igual a operando2
     * @return 
     */
    private Operandos getOperandosAleatorioNivel3(){
        Random aleatorio = new Random(System.nanoTime());
        int valorEntero = aleatorio.nextInt(100);
        aleatorio.setSeed(System.nanoTime());
        int valorEntero2 = aleatorio.nextInt(100);
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
    
    
    /**
     * Get Operandos, donde operando1 es mayor o igual a operando2
     * @return 
     */
    private Operandos getOperandosAleatorioNivel4(){
        Random aleatorio = new Random(System.nanoTime());
        int valorEntero = aleatorio.nextInt(400);
        aleatorio.setSeed(System.nanoTime());
        int valorEntero2 = aleatorio.nextInt(400);
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
    
    /**
     * Get Operandos, donde operando1 es mayor o igual a operando2
     * @return 
     */
    private Operandos getOperandosAleatorioNivel2Multiplicacion(){
        Random aleatorio = new Random(System.nanoTime());
        int valorEntero = aleatorio.nextInt(8);
        aleatorio.setSeed(System.nanoTime());
        int valorEntero2 = aleatorio.nextInt(8);
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
    
    /**
     * Get Operandos, donde operando1 es mayor o igual a operando2
     * @return 
     */
    private Operandos getOperandosAleatorioNivel3Multiplicacion(){
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
    
    /**
     * Get Operandos, donde operando1 es mayor o igual a operando2
     * @return 
     */
    private Operandos getOperandosAleatorioNivel4Multiplicacion(){
        Random aleatorio = new Random(System.nanoTime());
        int valorEntero = aleatorio.nextInt(30);
        aleatorio.setSeed(System.nanoTime());
        int valorEntero2 = aleatorio.nextInt(10);
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
    
    /**
     * Get Operandos, donde operando1 es mayor o igual a operando2
     * @return 
     */
    private Operandos getOperandosAleatorioNivel3Division(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(givenList.size());
        int valorEntero = givenList.get(randomIndex);
        int valorEntero2 = 2;
        Operandos operandos = new Operandos();
        operandos.operando1 = valorEntero;
        operandos.operando2 = valorEntero2;
        return operandos;
    }
    
    /**
     * Get Operandos, donde operando1 es mayor o igual a operando2
     * @return 
     */
    private Operandos getOperandosAleatorioNivel4Division(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(givenListLvl4.size());
        int valorEntero = givenListLvl4.get(randomIndex);
        int valorEntero2 = 3;
        Operandos operandos = new Operandos();
        operandos.operando1 = valorEntero;
        operandos.operando2 = valorEntero2;
        return operandos;
    }
    /**
     * Metodo encargado de traer todas las respuestas incorrectas del nivel 1
     * @param respuestaCorrecta
     * @return 
     */
    private Respuestas getRespuestasAleatoreas(long respuestaCorrecta, int nivel, long respuestaOpuesta){
        int i = 0;
        Respuestas resp = new Respuestas();
        int respuesta = 0;
        while(i<2){
            switch (nivel) {
                case 1:
                    respuesta = getNumeroAleatorioRespuestaNivel1();
                    break;
                case 2:
                    respuesta = getNumeroAleatorioRespuestaNivel2();
                    break;
                case 3:
                    respuesta = getNumeroAleatorioRespuestaNivel3();
                    break;
                case 4:
                    respuesta = getNumeroAleatorioRespuestaNivel4();
                    break;
                default:
                    break;
            }
            if(respuesta!=respuestaCorrecta && respuesta!= resp.respuesta1 && respuesta!= resp.respuesta2 && respuestaOpuesta!=respuesta){
                switch (i) {
                    case 0:
                        resp.respuesta1 = respuesta;
                        break;
                    default:
                        resp.respuesta2 = respuesta;
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
    private int operacionNivel2(){
        Random aleatorio = new Random(System.nanoTime());
        int valorEntero = aleatorio.nextInt(3);
        aleatorio.setSeed(System.nanoTime());
        return valorEntero;
    }
    
    
    /**
     * Trae la operacion
     * @return int<br>
     * <b>0</b>: suma <br>
     * <b>1</b>: resta <br>
     */
    private int operacionNivel3Y4(){
        Random aleatorio = new Random(System.nanoTime());
        int valorEntero = aleatorio.nextInt(4);
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
     * Trae la operacion
     * @return int<br>
     * <b>0</b>: suma <br>
     * <b>1</b>: resta <br>
     */
    private int getNumeroAleatorioRespuestaNivel2(){
        Random aleatorio = new Random(System.nanoTime());
        int valorEntero = aleatorio.nextInt(100);
        aleatorio.setSeed(System.nanoTime());
        return valorEntero;
    }
    
    /**
     * Trae la operacion
     * @return int<br>
     * <b>0</b>: suma <br>
     * <b>1</b>: resta <br>
     */
    private int getNumeroAleatorioRespuestaNivel3(){
        Random aleatorio = new Random(System.nanoTime());
        int valorEntero = aleatorio.nextInt(250);
        aleatorio.setSeed(System.nanoTime());
        return valorEntero;
    }
    /**
     * Trae la operacion
     * @return int<br>
     * <b>0</b>: suma <br>
     * <b>1</b>: resta <br>
     */
    private int getNumeroAleatorioRespuestaNivel4(){
        Random aleatorio = new Random(System.nanoTime());
        int valorEntero = aleatorio.nextInt(400);
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
        
        public Respuestas(){
            respuesta1 = -1;
            respuesta2 = -1;
        }
    }
}
