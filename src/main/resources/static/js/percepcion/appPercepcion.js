var appPercepcion = (function(){
    const cantidaPreguntasPorNivel = 8;
    const nivelMaximo = 3;
    var pregunta = [];
    var nivel = 1;
    var preguntasCorrectasTemporales = 1;
    var preguntasCorrectas = 0;
    var preguntasErroneas = 0;
    var horaInicio = new Date();
    var nivelMaximoAlcanzado = nivel;
    var llegoNivelMaximo = false;

    return{
        validarRespuesta:function(Boton){
        	var respuesta = Boton.name;
        	if(respuesta  === "S"){
        		preguntasCorrectasTemporales ++;
        		if(preguntasCorrectasTemporales > cantidaPreguntasPorNivel && nivel<nivelMaximo){
		        	$('#modalSubirNivel').modal('show');
		        	setTimeout(function(){ $('#modalSubirNivel').modal('hide'); }, 1500);
        			appPercepcion.subirNivel();
        		}
        		else if(preguntasCorrectasTemporales <= cantidaPreguntasPorNivel){
		        	$('#modalCorrecto').modal('show');
		        	setTimeout(function(){ $('#modalCorrecto').modal('hide'); }, 1500);
        		}
        		else if(nivel>=nivelMaximo){
        			llegoNivelMaximo = true;
        			alert("Llegaste al nivel máximo. Volvamos a empezar");
        			appPercepcion.mostrarEstadisticas();
        			appPercepcion.iniciarNivel();
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
        			appPercepcion.bajarNivel();
        		}
        	}
        	appPercepcion.trearSiguientePregunta();
        	habilitarTodosLosBotones();
            
        },
        trearSiguientePregunta:function(){
            apimockPercepcion.getPreguntaAleatorea(nivel, function(preguntaToda){
            	pregunta = preguntaToda;
            	$("#idNivel").text(nivel);
            	$("#idCantidadPreguntasBien").text(preguntasCorrectasTemporales );
            	$("#idCantidadPreguntasTotalNivel").text(cantidaPreguntasPorNivel );
            	$("#idImagenPregunta").attr("src",preguntaToda.imagen);
		$("#idPregunta").text(preguntaToda.pregunta);
		preguntaToda.respuestas= preguntaToda.respuestas.sort(function() {return Math.random() - 0.5});
		for (var i=0; i<4; i++) {
			$("#idImagen"+i).attr("src",preguntaToda.respuestas[i].opcion);
			$("#idImagen"+i).attr("onclick","appPercepcion.validarRespuesta(this)");
			$("#idImagen"+i).attr("name",preguntaToda.respuestas[i].respuestaCorrecta);
    		} });
        },
        init:function(){
            appPercepcion.trearSiguientePregunta();
        },
        getPReguntasCorrectas:function(){
        	return preguntasCorrectas ;
        },
        subirNivel: function(){
                if(nivelMaximoAlcanzado!=nivelMaximo && !llegoNivelMaximo ){
        		nivelMaximoAlcanzado++;
        	}
        	nivel ++;
        	apimockPercepcion.cambiarNivel(nivel);
        	preguntasCorrectasTemporales = 1;
        },
        bajarNivel: function(){
        	nivel --;
        	apimockPercepcion.cambiarNivel(nivel);
        	preguntasCorrectasTemporales = cantidaPreguntasPorNivel;
        	
        },
        ayuda5050:function(){
        	var arregloRespuestasIncorrectas = pregunta.respuestas.filter(traerRespuestasIncorrectas);
        	var numero = getRandomArbitrary(arregloRespuestasIncorrectas);
        	arregloRespuestasIncorrectas.splice(numero ,1);
        	console.info(arregloRespuestasIncorrectas)
        	arregloRespuestasIncorrectas.map(deshabilitarBotones5050);
        	
        }, 
        ayudaCambioPregunta:function(){
        	habilitarTodosLosBotones();
        	appPercepcion.trearSiguientePregunta();
        	
        }, 
        iniciarNivel : function(){
        	nivel=1; 
        	apimockPercepcion.cambiarNivel(nivel);
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
        	alert("Tiempo Jugado: "+appPercepcion.traerTiempoJugado() + ". Preguntas Correctas: "+preguntasCorrectas + ". Preguntas Erroneas: "+preguntasErroneas + " . Nivel Máximo: "+nivelMaximoAlcanzado  );
		console.info("Tiempo Jugado: "+appPercepcion.traerTiempoJugado() + ". Preguntas Correctas: "+preguntasCorrectas + ". Preguntas Erroneas: "+preguntasErroneas + " . Nivel Máximo: "+nivelMaximoAlcanzado  );
        }
    };
})();
function traerRespuestasIncorrectas(filter){
	if(filter.respuestaCorrecta === "N"){
		return filter;
	}
}
function habilitarTodosLosBotones(){
	for (var i=0; i<4; i++) {
		$("#idImagen"+i).show();
    	} 
    	$("#idBtn5050").attr("disabled",false);
    	$("#idBtn5050").attr("onclick","appPercepcion.ayuda5050()");
}


function getRandomArbitrary(arrgloIndices){ 
  	return parseInt(Math.random() * (arrgloIndices.length));
}

function deshabilitarBotones5050(respuesta){
	for (var i=0; i<4; i++) {
		if($("#idImagen"+i).attr('src')===respuesta.opcion){
			$("#idImagen"+i).hide();
			$("#idImagen"+i).attr("onclick","");
		}
    	} 
    	$("#idBtn5050").attr("disabled",true);
    	$("#idBtn5050").attr("onclick","");
}
