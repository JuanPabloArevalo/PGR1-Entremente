/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.services;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.Resultado;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.persistence.juegos.ResultadoRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class EntreMenteServicesResultados {
    
    @Autowired
    private ResultadoRepository resultado;
    
    //RESULTADOS
    /**
     * Metodo encargado de adicionar el resultado del juego Galeria
     * @param resultadoA
     * @throws PersistenceNotFoundException
     */
    public void adicionarResultadoGaleria(Resultado resultadoA) throws PersistenceNotFoundException{
        resultadoA.setTipoJuego(Resultado.TIPOJUEGOGALERIA);
        this.resultado.adicionarResultado(resultadoA);
    } 
    /**
     * Metodo encargado de adicionar el resultado del juego Atencion
     * @param resultadoA
     * @throws PersistenceNotFoundException
     */
    public void adicionarResultadoAtencion(Resultado resultadoA) throws PersistenceNotFoundException{
        resultadoA.setTipoJuego(Resultado.TIPOJUEGOATENCION);
        this.resultado.adicionarResultado(resultadoA);
    } 
    /**
     * Metodo encargado de adicionar el resultado del juego Percepcion
     * @param resultadoA
     * @throws PersistenceNotFoundException
     */
    public void adicionarResultadoPercepcion(Resultado resultadoA) throws PersistenceNotFoundException{
        resultadoA.setTipoJuego(Resultado.TIPOJUEGOPERCEPCION);
        this.resultado.adicionarResultado(resultadoA);
    }
    
    /**
     * Metodo encargado de adicionar el resultado del juego Calculemos
     * @param resultadoA
     * @throws PersistenceNotFoundException
     */
    public void adicionarResultadoCalculemos(Resultado resultadoA) throws PersistenceNotFoundException{
        resultadoA.setTipoJuego(Resultado.TIPOJUEGOCALCULEMOS);
        this.resultado.adicionarResultado(resultadoA);
    }
    
    /**
     * Metodo encargado de adicionar el resultado del juego Formas
     * @param resultadoA
     * @throws PersistenceNotFoundException
     */
    public void adicionarResultadoFormas(Resultado resultadoA) throws PersistenceNotFoundException{
        resultadoA.setTipoJuego(Resultado.TIPOJUEGOFORMAS);
        this.resultado.adicionarResultado(resultadoA);
    }
    
    /**
     * Metodo encargado de adicionar el resultado del juego Musicoterapia
     * @param resultadoA
     * @throws PersistenceNotFoundException
     */
    public void adicionarResultadoMusicoterapia(Resultado resultadoA) throws PersistenceNotFoundException{
        resultadoA.setTipoJuego(Resultado.TIPOJUEGOMUSICOTERAPIA);
        this.resultado.adicionarResultado(resultadoA);
    }
    
    /**
     * Metodo encargado de adicionar el resultado del juego Que Usar
     * @param resultadoA
     * @throws PersistenceNotFoundException
     */
    public void adicionarResultadoQueUsar(Resultado resultadoA) throws PersistenceNotFoundException{
        resultadoA.setTipoJuego(Resultado.TIPOJUEGOQUEUSAR);
        this.resultado.adicionarResultado(resultadoA);
    }
    
//CONSULTA RESULTADOS
    //GALERIA
    /**
     * Metodo encargado de consultar los resulrtados diarios del juego galeria
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosDiasGaleria(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosDias(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOGALERIA);
    }
    /**
     * Metodo encargado de consultar los resulrtados mensuales del juego galeria
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosMesGaleria(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosMeses(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOGALERIA);
    }
    /**
     * Metodo encargado de consultar los resulrtados anuelaes del juego galeria
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosAnualGaleria(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosAnios(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOGALERIA);
    }
    //FORMAS
    /**
     * Metodo encargado de consultar los resulrtados diarios del juego formas
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosDiasFormas(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosDias(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOFORMAS);
    }
    /**
     * Metodo encargado de consultar los resulrtados mensuales del juego formas
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosMesFormas(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosMeses(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOFORMAS);
    }
    /**
     * Metodo encargado de consultar los resulrtados anuelaes del juego formas
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosAnualFormas(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosAnios(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOFORMAS);
    }
    //PERCEPCION
    /**
     * Metodo encargado de consultar los resulrtados diarios del juego percepcion
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosDiasPercepcion(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosDias(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOPERCEPCION);
    }
    /**
     * Metodo encargado de consultar los resulrtados mensuales del juego percepcion
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosMesPercepcion(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosMeses(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOPERCEPCION);
    }
    /**
     * Metodo encargado de consultar los resulrtados anuelaes del juego percepcion
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosAnualPercepcion(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosAnios(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOPERCEPCION);
    }
    //CALCULO
    /**
     * Metodo encargado de consultar los resulrtados diarios del juego calculo
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosDiasCalculo(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosDias(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOCALCULEMOS);
    }
    /**
     * Metodo encargado de consultar los resulrtados mensuales del juego calculo
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosMesCalculo(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosMeses(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOCALCULEMOS);
    }
    /**
     * Metodo encargado de consultar los resulrtados anuelaes del juego calculo
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosAnualCalculo(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosAnios(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOCALCULEMOS);
    }
    //ATENCION
    /**
     * Metodo encargado de consultar los resulrtados diarios del juego atencion
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosDiasAtencion(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosDias(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOATENCION);
    }
    /**
     * Metodo encargado de consultar los resulrtados mensuales del juego atencion
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosMesAtencion(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosMeses(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOATENCION);
    }
    /**
     * Metodo encargado de consultar los resulrtados anuelaes del juego atencion
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosAnualAtencion(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosAnios(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOATENCION);
    }
    //MUSICOTERAPIA
    /**
     * Metodo encargado de consultar los resulrtados diarios del juego Musicoterapia
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosDiasMusicoterapia(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosDias(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOMUSICOTERAPIA);
    }
    /**
     * Metodo encargado de consultar los resulrtados mensuales del juego Musicoterapia
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosMesMusicoterapia(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosMeses(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOMUSICOTERAPIA);
    }
    /**
     * Metodo encargado de consultar los resulrtados anuelaes del juego musicoterapia
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosAnualMusicoterapia(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosAnios(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOMUSICOTERAPIA);
    }
    //QUEUSAR
    /**
     * Metodo encargado de consultar los resulrtados diarios del juego QueUSar
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosDiasQueUsar(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosDias(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOQUEUSAR);
    }
    /**
     * Metodo encargado de consultar los resulrtados mensuales del juego que Ussar
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosMesQueUsar(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosMeses(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOQUEUSAR);
    }
    /**
     * Metodo encargado de consultar los resulrtados anuelaes del juego que USar
     * @param idPaciente
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     * @throws PersistenceNotFoundException
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
     */
    public ArrayList<Resultado> consultarResultadosAnualQueUsar(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return this.resultado.traerResultadosAnios(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOQUEUSAR);
    }
}
