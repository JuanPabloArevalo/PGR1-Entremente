//var apimockPercepcion=(function(){
//	var arregloIndices= [];
//	var mockdata=[];
//        mockdata[1]=[
//            {"pregunta":"Seleccione la imagen que sea exactamente igual","imagen":"image\\Percepcion\\circulo1.png" ,"respuestas":[
//            	{"opcion":"image\\Percepcion\\circulo1.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\circulo2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\circulo3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\circulo4.png","respuestaCorrecta":"N"}]
//            }, 
//            {"pregunta":"Seleccione la imagen que sea exactamente igual","imagen":"image\\Percepcion\\cuadrado1.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\cuadrado1.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\cuadrado2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\cuadrado3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\cuadrado4.png","respuestaCorrecta":"N"}]
//            }, 
//            {"pregunta":"Seleccione la imagen que sea exactamente igual","imagen":"image\\Percepcion\\corazon1.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\trianguloRojo1.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\trianguloVerde1.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\corazon1.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\nube1.png","respuestaCorrecta":"N"}]
//            }, 
//            {"pregunta":"Seleccione la imagen que sea exactamente igual","imagen":"image\\Percepcion\\maleta1.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\maleta1.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\maleta2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\maleta3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\maleta4.png","respuestaCorrecta":"N"}]
//            }, 
//            {"pregunta":"Seleccione la imagen que sea exactamente igual","imagen":"image\\Percepcion\\balon4.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\balon4.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\balon1.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\balon2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\balon3.png","respuestaCorrecta":"N"}]
//            }, 
//            {"pregunta":"Seleccione la imagen que sea exactamente igual","imagen":"image\\Percepcion\\silla4.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\silla4.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\silla1.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\silla2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\silla3.png","respuestaCorrecta":"N"}]
//            }, 
//            {"pregunta":"Seleccione la imagen que sea exactamente igual","imagen":"image\\Percepcion\\carro1.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\carro1.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\carro2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\carro3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\carro4.png","respuestaCorrecta":"N"}]
//            }, 
//            {"pregunta":"Seleccione la imagen que sea exactamente igual","imagen":"image\\Percepcion\\casa4.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\casa4.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\casa1.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\casa2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\casa3.png","respuestaCorrecta":"N"}]
//            }
//            
//        ];
//
//	mockdata[2]=[
//           {"pregunta":"Seleccione la figura que tiene el mismo tamaño","imagen":"image\\Percepcion\\tv2.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\tv2.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\tv1.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\tv3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\tv4.png","respuestaCorrecta":"N"}]
//            },
//             {"pregunta":"Seleccione la figura que tiene el mismo tamaño","imagen":"image\\Percepcion\\pc1.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\pc1.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\pc2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\pc3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\pc4.png","respuestaCorrecta":"N"}]
//            },
//             {"pregunta":"Seleccione la figura que tiene el mismo tamaño","imagen":"image\\Percepcion\\nevera2.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\nevera2.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\nevera1.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\nevera3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\nevera4.png","respuestaCorrecta":"N"}]
//            }, 
//            {"pregunta":"Seleccione la imagen que sea exactamente igual","imagen":"image\\Percepcion\\lavadora4.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\lavadora4.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\lavadora1.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\lavadora2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\lavadora3.png","respuestaCorrecta":"N"}]
//            }, 
//            {"pregunta":"Seleccione la imagen que sea exactamente igual","imagen":"image\\Percepcion\\transmilenio1.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\transmilenio1.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\transmilenio2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\transmilenio3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\transmilenio4.png","respuestaCorrecta":"N"}]
//            }, 
//            {"pregunta":"Seleccione la imagen que sea exactamente igual","imagen":"image\\Percepcion\\cama3.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\cama3.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\cama1.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\cama2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\cama4.png","respuestaCorrecta":"N"}]
//            }, 
//            {"pregunta":"Seleccione la imagen que sea exactamente igual","imagen":"image\\Percepcion\\sofa1.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\sofa1.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\sofa2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\sofa3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\sofa4.png","respuestaCorrecta":"N"}]
//            }, 
//            {"pregunta":"Seleccione la imagen que sea exactamente igual","imagen":"image\\Percepcion\\avion2.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\avion2.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\avion1.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\avion3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\avion4.png","respuestaCorrecta":"N"}]
//            }
//        ];
//        
//        
//	mockdata[3]=[
// 	    {"pregunta":"Elige la figura que al girarla varias veces No corresponde con la figura de la parte superior","imagen":"image\\Percepcion\\figura1.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\figura1.4.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\figura1.2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\figura1.3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\figura1.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la figura que al girarla varias veces No corresponde con la figura de la parte superior","imagen":"image\\Percepcion\\figura2.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\figura2.4.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\figura2.2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\figura2.3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\figura2.1.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la figura que al girarla varias veces No corresponde con la figura de la parte superior","imagen":"image\\Percepcion\\figura3.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\figura3.4.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\figura3.2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\figura3.3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\figura3.1.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la figura que al girarla varias veces No corresponde con la figura de la parte superior","imagen":"image\\Percepcion\\figura4.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\figura4.4.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\figura4.2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\figura4.3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\figura4.1.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la figura que al girarla varias veces No corresponde con la figura de la parte superior","imagen":"image\\Percepcion\\figura5.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\figura5.4.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\figura5.2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\figura5.3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\figura5.1.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la figura que al girarla varias veces No corresponde con la figura de la parte superior","imagen":"image\\Percepcion\\figura6.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\figura6.4.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\figura6.2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\figura6.3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\figura6.1.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la figura que al girarla varias veces No corresponde con la figura de la parte superior","imagen":"image\\Percepcion\\figura7.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\figura7.4.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\figura7.2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\figura7.3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\figura7.1.png","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Elige la figura que al girarla varias veces No corresponde con la figura de la parte superior","imagen":"image\\Percepcion\\figura8.png", "respuestas":[
//            	{"opcion":"image\\Percepcion\\figura8.4.png","respuestaCorrecta":"S"},
//            	{"opcion":"image\\Percepcion\\figura8.2.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\figura8.3.png","respuestaCorrecta":"N"},
//            	{"opcion":"image\\Percepcion\\figura8.1.png","respuestaCorrecta":"N"}]
//            }
//            
//	];
//	return {
//		getPreguntaAleatorea:function(nivel,callback){
//			if(arregloIndices.length===0){
//				apimockPercepcion.llenarArreglo(nivel);
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
//			apimockPercepcion.llenarArreglo(nivel);	
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
