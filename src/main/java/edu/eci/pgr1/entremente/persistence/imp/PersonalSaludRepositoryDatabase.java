/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp;

import edu.eci.pgr1.entremente.model.PersonalSalud;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.persistence.PersonalSaludRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Pablo Arévalo
 */
@Service
public class PersonalSaludRepositoryDatabase implements PersonalSaludRepository{
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String NOMBRETABLA = "PERSONALSALUD";

       
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
    public boolean existePersonalSalud(PersonalSalud personalSalud) throws PersistenceNotFoundException, PersistenceException {
        boolean existePersonal = false;
        String nombreUsuario = "";
        String correo = "";
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            
            preparedStatement = connect.prepareStatement("SELECT documentoIdentidad, tipoDocumento, nombreUsuario, correo FROM "+NOMBRETABLA +" WHERE (documentoIdentidad='"+personalSalud.getDocumentoIdentidad()+"' AND tipoDocumento = '"+personalSalud.getTipoDocumento()+"') OR nombreUsuario = '"+personalSalud.getNombreUsuario()+"' OR correo = '"+personalSalud.getCorreo()+"'");
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                nombreUsuario = resultSet.getString(3);
                correo = resultSet.getString(4);
                existePersonal = true;
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
    
        if(existePersonal){
            if(nombreUsuario.trim().equalsIgnoreCase(personalSalud.getNombreUsuario())){
                throw new PersistenceException("El nombre de usuario ya existe!");
            }
            else if(correo.trim().equalsIgnoreCase(personalSalud.getCorreo())){
                throw new PersistenceException("El correo ya esta registrado!");
            }
            else{
                throw new PersistenceException("El documento ya esta registrado");
            }
        }
        else{
            return false;
        }
    }

    @Override
    public PersonalSalud traerPersonalSalud(String nombreUsuarios, String password) throws PersistenceNotFoundException, PersistenceException {
        PersonalSalud personalSalud = null;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            
            preparedStatement = connect.prepareStatement("SELECT * FROM "+NOMBRETABLA +" WHERE nombreUsuario = '"+nombreUsuarios+"' AND password = '"+password+"'");
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
               personalSalud = new PersonalSalud();
               personalSalud.setApellidos(resultSet.getString("apellidos"));
               personalSalud.setCorreo(resultSet.getString("correo"));
               personalSalud.setDocumentoIdentidad(resultSet.getString("documentoIdentidad"));
               personalSalud.setId(resultSet.getInt("id"));
               personalSalud.setNombreUsuario(nombreUsuarios);
               personalSalud.setNombres(resultSet.getString("nombres"));
               personalSalud.setTipoDocumento(resultSet.getString("tipoDocumento"));
               personalSalud.setPassword(resultSet.getString("password"));
               personalSalud.setRol(resultSet.getString("rol"));
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
    
        if(personalSalud==null){
            throw new PersistenceException("Usuario/Contraseña inválidos");
        }
        else{
            return personalSalud;
        }
    }

    @Override
    public void adicionarPersonalSalud(PersonalSalud personalSalud) throws PersistenceNotFoundException {
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("insert into  "+NOMBRETABLA+" (nombres, apellidos, documentoIdentidad, nombreUsuario, password, tipoDocumento, correo, rol) values (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, personalSalud.getNombres());
            preparedStatement.setString(2, personalSalud.getApellidos());
            preparedStatement.setString(3, personalSalud.getDocumentoIdentidad());
            preparedStatement.setString(4, personalSalud.getNombreUsuario());
            preparedStatement.setString(5, personalSalud.getPassword());
            preparedStatement.setString(6, personalSalud.getTipoDocumento());
            preparedStatement.setString(7, personalSalud.getCorreo());
            preparedStatement.setString(8, personalSalud.getRol());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }          
    }
}
