/* global apiclientMusicoterapia, estado */


var appMusicoterapia = (function () {
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
        validarRespuesta: function (Nombre) {
            var respuesta = pregunta.respuestas.filter(traerNombreCorrecto);
            if (respuesta[0].opcion === Nombre) {
                preguntasCorrectasTemporales++;
                //Detener el video
                $('.youtube-iframe').each(function (index) {
                    $(this).attr('src', $(this).attr('src'));
                    return false;
                });


                if (preguntasCorrectasTemporales > cantidaPreguntasPorNivel && nivel < nivelMaximo) {
                    $('#modalSubirNivel').modal('show');
                    setTimeout(function () {
                        $('#modalSubirNivel').modal('hide');
                    }, 1500);
                    appMusicoterapia.subirNivel();
                } else if (preguntasCorrectasTemporales <= cantidaPreguntasPorNivel) {
                    $('#modalCorrecto').modal('show');
                    setTimeout(function () {
                        $('#modalCorrecto').modal('hide');
                    }, 1500);
                } else if (nivel >= nivelMaximo) {
                    llegoNivelMaximo = true;
                    alert("Llegaste al nivel máximo. Volvamos a empezar");
                    appMusicoterapia.mostrarEstadisticas();
                    appMusicoterapia.iniciarNivel();
                }
                preguntasCorrectas++;

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
                    appMusicoterapia.bajarNivel();
                }
            }
            appMusicoterapia.trearSiguientePregunta();
            habilitarTodosLosBotones();

        },
        trearSiguientePregunta: function () {
            apiclientMusicoterapia.getPreguntaAleatorea(nivel, function (preguntaToda) {
                pregunta = preguntaToda;
                $("#idNivel").text(nivel);
                $("#idCantidadPreguntasBien").text(preguntasCorrectasTemporales);
                $("#idCantidadPreguntasTotalNivel").text(cantidaPreguntasPorNivel);
                $("#idVideo").attr("src", preguntaToda.video);
                $("#idPregunta").text(preguntaToda.pregunta);
                preguntaToda.respuestas = preguntaToda.respuestas.sort(function () {
                    return Math.random() - 0.5;
                });
                for (var i = 0; i < 4; i++) {
                    $("#idBoton" + i).text(preguntaToda.respuestas[i].opcion);
                    $("#idBoton" + i).attr("onclick", "appMusicoterapia.validarRespuesta('" + preguntaToda.respuestas[i].opcion + "')");
                    $("#idBoton" + i).attr("class", "btn btn-success letraTextos " + preguntaToda.respuestas[i].opcion);
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
            console.info(nivel);
            console.info("nivel");
            
            apiclientMusicoterapia.cargarPreguntas(sessionStorage.getItem("id"), nivel, function (preguntaToda) {
                pregunta = preguntaToda;
                $("#idNivel").text(nivel);
                $("#idCantidadPreguntasBien").text(preguntasCorrectasTemporales);
                $("#idCantidadPreguntasTotalNivel").text(cantidaPreguntasPorNivel);
                $("#idVideo").attr("src", preguntaToda.video);
                $("#idPregunta").text(preguntaToda.pregunta);
                preguntaToda.respuestas = preguntaToda.respuestas.sort(function () {
                    return Math.random() - 0.5;
                });
                for (var i = 0; i < 4; i++) {
                    $("#idBoton" + i).text(preguntaToda.respuestas[i].opcion);
                    $("#idBoton" + i).attr("onclick", "appMusicoterapia.validarRespuesta('" + preguntaToda.respuestas[i].opcion + "')");
                    $("#idBoton" + i).attr("class", "btn btn-success letraTextos " + preguntaToda.respuestas[i].opcion);
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
            apiclientMusicoterapia.cambiarNivel(nivel);
            preguntasCorrectasTemporales = 1;
        },
        bajarNivel: function () {
            nivel--;
            apiclientMusicoterapia.cambiarNivel(nivel);
            preguntasCorrectasTemporales = cantidaPreguntasPorNivel;

        },
        ayuda5050: function () {
            var arregloRespuestasIncorrectas = pregunta.respuestas.filter(traerRespuestasIncorrectas);
            var numero = getRandomArbitrary(arregloRespuestasIncorrectas);
            arregloRespuestasIncorrectas.splice(numero, 1);
            console.log(arregloRespuestasIncorrectas);
            arregloRespuestasIncorrectas.map(deshabilitarBotones5050);

        },
        ayudaCambioPregunta: function () {
            habilitarTodosLosBotones();
            appMusicoterapia.trearSiguientePregunta();

        },
        iniciarNivel: function () {
            nivel = 1;
            apiclientMusicoterapia.cambiarNivel(nivel);
            preguntasCorrectasTemporales = 1;
        },
        traerTiempoJugado: function () {
            var fechaFin = new Date();
            return (fechaFin - horaInicio) / 60000;
        },
        mostrarEstadisticas: function () {
            alert("Tiempo Jugado: " + appMusicoterapia.traerTiempoJugado() + ". Preguntas Correctas: " + preguntasCorrectas + ". Preguntas Erroneas: " + preguntasErroneas + " . Nivel Máximo: " + nivelMaximoAlcanzado);
            console.info("Tiempo Jugado: " + appMusicoterapia.traerTiempoJugado() + ". Preguntas Correctas: " + preguntasCorrectas + ". Preguntas Erroneas: " + preguntasErroneas + " . Nivel Máximo: " + nivelMaximoAlcanzado);
        },
        salir() {
            if ("S" === sessionStorage.getItem("esTemporal")) {
                window.location.href = "/menuPaciente.html";
            } else {
                var fec = new Date();
                var dia = fec.getDay() + 1;
                var mes = fec.getMonth() + 1;
                var anio = fec.getFullYear();

                var tiempoJugado = appMusicoterapia.traerTiempoJugado();
                tiempoJugado = tiempoJugado.toFixed(0);
                if (tiempoJugado === "0") {
                    tiempoJugado = 1;
                }
                var promesa = apiclientMusicoterapia.enviarResultados(sessionStorage.getItem("id"), anio + "/" + mes + "/" + dia, preguntasCorrectas, preguntasErroneas, tiempoJugado, nivelMaximoAlcanzado);
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
        cargarParaEditar() {
            var promesaConsulta = apiclientMusicoterapia.getTodasPreguntas(sessionStorage.getItem("idPacienteConsultaPS"))
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
        modificarPregunta(idPreguntaPaciente) {
            var nivelPersonalizado = $('select#nivel' + idPreguntaPaciente).val();
            var estado = $('#estado' + idPreguntaPaciente);
            if ($('#estado' + idPreguntaPaciente).is(':checked') === true) {
                estado = "A";
            } else {
                estado = "D";
            }
            var promesa = apiclientMusicoterapia.modificarPregunta(idPreguntaPaciente, nivelPersonalizado, estado);
            promesa.then(
                    function () {
                        $('#idPanel' + idPreguntaPaciente).show();
                        setTimeout(function () {
                            $('#idPanel' + idPreguntaPaciente).hide();
                        }, 1000);
                    },
                    function (dato) {
                        alert(dato.responseText);
                    }
            );
        },
        initAdicionarPregunta() {
            if ("undefined" === sessionStorage.getItem("id") || null === sessionStorage.getItem("id")) {
                //no inicio sesion
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "iniciarSesion.html";
            } else {
                if ("undefined" === sessionStorage.getItem("idPacienteConsultaPS") || null === sessionStorage.getItem("idPacienteConsultaPS")) {
                    alert("Para esta función, debe seleccionar un paciente.");
                    window.location.href = "perfilFamiliarFamiliares.html";
                } else {
                    $("#idNombreUsu").text(sessionStorage.getItem("nombres") + " " + sessionStorage.getItem("apellidos"));
                    $("#idNombrePaciente").text(sessionStorage.getItem("nombrePacienteConsultaPS"));

                }
            }
        },
        buscarVideos() {
            var cancion = $('#idBusqueda').val();
            if (cancion === "") {
                alert("Ingrese la canción a buscar");
            } else {
                var promesaConsulta = apiclientMusicoterapia.buscarVideosYoutube(cancion);
                promesaConsulta.then(
                        function (datos) {
                            if (promesaConsulta.responseJSON.pageInfo.totalResults > 0) {
                                inicializarVideo();
                                promesaConsulta.responseJSON.items.map(adicionarVideo);
                            } else {
                                alert("No se han encontrado videos!");
                            }
                        },
                        function (dato) {
                            alert(dato.responseText);
                        }
                );

            }



        },
        seleccionarVideo(idVideo) {
            $('.youtube-iframe').each(function (index) {
                $(this).attr('src', $(this).attr('src'));
                return false;
            });
            $('#idPanelBusqueda').hide();
            $('#idPanelAdicion').show();
            $("#idVideoAdicionar").attr("src", "https://www.youtube.com/embed/" + idVideo + "?rel=0&amp;controls=0&amp;showinfo=0\"");
            $('#idVid').val(idVideo);

        },
        atrasCrearPregunta() {
            $('#idPregunta').val("");
            $('#idRespuestaA').val("");
            $('#idRespuestaB').val("");
            $('#idRespuestaC').val("");
            $('#idRespuestaD').val("");
            $('#idPanelBusqueda').show();
            $('#idPanelAdicion').hide();

            $('.youtube-iframe').each(function (index) {
                $(this).attr('src', $(this).attr('src'));
                return false;
            });

        },
        guardarPregunta() {
            var pregunta = $('#idPregunta').val();
            var respuestaA = $('#idRespuestaA').val();
            var respuestaB = $('#idRespuestaB').val();
            var respuestaC = $('#idRespuestaC').val();
            var respuestaD = $('#idRespuestaD').val();
            var correcta = $("select#idRespuestaCorrecta").val();
            var nivel = $("select#idNivel").val();
            var mensaje = "";
            var valido = true;
            var correctaA;
            var correctaB;
            var correctaC;
            var correctaD;
            var idVideo = $('#idVid').val();
            var idPaciente = sessionStorage.getItem("idPacienteConsultaPS");
            var video = "https://www.youtube.com/embed/" + idVideo + "?rel=0&amp;controls=0&amp;showinfo=0&autoplay=1";
            if (pregunta === "") {
                valido = false;
                mensaje = "pregunta.";
            }

            if (respuestaA === "") {
                valido = false;
                mensaje = mensaje + "Respuesta A.";
            }

            if (respuestaB === "") {
                valido = false;
                mensaje = mensaje + "Respuesta B.";
            }

            if (respuestaC === "") {
                valido = false;
                mensaje = mensaje + "Respuesta C.";
            }

            if (respuestaD === "") {
                valido = false;
                mensaje = mensaje + "Respuesta D.";
            }

            if (!valido) {
                $("#mensajeFalta").text(mensaje);
                $("#divError").show();
            } else {
                $("#mensajeFalta").text("");
                $("#divError").hide();

                if ("A" === correcta) {
                    correctaA = "S";
                    correctaB = "N";
                    correctaC = "N";
                    correctaD = "N";
                } else if ("B" === correcta) {
                    correctaA = "N";
                    correctaB = "S";
                    correctaC = "N";
                    correctaD = "N";
                } else if ("C" === correcta) {
                    correctaA = "N";
                    correctaB = "N";
                    correctaC = "S";
                    correctaD = "N";
                } else {
                    correctaA = "N";
                    correctaB = "N";
                    correctaC = "N";
                    correctaD = "S";
                }
                $('.youtube-iframe').each(function (index) {
                    $(this).attr('src', $(this).attr('src'));
                    return false;
                });
                
                var promesa = apiclientMusicoterapia.adicionarPregunta(pregunta, video, nivel, respuestaA, respuestaB, respuestaC, respuestaD, correctaA, correctaB, correctaC, correctaD, idPaciente);
                promesa.then(
                        function () {
                            alert("Se ha adicionado la pregunta correctamente!");
                            inicializarVideo();
                            appMusicoterapia.atrasCrearPregunta();
                        },
                        function (dato) {
                            alert(dato.responseText);
                        }
                );
            }

        },
        atrasASeleccionPaciente() {
            window.location.href = "/perfilFamiliarConsultarFamiliares.html";
        },
        atrasASeleccionPacientePS() {
            window.location.href = "/perfilPersonalSaludConsultaPaciente.html";
        }
    };
})();

function adicionarPregunta(item) {
    var nivel;
    if (item.nivel === 1) {
        nivel = "<option value = 1 selected>1</option><option value = 2>2</option><option value = 3 >3</option><option value = 4 >4</option>";
    } else if (item.nivel === 2) {
        nivel = "<option value = 1 >1</option><option value = 2 selected>2</option><option value = 3 >3</option><option value = 4 >4</option>";
    } else if (item.nivel === 3) {
        nivel = "<option value = 1 >1</option><option value = 2 >2</option><option value = 3 selected>3</option><option value = 4 >4</option>";
    } else {
        nivel = "<option value = 1 >1</option><option value = 2 >2</option><option value = 3 >3</option><option value = 4 selected>4</option>";
    }

    var activo = "";
    if (item.estado === "A") {
        activo = "checked";
    }


    var markup = "<tr class=\"filasPG\"><td>" + item.id + "</td><td><div class=\"embed-container\"><iframe class=\"youtube-iframe\" width=\"400\" height=\"210\" frameborder=\"0\" allowfullscreen id=\"idVideo\" src=\"" + item.video.replace("&autoplay=1", "") + "\"></iframe></div></td><td>" + item.pregunta + "</td><td><select class=\"form-control\" id=\"nivel" + item.id + "\">" + nivel + "</select></td><td><input type=\"checkbox\" " + activo + " id=\"estado" + item.id + "\"></td><td><button class=\"btn btn-info btn-block\" onclick=\"appMusicoterapia.modificarPregunta(" + item.id + ")\"> Guardar</button><div class=\"alert alert-success\" style=\"display:none;\" id=\"idPanel" + item.id + "\"><strong >Bien!</strong></div></td></tr>";
    $("#idTablaG").append(markup);
}

function inicializarPregunta() {
    $(".filasPG").remove("tr");
}


function traerNombreCorrecto(filter) {
    if (filter.respuestaCorrecta === "S") {
        return filter.opcion;
    }
}
function traerRespuestasIncorrectas(filter) {
    if (filter.respuestaCorrecta === "N") {
        return filter;
    }
}
function habilitarTodosLosBotones() {
    for (var i = 0; i < 4; i++) {
        $("#idBoton" + i).attr("disabled", false);
    }
    $("#idBtn5050").attr("disabled", false);
    $("#idBtn5050").attr("onclick", "appMusicoterapia.ayuda5050()");
}

function respuestaCorrecta() {
}

function respuestaIncorrecta(preguntasCorrectasTemporales) {
    preguntasCorrectasTemporales--;
}

function getRandomArbitrary(arrgloIndices) {
    return parseInt(Math.random() * (arrgloIndices.length));
}

function deshabilitarBotones5050(respuesta) {
    for (var i = 0; i < 4; i++) {
        if ($("#idBoton" + i).text() === respuesta.opcion) {
            $("#idBoton" + i).attr("disabled", true);
            $("#idBoton" + i).attr("onclick", "");
        }
    }
    $("#idBtn5050").attr("disabled", true);
    $("#idBtn5050").attr("onclick", "");
}


function adicionarVideo(item) {
    var markup = "<tr class=\"filasVid\"><td><div class=\"embed-container\"><iframe class=\"youtube-iframe\" width=\"400\" height=\"210\" frameborder=\"0\" allowfullscreen id=\"idVideo\" src=\"https://www.youtube.com/embed/" + item.id.videoId + "?rel=0&amp;controls=0&amp;showinfo=0\"></iframe></div></td><td>" + item.snippet.title + "</td><td><button class=\"btn btn-info btn-block\" onclick=\"appMusicoterapia.seleccionarVideo('" + item.id.videoId + "')\"> Seleccionar</button></td></tr>";
    $("#idTablaVideos").append(markup);
}

function inicializarVideo() {
    $(".filasVid").remove("tr");
}

//Seleccionar Archivo
 $(document).on('ready', function() {
        $("#input-b5").fileinput({showCaption: false});
    });
