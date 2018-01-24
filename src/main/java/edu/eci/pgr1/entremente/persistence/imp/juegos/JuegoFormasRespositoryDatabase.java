/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp.juegos;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.juegos.PreguntaFormas;
import edu.eci.pgr1.entremente.model.juegos.PreguntaGaleria;
import edu.eci.pgr1.entremente.model.juegos.RespuestaFormas;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoFormasRepository;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.persistence.imp.DatosBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author JuanArevaloMerchan
 */
@Service
public class JuegoFormasRespositoryDatabase implements JuegoFormasRepository{
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String NOMBRETABLA = "JUEGOFORMASPACIENTE";
    
    
    @Override
    public Set<PreguntaFormas> traerPreguntas(int nivel, Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        Set<PreguntaFormas> preguntas = new HashSet<>();
        Set<RespuestaFormas> respuestas = null;
        PreguntaFormas pregunta = null;
        RespuestaFormas respuestaA = null;
        RespuestaFormas respuestaB = null;
        RespuestaFormas respuestaC = null;
        RespuestaFormas respuestaD = null;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT * FROM "+NOMBRETABLA+" JGP LEFT JOIN PREGUNTAFORMAS PG ON (JGP.idPreguntaFormas=PG.ID) WHERE JGP.nivelPersonalizado = '"+nivel+"' AND JGP.idPaciente = '"+paciente.getId()+"' AND ESTADO = '"+PreguntaGaleria.ESTADOACTIVO+"'");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                pregunta = new PreguntaFormas();
                pregunta.setImagen(resultSet.getString("PG.Imagen"));
                pregunta.setNivel(nivel);
                pregunta.setPersonalizado("N");
                pregunta.setPregunta(resultSet.getString("PG.pregunta"));
                pregunta.setId(resultSet.getInt("JGP.id"));
                pregunta.setIdPregunta(resultSet.getInt("JGP.idPreguntaFormas"));
                
                respuestas = new HashSet<>();
                respuestaA = new RespuestaFormas();
                respuestaA.setOpcion(resultSet.getString("PG.opcionA"));
                respuestaA.setRespuestaCorrecta(resultSet.getString("PG.correctaA"));
                respuestas.add(respuestaA);

                respuestaB = new RespuestaFormas();
                respuestaB.setOpcion(resultSet.getString("PG.opcionB"));
                respuestaB.setRespuestaCorrecta(resultSet.getString("PG.correctaB"));
                respuestas.add(respuestaB);
                
                respuestaC = new RespuestaFormas();
                respuestaC.setOpcion(resultSet.getString("PG.opcionC"));
                respuestaC.setRespuestaCorrecta(resultSet.getString("PG.correctaC"));
                respuestas.add(respuestaC);
                
                respuestaD = new RespuestaFormas();
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
    
}
