/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp.juegos;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.juegos.PreguntaAtencion;
import edu.eci.pgr1.entremente.model.juegos.PreguntaGaleria;
import edu.eci.pgr1.entremente.model.juegos.RespuestaAtencion;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoAtencionRepository;
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
 * @author Administrador
 */
@Service
public class JuegoAtencionRepositoryDatabase implements JuegoAtencionRepository{
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String NOMBRETABLA = "JUEGOATENCIONPACIENTE";
    
    @Override
    public Set<PreguntaAtencion> traerPreguntas(int nivel, Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        Set<PreguntaAtencion> preguntas = new HashSet<>();
        Set<RespuestaAtencion> respuestas = null;
        PreguntaAtencion pregunta = null;
        RespuestaAtencion respuestaA = null;
        RespuestaAtencion respuestaB = null;
        RespuestaAtencion respuestaC = null;
        RespuestaAtencion respuestaD = null;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT * FROM "+NOMBRETABLA+" JAP LEFT JOIN PREGUNTAATENCION PA ON (JAP.idPreguntaAtencion=PA.ID) WHERE JAP.nivelPersonalizado = '"+nivel+"' AND JAP.idPaciente = '"+paciente.getId()+"' AND JAP.ESTADO = '"+PreguntaGaleria.ESTADOACTIVO+"'");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                pregunta = new PreguntaAtencion();
                pregunta.setImagen(resultSet.getString("PA.Imagen"));
                pregunta.setPalabraClave(resultSet.getString("PA.palabraClave"));
                pregunta.setNivel(nivel);
                pregunta.setPersonalizado("N");
                pregunta.setPregunta(resultSet.getString("PA.pregunta"));
                pregunta.setId(resultSet.getInt("JAP.id"));
                pregunta.setIdPregunta(resultSet.getInt("JAP.idPreguntaAtencion"));
                
                respuestas = new HashSet<>();
                respuestaA = new RespuestaAtencion();
                respuestaA.setOpcion(resultSet.getString("PA.opcionA"));
                respuestaA.setRespuestaCorrecta(resultSet.getString("PA.correctaA"));
                respuestaA.setPalabraClave(resultSet.getString("PA.palabraClaveA"));
                respuestas.add(respuestaA);

                respuestaB = new RespuestaAtencion();
                respuestaB.setOpcion(resultSet.getString("PA.opcionB"));
                respuestaB.setRespuestaCorrecta(resultSet.getString("PA.correctaB"));
                respuestaB.setPalabraClave(resultSet.getString("PA.palabraClaveB"));
                respuestas.add(respuestaB);
                
                respuestaC = new RespuestaAtencion();
                respuestaC.setOpcion(resultSet.getString("PA.opcionC"));
                respuestaC.setRespuestaCorrecta(resultSet.getString("PA.correctaC"));
                respuestaC.setPalabraClave(resultSet.getString("PA.palabraClaveC"));
                respuestas.add(respuestaC);
                
                respuestaD = new RespuestaAtencion();
                respuestaD.setOpcion(resultSet.getString("PA.opcionD"));
                respuestaD.setRespuestaCorrecta(resultSet.getString("PA.correctaD"));
                respuestaD.setPalabraClave(resultSet.getString("PA.palabraClaveD"));
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
    public ArrayList<PreguntaAtencion> traerTODASPreguntas(Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        ArrayList<PreguntaAtencion> preguntas = new ArrayList<>();
        Set<RespuestaAtencion> respuestas = null;
        PreguntaAtencion pregunta = null;
        RespuestaAtencion respuestaA = null;
        RespuestaAtencion respuestaB = null;
        RespuestaAtencion respuestaC = null;
        RespuestaAtencion respuestaD = null;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT * FROM "+NOMBRETABLA+" JGP LEFT JOIN PREGUNTAATENCION PA ON (JGP.idPreguntaAtencion=PA.ID) WHERE JGP.idPaciente = '"+paciente.getId()+"' ORDER BY nivelPersonalizado");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                pregunta = new PreguntaAtencion();
                pregunta.setImagen(resultSet.getString("PA.Imagen"));
                pregunta.setPalabraClave(resultSet.getString("PA.palabraClave"));
                pregunta.setNivel(resultSet.getInt("JGP.nivelPersonalizado"));
                pregunta.setPersonalizado("S");
                pregunta.setPregunta(resultSet.getString("PA.pregunta"));
                pregunta.setId(resultSet.getInt("JGP.id"));
                pregunta.setIdPregunta(resultSet.getInt("JGP.idPreguntaAtencion"));
                pregunta.setEstado(resultSet.getString("JGP.estado"));
                
                respuestas = new HashSet<>();
                respuestaA = new RespuestaAtencion();
                respuestaA.setOpcion(resultSet.getString("PA.opcionA"));
                respuestaA.setRespuestaCorrecta(resultSet.getString("PA.correctaA"));
                respuestaA.setPalabraClave(resultSet.getString("PA.palabraClaveA"));
                respuestas.add(respuestaA);

                respuestaB = new RespuestaAtencion();
                respuestaB.setOpcion(resultSet.getString("PA.opcionB"));
                respuestaB.setRespuestaCorrecta(resultSet.getString("PA.correctaB"));
                respuestaB.setPalabraClave(resultSet.getString("PA.palabraClaveB"));
                respuestas.add(respuestaB);
                
                respuestaC = new RespuestaAtencion();
                respuestaC.setOpcion(resultSet.getString("PA.opcionC"));
                respuestaC.setRespuestaCorrecta(resultSet.getString("PA.correctaC"));
                respuestaC.setPalabraClave(resultSet.getString("PA.palabraClaveC"));
                respuestas.add(respuestaC);
                
                respuestaD = new RespuestaAtencion();
                respuestaD.setOpcion(resultSet.getString("PA.opcionD"));
                respuestaD.setRespuestaCorrecta(resultSet.getString("PA.correctaD"));
                respuestaD.setPalabraClave(resultSet.getString("PA.palabraClaveD"));
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
    public void modificarPregunta(PreguntaAtencion pregunta) throws PersistenceNotFoundException, PersistenceException {
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
