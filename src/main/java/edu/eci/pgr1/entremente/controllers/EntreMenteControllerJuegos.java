/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.controllers;

import edu.eci.pgr1.entremente.model.Resultado;
import edu.eci.pgr1.entremente.model.juegos.PreguntaAtencion;
import edu.eci.pgr1.entremente.model.juegos.PreguntaCalculo;
import edu.eci.pgr1.entremente.model.juegos.PreguntaFormas;
import edu.eci.pgr1.entremente.model.juegos.PreguntaGaleria;
import edu.eci.pgr1.entremente.model.juegos.PreguntaMusicoterapia;
import edu.eci.pgr1.entremente.model.juegos.PreguntaPercepcion;
import edu.eci.pgr1.entremente.model.juegos.PreguntaQueUsar;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.services.EntreMenteServicesJuegos;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JuanArevaloMerchan
 */
@RestController
@RequestMapping(value = "/entremente/V1/juegos")
public class EntreMenteControllerJuegos {
 
    @Autowired
    private EntreMenteServicesJuegos emsj = null;

    
    
    
    
    
//Juego GALERIA    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/galeria/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarGaleria(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getPreguntasGaleria(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }   
  //Consultar TODAS
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/galeria/todas/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarGaleriaTodas(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getTodasPreguntasGaleria(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
  //MODIFICAR  
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/galeria", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorModificarGaleria(@RequestBody PreguntaGaleria pregunta) {
        try {
            emsj.modificarPreguntaGaleria(pregunta);
            return new ResponseEntity<>("Modifico", HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    } 
    
   //Resultado Adicionar
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/galeria", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarResultadoGaleria(@RequestBody Resultado resultado) {
        try {
            emsj.adicionarResultadoGaleria(resultado);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    //Resultado Consultar
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/galeria/dia/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoGaleriaDia(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosDiasGaleria(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/galeria/mes/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoGaleriaMes(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosMesGaleria(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/galeria/anio/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoGaleriaAnio(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosAnualGaleria(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    
    
    
    
    
    
    
    
    
    
    
//Juego ATENCION  
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/atencion/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarAtencion(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getPreguntasAtencion(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }  
    
  //Consutlar TODAS
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/atencion/todas/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarAtencionTodas(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getTodasPreguntasAtencion(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
  //MODIFICAR
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/atencion", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorModificarAtencion(@RequestBody PreguntaAtencion pregunta) {
        try {
            emsj.modificarPreguntaAtencion(pregunta);
            return new ResponseEntity<>("Modifico", HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
  //Resultados Atencion ADicionar    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/atencion", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarResultadoAtencion(@RequestBody Resultado resultado) {
        try {
            emsj.adicionarResultadoAtencion(resultado);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
  //Resultados Atencion COnsultar
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/atencion/dia/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoAtencionDia(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosDiasAtencion(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/atencion/mes/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoAtencionMes(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosMesAtencion(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/atencion/anio/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoAtencionAnio(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosAnualAtencion(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
//Juego FORMAS
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/formas/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarFormas(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getPreguntasFormas(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }  
    
  //Consultar TODAS
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/formas/todas/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultaFormasTodas(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getTodasPreguntasFormas(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
  //MODIFICAR
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/formas", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorModificarFormas(@RequestBody PreguntaFormas pregunta) {
        try {
            emsj.modificarPreguntaFormas(pregunta);
            return new ResponseEntity<>("Modifico", HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
   //Resultado Formas Adicionar
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/formas", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarResultadoFormas(@RequestBody Resultado resultado) {
        try {
            emsj.adicionarResultadoFormas(resultado);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
   
    
    //Resultado Formas Consultar
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/formas/dia/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoFormasDia(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosDiasFormas(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/formas/mes/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoFormasMes(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosMesFormas(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/formas/anio/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoFormasAnio(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosAnualFormas(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    } 
    
    
    
    
    
    
    
    
    
    
    
//Juego CALCULO
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/calculo/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarCalculo(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getPreguntasCalculo(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    } 
  //Consultar TODAS
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/calculo/todas/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarCalculoTodas(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getTodasPreguntasCalculo(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    } 
    
  //MODIFICAR  
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/calculo", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorModificarCalculo(@RequestBody PreguntaCalculo pregunta) {
        try {
            emsj.modificarPreguntaCalculo(pregunta);
            return new ResponseEntity<>("Modifico", HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
  //Resultados Adicionar
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/calculo", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarResultadoCalculo(@RequestBody Resultado resultado) {
        try {
            emsj.adicionarResultadoCalculemos(resultado);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
  //REsultados Consultar
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/calculo/dia/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoCalculoDia(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosDiasCalculo(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/calculo/mes/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoCalculoMes(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosMesCalculo(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/calculo/anio/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoCalculoAnio(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosAnualCalculo(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    } 
    
    
    
    
    
    
    
//Juego PERCEPCION  
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/percepcion/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarPercepcion(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getPreguntasPercepcion(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    } 
    
  //Consultar TODAS
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/percepcion/todas/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultaPercepcionTodas(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getTodasPreguntasPercepcion(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    } 
    
  //MODIFICAR
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/percepcion", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorModificarPercepcion(@RequestBody PreguntaPercepcion pregunta) {
        try {
            emsj.modificarPreguntaPercepcion(pregunta);
            return new ResponseEntity<>("Modifico", HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    } 
    
    
   //Resultados Adicionar
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/percepcion", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarResultadoPercepcion(@RequestBody Resultado resultado) {
        try {
            emsj.adicionarResultadoPercepcion(resultado);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
  //Resultados COnsultar
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/percepcion/dia/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoPercepcionDia(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosDiasPercepcion(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/percepcion/mes/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoPercepcionMes(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosMesPercepcion(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/percepcion/anio/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoPercepcionAnio(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosAnualPercepcion(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }  
    
    
    
    
    
    
    
    
    
//Juego MUSICOTERAPIA
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/musicoterapia/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarMusicoterapia(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getPreguntasMusicoterapia(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    } 
   //Consultar TODAS
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/musicoterapia/todas/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultaMusicoterapiaTodas(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getTodasPreguntasMusicoterapia(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
   //MODIFICAR
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/musicoterapia", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorModificarMusicoterapia(@RequestBody PreguntaMusicoterapia pregunta) {
        try {
            emsj.modificarPreguntaMusicoterapia(pregunta);
            return new ResponseEntity<>("Modifico", HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    } 
    
   //Resultados Adicionar
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/musicoterapia", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarResultadoMusicoTerapia(@RequestBody Resultado resultado) {
        try {
            emsj.adicionarResultadoMusicoterapia(resultado);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
  //Resultados Consultar
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/musicoterapia/dia/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoMusicoterapiaDia(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosDiasMusicoterapia(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/musicoterapia/mes/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoMusicoterapiaMes(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosMesMusicoterapia(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/musicoterapia/anio/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoMusicoterapiaAnio(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosAnualMusicoterapia(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    } 
   //Adicionar Pregunta musicoterapia
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/musicoterapia/{idPaciente}", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarPreguntaMusicoTerapia(@RequestBody PreguntaMusicoterapia pregunta, @PathVariable("idPaciente") int idPaciente) throws PersistenceException {
        try {
            emsj.adicionarPreguntaMusicoterapia(pregunta, idPaciente);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    
    
    
    
    
    
    
    
    
 //Juego QUEUSAR   
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/queUsar/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarQueUsar(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getPreguntasQueUsar(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }  
    
  //Consutlar TODAS
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/queUsar/todas/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarQueUsarTodas(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(emsj.getTodasPreguntasQueUsar(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
  //MODIFICAR
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/queUsar", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorModificarQueUsar(@RequestBody PreguntaQueUsar pregunta) {
        try {
            emsj.modificarPreguntaQueUsar(pregunta);
            return new ResponseEntity<>("Modifico", HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException  | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
  //Resultados Adicionar
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/queUsar", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarResultadoQueUsar(@RequestBody Resultado resultado) {
        try {
            emsj.adicionarResultadoQueUsar(resultado);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
  //Resultados Consultar
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/queUsar/dia/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoQueUsarsDia(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosDiasQueUsar(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/queUsar/mes/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoQueUsarMes(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosMesQueUsar(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/resultados/queUsar/anio/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetConsultarResultadoQueUsarAnio(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
        try {
            return new ResponseEntity<>(emsj.consultarResultadosAnualQueUsar(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }  
    
    
// //Juego GrupoFamiliar   
//  //Resultados Adicionar
//    @RequestMapping(path = "/resultados/grupoFamiliar", method = RequestMethod.POST)
//    public ResponseEntity<?> manejadorPostAdicionarResultadoGrupoFamiliar(@RequestBody Resultado resultado) {
//        try {
//            emsj.adicionarResultadoRutinas(resultado);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (PersistenceNotFoundException ex) {
//            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
//            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//        }        
//    }
//    
//  //Resultados Consultar
//    @RequestMapping(path = "/resultados/grupoFamiliar/dia/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
//    public ResponseEntity<?> manejadorGetConsultarResultadoGrupoFamiliarDia(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
//        try {
//            return new ResponseEntity<>(emsj.consultarResultadosDiasGrupoFamiliar(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
//        } catch (PersistenceNotFoundException | PersistenceException ex) {
//            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
//            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//        }        
//    }
//    
//    @RequestMapping(path = "/resultados/grupoFamiliar/mes/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
//    public ResponseEntity<?> manejadorGetConsultarResultadoGrupoFamiliarsMes(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
//        try {
//            return new ResponseEntity<>(emsj.consultarResultadosMesGrupoFamiliar(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
//        } catch (PersistenceNotFoundException | PersistenceException ex) {
//            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
//            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//        }        
//    }
//    
//    @RequestMapping(path = "/resultados/grupoFamiliar/anio/{idPaciente}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET)
//    public ResponseEntity<?> manejadorGetConsultarResultadoGrupoFamiliarAnio(@PathVariable("idPaciente") int idPaciente, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
//        try {
//            return new ResponseEntity<>(emsj.consultarResultadosAnualGrupoFamiliar(idPaciente, fechaInicial, fechaFinal), HttpStatus.CREATED);
//        } catch (PersistenceNotFoundException | PersistenceException ex) {
//            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
//            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//        }        
//    }  
    
    
}
