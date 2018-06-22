
/* global apiclientPerfilPaciente */

//$(document).ready(function(){
//    $(".nav-tabs a").click(function(){
//        $(this).tab('show');
//    });
//});


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function adicionarFilaPendientes(item) {
    var markup = "<tr class=\"filasP\"><td>" + item.id + "</td><td>" + item.nombresFamiliar + "</td><td>" + item.apellidosFamiliar + "</td><td>" + item.relacion + "</td><td><button type=\"button\" class=\"btn btn-success\" onclick=\"perfilPaciente.aceptarSolicitud(" + item.id + ", " + item.idPaciente + ", " + item.idFamiliar + ")\">Aceptar</button><button type=\"button\" class=\"btn btn-danger\" onclick=\"perfilPaciente.rechazarSolicitud(" + item.id + ", " + item.idPaciente + ", " + item.idFamiliar + ")\">Rechazar</button></td></tr>";
    $("#tablaPendientes").append(markup);
}

function inicializarElementosPendientes() {
    $(".filasP").remove("tr");
}

function adicionarFilaAceptadas(item) {
    var markup = "<tr class=\"filasA\"><td>" + item.id + "</td><td>" + item.nombresFamiliar + "</td><td>" + item.apellidosFamiliar + "</td><td>" + item.relacion + "</td><td><button type=\"button\" class=\"btn btn-danger\" onclick=\"perfilPaciente.eliminarRelacion(" + item.id + ", " + item.idPaciente + ", " + item.idFamiliar + ")\">Eliminar</button></td></tr>";
    $("#tablaAceptadas").append(markup);
}

function inicializarElementosAceptadas() {
    $(".filasA").remove("tr");
}

function adicionarFilaBusqueda(item) {
//        console.info(item);
    var markup = "<tr class=\"filasB\"><td>" + item.id + "</td><td>" + item.nombreUsuario + "</td><td>" + item.nombres + "</td><td>" + item.apellidos + "</td><td><select class=\"form-control\" id=\"relacion" + item.id + "\"><option>Padres</option><option>Tios</option><option>Hermanos</option><option>Abuelos</option><option selected>Sobrinos</option><option selected>Otros</option></select></td><td><button type=\"button\" class=\"btn btn-success\" onclick=\"perfilPaciente.adicionarRelacion(" + item.id + ")\">Agregar</button></td></tr>";
    $("#idTablaBusqueda").append(markup);
}

function inicializarElementosBusqueda() {
    $(".filasB").remove("tr");
}

function adicionarFilaMensajes(item) {
    var markup = "<tr class=\"filasMen\"><td>" + item.id + "</td><td>" + item.fecha + "</td><td>" + item.mensaje + "</td><td>" + item.tipo + "</td><td>" + item.nombreRemitente + "</td><td>" + item.rol + "</td></tr>";
    $("#tablaMensajesPaciente").append(markup);
}

function inicializarElementosMensajes() {
    $(".filasMen").remove("tr");
}

