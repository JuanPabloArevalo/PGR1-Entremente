/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp;

import edu.eci.pgr1.entremente.model.Mensaje;
import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.persistence.MensajeRepository;
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
public class MensajeRepositoryDatabase implements MensajeRepository{
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String NOMBRETABLA = "MENSAJES";
    
    @Override
    public void adicionarMensaje(Mensaje mensaje) throws PersistenceNotFoundException {
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("insert into  "+NOMBRETABLA+" (idPaciente, idPersonalSalud, idFamiliar, fecha, mensaje, tipo, rol, puedeVerPac) values (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, mensaje.getIdPaciente());
            preparedStatement.setString(2, mensaje.getIdPersonalSalud());
            preparedStatement.setString(3, mensaje.getIdFamiliar());
            preparedStatement.setString(4, mensaje.getFecha());
            preparedStatement.setString(5, mensaje.getMensaje());
            preparedStatement.setString(6, mensaje.getTipo());
            preparedStatement.setString(7, mensaje.getRol());
            preparedStatement.setString(8, mensaje.getPuedeVerPac());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }  
    }

    @Override
    public void eliminarMensaje(Mensaje mensaje) throws PersistenceNotFoundException, PersistenceException {
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("DELETE FROM "+NOMBRETABLA+" WHERE ID = ?");
            preparedStatement.setInt(1, mensaje.getId());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        } 
    }

    @Override
    public Set<Mensaje> traerMensajesDePaciente(Paciente paciente, String puedeVerPaciente) throws PersistenceNotFoundException {
        Set<Mensaje> mensajes = new HashSet<>();
        Mensaje mensaje;
        String complemento = "";
        if(puedeVerPaciente.trim().equalsIgnoreCase(Mensaje.SIPUEDEVERPACIENTE)){
            complemento = " AND puedeVerPac = '"+Mensaje.SIPUEDEVERPACIENTE+"' ";
        }
        
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT *, STR_TO_DATE(M.Fecha, '%d/%m/%Y') as Fech FROM "+NOMBRETABLA+" M LEFT JOIN PACIENTE P ON (M.idPaciente=P.ID) LEFT JOIN PERSONALSALUD PS ON (M.idPersonalSalud=PS.ID) LEFT JOIN FAMILIAR F ON (M.idFamiliar=F.ID) WHERE idPaciente = '"+paciente.getId()+"' "+complemento+" ORDER BY M.Fecha");
            System.out.println("SELECT * FROM "+NOMBRETABLA+" M LEFT JOIN PACIENTE P ON (M.idPaciente=P.ID) LEFT JOIN PERSONALSALUD PS ON (M.idPersonalSalud=PS.ID) LEFT JOIN FAMILIAR F ON (M.idFamiliar=F.ID) WHERE idPaciente = '"+paciente.getId()+"' "+complemento+" ORDER BY M.Fecha");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
               mensaje = new Mensaje();
               mensaje.setFecha(resultSet.getString("M.Fecha"));
               mensaje.setId(resultSet.getInt("M.ID"));
               mensaje.setIdFamiliar(resultSet.getString("M.idFamiliar"));
               mensaje.setIdPaciente(resultSet.getString("M.idPaciente"));
               mensaje.setIdPersonalSalud(resultSet.getString("M.idPersonalSalud"));
               mensaje.setMensaje(resultSet.getString("M.Mensaje"));
               mensaje.setPuedeVerPac(resultSet.getString("M.puedeVerPac"));
               mensaje.setRol(resultSet.getString("M.ROL"));
               mensaje.setTipo(resultSet.getString("M.TIPO"));
               if(resultSet.getString("M.puedeVerPac").equalsIgnoreCase("S")){
                   mensaje.setCheckBox("checked");
               }
               else{
                   mensaje.setCheckBox("");
               }
               
               if(resultSet.getString("M.idFamiliar")!=null){
                   mensaje.setNombreRemitente(resultSet.getString("F.nombres")+" "+resultSet.getString("F.apellidos"));
               }
               else if(resultSet.getString("M.idPersonalSalud")!=null){
                   mensaje.setNombreRemitente(resultSet.getString("PS.nombres")+" "+resultSet.getString("PS.apellidos"));
               }
               mensajes.add(mensaje);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
        return mensajes;
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
