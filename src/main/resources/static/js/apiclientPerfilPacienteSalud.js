/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var apiclientPerfilPacienteSalud = (function(){
    var equipoBackEnd = configuracionHost.getEquipoBackEnd();
    var version = configuracionHost.getVersion();
    return{
        getSolicitudesPendientes(id,nombres,apellidos,documentoIdentidad,nombreUsuario,tipoDocumento,correo){
            return $.ajax({
                url:  equipoBackEnd+version+"pacientes/relaciones/personalSalud/pendientes",
                type: "POST",                
                data: '{"id":'+id+' ,"nombres":"'+nombres+'","apellidos":"'+apellidos+'", "documentoIdentidad":"'+documentoIdentidad+'","nombreUsuario":"'+nombreUsuario+'","password":"","tipoDocumento":"'+tipoDocumento+'","correo":"'+correo+'"}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getSolicitudesAceptadas(id,nombres,apellidos,documentoIdentidad,nombreUsuario,tipoDocumento,correo){
            return $.ajax({
                url:  equipoBackEnd+version+"pacientes/relaciones/personalSalud/aceptadas",
                type: "POST",
                data: '{"id":'+id+' ,"nombres":"'+nombres+'","apellidos":"'+apellidos+'", "documentoIdentidad":"'+documentoIdentidad+'","nombreUsuario":"'+nombreUsuario+'","password":"","tipoDocumento":"'+tipoDocumento+'","correo":"'+correo+'"}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getBusquedaPersonalSalud(dato){
            return $.ajax({
                url:  equipoBackEnd+version+"personalSalud/"+dato,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            }); 
        },
        aceptarSolicitud(id, idPaciente, idFamiliar){
            return $.ajax({
                url:  equipoBackEnd+version+"personalSalud/relaciones/pacientes",
                type: "PUT",
                data: '{"id":'+id+' ,"idPaciente":'+idPaciente+',"idFamiliar":'+idFamiliar+', "estado":"","relacion":""}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        eliminarSolicitud(id, idPaciente, idFamiliar){
            return $.ajax({
                url:  equipoBackEnd+version+"personalSalud/relaciones/pacientes",
                type: "DELETE",
                data: '{"id":'+id+' ,"idPaciente":'+idPaciente+',"idFamiliar":'+idFamiliar+', "estado":"","relacion":""}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        adicionarSolicitud(idPaciente, idFamiliar,relacion){
            return $.ajax({
                url:  equipoBackEnd+version+"pacientes/relaciones/personalSalud",
                type: "POST",
                data: '{"id":0 ,"idPaciente":'+idPaciente+',"idFamiliar":'+idFamiliar+', "estado":"","relacion":"'+relacion+'"}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        }
      };
    
}());


