/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var apiclientIniciarSesion = (function(){
    
    return{
        autenticacionPaciente(nombreUsuario,password, callback){
            return $.get("/entremente/V1/pacientes/"+nombreUsuario+"/"+password,callback);  
        },
        autenticacionFamiliar(nombreUsuario,password, callback){
            return $.get("/entremente/V1/familiares/"+nombreUsuario+"/"+password,callback);  
        },
        autenticacionPersonalSalud(nombreUsuario,password, callback){
            return $.get("/entremente/V1/personalSalud/"+nombreUsuario+"/"+password,callback);  
        }
    };
    
}());
