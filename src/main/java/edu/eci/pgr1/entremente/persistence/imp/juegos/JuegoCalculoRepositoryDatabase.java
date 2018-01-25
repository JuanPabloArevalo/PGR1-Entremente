/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp.juegos;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.juegos.PreguntaCalculo;
import edu.eci.pgr1.entremente.model.juegos.PreguntaGaleria;
import edu.eci.pgr1.entremente.model.juegos.RespuestaCalculo;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoCalculoRepository;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.persistence.imp.DatosBD;
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
 * @author JuanArevaloMerchan
 */
@Service
public class JuegoCalculoRepositoryDatabase implements JuegoCalculoRepository{
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String NOMBRETABLA = "JUEGOCALCULOPACIENTE";
    @Override
    
    public Set<PreguntaCalculo> traerPreguntas(int nivel, Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        Set<PreguntaCalculo> preguntas = new HashSet<>();
        Set<RespuestaCalculo> respuestas = null;
        PreguntaCalculo pregunta = null;
        RespuestaCalculo respuestaA = null;
        RespuestaCalculo respuestaB = null;
        RespuestaCalculo respuestaC = null;
        RespuestaCalculo respuestaD = null;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT * FROM "+NOMBRETABLA+" JGP LEFT JOIN PREGUNTACALCULO PG ON (JGP.idPreguntaCalculo=PG.ID) WHERE JGP.nivelPersonalizado = '"+nivel+"' AND JGP.idPaciente = '"+paciente.getId()+"' AND ESTADO = '"+PreguntaGaleria.ESTADOACTIVO+"'");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                pregunta = new PreguntaCalculo();
                pregunta.setOperacion(resultSet.getString("PG.OPERACION"));
                pregunta.setNivel(nivel);
                pregunta.setPersonalizado("N");
                pregunta.setId(resultSet.getInt("JGP.id"));
                pregunta.setIdPregunta(resultSet.getInt("JGP.idPreguntaCalculo"));
                
                respuestas = new HashSet<>();
                respuestaA = new RespuestaCalculo();
                respuestaA.setOpcion(resultSet.getString("PG.opcionA"));
                respuestaA.setRespuestaCorrecta(resultSet.getString("PG.correctaA"));
                respuestas.add(respuestaA);

                respuestaB = new RespuestaCalculo();
                respuestaB.setOpcion(resultSet.getString("PG.opcionB"));
                respuestaB.setRespuestaCorrecta(resultSet.getString("PG.correctaB"));
                respuestas.add(respuestaB);
                
                respuestaC = new RespuestaCalculo();
                respuestaC.setOpcion(resultSet.getString("PG.opcionC"));
                respuestaC.setRespuestaCorrecta(resultSet.getString("PG.correctaC"));
                respuestas.add(respuestaC);
                
                respuestaD = new RespuestaCalculo();
                respuestaD.setOpcion(resultSet.getString("PG.opcionD"));
                respuestaD.setRespuestaCorrecta(resultSet.getString("PG.correctaD"));
                respuestas.add(respuestaD);
                
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

    @Override
    public ArrayList<PreguntaCalculo> traerTODASPreguntas(Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        ArrayList<PreguntaCalculo> preguntas = new ArrayList<>();
        Set<RespuestaCalculo> respuestas = null;
        PreguntaCalculo pregunta = null;
        RespuestaCalculo respuestaA = null;
        RespuestaCalculo respuestaB = null;
        RespuestaCalculo respuestaC = null;
        RespuestaCalculo respuestaD = null;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT * FROM "+NOMBRETABLA+" JGP LEFT JOIN PREGUNTACALCULO PG ON (JGP.idPreguntaCalculo=PG.ID) WHERE JGP.idPaciente = '"+paciente.getId()+"' ORDER BY nivelPersonalizado");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                pregunta = new PreguntaCalculo();
                pregunta.setOperacion(resultSet.getString("PG.OPERACION"));
                pregunta.setNivel(resultSet.getInt("JGP.nivelPersonalizado"));
                pregunta.setPersonalizado("S");
                pregunta.setId(resultSet.getInt("JGP.id"));
                pregunta.setIdPregunta(resultSet.getInt("JGP.idPreguntaCalculo"));
                pregunta.setEstado(resultSet.getString("JGP.estado"));
                
                respuestas = new HashSet<>();
                respuestaA = new RespuestaCalculo();
                respuestaA.setOpcion(resultSet.getString("PG.opcionA"));
                respuestaA.setRespuestaCorrecta(resultSet.getString("PG.correctaA"));
                respuestas.add(respuestaA);

                respuestaB = new RespuestaCalculo();
                respuestaB.setOpcion(resultSet.getString("PG.opcionB"));
                respuestaB.setRespuestaCorrecta(resultSet.getString("PG.correctaB"));
                respuestas.add(respuestaB);
                
                respuestaC = new RespuestaCalculo();
                respuestaC.setOpcion(resultSet.getString("PG.opcionC"));
                respuestaC.setRespuestaCorrecta(resultSet.getString("PG.correctaC"));
                respuestas.add(respuestaC);
                
                respuestaD = new RespuestaCalculo();
                respuestaD.setOpcion(resultSet.getString("PG.opcionD"));
                respuestaD.setRespuestaCorrecta(resultSet.getString("PG.correctaD"));
                respuestas.add(respuestaD);
                
                pregunta.setRespuestas(respuestas);
                preguntas.add(pregunta);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
        if(preguntas.isEmpty()){
            throw new PersistenceException("No hay preguntas!");
        }
        return preguntas;
    }

    @Override
    public void modificarPregunta(PreguntaCalculo pregunta) throws PersistenceNotFoundException, PersistenceException {
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
    
}
