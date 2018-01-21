/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.controllers;

import edu.eci.pgr1.entremente.model.Familiar;
import edu.eci.pgr1.entremente.model.HistorialMedico;
import edu.eci.pgr1.entremente.model.Mensaje;
import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.PersonalSalud;
import edu.eci.pgr1.entremente.model.Relacion;
import edu.eci.pgr1.entremente.persistence.PersistenceException;
import edu.eci.pgr1.entremente.persistence.PersistenceNotFoundException;
import edu.eci.pgr1.entremente.services.EntreMenteServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan Pablo Arévalo
 */
@RestController
@RequestMapping(value = "/entremente/V1")
public class EntreMenteController {
    
    @Autowired
    private EntreMenteServices ems = null;
    
    
///PACIENTE    
    @RequestMapping(path = "/pacientes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarPaciente(@RequestBody Paciente paciente) {
        try {
            ems.adicionarPaciente(paciente);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/pacientes/{usuario}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorIniciarPaciente(@PathVariable("usuario") String nombreU, @PathVariable("password") String password) {
        try {
            return new ResponseEntity<>(ems.iniciarSesionPaciente(nombreU, password), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(path = "/pacientes/{dato}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorIniciarPaciente(@PathVariable("dato") String dato) {
        try {
            return new ResponseEntity<>(ems.consultarPacientes(dato), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(path = "/pacientes/relaciones/familiares/pendientes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesPendientesFamiliaresDesdePaciente(@RequestBody Paciente paciente) {
        try {
            return new ResponseEntity<>(ems.getRelacionesPacientePendientesDesdePaciente(paciente), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/pacientes/relaciones/familiares/aceptadas", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesAceptadasFamiliaresDesdePaciente(@RequestBody Paciente paciente) {
        try {
            return new ResponseEntity<>(ems.getRelacionesPacienterAceptadasDesdePaciente(paciente), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/pacientes/relaciones/familiares", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorRelacionesAdicionarRelacionDesdePaciente(@RequestBody Relacion relacion) {
        try {
            ems.adicionarRelacionPacienteDesdePaciente(relacion);
            return new ResponseEntity<>("Se ha enviado la solicitud!", HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }    
    }
    
    @RequestMapping(path = "/pacientes/relaciones/personalSalud", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorRelacionesAdicionarRelacionDesdePacienteSalud(@RequestBody Relacion relacion) {
        try {
            ems.adicionarRelacionSaludDesdePaciente(relacion);
            return new ResponseEntity<>("Se ha enviado la solicitud!", HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }    
    }
    
    @RequestMapping(path = "/pacientes/relaciones/personalSalud/pendientes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesPendientesSaludDesdePaciente(@RequestBody Paciente paciente) {
        try {
            return new ResponseEntity<>(ems.getRelacionesSaludPendientesDesdePaciente(paciente), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/pacientes/relaciones/personalSalud/aceptadas", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesAceptadasSaludDesdePaciente(@RequestBody Paciente paciente) {
        try {
            return new ResponseEntity<>(ems.getRelacionesSaludAceptadasDesdePaciente(paciente), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }

//FAMILIARES    
    @RequestMapping(path = "/familiares", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarFamiliar(@RequestBody Familiar familiar) {
        try {
            ems.adicionarFamiliar(familiar);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/familiares/{usuario}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorIniciarFamiliar(@PathVariable("usuario") String nombreU, @PathVariable("password") String password) {
        try {
            return new ResponseEntity<>(ems.iniciarSesionFamiliar(nombreU, password), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(path = "/familiares/relaciones/pacientes/pendientes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesFamliaresPacientesPendientes(@RequestBody Familiar familiar) {
        try {
            return new ResponseEntity<>(ems.getRelacionesPacientePendientesDesdeFamiliar(familiar), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/familiares/relaciones/pacientes/aceptadas", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesFamliaresPacientesAceptadas(@RequestBody Familiar familiar) {
        try {
            return new ResponseEntity<>(ems.getRelacionesPacienterAceptadasDesdeFamiliar(familiar), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/familiares/relaciones/pacientes", method = RequestMethod.PUT)
    public ResponseEntity<?> manejadorRelacionesFamliaresPacientesAceptadar(@RequestBody Relacion relacion) {
        try {
            ems.aceptarSolicitudPaciente(relacion);
            return new ResponseEntity<>("Se ha aceptado la solicitud!", HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }    
    }
    
    @RequestMapping(path = "/familiares/relaciones/pacientes", method = RequestMethod.DELETE)
    public ResponseEntity<?> manejadorRelacionesFamliaresPacientesEliminar(@RequestBody Relacion relacion) {
        try {
            ems.eliminarSolicitudPaciente(relacion);
            return new ResponseEntity<>("Se ha eliminado la solicitud!", HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }    
    }
    
    @RequestMapping(path = "/familiares/relaciones/pacientes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorRelacionesFamliaresPacientesAdicionar(@RequestBody Relacion relacion) {
        try {
            ems.adicionarRelacionPacienteDesdeFamiliar(relacion);
            return new ResponseEntity<>("Se ha enviado la solicitud!", HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }    
    }
    
    @RequestMapping(path = "/familiares/{dato}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarFamliares(@PathVariable("dato") String dato) {
        try {
            return new ResponseEntity<>(ems.consultarFamiliares(dato), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    
    
    
//PERSONAL SALUD 
    @RequestMapping(path = "/personalSalud", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostAdicionarPersonalSalud(@RequestBody PersonalSalud personalSalud) {
        try {
            ems.adicionarPersonalSalud(personalSalud);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/personalSalud/{usuario}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorIniciarPersonalSalud(@PathVariable("usuario") String nombreU, @PathVariable("password") String password) {
        try {
            return new ResponseEntity<>(ems.iniciarSesionPersonalSalud(nombreU, password), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }   
    
    @RequestMapping(path = "/personalSalud/relaciones/pacientes/pendientes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesSaludPacientesPendientes(@RequestBody PersonalSalud personalSalud) {
//        System.out.println("Entro Pendientes");
        try {
            return new ResponseEntity<>(ems.getRelacionesPacientePendientesDesdeSalud(personalSalud), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/personalSalud/relaciones/pacientes/aceptadas", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorGetRelacionesSaludPacientesAceptadas(@RequestBody PersonalSalud personalSalud) {
//        System.out.println("Entro Aceptadas");
        try {
            return new ResponseEntity<>(ems.getRelacionesPacienterAceptadasDesdeSalud(personalSalud), HttpStatus.CREATED);
        } catch (PersistenceNotFoundException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path = "/personalSalud/relaciones/pacientes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorRelacionesSaludPacientesAdicionar(@RequestBody Relacion relacion) {
        try {
            ems.adicionarRelacionPacienteDesdeSalud(relacion);
            return new ResponseEntity<>("Se ha enviado la solicitud!", HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }    
    }
    
    @RequestMapping(path = "/personalSalud/relaciones/pacientes", method = RequestMethod.PUT)
    public ResponseEntity<?> manejadorRelacionesSaludPacientesAceptadar(@RequestBody Relacion relacion) {
        try {
            ems.aceptarSolicitudPacientePersonalSalud(relacion);
            return new ResponseEntity<>("Se ha aceptado la solicitud!", HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }    
    }
    
    @RequestMapping(path = "/personalSalud/relaciones/pacientes", method = RequestMethod.DELETE)
    public ResponseEntity<?> manejadorRelacionesSaludPacientesEliminar(@RequestBody Relacion relacion) {
        try {
            ems.eliminarSolicitudPacientePersonalSalud(relacion);
            return new ResponseEntity<>("Se ha eliminado la solicitud!", HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }    
    }
    
    @RequestMapping(path = "/personalSalud/{dato}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarSalud(@PathVariable("dato") String dato) {
        try {
            return new ResponseEntity<>(ems.consultarSalud(dato), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
//MENSAJES    
    @RequestMapping(path = "/mensajes", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorMensajesAdicionar(@RequestBody Mensaje mensaje) {
        try {
//            System.out.println("Entro aca con "+mensaje.getFecha());
            ems.adicionarMensaje(mensaje);
            return new ResponseEntity<>("Se ha enviado el mensaje", HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }    
    }
    
    @RequestMapping(path = "/mensajes/", method = RequestMethod.DELETE)
    public ResponseEntity<?> manejadorMensajesEliminar(@RequestBody Mensaje mensaje) {
        try {
            ems.eliminarMensaje(mensaje);
            return new ResponseEntity<>("Se ha eliminado el mensaje!", HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }    
    }
    
    @RequestMapping(path = "/mensajes/pacientes/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarMensajes(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(ems.consultarMensajesPaciente(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(path = "/mensajes/otros/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarTodosMensajes(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(ems.consultarTodosMensajes(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    
//Historial Médico    
    @RequestMapping(path = "/historialMedico", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorHisotrialMedicoAdicionar(@RequestBody HistorialMedico historialMedico) {
        try {
//            System.out.println("Entro aca con "+mensaje.getFecha());
            ems.adicionarHistorialMedico(historialMedico);
            return new ResponseEntity<>("Se ha adicionado la enfermedad al historial médico del paciente", HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }    
    }
    
    @RequestMapping(path = "/historialMedico", method = RequestMethod.DELETE)
    public ResponseEntity<?> manejadorHistorialMedicoEliminar(@RequestBody HistorialMedico historialMedico) {
        try {
            ems.eliminarHistorialMedico(historialMedico);
            return new ResponseEntity<>("Se ha eliminado la enfermedad del historial médico del paciente!", HttpStatus.CREATED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }    
    }
    
    @RequestMapping(path = "/historialMedico/{idPaciente}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarHistorialMedico(@PathVariable("idPaciente") int idPaciente) {
        try {
            return new ResponseEntity<>(ems.consultarHistorialMedicoPaciente(idPaciente), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(path = "/enfermedades", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorEnfermedadesCargar() {
        try {
            return new ResponseEntity<>(ems.consultarEnfermedades(), HttpStatus.ACCEPTED);
        } catch (PersistenceNotFoundException | PersistenceException ex) {
            Logger.getLogger(EntreMenteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
