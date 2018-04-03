/* global apiclientFormas */

var appFormas = (function () {
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
        validarRespuesta: function (Boton) {
            var respuesta = Boton.name;
            if (respuesta === "S") {
                preguntasCorrectasTemporales++;
                if (preguntasCorrectasTemporales > cantidaPreguntasPorNivel && nivel < nivelMaximo) {
                    $('#modalSubirNivel').modal('show');
                    setTimeout(function () {
                        $('#modalSubirNivel').modal('hide');
                    }, 1500);
                    appFormas.subirNivel();
                } else if (preguntasCorrectasTemporales <= cantidaPreguntasPorNivel) {
                    $('#modalCorrecto').modal('show');
                    setTimeout(function () {
                        $('#modalCorrecto').modal('hide');
                    }, 1500);
                } else if (nivel >= nivelMaximo) {
                    llegoNivelMaximo = true;
                    alert("Llegaste al nivel máximo. Volvamos a empezar");
                    appFormas.mostrarEstadisticas();
                    appFormas.iniciarNivel();
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
                    appFormas.bajarNivel();
                }
            }
            appFormas.trearSiguientePregunta();
            habilitarTodosLosBotones();

        },
        trearSiguientePregunta: function () {
            apiclientFormas.getPreguntaAleatorea(nivel, function (preguntaToda) {
                pregunta = preguntaToda;
                $("#idNivel").text(nivel);
                $("#idCantidadPreguntasBien").text(preguntasCorrectasTemporales);
                $("#idCantidadPreguntasTotalNivel").text(cantidaPreguntasPorNivel);
                $("#idImagenPregunta").attr("src", preguntaToda.imagen);
                $("#idPregunta").text(preguntaToda.pregunta);
                preguntaToda.respuestas = preguntaToda.respuestas.sort(function () {
                    return Math.random() - 0.5;
                });
                for (var i = 0; i < 4; i++) {
                    $("#idImagen" + i).attr("src", preguntaToda.respuestas[i].opcion);
                    $("#idImagen" + i).attr("onclick", "appFormas.validarRespuesta(this)");
                    $("#idImagen" + i).attr("name", preguntaToda.respuestas[i].respuestaCorrecta);
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
            apiclientFormas.cargarPreguntas(sessionStorage.getItem("id"), nivel, function (preguntaToda) {
                pregunta = preguntaToda;
                $("#idNivel").text(nivel);
                $("#idCantidadPreguntasBien").text(preguntasCorrectasTemporales);
                $("#idCantidadPreguntasTotalNivel").text(cantidaPreguntasPorNivel);
                $("#idImagenPregunta").attr("src", preguntaToda.imagen);
                $("#idPregunta").text(preguntaToda.pregunta);
                preguntaToda.respuestas = preguntaToda.respuestas.sort(function () {
                    return Math.random() - 0.5;
                });
                for (var i = 0; i < 4; i++) {
                    $("#idImagen" + i).attr("src", preguntaToda.respuestas[i].opcion);
                    $("#idImagen" + i).attr("onclick", "appFormas.validarRespuesta(this)");
                    $("#idImagen" + i).attr("name", preguntaToda.respuestas[i].respuestaCorrecta);
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
            apiclientFormas.cambiarNivel(nivel);
            preguntasCorrectasTemporales = 1;
        },
        bajarNivel: function () {
            nivel--;
            apiclientFormas.cambiarNivel(nivel);
            preguntasCorrectasTemporales = cantidaPreguntasPorNivel;

        },
        ayuda5050: function () {
            var arregloRespuestasIncorrectas = pregunta.respuestas.filter(traerRespuestasIncorrectas);
            var numero = getRandomArbitrary(arregloRespuestasIncorrectas);
            arregloRespuestasIncorrectas.splice(numero, 1);
            arregloRespuestasIncorrectas.map(deshabilitarBotones5050);

        },
        ayudaCambioPregunta: function () {
            habilitarTodosLosBotones();
            appFormas.trearSiguientePregunta();

        },
        iniciarNivel: function () {
            nivel = 1;
            apiclientFormas.cambiarNivel(nivel);
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
            alert("Tiempo Jugado: " + appFormas.traerTiempoJugado() + ". Preguntas Correctas: " + preguntasCorrectas + ". Preguntas Erroneas: " + preguntasErroneas + " . Nivel Máximo: " + nivelMaximoAlcanzado);
            console.info("Tiempo Jugado: " + appFormas.traerTiempoJugado() + ". Preguntas Correctas: " + preguntasCorrectas + ". Preguntas Erroneas: " + preguntasErroneas + " . Nivel Máximo: " + nivelMaximoAlcanzado);
        },
        salir() {
            if ("S" === sessionStorage.getItem("esTemporal")) {
                window.location.href = "/menuPaciente.html";
            } else {
                var fec = new Date();
                var dia = fec.getDay() + 1;
                var mes = fec.getMonth() + 1;
                var anio = fec.getFullYear();

                var tiempoJugado = appFormas.traerTiempoJugado();
                tiempoJugado = tiempoJugado.toFixed(0);
//                console.info(tiempoJugado);
                if (tiempoJugado === "0") {
//                    console.info("tiempoJugado");
                    tiempoJugado = 1;
                }
//                console.info(tiempoJugado);
                var promesa = apiclientFormas.enviarResultados(sessionStorage.getItem("id"), anio + "/" + mes + "/" + dia, preguntasCorrectas, preguntasErroneas, tiempoJugado, nivelMaximoAlcanzado);
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
            
            var promesaConsulta = apiclientFormas.getTodasPreguntas(sessionStorage.getItem("idPacienteConsultaPS"))
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
            var promesa = apiclientFormas.modificarPregunta(idPreguntaPaciente, nivelPersonalizado, estado);
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

    
    var markup = "<tr class=\"filasPG\"><td>" + item.id + "</td><td><img src=\"" + item.imagen + "\" class=\"img-rounded img-responsive imagenGaleriaEditar\" alt=\"ImagenPregunta\"></td><td>" + item.pregunta + "</td><td><select class=\"form-control\" id=\"nivel"+item.id+"\">"+nivel+"</select></td><td><input type=\"checkbox\" "+activo+" id=\"estado"+item.id+"\"></td><td><button class=\"btn btn-info btn-block\" onclick=\"appFormas.modificarPregunta(" + item.id + ")\"> Guardar</button><div class=\"alert alert-success\" style=\"display:none;\" id=\"idPanel"+item.id+"\"><strong >Bien!</strong></div></td></tr>";
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
    $("#idBtn5050").attr("disabled", false);
    $("#idBtn5050").attr("onclick", "appFormas.ayuda5050()");
}


function getRandomArbitrary(arrgloIndices) {
    return parseInt(Math.random() * (arrgloIndices.length));
}

function deshabilitarBotones5050(respuesta) {
    for (var i = 0; i < 4; i++) {
        if ($("#idImagen" + i).attr('src') === respuesta.opcion) {
            $("#idImagen" + i).hide();
            $("#idImagen" + i).attr("onclick", "");
        }
    }
    $("#idBtn5050").attr("disabled", true);
    $("#idBtn5050").attr("onclick", "");
}
