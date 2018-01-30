/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var apiclientPerfilPaciente = (function(){
    return{
        getSolicitudesPendientes(id,nombres,apellidos,documentoIdentidad,nombreUsuario,tipoDocumento,correo){
            return $.ajax({
                url:  "/entremente/V1/pacientes/relaciones/familiares/pendientes",
                type: "POST",                
                data: '{"id":'+id+' ,"nombres":"'+nombres+'","apellidos":"'+apellidos+'", "documentoIdentidad":"'+documentoIdentidad+'","nombreUsuario":"'+nombreUsuario+'","password":"","tipoDocumento":"'+tipoDocumento+'","correo":"'+correo+'"}',
                contentType: "application/json"
            });
        },
        getSolicitudesAceptadas(id,nombres,apellidos,documentoIdentidad,nombreUsuario,tipoDocumento,correo){
            return $.ajax({
                url:  "/entremente/V1/pacientes/relaciones/familiares/aceptadas",
                type: "POST",
                data: '{"id":'+id+' ,"nombres":"'+nombres+'","apellidos":"'+apellidos+'", "documentoIdentidad":"'+documentoIdentidad+'","nombreUsuario":"'+nombreUsuario+'","password":"","tipoDocumento":"'+tipoDocumento+'","correo":"'+correo+'"}',
                contentType: "application/json"
            });
        },
        getBusquedaFamiliares(dato){
            return $.get("/entremente/V1/familiares/"+dato);  
        },
        aceptarSolicitud(id, idPaciente, idFamiliar){
            return $.ajax({
                url:  "/entremente/V1/familiares/relaciones/pacientes",
                type: "PUT",
                data: '{"id":'+id+' ,"idPaciente":'+idPaciente+',"idFamiliar":'+idFamiliar+', "estado":"","relacion":""}',
                contentType: "application/json"
            });
        },
        eliminarSolicitud(id, idPaciente, idFamiliar){
            return $.ajax({
                url:  "/entremente/V1/familiares/relaciones/pacientes",
                type: "DELETE",
                data: '{"id":'+id+' ,"idPaciente":'+idPaciente+',"idFamiliar":'+idFamiliar+', "estado":"","relacion":""}',
                contentType: "application/json"
            });
        },
        adicionarSolicitud(idPaciente, idFamiliar,relacion){
            return $.ajax({
                url:  "/entremente/V1/pacientes/relaciones/familiares",
                type: "POST",
                data: '{"id":0 ,"idPaciente":'+idPaciente+',"idFamiliar":'+idFamiliar+', "estado":"","relacion":"'+relacion+'"}',
                contentType: "application/json"
            });
        },
        getTodosMensajes(idPaciente){
            return $.get("/entremente/V1/mensajes/pacientes/"+idPaciente);  
        },
        modificarPaciente(nombres,apellidos,fechaNacimiento,genero,pais,ciudad,direccion,id){
            return $.ajax({
                url: "/entremente/V1/pacientes",
                type: "PUT",
                data: '{"nombres":"'+nombres+'","apellidos":"'+apellidos+'", "fechaNacimiento":"'+fechaNacimiento+'","genero":"'+genero+'","pais":"'+pais+'","ciudad":"'+ciudad+'","direccion":"'+direccion+'","id":'+id+'}',
                contentType: "application/json"
            });
        },
        getProgresoPaciente(idPaciente){
            return $.get("/entremente/V1/pacientes/progresos/"+idPaciente);  
        }
      };
    
}());


