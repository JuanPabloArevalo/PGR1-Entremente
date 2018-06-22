/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp;

import edu.eci.pgr1.entremente.model.Enfermedad;
import edu.eci.pgr1.entremente.model.HistorialMedico;
import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.persistence.HistorialMedicoRepository;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
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
public class HistorialMedicoRepositoryDatabase implements HistorialMedicoRepository{

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String NOMBRETABLA = "HISTORIALMEDICO";
    
    @Override
    public void adicionar(HistorialMedico historialM) throws PersistenceNotFoundException {
            try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("INSERT INTO  "+NOMBRETABLA+" (idPaciente, idEnfermedad, idPersonalSalud, fecha, rol) values (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, historialM.getIdPaciente());
            preparedStatement.setInt(2, historialM.getEnfermedad().getId());
            preparedStatement.setString(3, historialM.getIdPersonalSalud());
            preparedStatement.setString(4, historialM.getFecha());
            preparedStatement.setString(5, historialM.getRol());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }  
    }

    @Override
    public void eliminar(HistorialMedico historialM) throws PersistenceNotFoundException, PersistenceException {
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("DELETE FROM "+NOMBRETABLA+" WHERE ID = ?");
            preparedStatement.setInt(1, historialM.getId());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        } 
    }

    @Override
    public ArrayList<HistorialMedico> traerHistorialMedicoDePaciente(Paciente paciente) throws PersistenceNotFoundException {
        ArrayList<HistorialMedico> historialMed = new ArrayList<>();
        HistorialMedico historial;
        Enfermedad enferemedad;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT * FROM "+NOMBRETABLA+" HM LEFT JOIN PACIENTE P ON (HM.idPaciente=P.ID) LEFT JOIN PERSONALSALUD PS ON (HM.idPersonalSalud=PS.ID) LEFT JOIN ENFERMEDAD E ON (HM.idEnfermedad=E.Id) WHERE HM.idPaciente = '"+paciente.getId()+"' ORDER BY HM.Fecha");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                historial = new HistorialMedico();
                enferemedad = new Enfermedad();
                enferemedad.setCodigo(resultSet.getString("E.Codigo"));
                enferemedad.setId(resultSet.getInt("HM.idEnfermedad"));
                enferemedad.setNombre(resultSet.getString("E.Nombre"));
                historial.setEnfermedad(enferemedad);
                historial.setFecha(resultSet.getString("HM.fecha"));
                historial.setId(resultSet.getInt("HM.Id"));
                historial.setIdPaciente(resultSet.getString("HM.idPaciente"));
                historial.setIdPersonalSalud(resultSet.getString("HM.idPersonalSalud"));
                historial.setNombresPaciente(resultSet.getString("P.nombres") + " "+resultSet.getString("P.apellidos"));
                historial.setNombresPersonalSalud(resultSet.getString("PS.nombres") + " "+resultSet.getString("PS.apellidos"));
                historial.setRol(resultSet.getString("HM.rol"));
                historialMed.add(historial);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
        return historialMed;
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
