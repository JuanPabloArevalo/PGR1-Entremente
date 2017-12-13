var appCalculemos = (function(){
    const cantidaPreguntasPorNivel = 8;
    const nivelMaximo = 4;
    var pregunta = [];
    var nivel = 1;
    var preguntasCorrectasTemporales = 1;
    var preguntasCorrectas = 0;
    var preguntasErroneas = 0;
    var horaInicio = new Date();
    var nivelMaximoAlcanzado = nivel;
    var llegoNivelMaximo = false;


    return{
        validarRespuesta:function(Nombre){
        	var respuesta = pregunta.respuestas.filter(traerNombreCorrecto);
        	if(respuesta[0].opcion == Nombre){
        		preguntasCorrectasTemporales ++;
        		if(preguntasCorrectasTemporales > cantidaPreguntasPorNivel && nivel<nivelMaximo){
		        	$('#modalSubirNivel').modal('show');
		        	setTimeout(function(){ $('#modalSubirNivel').modal('hide'); }, 1500);
        			appCalculemos.subirNivel();
        		}
        		else if(preguntasCorrectasTemporales <= cantidaPreguntasPorNivel){
		        	$('#modalCorrecto').modal('show');
		        	setTimeout(function(){ $('#modalCorrecto').modal('hide'); }, 1500);
        		}
        		else if(nivel>=nivelMaximo){
        			llegoNivelMaximo = true;
        			alert("Llegaste al nivel máximo. Volvamos a empezar");
        			appCalculemos.mostrarEstadisticas();
        			appCalculemos.iniciarNivel();
        		}
        		preguntasCorrectas++;
        	
        	}
        	else{
        		//Respuesta Incorrecta
		        $('#modalIncorrecto').modal('show');
		        setTimeout(function(){ $('#modalIncorrecto').modal('hide'); }, 1500);
        		preguntasErroneas++; 
        		if(preguntasCorrectasTemporales > 1){
        			preguntasCorrectasTemporales--;
        		}
        		else if(nivel>1){
        			appCalculemos.bajarNivel();
        		}
        	}
        	appCalculemos.trearSiguientePregunta();
        	habilitarTodosLosBotones();
            
        },
        trearSiguientePregunta:function(){
            apimockCalculemos.getPreguntaAleatorea(nivel, function(preguntaToda){
            	pregunta = preguntaToda;
            	$("#idNivel").text(nivel);
            	$("#idCantidadPreguntasBien").text(preguntasCorrectasTemporales );
            	$("#idCantidadPreguntasTotalNivel").text(cantidaPreguntasPorNivel );
		$("#idOperacion").text(preguntaToda.operacion);
		preguntaToda.respuestas= preguntaToda.respuestas.sort(function() {return Math.random() - 0.5});
		for (var i=0; i<4; i++) {
			$("#idBoton"+i).text(preguntaToda.respuestas[i].opcion);
			$("#idBoton"+i).attr("onclick","appCalculemos.validarRespuesta('"+preguntaToda.respuestas[i].opcion+"')");
			$("#idBoton"+i).attr("class","btn btn-success botonOperacion "+preguntaToda.respuestas[i].opcion);
    		} });
        },
        init:function(){
            appCalculemos.trearSiguientePregunta();
        },
        getPReguntasCorrectas:function(){
        	return preguntasCorrectas ;
        },
        subirNivel: function(){
                if(nivelMaximoAlcanzado!=nivelMaximo && !llegoNivelMaximo ){
        		nivelMaximoAlcanzado++;
        	}
        	nivel ++;
        	apimockCalculemos.cambiarNivel(nivel);
        	preguntasCorrectasTemporales = 1;
        },
        bajarNivel: function(){
        	nivel --;
        	apimockCalculemos.cambiarNivel(nivel);
        	preguntasCorrectasTemporales = cantidaPreguntasPorNivel;
        	
        },
        ayuda5050:function(){
        	var arregloRespuestasIncorrectas = pregunta.respuestas.filter(traerRespuestasIncorrectas);
        	console.log(arregloRespuestasIncorrectas );
        	var numero = getRandomArbitrary(arregloRespuestasIncorrectas);
        	console.log(numero );
        	arregloRespuestasIncorrectas.splice(numero ,1);
        	console.log(arregloRespuestasIncorrectas );
        	arregloRespuestasIncorrectas.map(deshabilitarBotones5050);
        	
        }, 
        ayudaCambioPregunta:function(){
        	habilitarTodosLosBotones();
        	appCalculemos.trearSiguientePregunta();
        	
        }, 
        iniciarNivel : function(){
        	nivel=1; 
        	apimockCalculemos.cambiarNivel(nivel);
        	preguntasCorrectasTemporales = 1;
        },
        traerTiempoJugado:function(){
        	var fechaFin = new Date();
        	console.log(horaInicio );
        	console.log(fechaFin );
        	console.log(fechaFin - horaInicio);
        	console.log((fechaFin - horaInicio)/60000);
        	return (fechaFin - horaInicio)/60000;
        },
        mostrarEstadisticas:function(){
        	alert("Tiempo Jugado: "+appCalculemos.traerTiempoJugado() + ". Preguntas Correctas: "+preguntasCorrectas + ". Preguntas Erroneas: "+preguntasErroneas + " . Nivel Máximo: "+nivelMaximoAlcanzado  );
		console.info("Tiempo Jugado: "+appCalculemos.traerTiempoJugado() + ". Preguntas Correctas: "+preguntasCorrectas + ". Preguntas Erroneas: "+preguntasErroneas + " . Nivel Máximo: "+nivelMaximoAlcanzado  );
        }
    };
})();

function traerNombreCorrecto(filter){
	if(filter.respuestaCorrecta === "S"){
		return filter.opcion;
	}
}
function traerRespuestasIncorrectas(filter){
	if(filter.respuestaCorrecta === "N"){
		return filter;
	}
}
function habilitarTodosLosBotones(){
	for (var i=0; i<4; i++) {
		$("#idBoton"+i).attr("disabled",false);
    	} 
    	$("#idBtn5050").attr("disabled",false);
    	$("#idBtn5050").attr("onclick","appCalculemos.ayuda5050()");
}


function getRandomArbitrary(arrgloIndices){ 
  	return parseInt(Math.random() * (arrgloIndices.length));
}

function deshabilitarBotones5050(respuesta){
	for (var i=0; i<4; i++) {
		if($("#idBoton"+i).text()===respuesta.opcion){
			$("#idBoton"+i).attr("disabled",true);
			$("#idBoton"+i).attr("onclick","");
		}
    	} 
    	$("#idBtn5050").attr("disabled",true);
    	$("#idBtn5050").attr("onclick","");
}
