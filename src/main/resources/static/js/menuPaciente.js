/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var menuPaciente = (function () {
    return {
        init(){
            if ("undefined" === sessionStorage.getItem("esTemporal") || null === sessionStorage.getItem("esTemporal")) {
                window.location.href = "index.html";
            }else if("S" === sessionStorage.getItem("esTemporal")){
                $('#idBotonMiPerfil').hide();
                $('#idBotonAtras').hide();
                $('#idBotonAtras2').show();
               
            }
            else{
                $('#idBotonMiPerfil').show();
                $('#idBotonAtras').show();
                $('#idBotonAtras2').hide();
            }
        }
    };
}());
