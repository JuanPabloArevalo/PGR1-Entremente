/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var apiclientRegistrarPaciente = (function(){
    var equipoBackEnd = configuracionHost.getEquipoBackEnd();
    var version = configuracionHost.getVersion();
    return{
        adicionarPaciente(nombres,apellidos,tipoDocumento,documentoIdentidad,fechaNacimiento,genero,pais,ciudad,nombreUsuario,password,direccion,correo){
            return $.ajax({
                url: equipoBackEnd+version+"pacientes",
                type: "POST",
                data: '{"nombres":"'+nombres+'","apellidos":"'+apellidos+'", "documentoIdentidad":"'+documentoIdentidad+'", "fechaNacimiento":"'+fechaNacimiento+'","genero":"'+genero+'","pais":"'+pais+'","ciudad":"'+ciudad+'","nombreUsuario":"'+nombreUsuario+'","password":"'+password+'","direccion":"'+direccion+'","tipoDocumento":"'+tipoDocumento+'","correo":"'+correo+'"}',
                contentType: "application/json"
            });
        }
    };
    
}());
