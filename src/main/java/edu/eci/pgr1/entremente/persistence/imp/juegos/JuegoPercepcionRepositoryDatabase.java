/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp.juegos;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.juegos.PreguntaGaleria;
import edu.eci.pgr1.entremente.model.juegos.PreguntaPercepcion;
import edu.eci.pgr1.entremente.model.juegos.RespuestaPercepcion;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.persistence.imp.DatosBD;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoPercepcionRepository;
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
public class JuegoPercepcionRepositoryDatabase implements JuegoPercepcionRepository{
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String NOMBRETABLA = "JUEGOPERCEPCIONPACIENTE";
    
    @Override
    public Set<PreguntaPercepcion> traerPreguntas(int nivel, Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        Set<PreguntaPercepcion> preguntas = new HashSet<>();
        Set<RespuestaPercepcion> respuestas = null;
        PreguntaPercepcion pregunta = null;
        RespuestaPercepcion respuestaA = null;
        RespuestaPercepcion respuestaB = null;
        RespuestaPercepcion respuestaC = null;
        RespuestaPercepcion respuestaD = null;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT * FROM "+NOMBRETABLA+" JAP LEFT JOIN PREGUNTAPERCEPCION PA ON (JAP.idPreguntaPercepcion=PA.ID) WHERE JAP.nivelPersonalizado = '"+nivel+"' AND JAP.idPaciente = '"+paciente.getId()+"' AND JAP.ESTADO = '"+PreguntaGaleria.ESTADOACTIVO+"'");
//            System.out.println("SELECT * FROM "+NOMBRETABLA+" JAP LEFT JOIN PREGUNTAPERCEPCION PA ON (JAP.idPreguntaPercepcion=PA.ID) WHERE JAP.nivelPersonalizado = '"+nivel+"' AND JAP.idPaciente = '"+paciente.getId()+"' AND JAP.ESTADO = '"+PreguntaGaleria.ESTADOACTIVO+"'");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                pregunta = new PreguntaPercepcion();
                pregunta.setImagen(resultSet.getString("PA.Imagen"));
                pregunta.setNivel(nivel);
                pregunta.setPersonalizado("N");
                pregunta.setPregunta(resultSet.getString("PA.pregunta"));
                pregunta.setId(resultSet.getInt("JAP.id"));
                pregunta.setIdPregunta(resultSet.getInt("JAP.idPreguntaPercepcion"));
                
                respuestas = new HashSet<>();
                respuestaA = new RespuestaPercepcion();
                respuestaA.setOpcion(resultSet.getString("PA.opcionA"));
                respuestaA.setRespuestaCorrecta(resultSet.getString("PA.correctaA"));
                respuestas.add(respuestaA);

                respuestaB = new RespuestaPercepcion();
                respuestaB.setOpcion(resultSet.getString("PA.opcionB"));
                respuestaB.setRespuestaCorrecta(resultSet.getString("PA.correctaB"));
                respuestas.add(respuestaB);
                
                respuestaC = new RespuestaPercepcion();
                respuestaC.setOpcion(resultSet.getString("PA.opcionC"));
                respuestaC.setRespuestaCorrecta(resultSet.getString("PA.correctaC"));
                respuestas.add(respuestaC);
                
                respuestaD = new RespuestaPercepcion();
                respuestaD.setOpcion(resultSet.getString("PA.opcionD"));
                respuestaD.setRespuestaCorrecta(resultSet.getString("PA.correctaD"));
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
    public ArrayList<PreguntaPercepcion> traerTODASPreguntas(Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        ArrayList<PreguntaPercepcion> preguntas = new ArrayList<>();
        Set<RespuestaPercepcion> respuestas = null;
        PreguntaPercepcion pregunta = null;
        RespuestaPercepcion respuestaA = null;
        RespuestaPercepcion respuestaB = null;
        RespuestaPercepcion respuestaC = null;
        RespuestaPercepcion respuestaD = null;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT * FROM "+NOMBRETABLA+" JAP LEFT JOIN PREGUNTAPERCEPCION PA ON (JAP.idPreguntaPercepcion=PA.ID) WHERE JAP.idPaciente = '"+paciente.getId()+"'");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                pregunta = new PreguntaPercepcion();
                pregunta.setImagen(resultSet.getString("PA.Imagen"));
                pregunta.setNivel(resultSet.getInt("JAP.nivelPersonalizado"));
                pregunta.setPersonalizado("S");
                pregunta.setPregunta(resultSet.getString("PA.pregunta"));
                pregunta.setId(resultSet.getInt("JAP.id"));
                pregunta.setIdPregunta(resultSet.getInt("JAP.idPreguntaPercepcion"));
                pregunta.setEstado(resultSet.getString("JAP.estado"));
                
                respuestas = new HashSet<>();
                respuestaA = new RespuestaPercepcion();
                respuestaA.setOpcion(resultSet.getString("PA.opcionA"));
                respuestaA.setRespuestaCorrecta(resultSet.getString("PA.correctaA"));
                respuestas.add(respuestaA);

                respuestaB = new RespuestaPercepcion();
                respuestaB.setOpcion(resultSet.getString("PA.opcionB"));
                respuestaB.setRespuestaCorrecta(resultSet.getString("PA.correctaB"));
                respuestas.add(respuestaB);
                
                respuestaC = new RespuestaPercepcion();
                respuestaC.setOpcion(resultSet.getString("PA.opcionC"));
                respuestaC.setRespuestaCorrecta(resultSet.getString("PA.correctaC"));
                respuestas.add(respuestaC);
                
                respuestaD = new RespuestaPercepcion();
                respuestaD.setOpcion(resultSet.getString("PA.opcionD"));
                respuestaD.setRespuestaCorrecta(resultSet.getString("PA.correctaD"));
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
            throw new PersistenceException("No hay preguntas");
        }
        
        return preguntas;
    }

    @Override
    public void modificarPregunta(PreguntaPercepcion pregunta) throws PersistenceNotFoundException, PersistenceException {
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
