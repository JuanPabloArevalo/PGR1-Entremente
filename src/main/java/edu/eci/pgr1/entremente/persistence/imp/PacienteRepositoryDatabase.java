/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.Progreso;
import edu.eci.pgr1.entremente.model.Relacion;
import edu.eci.pgr1.entremente.model.juegos.PreguntaAtencion;
import edu.eci.pgr1.entremente.model.juegos.PreguntaCalculo;
import edu.eci.pgr1.entremente.model.juegos.PreguntaFormas;
import edu.eci.pgr1.entremente.model.juegos.PreguntaGaleria;
import edu.eci.pgr1.entremente.model.juegos.PreguntaMusicoterapia;
import edu.eci.pgr1.entremente.model.juegos.PreguntaQueUsar;
import edu.eci.pgr1.entremente.persistence.PacienteRepository;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.security.AES;
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
public class PacienteRepositoryDatabase implements PacienteRepository {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String NOMBRETABLA = "PACIENTE";

    @Override
    public void adicionarPaciente(Paciente paciente) throws PersistenceNotFoundException {
        if(!paciente.getCorreo().isEmpty()){
            paciente.setCorreo(paciente.getCorreo());
        }
        if(!paciente.getDocumentoIdentidad().isEmpty()){
            paciente.setDocumentoIdentidad(paciente.getDocumentoIdentidad());
        }
        
        long idInsertado = 0;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);

            connect.setAutoCommit(false);

            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("insert into  " + NOMBRETABLA + " (nombres, apellidos, documentoIdentidad, fechaNacimiento, genero, pais, ciudad, nombreUsuario, password, direccion, tipoDocumento, correo) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
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
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                idInsertado = rs.getLong(1);
            }
            
