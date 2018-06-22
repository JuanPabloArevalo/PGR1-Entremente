/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global apiclientPerfilPersonalSalud */

function adicionarFilaPendientes(item) {
    var markup = "<tr class=\"filasP\"><td>" + item.id + "</td><td>" + item.nombresPaciente + "</td><td>" + item.apellidosPaciente + "</td><td>" + item.relacion + "</td><td><button type=\"button\" class=\"btn btn-success\" onclick=\"perfilPersonalSalud.aceptarSolicitud(" + item.id + ", " + item.idPaciente + ", " + item.idFamiliar + ")\">Aceptar</button><button type=\"button\" class=\"btn btn-danger\" onclick=\"perfilPersonalSalud.rechazarSolicitud(" + item.id + ", " + item.idPaciente + ", " + item.idFamiliar + ")\">Rechazar</button></td></tr>";
    $("#tablaPendientes").append(markup);
}

function inicializarElementosPendientes() {
    $(".filasP").remove("tr");
}

function adicionarFilaAceptadas(item) {
    var markup = "<tr class=\"filasA\"><td>" + item.id + "</td><td>" + item.nombresPaciente + "</td><td>" + item.apellidosPaciente + "</td><td>" + item.relacion + "</td><td><button type=\"button\" class=\"btn btn-primary\" onclick=\"perfilPersonalSalud.irAConsultarPaciente(" + item.idPaciente + ",' " + item.nombresPaciente + " " + item.apellidosPaciente + "',' " + item.relacion + "')\">Consultar</button><button type=\"button\" class=\"btn btn-danger\" onclick=\"perfilPersonalSalud.eliminarRelacion(" + item.id + ", " + item.idPaciente + ", " + item.idFamiliar + ")\">Eliminar</button></td></tr>";
    console.info(markup);
    $("#tablaAceptadas").append(markup);
}

function inicializarElementosAceptadas() {
    $(".filasA").remove("tr");
}

function adicionarFilaBusqueda(item) {
    var markup = "<tr class=\"filasB\"><td>" + item.id + "</td><td>" + item.nombreUsuario + "</td><td>" + item.nombres + "</td><td>" + item.apellidos + "</td><td><select class=\"form-control\" id=\"relacion" + item.id + "\"><option selected>Neurólogo</option><option>Psicólogo</option><option>Psquiatra</option><option>Terapeuta</option><option>Médico General</option><option>Otros</option></select></td><td><button type=\"button\" class=\"btn btn-success\" onclick=\"perfilPersonalSalud.adicionarRelacion(" + item.id + ")\">Agregar</button></td></tr>";
    $("#idTablaBusqueda").append(markup);
}

function inicializarElementosBusqueda() {
    $(".filasB").remove("tr");
}

function adicionarFilaMensajes(item) {
    var markup = "<tr class=\"filasMen\"><td>" + item.id + "</td><td>" + item.fecha + "</td><td>" + item.mensaje + "</td><td>" + item.tipo + "</td><td>" + item.nombreRemitente + "</td><td>" + item.rol + "</td><td><input type=\"checkbox\" disabled  " + item.checkBox + "></td></tr>";
    $("#tablaMensajes").append(markup);
}

function inicializarElementosMensajes() {
    $(".filasMen").remove("tr");
}

function adicionarEnfermedad(item) {
    $('#listaEnfermedades').append('<option value=' + item.id + ' >' + item.nombre + '</option>');
}



function adicionarFilaHistorialMedico(item) {
    var markup = "<tr class=\"filasHM\"><td>" + item.id + "</td><td>" + item.enfermedad.codigo + "</td><td>" + item.enfermedad.nombre + "</td><td>" + item.fecha + "</td><td>" + item.nombresPersonalSalud + "</td><td>" + item.rol + "</td><td><button type='button' class='btn btn-danger' onclick=\"perfilPersonalSalud.eliminarHistorialMedico(" + item.id + ")\" >Eliminar</button></td></tr>";
    $("#idTablaHistorialM").append(markup);
}

function inicializarElementosHistorialMedico() {
    $(".filasHM").remove("tr");
}

