/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var apiclientResultados = (function(){
    var equipoBackEnd = configuracionHost.getEquipoBackEnd();
    var version = configuracionHost.getVersion();
    return{
    //Galeria
        getResultadosGaleriaDia(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/galeria/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosGaleriaMes(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/galeria/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosGaleriaAnual(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/galeria/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
    //Calculemos
        getResultadosCalculemosDia(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/calculo/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosCalculemosMes(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/calculo/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosCalculemosAnual(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/calculo/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
    //Percepcion
        getResultadosPercepcionDia(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/percepcion/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosPercepcionMes(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/percepcion/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosPercepcionAnual(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/percepcion/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
    //Atencion
        getResultadosAtencionDia(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/atencion/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosAtencionMes(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/atencion/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosAtencionAnual(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/atencion/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
    //Formas
        getResultadosFormasDia(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/formas/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosFormasMes(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/formas/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosAtFormasAnual(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/formas/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
    //Musicoterapia
        getResultadosMusicoterapiaDia(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/musicoterapia/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosMusicoterapiaMes(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/musicoterapia/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosMusicoterapiaAnual(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/musicoterapia/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
    //QUEUSAR
        getResultadosQueUsarDia(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/queUsar/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosQueUsarMes(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/queUsar/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosQueUsarAnual(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/queUsar/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
    //Rutinas
        getResultadosGrupoFamiliarDia(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/grupoFamiliar/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosGrupoFamiliarMes(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/grupoFamiliar/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        },
        getResultadosGrupoFamiliarAnual(idPaciente, fechaInicial, fechaFinal){
            return $.get(equipoBackEnd+version+"juegos/resultados/grupoFamiliar/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal);  
        }
    };
    
}());


