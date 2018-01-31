var apimockMusicoterapia =(function(){
	var arregloIndices= [];
	var mockdata=[];
        mockdata[1]=[
            {"pregunta":"¿Quien canta esta canción?","video":"https://www.youtube.com/embed/6WzBHgPVHeA?rel=0&amp;controls=0&amp;showinfo=0&autoplay=1", "respuestas":[
            	{"opcion":"Carlos Vives","respuestaCorrecta":"S"},
            	{"opcion":"Jaime Molina","respuestaCorrecta":"N"},
            	{"opcion":"Escalona","respuestaCorrecta":"N"},
            	{"opcion":"Mi abuelo","respuestaCorrecta":"N"}]
            },
            {"pregunta":"¿Como se llama este grupo musical?","video":"https://www.youtube.com/embed/Gy8TxGfvfYI?rel=0&amp;controls=0&amp;showinfo=0&autoplay=1", "respuestas":[
            	{"opcion":"Shakira","respuestaCorrecta":"N"},
            	{"opcion":"Sonora Matancera","respuestaCorrecta":"N"},
            	{"opcion":"Sonora Dinamita","respuestaCorrecta":"S"},
            	{"opcion":"Cumbiakings","respuestaCorrecta":"N"}]
            },
            {"pregunta":"¿Cúal es el nombre de esta canción?","video":"https://www.youtube.com/embed/pZCtg-xcm4w?rel=0&amp;controls=0&amp;showinfo=0&autoplay=1", "respuestas":[
            	{"opcion":"La cama vacia","respuestaCorrecta":"N"},
            	{"opcion":"Reminiscencias","respuestaCorrecta":"N"},
            	{"opcion":"Mamá vieja","respuestaCorrecta":"S"},
            	{"opcion":"No hay amigos","respuestaCorrecta":"N"}]
            },
            {"pregunta":"¿Cual es el nombre de este intérprete?","video":"https://www.youtube.com/embed/AUmD5VdVGc4?rel=0&amp;controls=0&amp;showinfo=0&autoplay=1", "respuestas":[
            	{"opcion":"Julio Jaramillo","respuestaCorrecta":"N"},
            	{"opcion":"Enrique Iglesias","respuestaCorrecta":"N"},
            	{"opcion":"Oscar Agudelo","respuestaCorrecta":"S"},
            	{"opcion":"Alci Acosta","respuestaCorrecta":"N"}]
            },
            {"pregunta":"¿Cómo se llama esta canción?","video":"https://www.youtube.com/embed/OF8XC9Tf4rE?rel=0&amp;controls=0&amp;showinfo=0&autoplay=1", "respuestas":[
            	{"opcion":"Amor","respuestaCorrecta":"N"},
            	{"opcion":"Amigo de que","respuestaCorrecta":"N"},
            	{"opcion":"Aunque me cueste la vida","respuestaCorrecta":"S"},
            	{"opcion":"Hola soledad","respuestaCorrecta":"N"}]
            },
            {"pregunta":"¿Cómo se llama esta canción?","video":"https://www.youtube.com/embed/o2e6hL7seqA?rel=0&amp;controls=0&amp;showinfo=0&autoplay=1", "respuestas":[
            	{"opcion":"Tu boca","respuestaCorrecta":"N"},
            	{"opcion":"En tus brazos la muerte","respuestaCorrecta":"N"},
            	{"opcion":"En un beso la vida","respuestaCorrecta":"S"},
            	{"opcion":"Destino","respuestaCorrecta":"N"}]
            },
            {"pregunta":"¿Cómo se llama esta canción?","video":"https://www.youtube.com/embed/Crd9zAol9f0?rel=0&amp;controls=0&amp;showinfo=0&autoplay=1", "respuestas":[
            	{"opcion":"El rencor","respuestaCorrecta":"N"},
            	{"opcion":"La indiferencia","respuestaCorrecta":"N"},
            	{"opcion":"Odiame","respuestaCorrecta":"S"},
            	{"opcion":"Piedad","respuestaCorrecta":"N"}]
            }
       ];

	mockdata[2]=[
            {"pregunta":"¿Cómo se llama esta canción?","video":"https://www.youtube.com/embed/ijIfPabCBoI?rel=0&amp;controls=0&amp;showinfo=0&autoplay=1", "respuestas":[
            	{"opcion":"Nada a cambio","respuestaCorrecta":"N"},
            	{"opcion":"Para vivir","respuestaCorrecta":"N"},
            	{"opcion":"El breve espacio en que no estas","respuestaCorrecta":"S"},
            	{"opcion":"La maza","respuestaCorrecta":"N"}]
            },
            {"pregunta":"¿Cómo se llama esta canción?","video":"https://www.youtube.com/embed/kRNQdV0ofW8?rel=0&amp;controls=0&amp;showinfo=0&autoplay=1", "respuestas":[
            	{"opcion":"Adiós","respuestaCorrecta":"N"},
            	{"opcion":"Ya no más","respuestaCorrecta":"N"},
            	{"opcion":"Ojalá","respuestaCorrecta":"S"},
            	{"opcion":"La sonrisa perfecta","respuestaCorrecta":"N"}]
            }
        ];
        
        mockdata[3]=[
            
        ];
        
        mockdata[4]=[
            
        ];        
        
           
	return {
		getPreguntaAleatorea:function(nivel,callback){
			if(arregloIndices.length===0){
                            apimockMusicoterapia.llenarArreglo(nivel);
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
			apimockMusicoterapia.llenarArreglo(nivel);	
		},
		getArreglo:function(nivel){
			return arregloIndices;
		}
	}	

})();

function getRandomArbitrary(arrgloIndices) {
  	return parseInt(Math.random() * (arrgloIndices.length));
}