var perfilPersonalSalud = (function () {
    return{
        init() {
            if ("undefined" === sessionStorage.getItem("id") || null === sessionStorage.getItem("id")) {
                //no inicio sesion
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "iniciarSesion.html";
            } else {
                //si inicio sesion               

                $("#idNombreUsu").text(sessionStorage.getItem("nombres") + " " + sessionStorage.getItem("apellidos"));

                $("#nombres").val(sessionStorage.getItem("nombres"));
                $("#apellidos").val(sessionStorage.getItem("apellidos"));
                $("#documento").val(sessionStorage.getItem("documentoIdentidad"));
                $("#usuario").val(sessionStorage.getItem("nombreUsuario"));
                $("#correo").val(sessionStorage.getItem("correo"));
                $("#tipoDoc").val(sessionStorage.getItem("tipoDocumento"));
                $("#listaRol").val(sessionStorage.getItem("rol"));
            }
        },
        cargarInformacionPacientes() {
            if ("undefined" === sessionStorage.getItem("id") || null === sessionStorage.getItem("id")) {
                //no inicio sesion
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "iniciarSesion.html";
            } else {
                //si inicio sesion
                $("#idNombreUsu").text(sessionStorage.getItem("nombres") + " " + sessionStorage.getItem("apellidos"));
                perfilPersonalSalud.cargarSolicitudes();
            }
        },
        cargarSolicitudes() {
            var id = sessionStorage.getItem("id");
            var nombres = sessionStorage.getItem("nombres");
            var apellidos = sessionStorage.getItem("apellidos");
            var documentoIdentidad = sessionStorage.getItem("documentoIdentidad");
            var nombreUsuario = sessionStorage.getItem("nombreUsuario");
            var tipoDocumento = sessionStorage.getItem("tipoDocumento");
            var correo = sessionStorage.getItem("correo");
            var promesaConsulta = apiclientPerfilPersonalSalud.getSolicitudesPendientes(id, nombres, apellidos, documentoIdentidad, nombreUsuario, tipoDocumento, correo);
            promesaConsulta.then(
                    function (datos) {
                        inicializarElementosPendientes();
                        datos.map(adicionarFilaPendientes);
                        var id = sessionStorage.getItem("id");
                        var nombres = sessionStorage.getItem("nombres");
                        var apellidos = sessionStorage.getItem("apellidos");
                        var documentoIdentidad = sessionStorage.getItem("documentoIdentidad");
                        var nombreUsuario = sessionStorage.getItem("nombreUsuario");
                        var tipoDocumento = sessionStorage.getItem("tipoDocumento");
                        var correo = sessionStorage.getItem("correo");
                        var promesaConsulta = apiclientPerfilPersonalSalud.getSolicitudesAceptadas(id, nombres, apellidos, documentoIdentidad, nombreUsuario, tipoDocumento, correo);
                        promesaConsulta.then(
                                function (datos) {
                                    inicializarElementosAceptadas();
                                    datos.map(adicionarFilaAceptadas);
                                },
                                function (dato) {
                                    alert(dato.responseText);
                                }
                        );
                    },
                    function (dato) {
                        alert(dato.responseText);
                    }
            );
        },
        consultarPacientes() {
            var buscar = $("#idBusqueda").val();
            if (buscar === "") {
                alert("Para realizar la búsqueda debe ingresar un dato");
            } else {
                var promesaConsulta = apiclientPerfilPersonalSalud.getBusquedaPacientes(buscar);
                promesaConsulta.then(
                        function (datos) {
                            inicializarElementosBusqueda();
                            datos.map(adicionarFilaBusqueda);
                            $('#modalBusqueda').modal('show');
                        },
                        function (dato) {
                            alert(dato.responseText);
                        }
                );
            }
        },
        aceptarSolicitud(id, idPaciente, idFamiliar) {
            var promesaConsulta = apiclientPerfilPersonalSalud.aceptarSolicitud(id, idPaciente, idFamiliar);
            promesaConsulta.then(
                    function () {
                        inicializarElementosAceptadas();
                        inicializarElementosPendientes();
                        perfilPersonalSalud.cargarSolicitudes();
                        alert("Se ha aceptado la solicitud!!");
                    },
                    function (dato) {
                        alert(dato.responseText);
                    }
            );
        },
        rechazarSolicitud(id, idPaciente, idFamiliar) {
            var promesaConsulta = apiclientPerfilPersonalSalud.eliminarSolicitud(id, idPaciente, idFamiliar);
            promesaConsulta.then(
                    function () {
                        inicializarElementosAceptadas();
                        inicializarElementosPendientes();
                        perfilPersonalSalud.cargarSolicitudes();
                        alert("Se ha rechazado la solicitud del Paciente!!");
                    },
                    function (dato) {
                        alert(dato.responseText);
                    }
            );
        },
        eliminarRelacion(id, idPaciente, idFamiliar) {
            var promesaConsulta = apiclientPerfilPersonalSalud.eliminarSolicitud(id, idPaciente, idFamiliar);
            promesaConsulta.then(
                    function () {
                        inicializarElementosAceptadas();
                        inicializarElementosPendientes();
                        perfilPersonalSalud.cargarSolicitudes();
                        alert("Se ha eliminado la relación con el Paciente");
                    },
                    function (dato) {
                        alert(dato.responseText);
                    }
            );
        },
        adicionarRelacion(idPaciente) {
            var relacion = $("select#relacion" + idPaciente).val();
            var idFamiliar = sessionStorage.getItem("id");
            var promesaConsulta = apiclientPerfilPersonalSalud.adicionarSolicitud(idPaciente, idFamiliar, relacion);
            promesaConsulta.then(
                    function () {
                        inicializarElementosAceptadas();
                        inicializarElementosPendientes();
                        perfilPersonalSalud.cargarSolicitudes();
                        alert("Se ha enviado la solicitud");
                    },
                    function (dato) {
                        alert(dato.responseText);
                    }
            );
        },
        irAConsultarPaciente(idPaciente, nombrePaciente, rol) {
            sessionStorage.setItem("idPacienteConsultaPS", idPaciente);
            sessionStorage.setItem("nombrePacienteConsultaPS", nombrePaciente);
            sessionStorage.setItem("rolMensaje", rol);
            window.location.href = "perfilPersonalSaludConsultaPaciente.html";
        },
        initConsultarPaciente() {
            if ("undefined" === sessionStorage.getItem("id") || null === sessionStorage.getItem("id")) {
                //no inicio sesion
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "iniciarSesion.html";
            } else {
                if ("undefined" === sessionStorage.getItem("idPacienteConsultaPS") || null === sessionStorage.getItem("idPacienteConsultaPS")) {
                    alert("Para esta función, debe seleccionar un paciente.");
                    window.location.href = "perfilPersonalSaludPaciente.html";
                } else {
                    $("#idNombreUsu").text(sessionStorage.getItem("nombres") + " " + sessionStorage.getItem("apellidos"));
                    $("#idNombrePaciente").text(sessionStorage.getItem("nombrePacienteConsultaPS"));
                    perfilPersonalSalud.cargarSelectEnfermedades();
                    perfilPersonalSalud.cargarMensajes();
                    //Cargar Historial Medico

                    perfilPersonalSalud.cargarHistorialMedico();

                }
            }
        },
        cargarMensajes() {
            var promesaConsulta = apiclientPerfilPersonalSalud.getTodosMensajes(sessionStorage.getItem("idPacienteConsultaPS"));
            promesaConsulta.then(
                    function (datos) {
                        inicializarElementosMensajes();
                        datos.map(adicionarFilaMensajes);
                    },
                    function (dato) {
                        alert(dato.responseText);
                    }
            );
        },
        cargarHistorialMedico() {
            var idPaciente = sessionStorage.getItem("idPacienteConsultaPS");
            var promesaConsulta = apiclientPerfilPersonalSalud.getHistorialMedico(idPaciente);
            promesaConsulta.then(
                    function (datos) {
                        inicializarElementosHistorialMedico();
                        datos.map(adicionarFilaHistorialMedico);
                    },
                    function (dato) {
                        alert(dato.responseText);
                    }
            );
        },
        initEnviarMensaje() {
            if ("undefined" === sessionStorage.getItem("id") || null === sessionStorage.getItem("id")) {
                //no inicio sesion
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "iniciarSesion.html";
            } else {
                if ("undefined" === sessionStorage.getItem("idPacienteConsultaPS") || null === sessionStorage.getItem("idPacienteConsultaPS")) {
                    alert("Para esta función, debe seleccionar un paciente.");
                    window.location.href = "perfilPersonalSaludPaciente.html";
                } else {
                    $("#idNombreUsu").text(sessionStorage.getItem("nombres") + " " + sessionStorage.getItem("apellidos"));
                    $("#idNombrePaciente").text(sessionStorage.getItem("nombrePacienteConsultaPS"));
//                    perfilPersonalSalud.cargarMensajes();
                    //Cargar Historial Medico
//                    perfilPersonalSalud.cargarHistorialMedico();
                }
            }
        },
        enviarMensaje() {
            var idPaciente = sessionStorage.getItem("idPacienteConsultaPS");
            var idPersonalSalud = sessionStorage.getItem("id");
            var fecha = $("#fecha").val();
            var mensaje = $("#mensaje").val();
            var tipo = "Personal Salud";
            var rol = sessionStorage.getItem("rolMensaje");
            var puedeVerPaciente = "N";
            if ($('#puedeVerPaciente').is(':checked') === true) {
                puedeVerPaciente = "S";
            }


            if (fecha === "" || fecha === null) {
                alert("La fecha no puede ir vacia");
            } else if (mensaje === "" || mensaje === null) {
                alert("El mensaje no puede ir vacio!");
            } else {
                var promesaConsulta = apiclientPerfilPersonalSalud.enviarMensaje(idPaciente, idPersonalSalud, fecha, mensaje, tipo, rol, puedeVerPaciente, "", "");
                promesaConsulta.then(
                        function () {
                            alert("Se ha enviado el mensaje!");
                            $("#fecha").val("");
                            $("#mensaje").val("");
                        },
                        function (dato) {
                            alert(dato.responseText);
                        }
                );
            }
        },
        cargarSelectEnfermedades() {
            var promesaConsulta = apiclientPerfilPersonalSalud.getEnfermedades();
            promesaConsulta.then(
                    function (datos) {
                        datos.map(adicionarEnfermedad);
                    },
                    function (dato) {
                        alert(dato.responseText);
                    }
            );
        },
        guardarHistorialMedico() {
            var fecha = $("#fechaHM").val();
            var idEnfermedad = $("select#listaEnfermedades").val();
            var idPaciente = sessionStorage.getItem("idPacienteConsultaPS");
            var idPersonalSalud = sessionStorage.getItem("id");
            var rol = sessionStorage.getItem("rolMensaje");
            if (fecha === "" || fecha === null) {
                alert("La fecha no puede ir vacia");
            } else if (idEnfermedad === "" || idEnfermedad === null) {
                alert("Seleccione una enfermedad!");
            } else {
                var promesaConsulta = apiclientPerfilPersonalSalud.guardarHistorialMedico(idPaciente, idEnfermedad, idPersonalSalud, fecha, rol);
                promesaConsulta.then(
                        function () {
                            alert("Se ha actualizado el historial médico del paciente!");
                            //Cargar HM
                            inicializarElementosHistorialMedico();
                            perfilPersonalSalud.cargarHistorialMedico();
                            $("#fechaHM").val("");
                        },
                        function (dato) {
                            alert(dato.responseText);
                        }
                );
            }
        },
        eliminarHistorialMedico(id) {
            var promesaConsulta = apiclientPerfilPersonalSalud.eliminarHistorialMedico(id);
            promesaConsulta.then(
                    function () {
                        inicializarElementosHistorialMedico();
                        perfilPersonalSalud.cargarHistorialMedico();
                        alert("Se ha actualizado el historial médico del paciente");
                    },
                    function (dato) {
                        alert(dato.responseText);
                    }
            );
        },
        modificarDatos() {
            var valido = true;
            var mensaje = "";
            var nombres = $("#nombres").val();
            var apellidos = $("#apellidos").val();
            var rol = $("select#listaRol").val();
            var id = sessionStorage.getItem("id");
            if (nombres === "") {
                valido = false;
                mensaje = "Nombres.";
            }
            if (apellidos === "") {
                valido = false;
                mensaje = mensaje + "Apellidos.";
            }
            if (rol === "") {
                valido = false;
                mensaje = mensaje + "Rol.";
            }

            if (!valido) {
                $("#mensajeFalta").text(mensaje);
                $("#divError").show();
            } else {
                var promesa = apiclientPerfilPersonalSalud.modificar(nombres, apellidos, rol, id);
                promesa.then(
                        function () {
                            alert("Se ha actualizado los datos con exito!");
                            sessionStorage.setItem("nombres", nombres);
                            sessionStorage.setItem("apellidos", apellidos);
                            sessionStorage.setItem("rol", rol);
                            $("#idNombreUsu").text(sessionStorage.getItem("nombres") + " " + sessionStorage.getItem("apellidos"));
                        },
                        function () {
                            $("#mensajeFaltaProm").text(promesa.responseText);
                            $("#divProm").show();
                        });

            }



        }
    };
}());



