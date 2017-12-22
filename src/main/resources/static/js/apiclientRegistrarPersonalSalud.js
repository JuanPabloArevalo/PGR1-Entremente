/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var apiclientRegistrarPersonalSalud = (function(){
    return{
        adicionarPersonalSalud(nombres,apellidos,tipoDocumento,documentoIdentidad,nombreUsuario,password,correo,rol){
            return $.ajax({
                url: "/entremente/V1/personalSalud",
                type: "POST",
                data: '{"nombres":"'+nombres+'","apellidos":"'+apellidos+'", "documentoIdentidad":"'+documentoIdentidad+'","nombreUsuario":"'+nombreUsuario+'","password":"'+password+'","tipoDocumento":"'+tipoDocumento+'","correo":"'+correo+'","rol":"'+rol+'" }',
                contentType: "application/json"
            });
        }
    };
    
}());
