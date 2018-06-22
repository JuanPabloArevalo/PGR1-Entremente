
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var apiclientPerfilPaciente = (function(){
    var equipoBackEnd = configuracionHost.getEquipoBackEnd();
    var version = configuracionHost.getVersion();
    return{
        getSolicitudesPendientes(id,nombres,apellidos,documentoIdentidad,nombreUsuario,tipoDocumento,correo){
            return $.ajax({
                url:  equipoBackEnd+version+"pacientes/relaciones/familiares/pendientes",
                type: "POST",                
                data: '{"id":'+id+' ,"nombres":"'+nombres+'","apellidos":"'+apellidos+'", "documentoIdentidad":"'+documentoIdentidad+'","nombreUsuario":"'+nombreUsuario+'","password":"","tipoDocumento":"'+tipoDocumento+'","correo":"'+correo+'"}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getSolicitudesAceptadas(id,nombres,apellidos,documentoIdentidad,nombreUsuario,tipoDocumento,correo){
            return $.ajax({
                url:  equipoBackEnd+version+"pacientes/relaciones/familiares/aceptadas",
                type: "POST",
                data: '{"id":'+id+' ,"nombres":"'+nombres+'","apellidos":"'+apellidos+'", "documentoIdentidad":"'+documentoIdentidad+'","nombreUsuario":"'+nombreUsuario+'","password":"","tipoDocumento":"'+tipoDocumento+'","correo":"'+correo+'"}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getBusquedaFamiliares(dato){
            return $.ajax({
                url:  equipoBackEnd+version+"familiares/"+dato,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        aceptarSolicitud(id, idPaciente, idFamiliar){
            return $.ajax({
                url:  equipoBackEnd+version+"familiares/relaciones/pacientes",
                type: "PUT",
                data: '{"id":'+id+' ,"idPaciente":'+idPaciente+',"idFamiliar":'+idFamiliar+', "estado":"","relacion":""}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        eliminarSolicitud(id, idPaciente, idFamiliar){
            return $.ajax({
                url:  equipoBackEnd+version+"familiares/relaciones/pacientes",
                type: "DELETE",
                data: '{"id":'+id+' ,"idPaciente":'+idPaciente+',"idFamiliar":'+idFamiliar+', "estado":"","relacion":""}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        adicionarSolicitud(idPaciente, idFamiliar,relacion){
            return $.ajax({
                url:  equipoBackEnd+version+"pacientes/relaciones/familiares",
                type: "POST",
                data: '{"id":0 ,"idPaciente":'+idPaciente+',"idFamiliar":'+idFamiliar+', "estado":"","relacion":"'+relacion+'"}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getTodosMensajes(idPaciente){
            return $.ajax({
                url:  equipoBackEnd+version+"mensajes/pacientes/"+idPaciente,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            }); 
        },
        modificarPaciente(nombres,apellidos,fechaNacimiento,genero,pais,ciudad,direccion,id){
            return $.ajax({
                url: equipoBackEnd+version+"pacientes",
                type: "PUT",
                data: '{"nombres":"'+nombres+'","apellidos":"'+apellidos+'", "fechaNacimiento":"'+fechaNacimiento+'","genero":"'+genero+'","pais":"'+pais+'","ciudad":"'+ciudad+'","direccion":"'+direccion+'","id":'+id+'}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getProgresoPaciente(idPaciente){
            return $.ajax({
                url:  equipoBackEnd+version+"pacientes/progresos/"+idPaciente,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            }); 
        }
      };
    
}());


