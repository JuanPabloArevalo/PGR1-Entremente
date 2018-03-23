/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var apiclientIniciarSesion = (function(){
    var equipoBackEnd = configuracionHost.getEquipoBackEnd();
    var version = configuracionHost.getVersion();
    return{
        autenticacionPaciente(nombreUsuario,password, callback){
            return $.get(equipoBackEnd+version+"pacientes/"+nombreUsuario+"/"+password,callback);  
        },
        autenticacionFamiliar(nombreUsuario,password, callback){
            return $.get(equipoBackEnd+version+"familiares/"+nombreUsuario+"/"+password,callback);  
        },
        autenticacionPersonalSalud(nombreUsuario,password, callback){
            return $.get(equipoBackEnd+version+"personalSalud/"+nombreUsuario+"/"+password,callback);  
        },
        autenticacionInvitado(callback){
            return $.get(equipoBackEnd+version+"invitado",callback);  
        }
    };
    
}());
