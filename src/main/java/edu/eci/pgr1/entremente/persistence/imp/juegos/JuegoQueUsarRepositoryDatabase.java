/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp.juegos;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.juegos.PreguntaQueUsar;
import edu.eci.pgr1.entremente.model.juegos.RespuestaQueUsar;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.persistence.imp.DatosBD;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoQueUsarRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class JuegoQueUsarRepositoryDatabase implements JuegoQueUsarRepository{
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String NOMBRETABLA = "JUEGOQUEUSARPACIENTE";

    @Override
    public Set<PreguntaQueUsar> traerPreguntas(int nivel, Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        Set<PreguntaQueUsar> preguntas = new HashSet<>();
        Set<RespuestaQueUsar> respuestas = null;
        PreguntaQueUsar pregunta = null;
        RespuestaQueUsar respuesta = null;
        
        ResultSet resultadoResp = null;
        PreparedStatement preparedStatementResp = null;
        int idPregunta;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT * FROM "+NOMBRETABLA+" JGP LEFT JOIN PREGUNTAQUEUSAR PG ON (JGP.idPreguntaQueUsar=PG.ID) WHERE JGP.nivelPersonalizado = '"+nivel+"' AND JGP.idPaciente = '"+paciente.getId()+"' AND ESTADO = '"+PreguntaQueUsar.ESTADOACTIVO+"'");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                pregunta = new PreguntaQueUsar();
                pregunta.setImagen(resultSet.getString("PG.Imagen"));
                pregunta.setNivel(nivel);
                pregunta.setPersonalizado("N");
                pregunta.setPregunta(resultSet.getString("PG.pregunta"));
                pregunta.setId(resultSet.getInt("JGP.id"));
                idPregunta = resultSet.getInt("JGP.idPreguntaQueUsar");
                pregunta.setIdPregunta(idPregunta);
                pregunta.setEstado(PreguntaQueUsar.ESTADOACTIVO);
                
                //Respuestas Correctas
                preparedStatementResp = connect.prepareStatement("SELECT * FROM RESPUESTASQUEUSAR RQU WHERE idPregunta = '"+idPregunta+"' AND ESCORRECTA = '"+RespuestaQueUsar.CORRECTA+"' ORDER BY RAND() LIMIT 2");
                resultadoResp = preparedStatementResp.executeQuery();
                while(resultadoResp.next()){
                    respuestas = new HashSet<>();
                    respuesta = new RespuestaQueUsar();
                    respuesta.setOpcion(resultadoResp.getString("RQU.imagen"));
                    respuesta.setRespuestaCorrecta(RespuestaQueUsar.CORRECTA);
                    respuestas.add(respuesta);

                }
                
                //Respuestas Incorrectas
                preparedStatementResp = connect.prepareStatement("SELECT * FROM RESPUESTASQUEUSAR WHERE idPregunta = '"+idPregunta+"' AND ESCORRECTA = '"+RespuestaQueUsar.INCORRECTA+"' ORDER BY RAND() LIMIT 2");
                resultadoResp = preparedStatementResp.executeQuery();
                while(resultadoResp.next()){
                    respuestas = new HashSet<>();
                    respuesta = new RespuestaQueUsar();
                    respuesta.setOpcion(resultadoResp.getString("RQU.imagen"));
                    respuesta.setRespuestaCorrecta(RespuestaQueUsar.CORRECTA);
                    respuestas.add(respuesta);

                }
                
                resultadoResp.close();                
                pregunta.setRespuestas(respuestas);
                preguntas.add(pregunta);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
        if(preguntas.isEmpty()){
            throw new PersistenceException("No hay preguntas para el nivel "+nivel);
        }
        
        return preguntas;
    }

    @Override
    public ArrayList<PreguntaQueUsar> traerTODASPreguntas(Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        ArrayList<PreguntaQueUsar> preguntas = new ArrayList<>();
        PreguntaQueUsar pregunta = null;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT * FROM "+NOMBRETABLA+" JAP LEFT JOIN PREGUNTAQUEUSAR PA ON (JAP.idPreguntaQueUsar=PA.ID) WHERE JAP.idPaciente = '"+paciente.getId()+"' ORDER BY nivelPersonalizado");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                pregunta = new PreguntaQueUsar();
                pregunta.setImagen(resultSet.getString("PA.Imagen"));
                pregunta.setNivel(resultSet.getInt("JAP.nivelPersonalizado"));
                pregunta.setPersonalizado("S");
                pregunta.setPregunta(resultSet.getString("PA.pregunta"));
                pregunta.setId(resultSet.getInt("JAP.id"));
                pregunta.setIdPregunta(resultSet.getInt("JAP.idPreguntaQueUsar"));
                pregunta.setEstado(resultSet.getString("JAP.estado"));
                preguntas.add(pregunta);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
        if(preguntas.isEmpty()){
            throw new PersistenceException("No hay preguntas");
        }
        
        return preguntas;
    }

    @Override
    public void modificarPregunta(PreguntaQueUsar pregunta) throws PersistenceNotFoundException, PersistenceException {
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("UPDATE "+NOMBRETABLA+" SET nivelPersonalizado = ?, estado = ? WHERE id = ?");
            preparedStatement.setInt(1, pregunta.getNivel());
            preparedStatement.setString(2, pregunta.getEstado());
            preparedStatement.setInt(3, pregunta.getId());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }  
    }
    
    
    /**
     * Metodo encargado de cerrar la conexión
     */
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (SQLException e) {

        }
    } 
    
}
