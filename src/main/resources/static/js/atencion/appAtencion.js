/* global apiclientAtencion */

var appAtencion = (function () {
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
        validarRespuesta: function (Boton) {
//        	console.info(opcionesQueTieneQueSeleccionar );
            var palabraClave = pregunta.palabraClave;
            var id = "#" + Boton.id;
            var respuesta = Boton.name;
            if (palabraClave === respuesta) {
                opcionesSeleccionadas++;
                deshabilitarBotonRespuesta(Boton.id);
                if (opcionesSeleccionadas === opcionesQueTieneQueSeleccionar) {
                    preguntasCorrectasTemporales++;
                    if (preguntasCorrectasTemporales > cantidaPreguntasPorNivel && nivel < nivelMaximo) {
                        $('#modalSubirNivel').modal('show');
                        setTimeout(function () {
                            $('#modalSubirNivel').modal('hide');
                        }, 1500);
                        appAtencion.subirNivel();
                    } else if (preguntasCorrectasTemporales <= cantidaPreguntasPorNivel) {
                        $('#modalCorrecto').modal('show');
                        setTimeout(function () {
                            $('#modalCorrecto').modal('hide');
                        }, 1500);
                    } else if (nivel >= nivelMaximo) {
                        llegoNivelMaximo = true;
                        alert("Llegaste al nivel máximo. Volvamos a empezar");
                        appAtencion.mostrarEstadisticas();
                        appAtencion.iniciarNivel();
                    }
                    preguntasCorrectas++;

                    appAtencion.trearSiguientePregunta();
                    habilitarTodosLosBotones();

                }

            } else {
                //Respuesta Incorrecta
                $('#modalIncorrecto').modal('show');
                setTimeout(function () {
                    $('#modalIncorrecto').modal('hide');
                }, 1500);
                preguntasErroneas++;
                if (preguntasCorrectasTemporales > 1) {
                    preguntasCorrectasTemporales--;
                } else if (nivel > 1) {
                    appAtencion.bajarNivel();
                }

                appAtencion.trearSiguientePregunta();
                habilitarTodosLosBotones();
            }


        },

        trearSiguientePregunta: function () {
            apiclientAtencion.getPreguntaAleatorea(nivel, function (preguntaToda) {
                pregunta = preguntaToda;
                opcionesQueTieneQueSeleccionar = 0;
                for (var i = 0; i < 4; i++) {
                    if (pregunta.respuestas[i].respuestaCorrecta === "S") {
                        opcionesQueTieneQueSeleccionar++;
                    }
                }

                opcionesSeleccionadas = 0;
                $("#idNivel").text(nivel);
                $("#idCantidadPreguntasBien").text(preguntasCorrectasTemporales);
                $("#idCantidadPreguntasTotalNivel").text(cantidaPreguntasPorNivel);
                $("#idImagenPregunta").attr("src", preguntaToda.imagen);
                $("#idPregunta").text(preguntaToda.pregunta);
                preguntaToda.respuestas = preguntaToda.respuestas.sort(function () {
                    return Math.random() - 0.5;
                });
                for (var i = 0; i < 4; i++) {
                    var idP = "#idImagen" + i;
                    $("#idImagen" + i).attr("src", preguntaToda.respuestas[i].opcion);
                    $("#idImagen" + i).attr("name", preguntaToda.respuestas[i].palabraClave);
                    $("#idImagen" + i).attr("onclick", "appAtencion.validarRespuesta(this)");
                }
            });
        },
        init: function () {
            if ("undefined" === sessionStorage.getItem("esTemporal") || null === sessionStorage.getItem("esTemporal")) {
                window.location.href = "index.html";
            } else if ("S" === sessionStorage.getItem("esTemporal")) {
                sessionStorage.setItem("id", 1);
                $('#idUsuarioDib').hide();
            } else {
                $('#idUsuarioDib').show();
            }


            apiclientAtencion.cargarPreguntas(sessionStorage.getItem("id"), nivel, function (preguntaToda) {
                pregunta = preguntaToda;
                opcionesQueTieneQueSeleccionar = 0;
                for (var i = 0; i < 4; i++) {
                    if (pregunta.respuestas[i].respuestaCorrecta === "S") {
                        opcionesQueTieneQueSeleccionar++;
                    }
                }

                opcionesSeleccionadas = 0;
                $("#idNivel").text(nivel);
                $("#idCantidadPreguntasBien").text(preguntasCorrectasTemporales);
                $("#idCantidadPreguntasTotalNivel").text(cantidaPreguntasPorNivel);
                $("#idImagenPregunta").attr("src", preguntaToda.imagen);
                $("#idPregunta").text(preguntaToda.pregunta);
                preguntaToda.respuestas = preguntaToda.respuestas.sort(function () {
                    return Math.random() - 0.5;
                });
                for (var i = 0; i < 4; i++) {
                    var idP = "#idImagen" + i;
                    $("#idImagen" + i).attr("src", preguntaToda.respuestas[i].opcion);
                    $("#idImagen" + i).attr("name", preguntaToda.respuestas[i].palabraClave);
                    $("#idImagen" + i).attr("onclick", "appAtencion.validarRespuesta(this)");
                }
            }
            );
        },
        getPReguntasCorrectas: function () {
            return preguntasCorrectas;
        },
        subirNivel: function () {
            if (nivelMaximoAlcanzado !== nivelMaximo && !llegoNivelMaximo) {
                nivelMaximoAlcanzado++;
            }
            nivel++;
            apiclientAtencion.cambiarNivel(nivel);
            preguntasCorrectasTemporales = 1;
        },
        bajarNivel: function () {
            nivel--;
            apiclientAtencion.cambiarNivel(nivel);
            preguntasCorrectasTemporales = cantidaPreguntasPorNivel;

        },
        ayuda5050: function () {
//            var arregloRespuestasIncorrectas = pregunta.respuestas.filter(traerRespuestasIncorrectas);
//            var numero = getRandomArbitrary(arregloRespuestasIncorrectas);
//            arregloRespuestasIncorrectas.splice(numero, 1);
//            arregloRespuestasIncorrectas.map(deshabilitarBotones5050);

        },
        ayudaCambioPregunta: function () {
            habilitarTodosLosBotones();
            appAtencion.trearSiguientePregunta();

        },
        iniciarNivel: function () {
            nivel = 1;
            apiclientAtencion.cambiarNivel(nivel);
            preguntasCorrectasTemporales = 1;
        },
        traerTiempoJugado: function () {
            var fechaFin = new Date();
//            console.log(horaInicio);
//            console.log(fechaFin);
//            console.log(fechaFin - horaInicio);
//            console.log((fechaFin - horaInicio) / 60000);
            return (fechaFin - horaInicio) / 60000;
        },
        mostrarEstadisticas: function () {
            alert("Tiempo Jugado: " + appAtencion.traerTiempoJugado() + ". Preguntas Correctas: " + preguntasCorrectas + ". Preguntas Erroneas: " + preguntasErroneas + " . Nivel Máximo: " + nivelMaximoAlcanzado);
            console.info("Tiempo Jugado: " + appAtencion.traerTiempoJugado() + ". Preguntas Correctas: " + preguntasCorrectas + ". Preguntas Erroneas: " + preguntasErroneas + " . Nivel Máximo: " + nivelMaximoAlcanzado);
        },
        salir() {
            if ("S" === sessionStorage.getItem("esTemporal")) {
                window.location.href = "/menuPaciente.html";
            } else {
                var fec = new Date();
                var dia = fec.getDay() + 1;
                var mes = fec.getMonth() + 1;
                var anio = fec.getFullYear();

                var tiempoJugado = appAtencion.traerTiempoJugado();
                tiempoJugado = tiempoJugado.toFixed(0);
                if (tiempoJugado === "0") {
                    tiempoJugado = 1;
                }
                var promesa = apiclientAtencion.enviarResultados(sessionStorage.getItem("id"), anio + "/" + mes + "/" + dia, preguntasCorrectas, preguntasErroneas, tiempoJugado, nivelMaximoAlcanzado);
                promesa.then(
                        function () {
                            window.location.href = "/menuPaciente.html";
                        },
                        function (datos) {
                            alert(datos.responseText);
                            window.location.href = "/menuPaciente.html";
                        }
                );
            }
        },
        cargarParaEditar(){
            var promesaConsulta = apiclientAtencion.getTodasPreguntas(sessionStorage.getItem("idPacienteConsultaPS"))
            promesaConsulta.then(
                function (datos) { 
                    inicializarPregunta();
                    datos.map(adicionarPregunta);
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        modificarPregunta(idPreguntaPaciente){
            var nivelPersonalizado = $('select#nivel'+idPreguntaPaciente).val();
            var estado = $('#estado'+idPreguntaPaciente);
            if($('#estado'+idPreguntaPaciente).is(':checked')===true){
                estado = "A";
            }
            else{
                estado = "D";
            }
            var promesa = apiclientAtencion.modificarPregunta(idPreguntaPaciente, nivelPersonalizado, estado);
            promesa.then(
                function () { 
                    $('#idPanel'+idPreguntaPaciente).show();
                    setTimeout(function () {
                        $('#idPanel'+idPreguntaPaciente).hide();
                    }, 1000);
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        }
    };
})();

function adicionarPregunta(item){
    var nivel;
    if(item.nivel===1){
        nivel = "<option value = 1 selected>1</option><option value = 2>2</option><option value = 3 >3</option><option value = 4 >4</option>";
    }
    else if(item.nivel===2){
        nivel = "<option value = 1 >1</option><option value = 2 selected>2</option><option value = 3 >3</option><option value = 4 >4</option>";
    }
    else if(item.nivel===3){
        nivel = "<option value = 1 >1</option><option value = 2 >2</option><option value = 3 selected>3</option><option value = 4 >4</option>";
    }  
    else{
        nivel = "<option value = 1 >1</option><option value = 2 >2</option><option value = 3 >3</option><option value = 4 selected>4</option>";
    }
    
    var activo = "";
    if(item.estado==="A"){
        activo = "checked";
    }

    
    var markup = "<tr class=\"filasPG\"><td>" + item.id + "</td><td><img src=\"" + item.imagen + "\" class=\"img-rounded img-responsive imagenGaleriaEditar\" alt=\"ImagenPregunta\"></td><td>" + item.pregunta + "</td><td><select class=\"form-control\" id=\"nivel"+item.id+"\">"+nivel+"</select></td><td><input type=\"checkbox\" "+activo+" id=\"estado"+item.id+"\"></td><td><button class=\"btn btn-info btn-block\" onclick=\"appAtencion.modificarPregunta(" + item.id + ")\"> Guardar</button><div class=\"alert alert-success\" style=\"display:none;\" id=\"idPanel"+item.id+"\"><strong >Bien!</strong></div></td></tr>";
    $("#idTablaG").append(markup);
}

function inicializarPregunta(){
    $(".filasPG").remove("tr");
}

function traerRespuestasIncorrectas(filter) {
    if (filter.respuestaCorrecta === "N") {
        return filter;
    }
}
function habilitarTodosLosBotones() {
    for (var i = 0; i < 4; i++) {
        $("#idImagen" + i).show();
    }
}
function getRandomArbitrary(arrgloIndices) {
    return parseInt(Math.random() * (arrgloIndices.length));
}

function deshabilitarBotonRespuesta(idBoton) {
    $("#" + idBoton).hide();
    $("#" + idBoton).attr("onclick", "");
}

