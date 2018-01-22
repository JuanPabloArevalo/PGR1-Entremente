/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var arregloIndices= [];
var mockdata=[];

var apiclientGaleria = (function(){
    return{
        getPreguntaAleatorea(idPaciente,nivel){
            return $.get("/entremente/V1/juegos/galeria/"+idPaciente+"/"+nivel);  
        }
    };
    
}());

function getRandomArbitrary(arrgloIndices) {
  	return parseInt(Math.random() * (arrgloIndices.length));
}