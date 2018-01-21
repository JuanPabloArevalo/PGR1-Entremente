/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp;

import edu.eci.pgr1.entremente.model.Enfermedad;
import edu.eci.pgr1.entremente.persistence.EnfermedadRepository;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author JuanArevaloMerchan
 */
@Service
public class EnfermedadRepositoryDatabase implements EnfermedadRepository{
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String NOMBRETABLA = "ENFERMEDAD";
    
    @Override
    public ArrayList<Enfermedad> cargarEnfermedades() throws PersistenceNotFoundException {
            ArrayList<Enfermedad> enferemedades = new ArrayList<>();
        Enfermedad enferemedad;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT * FROM "+NOMBRETABLA+" ORDER BY Codigo");
            System.out.println("SELECT * FROM ENFERMEDAD ORDER BY Codigo");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                enferemedad = new Enfermedad();
                enferemedad.setCodigo(resultSet.getString("Codigo"));
                enferemedad.setId(resultSet.getInt("id"));
                enferemedad.setNombre(resultSet.getString("Nombre"));
                enferemedades.add(enferemedad);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
        return enferemedades;
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
