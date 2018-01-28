/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp.juegos;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.Resultado;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.persistence.imp.DatosBD;
import edu.eci.pgr1.entremente.persistence.juegos.ResultadoRepository;
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

    @Override
    public ArrayList<Resultado> traerResultadosDias(Paciente paciente, String fechaInicial, String fechaFinal, String tipoJuego) throws PersistenceNotFoundException, PersistenceException {
        ArrayList<Resultado> resultados = new ArrayList<>();
        Resultado resultado;
        
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT SUM(acertadas), SUM(erroneas), SUM(tiempo), MAX(nivelMaximo), fecha FROM "+NOMBRETABLA+" R  WHERE R.idPaciente = '"+paciente.getId()+"' AND tipoJuego = '"+tipoJuego+"' AND fecha between '"+fechaInicial+"' AND '"+fechaFinal+"' GROUP BY fecha ORDER BY fecha LIMIT 12");
            System.out.println("SELECT SUM(acertadas), SUM(erroneas), SUM(tiempo), MAX(nivelMaximo), fecha FROM "+NOMBRETABLA+" R  WHERE R.idPaciente = '"+paciente.getId()+"' AND tipoJuego = '"+tipoJuego+"' AND fecha between '"+fechaInicial+"' AND '"+fechaFinal+"' GROUP BY fecha ORDER BY fecha LIMIT 12");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
               resultado = new Resultado();
               resultado.setAcertadas(resultSet.getInt(1));
               resultado.setErroneas(resultSet.getInt(2));
               resultado.setTiempo(resultSet.getInt(3));
               resultado.setNivelMaximo(resultSet.getInt(4));
               resultado.setFecha(resultSet.getString(5));
               resultado.setIdPaciente(paciente.getId().toString());
               resultado.setTipoJuego(tipoJuego);
               resultados.add(resultado);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
        if(resultados.isEmpty()){
            throw new PersistenceException("No existen datos para este periodo de tiempo");
        }
        return resultados;
    
    }

    @Override
    public ArrayList<Resultado> traerResultadosMeses(Paciente paciente, String fechaInicial, String fechaFinal, String tipoJuego) throws PersistenceNotFoundException, PersistenceException {
        ArrayList<Resultado> resultados = new ArrayList<>();
        Resultado resultado;
        
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT SUM(acertadas), SUM(erroneas), SUM(tiempo), MAX(nivelMaximo),  EXTRACT(YEAR_MONTH FROM fecha) FROM RESULTADO WHERE tipoJuego = '"+tipoJuego+"' AND idPaciente = '"+paciente.getId()+"' AND fecha between '"+fechaInicial+"' AND '"+fechaFinal+"' GROUP BY EXTRACT(YEAR_MONTH FROM fecha) ORDER BY fecha LIMIT 12");
            System.out.println("SELECT SUM(acertadas), SUM(erroneas), SUM(tiempo), MAX(nivelMaximo),  EXTRACT(YEAR_MONTH FROM fecha) FROM RESULTADO WHERE tipoJuego = '"+tipoJuego+"' AND idPaciente = '"+paciente.getId()+"' AND fecha between '"+fechaInicial+"' AND '"+fechaFinal+"' GROUP BY EXTRACT(YEAR_MONTH FROM fecha) ORDER BY fecha LIMIT 12");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
               resultado = new Resultado();
               resultado.setAcertadas(resultSet.getInt(1));
               resultado.setErroneas(resultSet.getInt(2));
               resultado.setTiempo(resultSet.getInt(3));
               resultado.setNivelMaximo(resultSet.getInt(4));
               resultado.setFecha(resultSet.getString(5));
               resultado.setIdPaciente(paciente.getId().toString());
               resultado.setTipoJuego(tipoJuego);
               resultados.add(resultado);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
        if(resultados.isEmpty()){
            throw new PersistenceException("No existen datos para este periodo de tiempo");
        }
        return resultados;
    }

    @Override
    public ArrayList<Resultado> traerResultadosAnios(Paciente paciente, String fechaInicial, String fechaFinal, String tipoJuego) throws PersistenceNotFoundException, PersistenceException {
        ArrayList<Resultado> resultados = new ArrayList<>();
        Resultado resultado;
        
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT SUM(acertadas), SUM(erroneas), SUM(tiempo), MAX(nivelMaximo),  EXTRACT(YEAR FROM fecha) FROM RESULTADO WHERE tipoJuego = '"+tipoJuego+"' AND idPaciente = '"+paciente.getId()+"' AND fecha between '"+fechaInicial+"' AND '"+fechaFinal+"' GROUP BY EXTRACT(YEAR FROM fecha) ORDER BY EXTRACT(YEAR FROM fecha) LIMIT 12");
            System.out.println("SELECT SUM(acertadas), SUM(erroneas), SUM(tiempo), MAX(nivelMaximo),  EXTRACT(YEAR FROM fecha) FROM RESULTADO WHERE tipoJuego = '"+tipoJuego+"' AND idPaciente = '"+paciente.getId()+"' AND fecha between '"+fechaInicial+"' AND '"+fechaFinal+"' GROUP BY EXTRACT(YEAR FROM fecha) ORDER BY EXTRACT(YEAR FROM fecha) LIMIT 12");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
               resultado = new Resultado();
               resultado.setAcertadas(resultSet.getInt(1));
               resultado.setErroneas(resultSet.getInt(2));
               resultado.setTiempo(resultSet.getInt(3));
               resultado.setNivelMaximo(resultSet.getInt(4));
               resultado.setFecha(resultSet.getString(5));
               resultado.setIdPaciente(paciente.getId().toString());
               resultado.setTipoJuego(tipoJuego);
               resultados.add(resultado);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
        if(resultados.isEmpty()){
            throw new PersistenceException("No existen datos para este periodo de tiempo");
        }
        return resultados;
    }
    
}
