//var apimockGaleria=(function(){
//	var arregloIndices= [];
//	var mockdata=[];
//        mockdata[1]=[
//            {"pregunta":"¿Quién es este personaje?","imagen":"image\\Galeria\\simonBolivar.jpg", "informacion":"Contribuyó a inspirar y concretar de manera decisiva la independencia de las actuales Bolivia, Colombia, Ecuador, Panamá, Venezuela y la reorganización del Perú. Tomado de: wikipedia", "respuestas":[
//            	{"opcion":"Simon Bolivar","respuestaCorrecta":"S"},
//            	{"opcion":"Yo","respuestaCorrecta":"N"},
//            	{"opcion":"El chavo del ocho","respuestaCorrecta":"N"},
//            	{"opcion":"Mi papá","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"¿Donde queda la Torre Eiffel?","imagen":"image\\Galeria\\torreEifell.jpg", "informacion":"Construida en 1889 para la Exposición Universal, la Torre Eiffel se convirtió en el principal símbolo de esta ciudad y es el monumento más visitado del mundo. Tomado de: www.paris.es/torre-eiffel", "respuestas":[
//            	{"opcion":"Bogotá","respuestaCorrecta":"N"},
//            	{"opcion":"Madrid","respuestaCorrecta":"N"},
//            	{"opcion":"Paris","respuestaCorrecta":"S"},
//            	{"opcion":"Roma","respuestaCorrecta":"N"}]
//            },
//	    {"pregunta":"¿Como se llama este artista Colombiano?","imagen":"image\\Galeria\\FernandoBotero.jpg", "informacion":"Pintor y escultor colombiano. Sus obras tiene entre sus rasgos más fácilmente identificables el agrandamiento o la deformación de los volúmenes. Tomado de www.biografiasyvidas.com", "respuestas":[
//            	{"opcion":"Pablo Picasso","respuestaCorrecta":"N"},
//            	{"opcion":"Fernando Botero","respuestaCorrecta":"S"},
//            	{"opcion":"Juan Pablo Montoya","respuestaCorrecta":"N"},
//            	{"opcion":"Nairo Quintana","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"¿Como se llama este personaje?","imagen":"image\\Galeria\\FidelCastro.jpg", "informacion":"Militar, revolucionario, estadista y político cubano. Fue mandatario de su país como presidente entre 1976 y 2008. Tomado de: wikipedia", "respuestas":[
//            	{"opcion":"Alvaro Uribe","respuestaCorrecta":"N"},
//            	{"opcion":"Fernando Gaviria","respuestaCorrecta":"N"},
//            	{"opcion":"Raul Castro","respuestaCorrecta":"N"},
//            	{"opcion":"Fidel Castro","respuestaCorrecta":"S"}]
//            },
//            {"pregunta":"¿Quién es este este escritor Colombiano?","imagen":"image\\Galeria\\GabrielGarcia.jpg", "informacion":"Fue un escritor, guionista, editor y periodista colombiano. Está relacionado de manera inherente con el realismo mágico y su obra más conocida, la novela Cien años de soledad. Tomado de: wikipedia", "respuestas":[
//            	{"opcion":"Gustavo Bolivar","respuestaCorrecta":"N"},
//            	{"opcion":"Gabriel Garcia M.","respuestaCorrecta":"S"},
//            	{"opcion":"Condorito","respuestaCorrecta":"N"},
//            	{"opcion":"Francisco de Paula","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"¿Quién es este personaje?","imagen":"image\\Galeria\\Galan.jpg", "informacion":"Político colombiano. Proclamado candidato presidencial por la convención del partido liberal, el 18 de agosto de 1989, en plena campaña, sufrió un atentado mortal en la plaza de Soacha, al sur de Bogotá. Tomado de www.biografiasyvidas.com", "respuestas":[
//            	{"opcion":"Juan Gabriel","respuestaCorrecta":"N"},
//            	{"opcion":"Fernando Galán","respuestaCorrecta":"N"},
//            	{"opcion":"Luis Carlos Galán","respuestaCorrecta":"S"},
//            	{"opcion":"Enrique Peñalosa","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Esta reconocida monja ayudo a muchos en su vida. ¿Como se llama?","imagen":"image\\Galeria\\teresaCalcuta.jpg", "informacion":"Fundó la congregación de las Misioneras de la Caridad en Calcuta en 1950. Durante más de 45 años atendió a pobres, enfermos, huérfanos y moribundos. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Shakira","respuestaCorrecta":"N"},
//            	{"opcion":"Teresa de Calcuta","respuestaCorrecta":"S"},
//            	{"opcion":"Policarpa","respuestaCorrecta":"N"},
//            	{"opcion":"Juana de Arco","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"¿Como se llama este conocido militante de la revolución cubana?","imagen":"image\\Galeria\\CheGuevara.jpg", "informacion":"Fue un médico, político, militar, escritor y periodista y uno de los ideólogos y comandantes de la Revolución cubana. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Ernesto Che Guevara","respuestaCorrecta":"S"},
//            	{"opcion":"Hugo Chávez","respuestaCorrecta":"N"},
//            	{"opcion":"Nicolas Maduro","respuestaCorrecta":"N"},
//            	{"opcion":"Simón Bolivar","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"¿Como es el nombre de este famoso personaje animado?","imagen":"image\\Galeria\\MickeyMouse.jpg", "informacion":"Emblema de la compañía Disney. Creado el 18 de noviembre de 1928. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Mickey Mouse","respuestaCorrecta":"S"},
//            	{"opcion":"Minnie Mouse","respuestaCorrecta":"N"},
//            	{"opcion":"Pluto","respuestaCorrecta":"N"},
//            	{"opcion":"Jerry","respuestaCorrecta":"N"}]
//            }
//        ];
//
//	mockdata[2]=[
//            {"pregunta":"¿Como es el nombre de este gran físico?","imagen":"image\\Galeria\\AlbertEinstein.jpg", "informacion":"Fue un físico alemán de origen judío, nacionalizado después suizo, austriaco y estadounidense. Es considerado el científico más conocido y popular del siglo XX. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Albert Einstein","respuestaCorrecta":"S"},
//            	{"opcion":"Manuel Patarroyo","respuestaCorrecta":"N"},
//            	{"opcion":"Bohr","respuestaCorrecta":"N"},
//            	{"opcion":"Guye","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"¿Cuál es el nombre de esta Actriz Colombiana?","imagen":"image\\Galeria\\VickyHernandez.jpg", "informacion":"Es una destacada actriz colombiana de teatro, cine y televisión de amplia trayectoria profesiona, actuo en Azúcar, Romeo y Buseta, Mujeres asesinas, entre otros. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Vicky Hernández","respuestaCorrecta":"S"},
//            	{"opcion":"Shakira","respuestaCorrecta":"N"},
//            	{"opcion":"Margarita Rosa","respuestaCorrecta":"N"},
//            	{"opcion":"Teresa Gutiérrez","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"¿Como se llamaba esta serie estadounidense?","imagen":"image\\Galeria\\miBellaGenio.jpg", "informacion":"Es una serie de televisión estadounidense que fue emitida por la cadena NBC a lo largo de cinco temporadas, entre 1965 y 1970. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Friends","respuestaCorrecta":"N"},
//            	{"opcion":"Pepa Pig","respuestaCorrecta":"N"},
//            	{"opcion":"Mi Bella Genio","respuestaCorrecta":"S"},
//            	{"opcion":"La niñera","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Esta es una de las maravillas del mundo. ¿Cuál es su nombre?","imagen":"image\\Galeria\\TajMahal.jpg", "informacion":"Es un mausoleo construido entre 1632 y 1653 en la ciudad de Agra, estado de Uttar Pradesh (India), a orillas del río Yamuna. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Burj Khalifa","respuestaCorrecta":"N"},
//            	{"opcion":"Las pirámides de Egito","respuestaCorrecta":"N"},
//            	{"opcion":"Taj Mahal","respuestaCorrecta":"S"},
//            	{"opcion":"Chichén Itzá","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Esta muralla mide alrededor de 7000 km. ¿Donde esta ubicada?","imagen":"image\\Galeria\\murallaChina.jpg", "informacion":"Su construcción se extendió en el tiempo entre los siglos 7 y 8 a. de C, la muralla llegó a tener 7300 km de longitud. Tomado de 21wonders.es", "respuestas":[
//            	{"opcion":"Colombia","respuestaCorrecta":"N"},
//            	{"opcion":"Corea del Norte","respuestaCorrecta":"N"},
//            	{"opcion":"Japón","respuestaCorrecta":"N"},
//            	{"opcion":"China","respuestaCorrecta":"S"}]
//            },
//            {"pregunta":"Uno de los monumentos más reconocidos en el mundo. ¿Como se llama?","imagen":"image\\Galeria\\estatuaLibertad.jpg", "informacion":"Es una antigua fortificación construida y reconstruida entre el siglo V a. C. y el siglo XVI (Edad Moderna) para proteger la frontera norte del Imperio chino durante las sucesivas dinastías imperiales de los ataques de los nómadas xiongnu de Mongolia y Manchuria. Tomado de wikipedia.", "respuestas":[
//            	{"opcion":"Estatua de la esperanza","respuestaCorrecta":"N"},
//            	{"opcion":"Obelisco","respuestaCorrecta":"N"},
//            	{"opcion":"New York","respuestaCorrecta":"N"},
//            	{"opcion":"Estatua de la libertad","respuestaCorrecta":"S"}]
//            },
//            {"pregunta":"Una de las series de televisión más conocidas. ¿Como se llama este personaje?","imagen":"image\\Galeria\\alf.jpg", "informacion":"Un extraterrestre. Nació el 28 de octubre de 1756, en la región Lower East del planeta Melmac, que a su vez estaba localizado 6 pársecs más allá del supercúmulo Hydra-Centaurus, tenía cielo verde, pasto azul y agua naranja. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Oliver","respuestaCorrecta":"N"},
//            	{"opcion":"Alf","respuestaCorrecta":"S"},
//            	{"opcion":"Mickey Mouse","respuestaCorrecta":"N"},
//            	{"opcion":"Melmac","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Para el no habia nada imposible. ¿Como se llama este personaje?","imagen":"image\\Galeria\\macgyver.jpg", "informacion":"Es un agente al servicio de la Fundación Phoenix que siempre resuelve todos los problemas usando su inteligencia superior y sus amplios conocimientos técnicos. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Murdoc","respuestaCorrecta":"N"},
//            	{"opcion":"Pete Thornton","respuestaCorrecta":"N"},
//            	{"opcion":"Macgyver","respuestaCorrecta":"S"},
//            	{"opcion":"Harry Jackson","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Un gran activista practicante de la desobediencia civil no violenta. ¿Como se llama este personaje?","imagen":"image\\Galeria\\Gandi.jpg", "informacion":"Fue el dirigente más destacado del Movimiento de independencia indio contra el Raj británico, para lo que practicó la desobediencia civil no violenta, además de pacifista, político, pensador y abogado hinduista indio. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Kim Jong-un","respuestaCorrecta":"N"},
//            	{"opcion":"Hugo Chavéz","respuestaCorrecta":"N"},
//            	{"opcion":"Martin Lutero","respuestaCorrecta":"N"},
//            	{"opcion":"Mahatma Gandhi","respuestaCorrecta":"S"}]
//            },
//            {"pregunta":"¿Como se llama este famoso personaje animado de una de las peliculas hechas por Walt Disney Pictures?","imagen":"image\\Galeria\\dumbo.jpg", "informacion":"Es un elefante que es ridiculizado por sus grandísimas orejas, aunque descubre que puede volar usándolas como alas. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Dumbo","respuestaCorrecta":"S"},
//            	{"opcion":"Bambi","respuestaCorrecta":"N"},
//            	{"opcion":"Melman","respuestaCorrecta":"N"},
//            	{"opcion":"Pato Donald","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"Un actor polifacético. ¿Cual es su nombre?","imagen":"image\\Galeria\\robinsonDiaz.jpg", "informacion":"Es un actor colombiano de teatro, cine y televisión, actúo en Pecados capitales,El Cartel de los Sapos, La pena máxima, entre otros. Tomado de wikipedia ", "respuestas":[
//            	{"opcion":"Gordo Benjumea","respuestaCorrecta":"N"},
//            	{"opcion":"Robinson Díaz","respuestaCorrecta":"S"},
//            	{"opcion":"Jorge Alfredo Vargas","respuestaCorrecta":"N"},
//            	{"opcion":"Julian Arango","respuestaCorrecta":"N"}]
//            }
//        ];
//        
//        mockdata[3]=[
//            {"pregunta":"¿Como es el nombre de este sitio turístico?","imagen":"image\\Galeria\\chichenitza.png", "informacion":"Es uno de los principales sitios arqueológicos de la península de Yucatán, en México. Vestigio importante y renombrado de la civilización maya, las edificaciones principales que ahí perduran corresponden al periodo denominado clásico tardío o postclásico temprano (800-1100 dC.) Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Chichén Itzá","respuestaCorrecta":"S"},
//            	{"opcion":"Pirámides de Egipto","respuestaCorrecta":"N"},
//            	{"opcion":"Pirámide de Guiza","respuestaCorrecta":"N"},
//            	{"opcion":"Taj Mahal","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"¿Cual es el nombre de este rascacielos?","imagen":"image\\Galeria\\Burjkhalifa.png", "informacion":"Es un rascacielos ubicado en Dubái (Emiratos Árabes Unidos). Con 828 metros de altura, es la estructura más alta de la que se tiene registro en la historia. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Khawr Dubayy","respuestaCorrecta":"N"},
//            	{"opcion":"Casa Blanca","respuestaCorrecta":"N"},
//            	{"opcion":"Burj Al Arab","respuestaCorrecta":"N"},
//            	{"opcion":"Burj Khalifa","respuestaCorrecta":"S"}]
//            },
//            {"pregunta":"¿Cuál es el nombre de este reconocido personaje animado?","imagen":"image\\Galeria\\pluto.png", "informacion":"Es un personaje de ficción que se hizo famoso mediante los cortos de animación de The Walt Disney Company. Generalmente caracteriza al perro de Mickey Mouse, aunque también ha sido la mascota del Pato Donald y de Tribilín o Goofy. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Tom","respuestaCorrecta":"N"},
//            	{"opcion":"Scooby-Doo","respuestaCorrecta":"N"},
//            	{"opcion":"Coraje","respuestaCorrecta":"N"},
//            	{"opcion":"Pluto","respuestaCorrecta":"S"}]
//            },
//            {"pregunta":"¿Como se llama este reconocido parque?","imagen":"image\\Galeria\\centralPatk.jpg", "informacion":"Es un parque urbano público situado en el distrito metropolitano de Manhattan, en la ciudad de Nueva York, Estados Unidos. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Parque Simón Bolivar","respuestaCorrecta":"N"},
//            	{"opcion":"Nueva York","respuestaCorrecta":"N"},
//            	{"opcion":"Manhattan","respuestaCorrecta":"N"},
//            	{"opcion":"Central Park","respuestaCorrecta":"S"}]
//            },
//            {"pregunta":"¿Como se llama esta torre?","imagen":"image\\Galeria\\TorrePisa.jpg", "informacion":"La torre comenzó a inclinarse tan pronto como se inició su construcción en agosto de 1173. Su altura es de 55,7 a 55,8 metros desde la base y la inclinación de unos 4°, extendiéndose 3,9 m de la vertical. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Italia","respuestaCorrecta":"N"},
//            	{"opcion":"Arco Trinfo","respuestaCorrecta":"N"},
//            	{"opcion":"Torres Gemelas","respuestaCorrecta":"N"},
//            	{"opcion":"Torre de Pisa","respuestaCorrecta":"S"}]
//            },
//            {"pregunta":"¿Cuál era el nombre de estos dos edificios?","imagen":"image\\Galeria\\torresGemelas.jpg", "informacion":"Ubicadas en Bajo Manhattan, ciudad de Nueva York, Estados Unidos, inauguradas el 4 de abril de 1973, y destruidas en los atentados del 11 de septiembre de 2001. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Burj Khalifa","respuestaCorrecta":"N"},
//            	{"opcion":"Edificio Empire State","respuestaCorrecta":"N"},
//            	{"opcion":"Torre de pisa","respuestaCorrecta":"N"},
//            	{"opcion":"Torres Gemelas","respuestaCorrecta":"S"}]
//            },
//            {"pregunta":"¿Cuál es el nombre de esta estructura?","imagen":"image\\Galeria\\bigben.jpg", "informacion":"Situado en el lado noroeste del Palacio de Westminster, la sede del Parlamento del Reino Unido, en Londres. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"London Eye","respuestaCorrecta":"N"},
//            	{"opcion":"Palacio de Versalles","respuestaCorrecta":"N"},
//            	{"opcion":"Palacio de Westminster","respuestaCorrecta":"N"},
//            	{"opcion":"Big Ben","respuestaCorrecta":"S"}]
//            },
//            {"pregunta":"¿Como se llama este edificio?","imagen":"image\\Galeria\\torreColpatria.jpg", "informacion":"Es un rascacielos situado en Bogotá, en el sector de San Diego. También hace parte del Centro Internacional de Bogotá. Con sus 50 pisos, es el segundo edificio más alto de la ciudad así como uno de sus iconos. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Bacata","respuestaCorrecta":"N"},
//            	{"opcion":"Casa de Nariño","respuestaCorrecta":"N"},
//            	{"opcion":"Torres Gemelas","respuestaCorrecta":"N"},
//            	{"opcion":"Torre Colpatria","respuestaCorrecta":"S"}]
//            },
//            {"pregunta":"¿Cuál es el nombre de esta obra de arte?","imagen":"image\\Galeria\\monalisa.jpg", "informacion":"Es una obra pictórica del pintor renacentista italiano Leonardo da Vinci. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"El grito","respuestaCorrecta":"N"},
//            	{"opcion":"La María","respuestaCorrecta":"N"},
//            	{"opcion":"Leonardo da Vinci","respuestaCorrecta":"N"},
//            	{"opcion":"La Gioconda","respuestaCorrecta":"S"}]
//            }
//        ];
//        
//        mockdata[4]=[
//            {"pregunta":"¿Cuál es el nombre de este personaje?","imagen":"image\\Galeria\\Chaplin.jpg", "informacion":"Fue un actor, humorista, compositor, productor, guionista, director, escritor y editor británico. Adquirió gran popularidad en el cine mudo gracias a las múltiples películas que realizó con su personaje Charlot. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Charles Chaplin","respuestaCorrecta":"S"},
//            	{"opcion":"Piolin","respuestaCorrecta":"N"},
//            	{"opcion":"Cantinflas","respuestaCorrecta":"N"},
//            	{"opcion":"Elvis Presley","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"¿Cuál es el nombre de este expresidente de los Estados Unidos?","imagen":"image\\Galeria\\abrahamlincoln.jpg", "informacion":"Fue un político y abogado estadounidense que ejerció como decimosexto presidente de los Estados Unidos de América desde marzo de 1861 hasta su asesinato en abril de 1865. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Abraham Lincoln","respuestaCorrecta":"S"},
//            	{"opcion":"George Washington","respuestaCorrecta":"N"},
//            	{"opcion":"James Madison","respuestaCorrecta":"N"},
//            	{"opcion":"Thomas Jefferson","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"¿Cuál es el nombre de este famoso cantante?","imagen":"image\\Galeria\\presley.jpg", "informacion":"Fue un cantante y actor estadounidense, uno de los más populares del siglo XX. Se hace referencia a él como «el Rey del rock and roll». Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Elvis Presley","respuestaCorrecta":"S"},
//            	{"opcion":"Justin Bieber","respuestaCorrecta":"N"},
//            	{"opcion":"Charles Chaplin","respuestaCorrecta":"N"},
//            	{"opcion":"Thomas Jefferson","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"¿Cuál es el nombre de este personaje?","imagen":"image\\Galeria\\cantinflas.jpg", "informacion":"Fue un actor y comediante mexicano, ganador del Globo de Oro en 1956. Debido a su gran trayectoria cinematográfica, se constituye como uno de los comediantes más grandes y recordados de habla hispana y como el más reconocido comediante mexicano de todos los tiempos. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Cantinflas","respuestaCorrecta":"S"},
//            	{"opcion":"Charles Chaplin","respuestaCorrecta":"N"},
//            	{"opcion":"El chavo del 8","respuestaCorrecta":"N"},
//            	{"opcion":"Elvis Presley","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"¿Cuál es el nombre de esta famosa actriz?","imagen":"image\\Galeria\\Monroe.jpg", "informacion":"Fue una actriz de cine estadounidense y una de las más populares del siglo XX, considerada como un icono pop y un símbolo sexual. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Marilyn Monroe","respuestaCorrecta":"S"},
//            	{"opcion":"Marilyn Manson","respuestaCorrecta":"N"},
//            	{"opcion":"Maddona","respuestaCorrecta":"N"},
//            	{"opcion":"Shakira","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"¿Cuál es el nombre de esta personaje?","imagen":"image\\Galeria\\Condorito.png", "informacion":"Es una serie de historieta cómica chilena, protagonizada por el personaje homónimo. Publicada por primera vez el 6 de agosto en 1949 por Pepo, con los años se convirtió en la más popular historieta en Chile, habiendo sido distribuida además en Latinoamérica. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Condorito","respuestaCorrecta":"S"},
//            	{"opcion":"Mafalda","respuestaCorrecta":"N"},
//            	{"opcion":"Batman","respuestaCorrecta":"N"},
//            	{"opcion":"Superman","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"¿Cuál es el nombre de esta personaje?","imagen":"image\\Galeria\\Mafaldayalma.jpg", "informacion":"Es el nombre de una tira de prensa argentina desarrollada por el humorista gráfico Quino de 1964 a 1973, protagonizada por la niña homónima, «espejo de la clase media latinoamericana y de la juventud progresista», que se muestra preocupada por la humanidad y la paz mundial, y se rebela contra el mundo legado por sus mayores. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Mafalda","respuestaCorrecta":"S"},
//            	{"opcion":"Garfield","respuestaCorrecta":"N"},
//            	{"opcion":"Gaturro","respuestaCorrecta":"N"},
//            	{"opcion":"Superman","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"¿Cuál es el nombre de esta personaje?","imagen":"image\\Galeria\\piolin.png", "informacion":"También conocido en algunos países hispanohablantes por su nombre en inglés Tweety, es un personaje creado por Bob Clampett para la serie de dibujos animados Looney Tunes, de la productora estadounidense Warner Bros. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Piolín","respuestaCorrecta":"S"},
//            	{"opcion":"Silvestre","respuestaCorrecta":"N"},
//            	{"opcion":"Tom","respuestaCorrecta":"N"},
//            	{"opcion":"Jerry","respuestaCorrecta":"N"}]
//            },
//            {"pregunta":"¿Cuál es el nombre de esta personaje?","imagen":"image\\Galeria\\justin.jpg", "informacion":"Apodado «La Voz»,​ fue una de las principales figuras de la música popular del siglo XX y dejó, a través de sus discos y actuaciones en directo, un legado canónico en lo que respecta a la interpretación vocal masculina de esa música. Tomado de wikipedia", "respuestas":[
//            	{"opcion":"Frank Sinatra","respuestaCorrecta":"S"},
//            	{"opcion":"Shaggy","respuestaCorrecta":"N"},
//            	{"opcion":"Michael Bublé","respuestaCorrecta":"N"},
//            	{"opcion":"Bryan Adams","respuestaCorrecta":"N"}]
//            }
//        ];        
//        
//           
//	return {
//		getPreguntaAleatorea:function(nivel,callback){
//			if(arregloIndices.length===0){
//                            apimockGaleria.llenarArreglo(nivel);
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
//			apimockGaleria.llenarArreglo(nivel);	
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
