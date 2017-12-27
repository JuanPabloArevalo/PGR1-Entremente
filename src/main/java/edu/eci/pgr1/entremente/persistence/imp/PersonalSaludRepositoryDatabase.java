/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp;

import edu.eci.pgr1.entremente.model.Familiar;
import edu.eci.pgr1.entremente.model.PersonalSalud;
import edu.eci.pgr1.entremente.model.Relacion;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.persistence.PersonalSaludRepository;
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

    @Override
    public Set<PersonalSalud> busquedaPersonalSalud(String valor) throws PersistenceNotFoundException, PersistenceException {
        Set<PersonalSalud> personalesSalud = new HashSet<>();
        PersonalSalud personalSalud = null;
        
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT * FROM "+NOMBRETABLA +" WHERE nombreUsuario LIKE '%"+valor+"%' OR nombres LIKE '%"+valor+"%' OR apellidos LIKE '%"+valor+"%' OR documentoIdentidad LIKE '%"+valor+"%' or correo LIKE '%"+valor+"%' ORDER BY Apellidos, Nombres");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                personalSalud = new PersonalSalud();
                personalSalud.setApellidos(resultSet.getString("apellidos"));
                personalSalud.setCorreo(resultSet.getString("correo"));
                personalSalud.setDocumentoIdentidad(resultSet.getString("documentoIdentidad"));
                personalSalud.setId(resultSet.getInt("id"));
                personalSalud.setNombreUsuario(resultSet.getString("nombreUsuario"));
                personalSalud.setNombres(resultSet.getString("nombres"));
                personalSalud.setTipoDocumento(resultSet.getString("tipoDocumento"));
                personalSalud.setPassword("");
                personalSalud.setRol(resultSet.getString("rol"));
                personalesSalud.add(personalSalud);
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
    
        if(personalesSalud.isEmpty()){
            throw new PersistenceException("No existe ningún personal de la salud!");
        }
        else{
            return personalesSalud;
        }
    }

    @Override
    public Set<Relacion> traerRelacionesPacientesDesdeSalud(PersonalSalud personalSalud, String estado) throws PersistenceNotFoundException {
        Set<Relacion> relaciones = new HashSet<>();
        Relacion rel = null;
        String complemento = "";
        if(Relacion.ESTADOPENDIENTE.equalsIgnoreCase(estado)){
            complemento = " AND ENVIADO = '"+Relacion.ENVIADOPACIENTE+"' ";
        }
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT * FROM PACIENTESALUD PS LEFT JOIN PACIENTE P ON (PS.idPaciente=P.ID) WHERE idPersonalSalud = '"+personalSalud.getId()+"' AND ESTADO = '"+estado+"' "+complemento+" ORDER BY PS.ID");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
               rel = new Relacion();
               rel.setApellidosFamiliar(personalSalud.getApellidos());
               rel.setIdFamiliar(personalSalud.getId());
               rel.setNombresFamiliar(personalSalud.getNombres());
               rel.setId(resultSet.getInt("PS.ID"));
               rel.setIdPaciente(resultSet.getInt("P.ID"));
               rel.setApellidosPaciente(resultSet.getString("P.APELLIDOS"));
               rel.setNombresPaciente(resultSet.getString("P.NOMBRES"));
               rel.setEstado(estado);
               rel.setRelacion(resultSet.getString("PS.relacion"));
               relaciones.add(rel);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
        return relaciones;
    }

    @Override
    public void adicionarSolicitudPacienteDesdeSalud(Relacion relacion) throws PersistenceNotFoundException, PersistenceException {
            try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("INSERT INTO PACIENTESALUD (Id, IdPaciente, idPersonalSalud, estado, relacion, enviado) VALUES (?,?,?,?,?,?) ");
            preparedStatement.setInt(1, relacion.getId());
            preparedStatement.setInt(2, relacion.getIdPaciente());
            preparedStatement.setInt(3, relacion.getIdFamiliar());
            preparedStatement.setString(4, "P");
            preparedStatement.setString(5, relacion.getRelacion());
            preparedStatement.setString(6, Relacion.ENVIADOOTRO);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        } 
    }

    @Override
    public boolean existeRelacionPacienteSalud(Relacion relacion) throws PersistenceNotFoundException, PersistenceException {
        boolean existeRelacion = false;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            
            preparedStatement = connect.prepareStatement("SELECT id FROM PACIENTESALUD WHERE idPaciente = ? AND idPersonalSalud = ?");
            preparedStatement.setInt(1, relacion.getIdPaciente());
            preparedStatement.setInt(2, relacion.getIdFamiliar());
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                relacion.setId(resultSet.getInt(1));
                existeRelacion = true;
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
    
        if(existeRelacion){
            throw new PersistenceException("Ya existe la relación Paciente - Personal de Salud");
        }
        else{
            return false;
        }
    }

    @Override
    public void aceptarSolicitudPaciente(Relacion relacion) throws PersistenceNotFoundException, PersistenceException {
            try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("UPDATE PACIENTESALUD SET ESTADO = '"+Relacion.ESTADOACEPTADO+"' WHERE ID = ?");
            preparedStatement.setInt(1, relacion.getId());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }  
    }

    @Override
    public void eliminarSolicitudPaciente(Relacion relacion) throws PersistenceNotFoundException, PersistenceException {
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("DELETE FROM PACIENTESALUD WHERE ID = ?");
            preparedStatement.setInt(1, relacion.getId());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        } 
    }
}
