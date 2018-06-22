/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var arregloIndices= [];
var mockdata=[];
var arreglo;


var apiclientAtencion = (function(){
    var equipoBackEnd = configuracionHost.getEquipoBackEnd();
    var version = configuracionHost.getVersion();
    return{
        cargarPreguntas(idPaciente, nivel, callback){
            var promesa2 = $.ajax({
                url:  equipoBackEnd+version+"juegos/atencion/"+idPaciente,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
            promesa2.then(
                function () { 
                    mockdata[1] = promesa2.responseJSON[0];
                    mockdata[2] = promesa2.responseJSON[1];
                    mockdata[3] = promesa2.responseJSON[2];
                    mockdata[4] = promesa2.responseJSON[3];
                    apiclientAtencion.getPreguntaAleatorea(nivel,callback);
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        getPreguntaAleatorea:function(nivel,callback){
            if(arregloIndices.length===0){
                apiclientAtencion.llenarArreglo(nivel);
            }
            
            var numero = getRandomArbitrary(arregloIndices);
            callback(
                    mockdata[nivel][arregloIndices[numero]]
            );
            arregloIndices.splice(numero , 1);
        },
        llenarArreglo:function(nivel){
                for (i = 0; i < mockdata[nivel].length; i++) {
                        arregloIndices.push(i);
                }
        },
        cambiarNivel:function(nivel){
                arregloIndices= [];
                apiclientAtencion.llenarArreglo(nivel);	
        },
        getArreglo:function(nivel){
                return arregloIndices;
        },
        enviarResultados(idPaciente, fecha, acertadas, erroneas, tiempo, nivelMaximo){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/atencion",
                type: "POST",
                data: '{"idPaciente":"'+idPaciente+'" ,"fecha":"'+fecha+'","acertadas":'+acertadas+', "erroneas":'+erroneas+',"tiempo":'+tiempo+',"nivelMaximo":'+nivelMaximo+'}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getTodasPreguntas(idPaciente){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/atencion/todas/"+idPaciente,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        modificarPregunta(id, nivelPersonalizado, estado){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/atencion",
                type: "POST",
                data: '{"id":'+id+' ,"nivel":'+nivelPersonalizado+',"estado":"'+estado+'"}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        }
    };
    
}());

function getRandomArbitrary(arrgloIndices) {
  	return parseInt(Math.random() * (arrgloIndices.length));
}