var perfilPaciente = (function () {
    return{
        init() {
            if ("undefined" === sessionStorage.getItem("id") || null === sessionStorage.getItem("id")) {
                //no inicio sesion
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "iniciarSesion.html";
            } else {
                //si inicio sesion

//                sessionStorage.setItem("id", usuario.id);
//                sessionStorage.setItem("nombres", usuario.nombres);
//                sessionStorage.setItem("apellidos", usuario.apellidos);
//                sessionStorage.setItem("documentoIdentidad", usuario.documentoIdentidad);
//                sessionStorage.setItem("fechaNacimiento", usuario.fechaNacimiento);
//                sessionStorage.setItem("genero", usuario.genero);
//                sessionStorage.setItem("pais", usuario.pais);
//                sessionStorage.setItem("nombreUsuario", usuario.nombreUsuario);
//                sessionStorage.setItem("password", usuario.password);
//                sessionStorage.setItem("direccion", usuario.direccion);
//                sessionStorage.setItem("tipoDocumento", usuario.tipoDocumento);
//                sessionStorage.setItem("correo", usuario.correo);


                $("#idNombreUsu").text(sessionStorage.getItem("nombres") + " " + sessionStorage.getItem("apellidos"));

                $("#nombre").val(sessionStorage.getItem("nombres"));
                $("#apellido").val(sessionStorage.getItem("apellidos"));
                $("#documento").val(sessionStorage.getItem("documentoIdentidad"));
                $("#nombreUsuario").val(sessionStorage.getItem("nombreUsuario"));
                $("#idCorreo").val(sessionStorage.getItem("correo"));
                $('#tipoDoc').val(sessionStorage.getItem("tipoDocumento"));
                $('#genero').val(sessionStorage.getItem("genero"));
                $("#idPais").val(sessionStorage.getItem("pais"));
                $("#idCiudad").val(sessionStorage.getItem("ciudad"));
                $("#idDireccion").val(sessionStorage.getItem("direccion"));
                $("#idFechaN").val(sessionStorage.getItem("fechaNacimiento"));
                
                perfilPaciente.calcularProgreso();
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
                perfilPaciente.cargarSolicitudes();
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
            var promesaConsulta = apiclientPerfilPaciente.getSolicitudesPendientes(id, nombres, apellidos, documentoIdentidad, nombreUsuario, tipoDocumento, correo);
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
                        var promesaConsulta = apiclientPerfilPaciente.getSolicitudesAceptadas(id, nombres, apellidos, documentoIdentidad, nombreUsuario, tipoDocumento, correo);
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
        consultarFamiliares() {
            var buscar = $("#idBusqueda").val();
            if (buscar === "") {
                alert("Para realizar la búsqueda debe ingresar un dato");
            } else {
                var promesaConsulta = apiclientPerfilPaciente.getBusquedaFamiliares(buscar);
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
            var promesaConsulta = apiclientPerfilPaciente.aceptarSolicitud(id, idPaciente, idFamiliar);
            promesaConsulta.then(
                    function () {
                        inicializarElementosAceptadas();
                        inicializarElementosPendientes();
                        perfilPaciente.cargarSolicitudes();
                        alert("Se ha aceptado la solicitud!!");
                    },
                    function (dato) {
                        alert(dato.responseText);
                    }
            );
        },
        rechazarSolicitud(id, idPaciente, idFamiliar) {
            var promesaConsulta = apiclientPerfilPaciente.eliminarSolicitud(id, idPaciente, idFamiliar);
            promesaConsulta.then(
                    function () {
                        inicializarElementosAceptadas();
                        inicializarElementosPendientes();
                        perfilPaciente.cargarSolicitudes();
                        alert("Se ha rechazado la solicitud del Paciente!!");
                    },
                    function (dato) {
                        alert(dato.responseText);
                    }
            );
        },
        eliminarRelacion(id, idPaciente, idFamiliar) {
            var promesaConsulta = apiclientPerfilPaciente.eliminarSolicitud(id, idPaciente, idFamiliar);
            promesaConsulta.then(
                    function () {
                        inicializarElementosAceptadas();
                        inicializarElementosPendientes();
                        perfilPaciente.cargarSolicitudes();
                        alert("Se ha eliminado la relación con el Paciente");
                    },
                    function (dato) {
                        alert(dato.responseText);
                    }
            );
        },
        adicionarRelacion(idFamiliar) {
            var relacion = $("select#relacion" + idFamiliar).val();
            var idPaciente = sessionStorage.getItem("id");
            var promesaConsulta = apiclientPerfilPaciente.adicionarSolicitud(idPaciente, idFamiliar, relacion);
            promesaConsulta.then(
                    function () {
                        inicializarElementosAceptadas();
                        inicializarElementosPendientes();
                        perfilPaciente.cargarSolicitudes();
                        alert("Se ha enviado la solicitud");
                    },
                    function (dato) {
                        alert(dato.responseText);
                    }
            );
        },
        initCargarMensajes() {
            if ("undefined" === sessionStorage.getItem("id") || null === sessionStorage.getItem("id")) {
                //no inicio sesion
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "iniciarSesion.html";
            } else {
                //si inicio sesion
                $("#idNombreUsu").text(sessionStorage.getItem("nombres") + " " + sessionStorage.getItem("apellidos"));
                perfilPaciente.cargarMensajes();
            }
        },
        cargarMensajes() {
            var promesaConsulta = apiclientPerfilPaciente.getTodosMensajes(sessionStorage.getItem("id"));
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
        modificarDatosPaciente() {
            var valido = true;
            var mensaje = "";
            var nombres = $("#nombre").val();
            var apellidos = $("#apellido").val();
            var fechaNacimiento = $("#idFechaN").val();
            var genero = $("select#genero").val();
            var pais = $("#idPais").val();
            var ciudad = $("#idCiudad").val();
            var direccion = $("#idDireccion").val();
            var id = sessionStorage.getItem("id");
            if (nombres === "") {
                valido = false;
                mensaje = "Nombres.";
            }
            if (apellidos === "") {
                valido = false;
                mensaje = mensaje + "Apellidos.";
            }
            if (fechaNacimiento === "") {
                valido = false;
                mensaje = mensaje + "Fecha de Nacimiento.";
            }
            if (genero === "") {
                valido = false;
                mensaje = mensaje + "Género.";
            }
            if (pais === "") {
                valido = false;
                mensaje = mensaje + "País.";
            }
            if (ciudad === "") {
                valido = false;
                mensaje = mensaje + "Ciudad.";
            }
            if (direccion === "") {
                valido = false;
                mensaje = mensaje + "Dirección.";
            }
            if (!valido) {
                $("#mensajeFalta").text(mensaje);
                $("#divError").show();
            } else {
                var promesa = apiclientPerfilPaciente.modificarPaciente(nombres, apellidos, fechaNacimiento, genero, pais, ciudad, direccion, id);
                promesa.then(
                        function () {
                            alert("Se ha actualizado los datos con exito!");

                            sessionStorage.setItem("nombres", nombres);
                            sessionStorage.setItem("apellidos", apellidos);
                            sessionStorage.setItem("fechaNacimiento", fechaNacimiento);
                            sessionStorage.setItem("genero", genero);
                            sessionStorage.setItem("pais", pais);
                            sessionStorage.setItem("direccion", direccion);
                            sessionStorage.setItem("ciudad", ciudad);
                            
                            $("#idNombreUsu").text(sessionStorage.getItem("nombres") + " " + sessionStorage.getItem("apellidos"));
                        },
                        function () {
                            $("#mensajeFaltaProm").text(promesa.responseText);
                            $("#divProm").show();
                        });
            }
        },
        atras() {
            window.location.href = "/menuPaciente.html";
        },
        calcularProgreso(){
            var promesa = apiclientPerfilPaciente.getProgresoPaciente(sessionStorage.getItem("id"));
                promesa.then(
                        function (dato) {
                            $("#idNivel").text(dato.nivel);
                            $("#idProgeso").text(dato.porcentaje+"%");
                            $("#idProgeso").css("width", dato.porcentaje+"%");
                        },
                        function (dato) {
                        alert(dato.responseText);
                    });
        }
    };
}());



