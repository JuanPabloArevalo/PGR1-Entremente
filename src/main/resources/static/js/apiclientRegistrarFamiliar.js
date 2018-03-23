/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var apiclientRegistrarFamiliar = (function(){
    var equipoBackEnd = configuracionHost.getEquipoBackEnd();
    var version = configuracionHost.getVersion();
    return{
        adicionarFamiliar(nombres,apellidos,tipoDocumento,documentoIdentidad,nombreUsuario,password,correo){
            return $.ajax({
                url: equipoBackEnd+version+"familiares",
                type: "POST",
                data: '{"nombres":"'+nombres+'","apellidos":"'+apellidos+'", "documentoIdentidad":"'+documentoIdentidad+'","nombreUsuario":"'+nombreUsuario+'","password":"'+password+'","tipoDocumento":"'+tipoDocumento+'","correo":"'+correo+'"}',
                contentType: "application/json"
            });
        }
    };
    
}());
