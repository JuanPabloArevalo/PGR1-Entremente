/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var apiclientResultados = (function(){
    return{
    //Galeria
        getResultadosGaleriaDia(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/galeria/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosGaleriaMes(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/galeria/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosGaleriaAnual(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/galeria/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
    //Calculemos
        getResultadosCalculemosDia(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/calculo/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosCalculemosMes(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/calculo/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosCalculemosAnual(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/calculo/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
    //Percepcion
        getResultadosPercepcionDia(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/percepcion/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosPercepcionMes(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/percepcion/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosPercepcionAnual(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/percepcion/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
    //Atencion
        getResultadosAtencionDia(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/atencion/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosAtencionMes(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/atencion/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosAtencionAnual(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/atencion/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
    //Formas
        getResultadosFormasDia(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/formas/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosFormasMes(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/formas/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosAtFormasAnual(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/formas/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
    //Musicoterapia
        getResultadosMusicoterapiaDia(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/musicoterapia/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosMusicoterapiaMes(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/musicoterapia/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosMusicoterapiaAnual(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/musicoterapia/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
    //Rutinas
        getResultadosRutinasDia(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/rutinas/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosRutinasMes(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/rutinas/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosRutinasAnual(idPaciente, fechaInicial, fechaFinal){
            return $.get("/entremente/V1/juegos/resultados/rutinas/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        }
    };
    
}());


