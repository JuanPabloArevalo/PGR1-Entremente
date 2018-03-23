/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var apiclientPerfilPersonalSalud = (function(){
    var equipoBackEnd = configuracionHost.getEquipoBackEnd();
    var version = configuracionHost.getVersion();
    return{
        getSolicitudesPendientes(id,nombres,apellidos,documentoIdentidad,nombreUsuario,tipoDocumento,correo,rol){
            return $.ajax({
                url:  equipoBackEnd+version+"personalSalud/relaciones/pacientes/pendientes",
                type: "POST",
                data: '{"id":'+id+' ,"nombres":"'+nombres+'","apellidos":"'+apellidos+'", "documentoIdentidad":"'+documentoIdentidad+'","nombreUsuario":"'+nombreUsuario+'","password":"","tipoDocumento":"'+tipoDocumento+'","correo":"'+correo+'","rol":"'+rol+'" }',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getSolicitudesAceptadas(id,nombres,apellidos,documentoIdentidad,nombreUsuario,tipoDocumento,correo,rol){
            return $.ajax({
                url:  equipoBackEnd+version+"personalSalud/relaciones/pacientes/aceptadas",
                type: "POST",
                data: '{"id":'+id+' ,"nombres":"'+nombres+'","apellidos":"'+apellidos+'", "documentoIdentidad":"'+documentoIdentidad+'","nombreUsuario":"'+nombreUsuario+'","password":"","tipoDocumento":"'+tipoDocumento+'","correo":"'+correo+'","rol":"'+rol+'"}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getBusquedaPacientes(dato){
            return $.ajax({
                url:  equipoBackEnd+version+"pacientes/"+dato,
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
                url:  equipoBackEnd+version+"personalSalud/relaciones/pacientes",
                type: "POST",
                data: '{"id":0 ,"idPaciente":'+idPaciente+',"idFamiliar":'+idFamiliar+', "estado":"","relacion":"'+relacion+'"}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getTodosMensajes(idPaciente){
            return $.ajax({
                url:  equipoBackEnd+version+"mensajes/otros/"+idPaciente,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            }); 
        },
        enviarMensaje(idPaciente, idPersonalSalud, fecha, mensaje, tipo, rol, puedeVerPac, nombreRemitente, checkBox){
            return $.ajax({
                url:  equipoBackEnd+version+"mensajes",
                type: "POST",
                data: '{"id":0 ,"idPaciente":"'+idPaciente+'","idPersonalSalud":"'+idPersonalSalud+'", "fecha":"'+fecha+'" ,"mensaje":"'+mensaje+'","tipo":"'+tipo+'","rol":"'+rol+'","puedeVerPac":"'+puedeVerPac+'","nombreRemitente":"'+nombreRemitente+'","checkBox":"'+checkBox+'"}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getEnfermedades(){
            return $.ajax({
                url:  equipoBackEnd+version+"enfermedades",
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        guardarHistorialMedico(idPaciente, idEnfermedad, idPersonalSalud, fecha, rol){
            return $.ajax({
                url:  equipoBackEnd+version+"historialMedico",
                type: "POST",
                data: '{"id":0 ,"idPaciente":"'+idPaciente+'","idPersonalSalud":"'+idPersonalSalud+'", "fecha":"'+fecha+'" , "rol":"'+rol+'", "enfermedad" : {"id":'+idEnfermedad+'}}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getHistorialMedico(idPaciente){
            return $.ajax({
                url:  equipoBackEnd+version+"historialMedico/"+idPaciente,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        eliminarHistorialMedico(id){
            return $.ajax({
                url:  equipoBackEnd+version+"historialMedico",
                type: "DELETE",
                data: '{"id":'+id+',"idPaciente":"0"}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        modificar(nombres,apellidos,rol,id){
            return $.ajax({
                url: equipoBackEnd+version+"personalSalud",
                type: "PUT",
                data: '{"nombres":"'+nombres+'","apellidos":"'+apellidos+'", "rol":"'+rol+'","id":'+id+'}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        }
    };
    
}());


