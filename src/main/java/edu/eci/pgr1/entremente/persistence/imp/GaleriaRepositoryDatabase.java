/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.PreguntaGaleria;
import edu.eci.pgr1.entremente.model.Relacion;
import edu.eci.pgr1.entremente.model.RespuestaGaleria;
import edu.eci.pgr1.entremente.persistence.GaleriaRepository;
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

/**
 *
 * @author JuanArevaloMerchan
 */
@Service
public class GaleriaRepositoryDatabase implements GaleriaRepository{
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
                pregunta.setPersonalizado("S");
                pregunta.setPregunta(resultSet.getString("PG.pregunta"));
                pregunta.setId(resultSet.getInt("JGP.id"));
                pregunta.setIdPregunta(resultSet.getInt("JGP.idPreguntaGaleria"));
                
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

    @Override
    public Set<PreguntaGaleria> traerPreguntasPredeterminadas(int nivel) throws PersistenceNotFoundException, PersistenceException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
