/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




var index = (function () {
    return {
        jugar(){
             sessionStorage.setItem("esTemporal", "S");
             window.location.href = "menuPaciente.html";
        },
        iniciarSesion(){
             sessionStorage.setItem("esTemporal", "N");
             window.location.href = "iniciarSesion.html";
        }
    };
}());