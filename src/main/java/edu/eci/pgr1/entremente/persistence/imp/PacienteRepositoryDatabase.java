/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.persistence.PacienteRepository;
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
 * @author Administrador
 */
@Service
public class PacienteRepositoryDatabase implements PacienteRepository{
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String NOMBRETABLA = "PACIENTE";

    @Override
    public void adicionarPaciente(Paciente paciente) throws PersistenceNotFoundException{
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("insert into  "+NOMBRETABLA+" (nombres, apellidos, documentoIdentidad, fechaNacimiento, genero, pais, ciudad, nombreUsuario, password, direccion, tipoDocumento, correo) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, paciente.getNombres());
            preparedStatement.setString(2, paciente.getApellidos());
            preparedStatement.setString(3, paciente.getDocumentoIdentidad());
            preparedStatement.setString(4, paciente.getFechaNacimiento());
            preparedStatement.setString(5, paciente.getGenero());
            preparedStatement.setString(6, paciente.getPais());
            preparedStatement.setString(7, paciente.getCiudad());
            preparedStatement.setString(8, paciente.getNombreUsuario());
            preparedStatement.setString(9, paciente.getPassword());
            preparedStatement.setString(10, paciente.getDireccion());
            preparedStatement.setString(11, paciente.getTipoDocumento());
            preparedStatement.setString(12, paciente.getCorreo());
            preparedStatement.executeUpdate();
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

    @Override
    public boolean existePaciente(Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        boolean existePaciente = false;
        String nombreUsuario = "";
        String correo = "";
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            
            preparedStatement = connect.prepareStatement("SELECT documentoIdentidad, tipoDocumento, nombreUsuario, correo FROM "+NOMBRETABLA +" WHERE (documentoIdentidad='"+paciente.getDocumentoIdentidad()+"' AND tipoDocumento = '"+paciente.getTipoDocumento()+"') OR nombreUsuario = '"+paciente.getNombreUsuario()+"' OR correo = '"+paciente.getCorreo()+"'");
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                nombreUsuario = resultSet.getString(3);
                correo = resultSet.getString(4);
                existePaciente = true;
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
    
        if(existePaciente){
            if(nombreUsuario.trim().equalsIgnoreCase(paciente.getNombreUsuario())){
                throw new PersistenceException("El nombre de usuario ya existe!");
            }
            else if(correo.trim().equalsIgnoreCase(paciente.getCorreo())){
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
    public Paciente traerPaciente(String nombreUsuarios, String password) throws PersistenceNotFoundException, PersistenceException {
        Paciente paciente = null;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            
            preparedStatement = connect.prepareStatement("SELECT * FROM "+NOMBRETABLA +" WHERE nombreUsuario = '"+nombreUsuarios+"' AND password = '"+password+"'");
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
               paciente = new Paciente();
               paciente.setApellidos(resultSet.getString("apellidos"));
               paciente.setCiudad(resultSet.getString("ciudad"));
               paciente.setCorreo(resultSet.getString("correo"));
               paciente.setDireccion(resultSet.getString("direccion"));
               paciente.setDocumentoIdentidad(resultSet.getString("documentoIdentidad"));
               paciente.setFechaNacimiento(resultSet.getDate("fechaNacimiento").toString());
               paciente.setGenero(resultSet.getString("genero"));
               paciente.setId(resultSet.getInt("id"));
               paciente.setNombreUsuario(nombreUsuarios);
               paciente.setNombres(resultSet.getString("nombres"));
               paciente.setPais(resultSet.getString("pais"));
               paciente.setTipoDocumento(resultSet.getString("tipoDocumento"));
               paciente.setPassword(resultSet.getString("password"));
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
    
        if(paciente==null){
            throw new PersistenceException("Usuario/Contraseña inválidos");
        }
        else{
            return paciente;
        }
    }

    @Override
    public Set<Paciente> busquedaPacientes(String valor) throws PersistenceNotFoundException, PersistenceException {
        Set<Paciente> pacientes = new HashSet<>();
        Paciente paciente = null;
        
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            
            preparedStatement = connect.prepareStatement("SELECT * FROM "+NOMBRETABLA +" WHERE nombreUsuario LIKE '%"+valor+"%' OR nombres LIKE '%"+valor+"%' OR apellidos LIKE '%"+valor+"%' OR documentoIdentidad LIKE '%"+valor+"%' or correo LIKE '%"+valor+"%' ORDER BY Apellidos, Nombres");
            System.out.println("SELECT * FROM "+NOMBRETABLA +" WHERE nombreUsuario LIKE '%"+valor+"%' OR nombres LIKE '%"+valor+"%' OR apellidos LIKE '%"+valor+"%' OR documentoIdentidad LIKE '%"+valor+"%' or correo LIKE '%"+valor+"%' ORDER BY Apellidos, Nombres");
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                System.out.println("Entroooo. ");
               paciente = new Paciente();
               paciente.setApellidos(resultSet.getString("apellidos"));
               paciente.setCiudad(resultSet.getString("ciudad"));
               paciente.setCorreo(resultSet.getString("correo"));
               paciente.setDireccion(resultSet.getString("direccion"));
               paciente.setDocumentoIdentidad(resultSet.getString("documentoIdentidad"));
               paciente.setFechaNacimiento(resultSet.getDate("fechaNacimiento").toString());
               paciente.setGenero(resultSet.getString("genero"));
               paciente.setId(resultSet.getInt("id"));
               paciente.setNombreUsuario(resultSet.getString("nombreUsuario"));
               paciente.setNombres(resultSet.getString("nombres"));
               paciente.setPais(resultSet.getString("pais"));
               paciente.setTipoDocumento(resultSet.getString("tipoDocumento"));
               paciente.setPassword("");
               pacientes.add(paciente);
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
    
        if(pacientes.isEmpty()){
            throw new PersistenceException("No existen pacienes con ese dato!");
        }
        else{
            return pacientes;
        }
        
    }
}
