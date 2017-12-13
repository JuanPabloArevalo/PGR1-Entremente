var appAtencion = (function(){
    const cantidaPreguntasPorNivel = 8;
    const nivelMaximo = 4;
    var pregunta = [];
    var nivel = 1;
    var preguntasCorrectasTemporales = 1;
    var preguntasCorrectas = 0;
    var preguntasErroneas = 0;
    var horaInicio = new Date();
    var opcionesSeleccionadas = 0;
    var opcionesQueTieneQueSeleccionar = 0;
    var nivelMaximoAlcanzado = nivel;
    var llegoNivelMaximo = false;
    
    return{
        validarRespuesta:function(Boton){
        	console.info(opcionesQueTieneQueSeleccionar );
        	var palabraClave = pregunta.palabraClave;
        	var id = "#"+Boton.id;
        	var respuesta = Boton.name;
        	if(palabraClave  == respuesta){
        		opcionesSeleccionadas ++;
        		deshabilitarBotonRespuesta(Boton.id);
        		if(opcionesSeleccionadas  === opcionesQueTieneQueSeleccionar){
	        		preguntasCorrectasTemporales ++;
	        		if(preguntasCorrectasTemporales > cantidaPreguntasPorNivel && nivel<nivelMaximo){
		        		$('#modalSubirNivel').modal('show');
		        		setTimeout(function(){ $('#modalSubirNivel').modal('hide'); }, 1500);
	        			appAtencion.subirNivel();
	        		}
	        		else if(preguntasCorrectasTemporales <= cantidaPreguntasPorNivel){
		        		$('#modalCorrecto').modal('show');
		        		setTimeout(function(){ $('#modalCorrecto').modal('hide'); }, 1500);
	        		}
	        		else if(nivel>=nivelMaximo){
	        			llegoNivelMaximo = true;
        				alert("Llegaste al nivel máximo. Volvamos a empezar");
        				appAtencion.mostrarEstadisticas();
	        			appAtencion.iniciarNivel();
	        		}
	        		preguntasCorrectas++;
	        		
	        		appAtencion.trearSiguientePregunta();
	        		habilitarTodosLosBotones();
        			
        		}
        	
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
        			appAtencion.bajarNivel();
        		}
        		
        		appAtencion.trearSiguientePregunta();
        		habilitarTodosLosBotones();
        	}
        	
            
        },
        
        trearSiguientePregunta:function(){
            apimockAtencion.getPreguntaAleatorea(nivel, function(preguntaToda){
            	pregunta = preguntaToda;
            	opcionesQueTieneQueSeleccionar =0;
            	for(var i=0; i<4;i++){
			if(pregunta.respuestas[i].respuestaCorrecta == "S"){
				opcionesQueTieneQueSeleccionar ++; 
			}
		}
		
            	opcionesSeleccionadas  = 0;
            	$("#idNivel").text(nivel);
            	$("#idCantidadPreguntasBien").text(preguntasCorrectasTemporales );
            	$("#idCantidadPreguntasTotalNivel").text(cantidaPreguntasPorNivel );
            	$("#idImagenPregunta").attr("src",preguntaToda.imagen);
		$("#idPregunta").text(preguntaToda.pregunta);
		preguntaToda.respuestas= preguntaToda.respuestas.sort(function() {return Math.random() - 0.5});
		for (var i=0; i<4; i++) {
			var idP ="#idImagen"+i;
			$("#idImagen"+i).attr("src",preguntaToda.respuestas[i].opcion);
			$("#idImagen"+i).attr("name",preguntaToda.respuestas[i].palabraClave);
			$("#idImagen"+i).attr("onclick","appAtencion.validarRespuesta(this)");
    		} });
        },
        init:function(){
            appAtencion.trearSiguientePregunta();
        },
        getPReguntasCorrectas:function(){
        	return preguntasCorrectas ;
        },
        subirNivel: function(){
        	if(nivelMaximoAlcanzado!=nivelMaximo && !llegoNivelMaximo ){
        		nivelMaximoAlcanzado++;
        	}
        	nivel ++;
        	apimockAtencion.cambiarNivel(nivel);
        	preguntasCorrectasTemporales = 1;
        },
        bajarNivel: function(){
        	nivel --;
        	apimockAtencion.cambiarNivel(nivel);
        	preguntasCorrectasTemporales = cantidaPreguntasPorNivel;
        	
        },
        ayuda5050:function(){
        	var arregloRespuestasIncorrectas = pregunta.respuestas.filter(traerRespuestasIncorrectas);
        	var numero = getRandomArbitrary(arregloRespuestasIncorrectas);
        	arregloRespuestasIncorrectas.splice(numero ,1);
        	arregloRespuestasIncorrectas.map(deshabilitarBotones5050);
        	
        }, 
        ayudaCambioPregunta:function(){
        	habilitarTodosLosBotones();
        	appAtencion.trearSiguientePregunta();
        	
        }, 
        iniciarNivel : function(){
        	nivel=1; 
        	apimockAtencion.cambiarNivel(nivel);
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
        	alert("Tiempo Jugado: "+appAtencion.traerTiempoJugado() + ". Preguntas Correctas: "+preguntasCorrectas + ". Preguntas Erroneas: "+preguntasErroneas + " . Nivel Máximo: "+nivelMaximoAlcanzado  );
		console.info("Tiempo Jugado: "+appAtencion.traerTiempoJugado() + ". Preguntas Correctas: "+preguntasCorrectas + ". Preguntas Erroneas: "+preguntasErroneas + " . Nivel Máximo: "+nivelMaximoAlcanzado  );
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
}
function getRandomArbitrary(arrgloIndices){ 
  	return parseInt(Math.random() * (arrgloIndices.length));
}

function deshabilitarBotonRespuesta(idBoton){
	$("#"+idBoton).hide();
	$("#"+idBoton).attr("onclick","");
}

