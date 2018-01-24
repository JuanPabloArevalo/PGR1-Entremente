/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp;

import edu.eci.pgr1.entremente.model.Resultado;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.persistence.ResultadoRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Service;

/**
 *
 * @author JuanArevaloMerchan
 */
@Service
public class ResultadoRepositoryDatabase implements ResultadoRepository{

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String NOMBRETABLA = "RESULTADO";
    
    
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
    public void adicionarResultado(Resultado resultado) throws PersistenceNotFoundException {
            try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("INSERT INTO  "+NOMBRETABLA+" (tipoJuego, idPaciente, fecha, acertadas, erroneas, tiempo, nivelMaximo) values (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, resultado.getTipoJuego());
            preparedStatement.setString(2, resultado.getIdPaciente());
            preparedStatement.setString(3, resultado.getFecha());
            preparedStatement.setInt(4, resultado.getAcertadas());
            preparedStatement.setInt(5, resultado.getErroneas());
            preparedStatement.setDouble(6, resultado.getTiempo());
            preparedStatement.setInt(7, resultado.getNivelMaximo());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }   
    }
    
}
