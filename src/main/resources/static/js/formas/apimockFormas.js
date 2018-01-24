//var apimockFormas=(function(){
//	var arregloIndices= [];
//	var mockdata=[];
//        mockdata[1]=[
//            {"pregunta":"Elige la silueta que no aparece en la imagen","imagen":"image\\Formas\\forma1.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\forma1.1.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\forma1.2.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\forma1.3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\forma1.4.png","respuestaCorrecta":"N"}]
//            },
//             {"pregunta":"Elige la imagen con igual silueta","imagen":"image\\Formas\\forma2.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\forma2.1.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\forma2.4.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\forma2.3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\forma2.2.png","respuestaCorrecta":"N"}]
//            },
//             {"pregunta":"Elige la silueta que no aparece mezclada con las siluetas que se muestrean en la imagen superior","imagen":"image\\Formas\\formas3.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\formas3M1.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\formas3C1.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\formas3M2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\formas3M3.png","respuestaCorrecta":"N"}]
//            },
//             {"pregunta":"Elige la silueta que no aparece mezclada con las siluetas que se muestrean en la imagen superior","imagen":"image\\Formas\\formas4.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\formaNube.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\formaArco.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\formaCorrecto.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\formabandera.png","respuestaCorrecta":"N"}]
//            },
//             {"pregunta":"Elige la silueta que no aparece mezclada con las siluetas que se muestrean en la imagen superior","imagen":"image\\Formas\\formas5.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\formaEstrella4.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\formaEstrella2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\formaCorrecto.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\formaCuadradoRed.png","respuestaCorrecta":"N"}]
//            },
//             {"pregunta":"Elige la silueta que no aparece mezclada con las siluetas que se muestrean en la imagen superior","imagen":"image\\Formas\\formas6.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\formaTriangulo.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\formaOvalo.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\formaCirculo.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\formaEstrella4.png","respuestaCorrecta":"N"}]
//            },
//             {"pregunta":"Elige la silueta que no aparece mezclada con las siluetas que se muestrean en la imagen superior","imagen":"image\\Formas\\formas7.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\formaTriangulo2.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\formaDiamante.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\formaPentagono.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\formaHexagono.png","respuestaCorrecta":"N"}]
//            },
//             {"pregunta":"Elige la silueta que no aparece mezclada con las siluetas que se muestrean en la imagen superior","imagen":"image\\Formas\\formas8.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\formaEstrella2.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\formaFlecha.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\formaFlecha2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\formaEstrella3.png","respuestaCorrecta":"N"}]
//            }
//        ];
//
//	mockdata[2]=[
//            {"pregunta":"Elige la silueta del animal que no tiene relación con la imagen superior","imagen":"image\\Formas\\alce.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\delfin.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\burro.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\caballo.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\cabra.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta del animal que no tiene relación con la imagen superior","imagen":"image\\Formas\\arana.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\pescado.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\arana2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\lagartija.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\hormiga.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta del animal que no tiene relación con la imagen superior","imagen":"image\\Formas\\ardilla.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\buho.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\lobo.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\gato.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\gallina.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta del animal que no tiene relación con la imagen superior","imagen":"image\\Formas\\cerdo.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\pescado2.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\rinoceronte.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\vaca.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\llama.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta del animal que no tiene relación con la imagen superior","imagen":"image\\Formas\\delfin.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\pollito.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\estrellaMar.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\leonMarino.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\pescado.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta del animal que no tiene relación con la imagen superior","imagen":"image\\Formas\\mico.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\pato.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\mico2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\mono.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\oso.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta del animal que no tiene relación con la imagen superior","imagen":"image\\Formas\\hormiga.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\gallina.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\arana.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\arana2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\cienPies.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta del animal que no tiene relación con la imagen superior","imagen":"image\\Formas\\colibri.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\oso.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\buho.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\libelula.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\abeja.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta del animal que no tiene relación con la imagen superior","imagen":"image\\Formas\\alce.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\perro.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\cabra.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\elefante.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\toro.png","respuestaCorrecta":"N"}]
//            }
//        ];
//        
//        mockdata[3]=[
//            {"pregunta":"Elige la silueta que no hace parte de la imagen superior","imagen":"image\\Formas\\formas9.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\formabandera.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\formaCuadrado.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\formaArco.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\abeja.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta que no hace parte de la imagen superior","imagen":"image\\Formas\\formas10.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\ardilla.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\delfin.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\estrellaMar.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\formaEstrella4.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta que no hace parte de la imagen superior","imagen":"image\\Formas\\formas11.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\pollito.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\ardilla.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\cerdo.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\colibri.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta que no hace parte de la imagen superior","imagen":"image\\Formas\\formas12.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\formaGlobo.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\formaNube.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\arana.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\arana2.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta que no hace parte de la imagen superior","imagen":"image\\Formas\\formas13.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\elefante.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\alce.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\burro.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\cabra.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta que no hace parte de la imagen superior","imagen":"image\\Formas\\formas14.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\oso.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\caballo.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\llama.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\leonMarino.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta que no hace parte de la imagen superior","imagen":"image\\Formas\\formas15.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\tigre1.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\formaCorrecto.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\gato.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\lobo.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta que no hace parte de la imagen superior","imagen":"image\\Formas\\formas16.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\formaHexagono.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\pollito.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\formaCirculo.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\formaPentagono.png","respuestaCorrecta":"N"}]
//            }
//        ]; 
//        mockdata[4]=[
//            {"pregunta":"Elige la silueta que hace parte de la imagen superior","imagen":"image\\Formas\\formas17.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\burro.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\alce.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\rinoceronte.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\toro.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta que hace parte de la imagen superior","imagen":"image\\Formas\\formas18.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\rinoceronte.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\elefante.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\mico.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\jirafa.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta que hace parte de la imagen superior","imagen":"image\\Formas\\formas19.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\mico.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\alce.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\oso.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\pescado2.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta que hace parte de la imagen superior","imagen":"image\\Formas\\formas20.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\osoHormiguero.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\perro.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\estrellaMar.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\caballo.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta que hace parte de la imagen superior","imagen":"image\\Formas\\formas21.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\jirafa.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\gallina.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\cerdo.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\hormiga.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta que hace parte de la imagen superior","imagen":"image\\Formas\\formas22.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\elefante.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\jirafa.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\pollito.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\pato.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta que hace parte de la imagen superior","imagen":"image\\Formas\\formas23.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\mono.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\pescado.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\mico2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\abeja.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la silueta que hace parte de la imagen superior","imagen":"image\\Formas\\formas24.png" ,"respuestas":[
//            	{"opcion":"image\\Formas\\lagartija.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Formas\\hormiga.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\buho.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Formas\\elefante.png","respuestaCorrecta":"N"}]
//            }
//        ]; 
//	return {
//		getPreguntaAleatorea:function(nivel,callback){
//			if(arregloIndices.length===0){
//				apimockFormas.llenarArreglo(nivel);
//			}
//			
//			var numero = getRandomArbitrary(arregloIndices);
//			
//			callback(
//				mockdata[nivel][arregloIndices[numero]]
//			);
//			arregloIndices.splice(numero , 1);
//		},
//		llenarArreglo:function(nivel){
//			for (i = 0; i < mockdata[nivel].length; i++) {
//    				arregloIndices.push(i);
//			}
//		},
//		cambiarNivel:function(nivel){
//			arregloIndices= [];
//			apimockFormas.llenarArreglo(nivel);	
//		},
//		getArreglo:function(nivel){
//			return arregloIndices;
//		}
//	}	
//
//})();
//
//function getRandomArbitrary(arrgloIndices) {
//  	return parseInt(Math.random() * (arrgloIndices.length));
//}
