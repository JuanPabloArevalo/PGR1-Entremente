var apimockRutinas=(function(){
	var arregloIndices= [];
	var mockdata=[];
        mockdata[1]=[
            {"pregunta":"¿Cuál de los siguientes atuendos es conveniente llevar a la playa?", "imagen":"image\\Rutinas\\playa2.jpg", "respuestas":[
            	{"opcion":"image\\Rutinas\\botas1.png","respuestaCorrecta":"N", "numero":1},
            	{"opcion":"image\\Rutinas\\corbata1.png","respuestaCorrecta":"N", "numero":2},
            	{"opcion":"image\\Rutinas\\chanclas1.png","respuestaCorrecta":"S", "numero":3},
            	{"opcion":"image\\Rutinas\\vestidoBano1.png","respuestaCorrecta":"S", "numero":4}]
            },
            {"pregunta":"¿Que atuendos consideras son los más apropiados para ir a un matrimonio?", "imagen":"image\\Rutinas\\matrimonio1.jpg", "respuestas":[
            	{"opcion":"image\\Rutinas\\ropaLigera1.jpg","respuestaCorrecta":"N", "numero":1},
            	{"opcion":"image\\Rutinas\\shorts1.jpg","respuestaCorrecta":"N", "numero":2},
            	{"opcion":"image\\Rutinas\\smoking1.jpg","respuestaCorrecta":"S", "numero":3},
            	{"opcion":"image\\Rutinas\\vestidoElegante1.jpg","respuestaCorrecta":"S", "numero":4}]
            }
            
        ];

	mockdata[2]=[
            {"pregunta":"Seleccione los números que aparecen en la imagen superior, pero en orden inverso. Ejemplo 123 ->321", "imagen":"image\\Atencion\\numeros1.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\numeros1Bien.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numeros1Bien2.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numeros1Mal1.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\numeros1Mal2.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"Seleccione los números que aparecen en la imagen superior, pero en orden inverso. Ejemplo 123 ->321", "imagen":"image\\Atencion\\numeros2.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\numeros2Bien.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numeros2Bien2.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numeros2Mal1.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\numeros2Mal2.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"En la imagen superior se muestra asociaciones color-número. Seleccione las dos imagenes con asociaciones correctas.", "imagen":"image\\Atencion\\numeroColores1.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\numeroColores1Bien1.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numeroColores1Bien2.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numeroColores1Mal1.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\numeroColores1Mal2.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"En la imagen superior se muestra asociaciones color-número. Seleccione las dos imagenes con asociaciones correctas.", "imagen":"image\\Atencion\\numeroColores2.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\numeroColores2Bien1.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numeroColores2Bien2.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numeroColores2Mal1.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\numeroColores2Mal2.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"De los números del 1 al 8 cuales faltan en la imagen superior?", "imagen":"image\\Atencion\\numeros3.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\numeros3Bien1.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numeros3Bien2.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numeros3Mal1.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\numeros3Mal2.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"De los números del 0 al 9 cuales faltan en la imagen superior?", "imagen":"image\\Atencion\\numeros4.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\numero0.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numero4.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numero9.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\numero7.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"De los números del 0 al 9 cuales faltan en la imagen superior?", "imagen":"image\\Atencion\\numeros5.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\numero1.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numero6.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numero0.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\numero5.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"De los números del 0 al 9 cuales faltan en la imagen superior?", "imagen":"image\\Atencion\\numeros6.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\numero2.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numero9.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numero1.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\numero0.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"De los números del 0 al 9 cuales faltan en la imagen superior?", "imagen":"image\\Atencion\\numeros7.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\numero5.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numero8.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numero0.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\numero7.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            }
        ];
        
        mockdata[3]=[
            {"pregunta":"Seleccione los personajes que aparecen en la imagen superior", "imagen":"image\\Atencion\\losSimpsons.jpg", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\homero.jpg","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\bart.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\milhouse.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\rafa.jpg","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"Seleccione los personajes que aparecen en la imagen superior", "imagen":"image\\Atencion\\looneyTunes.jpg", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\BugsBunny.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\Sylvester.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\headShot.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\pepe.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"Seleccione los personajes que aparecen en la imagen superior", "imagen":"image\\Atencion\\Supersonicos.jpg", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\cometin.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\perroSuper.jpg","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\robotina.jpg","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\Wally_Gator.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"Seleccione los personajes que aparecen en la imagen superior", "imagen":"image\\Atencion\\ScoobyDoo.jpg", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\ScoobyDoo.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\Shaggy.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\bart.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\BugsBunny.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"Seleccione todos los elementos que puedas encontrar en el sitio de la fotografia superior. (Comedor)", "imagen":"image\\Atencion\\comedor.jpg", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\sillaComedor.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\plato1.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\tina1.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\gato1.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"Seleccione todas las imagenes que correspondan al medio de transporte que se ve en la imagen superior", "imagen":"image\\Atencion\\avion.jpg", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\helicoptero.jpg","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\globo.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\bus.jpg","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\moto.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"Seleccione todas las imagenes que correspondan a la misma especie del animal mostrado en la imagen superior", "imagen":"image\\Atencion\\gato3.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\gato2.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\gato1.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\perro1.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\dalmata1.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"Seleccione todas las imagenes que correspondan al elemento mostrado en la imagen superior", "imagen":"image\\Atencion\\pc.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\mouse.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\teclado.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\vaso.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\planta.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            }
        ];
        
        mockdata[4]=[
            {"pregunta":"Seleccione los dos números que más se repiten en la imagen superior", "imagen":"image\\Atencion\\numerosRepetidos1.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\numero1.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numero4.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numero7.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\numero3.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
             {"pregunta":"Seleccione los dos números que menos se repiten en la imagen superior", "imagen":"image\\Atencion\\numerosRepetidos1.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\numero2.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numero3.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numero4.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\numero1.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
             {"pregunta":"Seleccione las dos letras que más se repiten en la imagen superior", "imagen":"image\\Atencion\\numerosRepetidos2.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\letraA.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\letraI.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\letraL.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\letraN.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
             {"pregunta":"Seleccione las imagenes que menos se repiten en la imagen superior", "imagen":"image\\Atencion\\numerosRepetidos3.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\numero1.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\letraL.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\letraA.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\letraN.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"En la imagen superior se muestra asociaciones color-número. Seleccione las dos imagenes con asociaciones correctas.", "imagen":"image\\Atencion\\numeroColores3.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\numeroColores3Bien1.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numeroColores3Bien2.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numeroColores3Mal1.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\numeroColores3Mal2.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"En la imagen superior se muestra asociaciones color-número. Seleccione las dos imagenes con asociaciones incorrectas.", "imagen":"image\\Atencion\\numeroColores3.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\numeroColores3Mal1.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numeroColores3Mal2.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numeroColores3Bien2.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\numeroColores3Bien1.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"Seleccione los números que aparecen en la imagen superior, pero en orden inverso. Ejemplo 123 ->321", "imagen":"image\\Atencion\\numerosInversos2.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\numerosInversos2B1.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numerosInversos2B2.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\numerosInversos2M1.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\numerosInversos2M2.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            },
            {"pregunta":"Seleccione las letras que aparecen en la imagen superior, pero en orden inverso. Ejemplo ABC ->CBA", "imagen":"image\\Atencion\\letrasInversas.png", "palabraClave":"a" , "respuestas":[
            	{"opcion":"image\\Atencion\\letrasInversasB1.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\letrasInversasB2.png","respuestaCorrecta":"S", "palabraClave":"a"},
            	{"opcion":"image\\Atencion\\letrasInversasM1.png","respuestaCorrecta":"N", "palabraClave":"b"},
            	{"opcion":"image\\Atencion\\letrasInversasM2.png","respuestaCorrecta":"N", "palabraClave":"b"}]
            }
         ];   
	return {
                cargarPreguntas(idPaciente, nivel, callback){
                    apimockRutinas.getPreguntaAleatorea(nivel,callback);
                },
		getPreguntaAleatorea:function(nivel,callback){
			if(arregloIndices.length===0){
				apimockRutinas.llenarArreglo(nivel);
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
			apimockRutinas.llenarArreglo(nivel);	
		},
		getArreglo:function(nivel){
			return arregloIndices;
		}
	}	

})();

function getRandomArbitrary(arrgloIndices) {
  	return parseInt(Math.random() * (arrgloIndices.length));
}
