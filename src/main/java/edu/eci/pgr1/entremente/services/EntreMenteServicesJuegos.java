/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.services;

import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.Resultado;
import edu.eci.pgr1.entremente.model.juegos.PreguntaAtencion;
import edu.eci.pgr1.entremente.model.juegos.PreguntaCalculo;
import edu.eci.pgr1.entremente.model.juegos.PreguntaFormas;
import edu.eci.pgr1.entremente.model.juegos.PreguntaGaleria;
import edu.eci.pgr1.entremente.model.juegos.PreguntaMusicoterapia;
import edu.eci.pgr1.entremente.model.juegos.PreguntaPercepcion;
import edu.eci.pgr1.entremente.model.juegos.PreguntaQueUsar;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoAtencionRepository;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoCalculoRepository;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoFormasRepository;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.persistence.juegos.ResultadoRepository;
import java.util.ArrayList;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoGaleriaRepository;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoMusicoterapiaRepository;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoPercepcionRepository;
import edu.eci.pgr1.entremente.persistence.juegos.JuegoQueUsarRepository;

/**
 *
 * @author JuanArevaloMerchan
 */
@Service
public class EntreMenteServicesJuegos {
    
    @Autowired
    private JuegoGaleriaRepository galeria;
    @Autowired
    private JuegoAtencionRepository atencion;    
    @Autowired
    private JuegoFormasRepository formas;  
    @Autowired
    private JuegoCalculoRepository calculo;  
    @Autowired
    private JuegoPercepcionRepository percepcion;  
    @Autowired
    private ResultadoRepository resultado;
    @Autowired
    private JuegoMusicoterapiaRepository musicoterapia;  
    @Autowired
    private JuegoQueUsarRepository queUsar;  
    /**
     * Metodo encargado de traer todas las preguntas del juego Galeria
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<Set<PreguntaGaleria>> getPreguntasGaleria(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        ArrayList<Set<PreguntaGaleria>> arreglo = new ArrayList<>();
        arreglo.add(galeria.traerPreguntas(1, paciente));
        arreglo.add(galeria.traerPreguntas(2, paciente));
        arreglo.add(galeria.traerPreguntas(3, paciente));
        arreglo.add(galeria.traerPreguntas(4, paciente));
        return arreglo;
    }
    /**
     * Metodo encargado de traer todas las preguntas del juego Galeria
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<PreguntaGaleria> getTodasPreguntasGaleria(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return galeria.traerTODASPreguntas(paciente);
    }
    
    /**
     * Metodo encargado de modificar la pregunta de Galeria
     * @param pregunta
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public void modificarPreguntaGaleria(PreguntaGaleria pregunta) throws PersistenceNotFoundException, PersistenceException{
        galeria.modificarPregunta(pregunta);
    }
    /**
     * Metodo encargado de traer todas las preguntas del juego Atencion
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<Set<PreguntaAtencion>> getPreguntasAtencion(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        ArrayList<Set<PreguntaAtencion>> arreglo = new ArrayList<>();
        arreglo.add(atencion.traerPreguntas(1, paciente));
        arreglo.add(atencion.traerPreguntas(2, paciente));
        arreglo.add(atencion.traerPreguntas(3, paciente));
        arreglo.add(atencion.traerPreguntas(4, paciente));
        return arreglo;
    }
    /**
     * Metodo encargado de traer todas las preguntas del juego Atencion
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<PreguntaAtencion> getTodasPreguntasAtencion(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return atencion.traerTODASPreguntas(paciente);
    }
    
    /**
     * Metodo encargado de modificar la pregunta de Atencion
     * @param pregunta
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public void modificarPreguntaAtencion(PreguntaAtencion pregunta) throws PersistenceNotFoundException, PersistenceException{
        atencion.modificarPregunta(pregunta);
    }
    /**
     * Metodo encargado de traer todas las preguntas del juego Formas
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<Set<PreguntaFormas>> getPreguntasFormas(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        ArrayList<Set<PreguntaFormas>> arreglo = new ArrayList<>();
        arreglo.add(formas.traerPreguntas(1, paciente));
        arreglo.add(formas.traerPreguntas(2, paciente));
        arreglo.add(formas.traerPreguntas(3, paciente));
        arreglo.add(formas.traerPreguntas(4, paciente));
        return arreglo;
    }
   /**
     * Metodo encargado de traer todas las preguntas del juego Atencion
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<PreguntaFormas> getTodasPreguntasFormas(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return formas.traerTODASPreguntas(paciente);
    }
    
    /**
     * Metodo encargado de modificar la pregunta de Formas
     * @param pregunta
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public void modificarPreguntaFormas(PreguntaFormas pregunta) throws PersistenceNotFoundException, PersistenceException{
        formas.modificarPregunta(pregunta);
    }
    /**
     * Metodo encargado de traer todas las preguntas del juego Calculo
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<Set<PreguntaCalculo>> getPreguntasCalculo(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        ArrayList<Set<PreguntaCalculo>> arreglo = new ArrayList<>();
        arreglo.add(calculo.traerPreguntas(1, paciente));
        arreglo.add(calculo.traerPreguntas(2, paciente));
        arreglo.add(calculo.traerPreguntas(3, paciente));
        arreglo.add(calculo.traerPreguntas(4, paciente));
        return arreglo;
    }   
    /**
     * Metodo encargado de traer todas las preguntas del juego Atencion
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<PreguntaCalculo> getTodasPreguntasCalculo(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return calculo.traerTODASPreguntas(paciente);
    }
    
    /**
     * Metodo encargado de modificar la pregunta de Calculo
     * @param pregunta
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public void modificarPreguntaCalculo(PreguntaCalculo pregunta) throws PersistenceNotFoundException, PersistenceException{
        calculo.modificarPregunta(pregunta);
    }
    /**
     * Metodo encargado de traer todas las preguntas del juego Percepcion
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<Set<PreguntaPercepcion>> getPreguntasPercepcion(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        ArrayList<Set<PreguntaPercepcion>> arreglo = new ArrayList<>();
        arreglo.add(percepcion.traerPreguntas(1, paciente));
        arreglo.add(percepcion.traerPreguntas(2, paciente));
        arreglo.add(percepcion.traerPreguntas(3, paciente));
        return arreglo;
    }    
    /**
     * Metodo encargado de traer todas las preguntas del juego Percepcion
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<PreguntaPercepcion> getTodasPreguntasPercepcion(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return percepcion.traerTODASPreguntas(paciente);
    }
    
    /**
     * Metodo encargado de modificar la pregunta de Percepcion
     * @param pregunta
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public void modificarPreguntaPercepcion(PreguntaPercepcion pregunta) throws PersistenceNotFoundException, PersistenceException{
        percepcion.modificarPregunta(pregunta);
    }    
///MUSICOTERAPIA
    /**
     * Metodo encargado de traer todas las preguntas del juego Musicoterapia
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<Set<PreguntaMusicoterapia>> getPreguntasMusicoterapia(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        ArrayList<Set<PreguntaMusicoterapia>> arreglo = new ArrayList<>();
        arreglo.add(musicoterapia.traerPreguntas(1, paciente));
        arreglo.add(musicoterapia.traerPreguntas(2, paciente));
        arreglo.add(musicoterapia.traerPreguntas(3, paciente));
        arreglo.add(musicoterapia.traerPreguntas(4, paciente));
        return arreglo;
    }    
    /**
     * Metodo encargado de traer todas las preguntas del juego Musicoterapia
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<PreguntaMusicoterapia> getTodasPreguntasMusicoterapia(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return musicoterapia.traerTODASPreguntas(paciente);
    }
    
    /**
     * Metodo encargado de modificar la pregunta de Musicoterapia
     * @param pregunta
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public void modificarPreguntaMusicoterapia(PreguntaMusicoterapia pregunta) throws PersistenceNotFoundException, PersistenceException{
        musicoterapia.modificarPregunta(pregunta);
    }      
    
    /**
     * Metodo encargado de adicionar la pregunta de Musicoterapia
     * @param pregunta
     * @param idPaciente
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public void adicionarPreguntaMusicoterapia(PreguntaMusicoterapia pregunta, int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        musicoterapia.adicionarPregunta(pregunta, paciente);
    }        
    
    /**
     * Metodo encargado de traer todas las preguntas del juego Que Usar
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<Set<PreguntaQueUsar>> getPreguntasQueUsar(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        ArrayList<Set<PreguntaQueUsar>> arreglo = new ArrayList<>();
        arreglo.add(queUsar.traerPreguntas(1, paciente));
        arreglo.add(queUsar.traerPreguntas(2, paciente));
        arreglo.add(queUsar.traerPreguntas(3, paciente));
        arreglo.add(queUsar.traerPreguntas(4, paciente));
        return arreglo;
    }
    /**
     * Metodo encargado de traer todas las preguntas del juego Que Usar
     * @param idPaciente
     * @return
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public ArrayList<PreguntaQueUsar> getTodasPreguntasQueUsar(int idPaciente) throws PersistenceNotFoundException, PersistenceException{
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        return queUsar.traerTODASPreguntas(paciente);
    }
    
    /**
     * Metodo encargado de modificar la pregunta de Que USar
     * @param pregunta
     * @throws PersistenceNotFoundException 
     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException 
     */
    public void modificarPreguntaQueUsar(PreguntaQueUsar pregunta) throws PersistenceNotFoundException, PersistenceException{
        queUsar.modificarPregunta(pregunta);
    }
    
    
    
    
    
    
    
    
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
    
    
////GRUPOFAMILIAR
//    /**
//     * Metodo encargado de consultar los resulrtados diarios del juego que 
//     * @param idPaciente
//     * @param fechaInicial
//     * @param fechaFinal
//     * @return 
//     * @throws PersistenceNotFoundException
//     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
//     */
//    public ArrayList<Resultado> consultarResultadosDiasGrupoFamiliar(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
//        Paciente paciente = new Paciente();
//        paciente.setId(idPaciente);
//        return this.resultado.traerResultadosDias(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOGRUPOFAMILIAR);
//    }
//    /**
//     * Metodo encargado de consultar los resulrtados mensuales del juego rutina
//     * @param idPaciente
//     * @param fechaInicial
//     * @param fechaFinal
//     * @return 
//     * @throws PersistenceNotFoundException
//     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
//     */
//    public ArrayList<Resultado> consultarResultadosMesGrupoFamiliar(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
//        Paciente paciente = new Paciente();
//        paciente.setId(idPaciente);
//        return this.resultado.traerResultadosMeses(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOGRUPOFAMILIAR);
//    }
//    /**
//     * Metodo encargado de consultar los resulrtados anuelaes del juego rutina
//     * @param idPaciente
//     * @param fechaInicial
//     * @param fechaFinal
//     * @return 
//     * @throws PersistenceNotFoundException
//     * @throws edu.eci.pgr1.entremente.persistence.PersistenceException
//     */
//    public ArrayList<Resultado> consultarResultadosAnualGrupoFamiliar(int idPaciente, String fechaInicial, String fechaFinal) throws PersistenceNotFoundException, PersistenceException{
//        Paciente paciente = new Paciente();
//        paciente.setId(idPaciente);
//        return this.resultado.traerResultadosAnios(paciente, fechaInicial, fechaFinal, Resultado.TIPOJUEGOGRUPOFAMILIAR);
//    }
    
    
}
