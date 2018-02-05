/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp.juegos;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.juegos.PreguntaMusicoterapia;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.persistence.imp.DatosBD;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoMusicoterapiaRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author JuanArevaloMerchan
 */
@Service
public class JuegoMusicoterapiaRepositoryDatabase implements JuegoMusicoterapiaRepository{
    
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String NOMBRETABLA = "JUEGOMUSICOTERAPIAPACIENTE";

    @Override
    public Set<PreguntaMusicoterapia> traerPreguntas(int nivel, Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PreguntaMusicoterapia> traerTODASPreguntas(Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarPregunta(PreguntaMusicoterapia pregunta) throws PersistenceNotFoundException, PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adicionarPregunta(PreguntaMusicoterapia pregunta, Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        long idInsertado = 0;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            connect.setAutoCommit(false);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("insert into  PREGUNTAMUSICOTERAPIA (video, pregunta, opcionA, opcionB, opcionC, opcionD, nivelPredeterminado, personalizado, correctaA, correctaB, correctaC, correctaD) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, pregunta.getVideo());
            preparedStatement.setString(2, pregunta.getPregunta());
            preparedStatement.setString(3, pregunta.getRespuestas().get(0).getOpcion());
            preparedStatement.setString(4, pregunta.getRespuestas().get(1).getOpcion());
            preparedStatement.setString(5, pregunta.getRespuestas().get(2).getOpcion());
            preparedStatement.setString(6, pregunta.getRespuestas().get(3).getOpcion());
            preparedStatement.setInt(7, pregunta.getNivel());
            preparedStatement.setString(8, "S");
            preparedStatement.setString(9, pregunta.getRespuestas().get(0).getRespuestaCorrecta());
            preparedStatement.setString(10, pregunta.getRespuestas().get(1).getRespuestaCorrecta());
            preparedStatement.setString(11, pregunta.getRespuestas().get(2).getRespuestaCorrecta());
            preparedStatement.setString(12, pregunta.getRespuestas().get(3).getRespuestaCorrecta());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                idInsertado = rs.getLong(1);
            }
            preparedStatement = connect.prepareStatement("INSERT INTO  "+NOMBRETABLA+" (IdPaciente, idPreguntaMusicoterapia, nivelPersonalizado, estado) values (?, ?, ?, ?)");
            preparedStatement.setLong(1, paciente.getId());
            preparedStatement.setLong(2, idInsertado);
            preparedStatement.setInt(3, pregunta.getNivel());
            preparedStatement.setString(4, PreguntaMusicoterapia.ESTADOACTIVO);
            preparedStatement.executeUpdate();
            
            
            try {
                connect.commit();
            } catch (SQLException e) {
                connect.rollback();
                throw new PersistenceNotFoundException(e.getMessage());
            }
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
