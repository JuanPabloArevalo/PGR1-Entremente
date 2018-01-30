/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var arregloIndices= [];
var mockdata=[];
var arreglo;

var apiclientMusicoterapia = (function(){
    return{
        cargarPreguntas(idPaciente, nivel, callback){
            var promesa2 = $.get("/entremente/V1/juegos/galeria/"+idPaciente);
            promesa2.then(
                function () { 
                    mockdata[1] = promesa2.responseJSON[0];
                    mockdata[2] = promesa2.responseJSON[1];
                    mockdata[3] = promesa2.responseJSON[2];
                    mockdata[4] = promesa2.responseJSON[3];
                    apiclientGaleria.getPreguntaAleatorea(nivel,callback);
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        getPreguntaAleatorea:function(nivel,callback){
            if(arregloIndices.length===0){
                apiclientGaleria.llenarArreglo(nivel);
            }
            
            var numero = getRandomArbitrary(arregloIndices);
//            console.info(nivel);
//            console.info(numero);
//            console.info(mockdata[nivel]);
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
                apiclientGaleria.llenarArreglo(nivel);	
        },
        getArreglo:function(nivel){
                return arregloIndices;
        },
        enviarResultados(idPaciente, fecha, acertadas, erroneas, tiempo, nivelMaximo){
            return $.ajax({
                url:  "/entremente/V1/juegos/resultados/galeria",
                type: "POST",
                data: '{"idPaciente":"'+idPaciente+'" ,"fecha":"'+fecha+'","acertadas":'+acertadas+', "erroneas":'+erroneas+',"tiempo":'+tiempo+',"nivelMaximo":'+nivelMaximo+'}',
                contentType: "application/json"
            });
        },
        getTodasPreguntas(idPaciente){
            return $.get("/entremente/V1/juegos/galeria/todas/"+idPaciente);;
        },
        modificarPregunta(id, nivelPersonalizado, estado){
            return $.ajax({
                url:  "/entremente/V1/juegos/galeria",
                type: "POST",
                data: '{"id":'+id+' ,"nivel":'+nivelPersonalizado+',"estado":"'+estado+'"}',
                contentType: "application/json"
            });
        }
    };
    
}());

function getRandomArbitrary(arrgloIndices) {
  	return parseInt(Math.random() * (arrgloIndices.length));
}