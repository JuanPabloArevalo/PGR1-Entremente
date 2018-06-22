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
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/galeria/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            }); 
        },
        getResultadosGaleriaMes(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/galeria/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getResultadosGaleriaAnual(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/galeria/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
    //Calculemos
        getResultadosCalculemosDia(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/calculo/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getResultadosCalculemosMes(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/calculo/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getResultadosCalculemosAnual(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/calculo/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
    //Percepcion
        getResultadosPercepcionDia(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/percepcion/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });  
        },
        getResultadosPercepcionMes(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/percepcion/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getResultadosPercepcionAnual(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/percepcion/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
    //Atencion
        getResultadosAtencionDia(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/atencion/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            }); 
        },
        getResultadosAtencionMes(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/atencion/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getResultadosAtencionAnual(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/atencion/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
    //Formas
        getResultadosFormasDia(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/formas/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            }); 
        },
        getResultadosFormasMes(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/formas/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getResultadosAtFormasAnual(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/formas/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
    //Musicoterapia
        getResultadosMusicoterapiaDia(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/musicoterapia/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            }); 
        },
        getResultadosMusicoterapiaMes(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/musicoterapia/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            }); 
        },
        getResultadosMusicoterapiaAnual(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/musicoterapia/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            }); 
        },
    //QUEUSAR
        getResultadosQueUsarDia(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/queUsar/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getResultadosQueUsarMes(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/queUsar/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getResultadosQueUsarAnual(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/queUsar/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
    //Rutinas
        getResultadosGrupoFamiliarDia(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/grupoFamiliar/dia/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getResultadosGrupoFamiliarMes(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/grupoFamiliar/mes/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getResultadosGrupoFamiliarAnual(idPaciente, fechaInicial, fechaFinal){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/grupoFamiliar/anio/"+idPaciente+"/"+fechaInicial+"/"+fechaFinal,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        }
    };
    
}());


