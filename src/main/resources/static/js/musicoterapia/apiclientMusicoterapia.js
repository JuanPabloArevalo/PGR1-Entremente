/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var arregloIndices= [];
var mockdata=[];
var arreglo;

var apiclientMusicoterapia = (function(){
    var equipoBackEnd = configuracionHost.getEquipoBackEnd();
    var version = configuracionHost.getVersion();
    return{
        cargarPreguntas(idPaciente, nivel, callback){
            var promesa2 = $.ajax({
                url:  equipoBackEnd+version+"juegos/musicoterapia/"+idPaciente,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
            promesa2.then(
                function () { 
                    console.info(promesa2)
                    mockdata[1] = promesa2.responseJSON[0];
                    mockdata[2] = promesa2.responseJSON[1];
                    mockdata[3] = promesa2.responseJSON[2];
                    mockdata[4] = promesa2.responseJSON[3];
                    apiclientMusicoterapia.getPreguntaAleatorea(nivel,callback);
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        getPreguntaAleatorea:function(nivel,callback){
            console.info(nivel)
            console.info(arregloIndices)
            
             
            if(arregloIndices.length===0){
                apiclientMusicoterapia.llenarArreglo(nivel);
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
                apiclientMusicoterapia.llenarArreglo(nivel);	
        },
        getArreglo:function(nivel){
                return arregloIndices;
        },
        enviarResultados(idPaciente, fecha, acertadas, erroneas, tiempo, nivelMaximo){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/resultados/musicoterapia",
                type: "POST",
                data: '{"idPaciente":"'+idPaciente+'" ,"fecha":"'+fecha+'","acertadas":'+acertadas+', "erroneas":'+erroneas+',"tiempo":'+tiempo+',"nivelMaximo":'+nivelMaximo+'}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        getTodasPreguntas(idPaciente){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/musicoterapia/todas/"+idPaciente,
                type: "GET",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        modificarPregunta(id, nivelPersonalizado, estado){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/musicoterapia",
                type: "POST",
                data: '{"id":'+id+' ,"nivel":'+nivelPersonalizado+',"estado":"'+estado+'"}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        },
        buscarVideosYoutube(palabraClave){            
            return $.ajax({
                type: "GET", 
                url: "https://www.googleapis.com/youtube/v3/search?maxResults=10&part=id,snippet&q="+palabraClave+"&key=AIzaSyBpOECppHPmAQ_zxLA2u3njjmTEu_5B00k",
                headers: {
                    "Access-Control-Allow-Origin": "*",
                    "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,OPTIONS",
                    "Access-Control-Allow-Headerss": "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,t",
                    "Access-Control-Allow-Credentials":"true"
                },
                contentType: "application/json"
              });
        },
        adicionarPregunta(pregunta, video, nivel, respuestaA, respuestaB, respuestaC, respuestaD, correctaA, correctaB, correctaC, correctaD, idPaciente){
            return $.ajax({
                url:  equipoBackEnd+version+"juegos/musicoterapia/"+idPaciente,
                type: "POST",
                data: '{"id":0 , "pregunta":"'+pregunta+'", "video":"'+video+'", "nivel":'+nivel+', "personalizado" : "S",  "estado": "A", "respuestas" : [{"opcion" : "'+respuestaA+'" , "respuestaCorrecta": "'+correctaA+'"},{"opcion" : "'+respuestaB+'" , "respuestaCorrecta": "'+correctaB+'"},{"opcion" : "'+respuestaC+'" , "respuestaCorrecta": "'+correctaC+'"},{"opcion" : "'+respuestaD+'" , "respuestaCorrecta": "'+correctaD+'"}]}',
                contentType: "application/json",
                headers: {'Authorization':'Bearer '+sessionStorage.getItem("Token")}
            });
        }
    };
      
}());

function getRandomArbitrary(arrgloIndices) {
  	return parseInt(Math.random() * (arrgloIndices.length));
}