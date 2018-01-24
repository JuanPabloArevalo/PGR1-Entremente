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

var apiclientCalculemos = (function(){
    return{
        cargarPreguntas(idPaciente, nivel, callback){
            var promesa2 = $.get("/entremente/V1/juegos/calculo/"+idPaciente);
            promesa2.then(
                function () { 
                    mockdata[1] = promesa2.responseJSON[0];
                    mockdata[2] = promesa2.responseJSON[1];
                    mockdata[3] = promesa2.responseJSON[2];
                    mockdata[4] = promesa2.responseJSON[3];
                    apiclientCalculemos.getPreguntaAleatorea(nivel,callback);
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        getPreguntaAleatorea:function(nivel,callback){
            if(arregloIndices.length===0){
                apiclientCalculemos.llenarArreglo(nivel);
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
                apiclientCalculemos.llenarArreglo(nivel);	
        },
        getArreglo:function(nivel){
                return arregloIndices;
        }
    };
    
}());

function getRandomArbitrary(arrgloIndices) {
  	return parseInt(Math.random() * (arrgloIndices.length));
}

