/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp.juegos;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.juegos.PreguntaGaleria;
import edu.eci.pgr1.entremente.model.juegos.RespuestaGaleria;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoGaleriaRepository;
import edu.eci.pgr1.entremente.persistence.imp.DatosBD;
import java.util.ArrayList;

/**
 *
 * @author JuanArevaloMerchan
 */
@Service
public class JuegoGaleriaRepositoryDatabase implements JuegoGaleriaRepository{
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String NOMBRETABLA = "JUEGOGALERIAPACIENTE";
    
    
    @Override
    public Set<PreguntaGaleria> traerPreguntas(int nivel, Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        Set<PreguntaGaleria> preguntas = new HashSet<>();
        Set<RespuestaGaleria> respuestas = null;
        PreguntaGaleria pregunta = null;
        RespuestaGaleria respuestaA = null;
        RespuestaGaleria respuestaB = null;
        RespuestaGaleria respuestaC = null;
        RespuestaGaleria respuestaD = null;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT * FROM "+NOMBRETABLA+" JGP LEFT JOIN PREGUNTAGALERIA PG ON (JGP.idPreguntaGaleria=PG.ID) WHERE JGP.nivelPersonalizado = '"+nivel+"' AND JGP.idPaciente = '"+paciente.getId()+"' AND ESTADO = '"+PreguntaGaleria.ESTADOACTIVO+"'");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                pregunta = new PreguntaGaleria();
                pregunta.setImagen(resultSet.getString("PG.Imagen"));
                pregunta.setInformacion(resultSet.getString("PG.informacion"));
                pregunta.setNivel(nivel);
                pregunta.setPersonalizado("N");
                pregunta.setPregunta(resultSet.getString("PG.pregunta"));
                pregunta.setId(resultSet.getInt("JGP.id"));
                pregunta.setIdPregunta(resultSet.getInt("JGP.idPreguntaGaleria"));
                pregunta.setEstado(PreguntaGaleria.ESTADOACTIVO);
                respuestas = new HashSet<>();
                respuestaA = new RespuestaGaleria();
                respuestaA.setOpcion(resultSet.getString("PG.opcionA"));
                respuestaA.setRespuestaCorrecta(resultSet.getString("PG.correctaA"));
                respuestas.add(respuestaA);

                respuestaB = new RespuestaGaleria();
                respuestaB.setOpcion(resultSet.getString("PG.opcionB"));
                respuestaB.setRespuestaCorrecta(resultSet.getString("PG.correctaB"));
                respuestas.add(respuestaB);
                
                respuestaC = new RespuestaGaleria();
                respuestaC.setOpcion(resultSet.getString("PG.opcionC"));
                respuestaC.setRespuestaCorrecta(resultSet.getString("PG.correctaC"));
                respuestas.add(respuestaC);
                
                respuestaD = new RespuestaGaleria();
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
    public ArrayList<PreguntaGaleria> traerTODASPreguntas(Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        ArrayList<PreguntaGaleria> preguntas = new ArrayList<>();
        Set<RespuestaGaleria> respuestas = null;
        PreguntaGaleria pregunta = null;
        RespuestaGaleria respuestaA = null;
        RespuestaGaleria respuestaB = null;
        RespuestaGaleria respuestaC = null;
        RespuestaGaleria respuestaD = null;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT * FROM "+NOMBRETABLA+" JGP LEFT JOIN PREGUNTAGALERIA PG ON (JGP.idPreguntaGaleria=PG.ID) WHERE JGP.idPaciente = '"+paciente.getId()+"' ORDER BY nivelPersonalizado");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                pregunta = new PreguntaGaleria();
                pregunta.setImagen(resultSet.getString("PG.Imagen"));
                pregunta.setInformacion(resultSet.getString("PG.informacion"));
                pregunta.setNivel(resultSet.getInt("JGP.nivelPersonalizado"));
                pregunta.setPersonalizado("S");
                pregunta.setPregunta(resultSet.getString("PG.pregunta"));
                pregunta.setId(resultSet.getInt("JGP.id"));
                pregunta.setIdPregunta(resultSet.getInt("JGP.idPreguntaGaleria"));
                pregunta.setEstado(resultSet.getString("JGP.estado"));
                
                respuestas = new HashSet<>();
                respuestaA = new RespuestaGaleria();
                respuestaA.setOpcion(resultSet.getString("PG.opcionA"));
                respuestaA.setRespuestaCorrecta(resultSet.getString("PG.correctaA"));
                respuestas.add(respuestaA);

                respuestaB = new RespuestaGaleria();
                respuestaB.setOpcion(resultSet.getString("PG.opcionB"));
                respuestaB.setRespuestaCorrecta(resultSet.getString("PG.correctaB"));
                respuestas.add(respuestaB);
                
                respuestaC = new RespuestaGaleria();
                respuestaC.setOpcion(resultSet.getString("PG.opcionC"));
                respuestaC.setRespuestaCorrecta(resultSet.getString("PG.correctaC"));
                respuestas.add(respuestaC);
                
                respuestaD = new RespuestaGaleria();
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
        return preguntas;
    }

    @Override
    public void modificarPregunta(PreguntaGaleria pregunta) throws PersistenceNotFoundException, PersistenceException {
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