            //Preguntas Atencion
            preparedStatement = connect.prepareStatement("SELECT Id, nivelPredeterminado FROM PREGUNTAATENCION WHERE PERSONALIZADO = 'N'");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                preparedStatement = connect.prepareStatement("INSERT INTO  JUEGOATENCIONPACIENTE (IdPaciente, idPreguntaAtencion, nivelPersonalizado, estado) values (?, ?, ?, ?)");
                preparedStatement.setLong(1, idInsertado);
                preparedStatement.setString(2, resultSet.getString(1));
                preparedStatement.setString(3, resultSet.getString(2));
                preparedStatement.setString(4, PreguntaAtencion.ESTADOACTIVO);
                preparedStatement.executeUpdate();
            }
            //Preguntas Calculo
            preparedStatement = connect.prepareStatement("SELECT Id, nivelPredeterminado FROM PREGUNTACALCULO WHERE PERSONALIZADO = 'N'");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                preparedStatement = connect.prepareStatement("INSERT INTO  JUEGOCALCULOPACIENTE (IdPaciente, idPreguntaCalculo, nivelPersonalizado, estado) values (?, ?, ?, ?)");
                preparedStatement.setLong(1, idInsertado);
                preparedStatement.setString(2, resultSet.getString(1));
                preparedStatement.setString(3, resultSet.getString(2));
                preparedStatement.setString(4, PreguntaCalculo.ESTADOACTIVO);
                preparedStatement.executeUpdate();
            }
            //Preguntas Formas
            preparedStatement = connect.prepareStatement("SELECT Id, nivelPredeterminado FROM PREGUNTAFORMAS WHERE PERSONALIZADO = 'N'");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                preparedStatement = connect.prepareStatement("INSERT INTO  JUEGOFORMASPACIENTE (IdPaciente, idPreguntaFormas, nivelPersonalizado, estado) values (?, ?, ?, ?)");
                preparedStatement.setLong(1, idInsertado);
                preparedStatement.setString(2, resultSet.getString(1));
                preparedStatement.setString(3, resultSet.getString(2));
                preparedStatement.setString(4, PreguntaFormas.ESTADOACTIVO);
                preparedStatement.executeUpdate();
            }
            //Preguntas Galeria
            preparedStatement = connect.prepareStatement("SELECT Id, nivelPredeterminado FROM PREGUNTAGALERIA WHERE PERSONALIZADO = 'N'");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                preparedStatement = connect.prepareStatement("INSERT INTO  JUEGOGALERIAPACIENTE (IdPaciente, idPreguntaGaleria, nivelPersonalizado, estado) values (?, ?, ?, ?)");
                preparedStatement.setLong(1, idInsertado);
                preparedStatement.setString(2, resultSet.getString(1));
                preparedStatement.setString(3, resultSet.getString(2));
                preparedStatement.setString(4, PreguntaGaleria.ESTADOACTIVO);
                preparedStatement.executeUpdate();
            }
            //Preguntas PERCEPCION
            preparedStatement = connect.prepareStatement("SELECT Id, nivelPredeterminado FROM PREGUNTAPERCEPCION WHERE PERSONALIZADO = 'N'");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                preparedStatement = connect.prepareStatement("INSERT INTO  JUEGOPERCEPCIONPACIENTE (IdPaciente, idPreguntaPercepcion, nivelPersonalizado, estado) values (?, ?, ?, ?)");
                preparedStatement.setLong(1, idInsertado);
                preparedStatement.setString(2, resultSet.getString(1));
                preparedStatement.setString(3, resultSet.getString(2));
                preparedStatement.setString(4, PreguntaAtencion.ESTADOACTIVO);
                preparedStatement.executeUpdate();
            }
            //Preguntas MUSICOTERAPIA
            preparedStatement = connect.prepareStatement("SELECT Id, nivelPredeterminado FROM PREGUNTAMUSICOTERAPIA WHERE PERSONALIZADO = 'N'");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                preparedStatement = connect.prepareStatement("INSERT INTO  JUEGOMUSICOTERAPIAPACIENTE (IdPaciente, idPreguntaMusicoterapia, nivelPersonalizado, estado) values (?, ?, ?, ?)");
                preparedStatement.setLong(1, idInsertado);
                preparedStatement.setString(2, resultSet.getString(1));
                preparedStatement.setString(3, resultSet.getString(2));
                preparedStatement.setString(4, PreguntaMusicoterapia.ESTADOACTIVO);
                preparedStatement.executeUpdate();
            }
            //Preguntas QUE USAR
            preparedStatement = connect.prepareStatement("SELECT Id, nivelPredeterminado FROM PREGUNTAQUEUSAR");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                preparedStatement = connect.prepareStatement("INSERT INTO  JUEGOQUEUSARPACIENTE (IdPaciente, idPreguntaQueUsar, nivelPersonalizado, estado) values (?, ?, ?, ?)");
                preparedStatement.setLong(1, idInsertado);
                preparedStatement.setString(2, resultSet.getString(1));
                preparedStatement.setString(3, resultSet.getString(2));
                preparedStatement.setString(4, PreguntaQueUsar.ESTADOACTIVO);
                preparedStatement.executeUpdate();
            }
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

    @Override
    public boolean existePaciente(Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        boolean existePaciente = false;
        String nombreUsuario = "";
        String correo = "";
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);

            preparedStatement = connect.prepareStatement("SELECT documentoIdentidad, tipoDocumento, nombreUsuario, correo FROM " + NOMBRETABLA + " WHERE (documentoIdentidad='" + AES.encrypt(paciente.getDocumentoIdentidad()) + "' AND tipoDocumento = '" + paciente.getTipoDocumento() + "') OR nombreUsuario = '" + paciente.getNombreUsuario() + "' OR correo = '" + AES.encrypt(paciente.getCorreo()) + "'");
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                nombreUsuario = resultSet.getString(3);
                correo = resultSet.getString(4);
                existePaciente = true;
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }

        if (existePaciente) {
            if (nombreUsuario.trim().equalsIgnoreCase(paciente.getNombreUsuario())) {
                throw new PersistenceException("El nombre de usuario ya existe!");
            } else if (correo.trim().equalsIgnoreCase(paciente.getCorreo())) {
                throw new PersistenceException("El correo ya esta registrado!");
            } else {
                throw new PersistenceException("El documento ya esta registrado");
            }
        } else {
            return false;
        }
    }

    @Override
    public Paciente traerPaciente(String nombreUsuarios, String password) throws PersistenceNotFoundException, PersistenceException {
        Paciente paciente = null;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);

            preparedStatement = connect.prepareStatement("SELECT * FROM " + NOMBRETABLA + " WHERE nombreUsuario = '" + nombreUsuarios + "' AND password = '" + password + "'");
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                paciente = new Paciente();
                paciente.setApellidos(resultSet.getString("apellidos"));
                paciente.setCiudad(resultSet.getString("ciudad"));
                paciente.setCorreo(resultSet.getString("correo"));
                if(!paciente.getCorreo().isEmpty()){
                   paciente.setCorreo(AES.decrypt(paciente.getCorreo()));
                }
                paciente.setDireccion(resultSet.getString("direccion"));
                paciente.setDocumentoIdentidad(resultSet.getString("documentoIdentidad"));
                if(!paciente.getDocumentoIdentidad().isEmpty()){
                   paciente.setDocumentoIdentidad(AES.decrypt(paciente.getDocumentoIdentidad()));
                }
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

        if (paciente == null) {
            throw new PersistenceException("Usuario/Contraseña inválidos");
        } else {
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
            preparedStatement = connect.prepareStatement("SELECT * FROM " + NOMBRETABLA + " WHERE nombreUsuario LIKE '%" + valor + "%' OR nombres LIKE '%" + valor + "%' OR apellidos LIKE '%" + valor + "%' OR documentoIdentidad LIKE '%" + AES.encrypt(valor) + "%' or correo LIKE '%" + AES.encrypt(valor) + "%' ORDER BY Apellidos, Nombres");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                paciente = new Paciente();
                paciente.setApellidos(resultSet.getString("apellidos"));
                paciente.setCiudad(resultSet.getString("ciudad"));
                paciente.setCorreo(resultSet.getString("correo"));
                if(!paciente.getCorreo().isEmpty()){
                   paciente.setCorreo(AES.decrypt(paciente.getCorreo()));
                }
                paciente.setDireccion(resultSet.getString("direccion"));
                paciente.setDocumentoIdentidad(resultSet.getString("documentoIdentidad"));
                if(!paciente.getDocumentoIdentidad().isEmpty()){
                   paciente.setDocumentoIdentidad(AES.decrypt(paciente.getDocumentoIdentidad()));
                }
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

        if (pacientes.isEmpty()) {
            throw new PersistenceException("No existen pacienes con ese dato!");
        } else {
            return pacientes;
        }

    }

    @Override
    public Set<Relacion> traerRelacionesFamiliaresDesdePaciente(Paciente paciente, String estado) throws PersistenceNotFoundException {
        Set<Relacion> relaciones = new HashSet<>();
        String complemento = "";
        if (Relacion.ESTADOPENDIENTE.equalsIgnoreCase(estado)) {
            complemento = " AND ENVIADO = '" + Relacion.ENVIADOOTRO + "' ";
        }
        Relacion rel = null;
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT * FROM PACIENTEFAMILIAR PF LEFT JOIN FAMILIAR F ON (PF.idFamiliar=F.ID) WHERE idPaciente = '" + paciente.getId() + "' AND ESTADO = '" + estado + "' " + complemento + " ORDER BY PF.ID");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                rel = new Relacion();
                rel.setId(resultSet.getInt("PF.ID"));
                rel.setIdFamiliar(resultSet.getInt("F.ID"));
                rel.setIdPaciente(paciente.getId());
                rel.setApellidosFamiliar(resultSet.getString("F.APELLIDOS"));
                rel.setApellidosPaciente(paciente.getApellidos());
                rel.setNombresFamiliar(resultSet.getString("F.NOMBRES"));
                rel.setNombresPaciente(paciente.getNombres());
                rel.setEstado(estado);
                rel.setRelacion(resultSet.getString("PF.relacion"));
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
    public void adicionarSolicitudPacienteDesdePaciente(Relacion relacion) throws PersistenceNotFoundException, PersistenceException {
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("INSERT INTO PACIENTEFAMILIAR (Id, IdPaciente, idFamiliar, estado, relacion, enviado) VALUES (?,?,?,?,?,?) ");
            preparedStatement.setInt(1, relacion.getId());
            preparedStatement.setInt(2, relacion.getIdPaciente());
            preparedStatement.setInt(3, relacion.getIdFamiliar());
            preparedStatement.setString(4, "P");
            preparedStatement.setString(5, relacion.getRelacion());
            preparedStatement.setString(6, Relacion.ENVIADOPACIENTE);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void adicionarSolicitudSaludDesdePaciente(Relacion relacion) throws PersistenceNotFoundException, PersistenceException {
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
            preparedStatement.setString(6, Relacion.ENVIADOPACIENTE);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public Set<Relacion> traerRelacionesSaludDesdePaciente(Paciente paciente, String estado) throws PersistenceNotFoundException {
        Set<Relacion> relaciones = new HashSet<>();
        Relacion rel = null;
        String complemento = "";
        if (Relacion.ESTADOPENDIENTE.equalsIgnoreCase(estado)) {
            complemento = " AND ENVIADO = '" + Relacion.ENVIADOOTRO + "' ";
        }
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT * FROM PACIENTESALUD PS LEFT JOIN PERSONALSALUD P ON (PS.idPersonalSalud = P.ID) WHERE idPaciente = '" + paciente.getId() + "' AND ESTADO = '" + estado + "' " + complemento + " ORDER BY PS.ID");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                rel = new Relacion();
                rel.setId(resultSet.getInt("PS.ID"));
                rel.setApellidosPaciente(paciente.getApellidos());
                rel.setApellidosFamiliar(resultSet.getString("P.APELLIDOS"));
                rel.setIdPaciente(paciente.getId());
                rel.setIdFamiliar(resultSet.getInt("P.ID"));
                rel.setNombresFamiliar(resultSet.getString("P.NOMBRES"));
                rel.setNombresPaciente(paciente.getNombres());
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
    public void modificarPaciente(Paciente paciente) throws PersistenceNotFoundException {
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("UPDATE  " + NOMBRETABLA + " SET nombres = ?, apellidos = ?, fechaNacimiento = ?, genero = ?, pais = ?, ciudad = ?, direccion = ? WHERE id = ? ");
            preparedStatement.setString(1, paciente.getNombres());
            preparedStatement.setString(2, paciente.getApellidos());
            preparedStatement.setString(3, paciente.getFechaNacimiento());
            preparedStatement.setString(4, paciente.getGenero());
            preparedStatement.setString(5, paciente.getPais());
            preparedStatement.setString(6, paciente.getCiudad());
            preparedStatement.setString(7, paciente.getDireccion());
            preparedStatement.setInt(8, paciente.getId());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public Progreso traerProgresoPaciente(Paciente paciente) throws PersistenceNotFoundException, PersistenceException {
        Progreso progreso = new Progreso();
        try {
            Class.forName(DatosBD.DRIVER);
            connect = DriverManager.getConnection(DatosBD.CONECTOR);
            preparedStatement = connect.prepareStatement("SELECT SUM(acertadas) FROM RESULTADO WHERE idPaciente = '" + paciente.getId() + "'");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                progreso.setPreguntasAcertadas(resultSet.getInt(1));
            } else {
                progreso.setPreguntasAcertadas(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenceNotFoundException(e.getMessage());
        } finally {
            close();
        }
        progreso.calcularTodo();
        return progreso;
    }
}
