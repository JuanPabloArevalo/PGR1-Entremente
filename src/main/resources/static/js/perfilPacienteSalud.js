
/* global apiclientResultados, diagramaFormas, diagramaAtencion, diagramaPercepcion, diagramaCalculemos, diagramaGaleria, apiclientPerfilPacienteSalud */

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
    function adicionarFilaPendientes(item){
        var markup = "<tr class=\"filasP\"><td>" + item.id + "</td><td>" + item.nombresFamiliar + "</td><td>" + item.apellidosFamiliar + "</td><td>" + item.relacion + "</td><td><button type=\"button\" class=\"btn btn-success\" onclick=\"perfilPacienteSalud.aceptarSolicitud("+item.id+", "+item.idPaciente+", "+item.idFamiliar+")\">Aceptar</button><button type=\"button\" class=\"btn btn-danger\" onclick=\"perfilPacienteSalud.rechazarSolicitud("+item.id+", "+item.idPaciente+", "+item.idFamiliar+")\">Rechazar</button></td></tr>";
        $("#tablaPendientes").append(markup);
    }

    function inicializarElementosPendientes(){
        $(".filasP").remove("tr");
    }
    
    function adicionarFilaAceptadas(item){
        var markup = "<tr class=\"filasA\"><td>" + item.id + "</td><td>" + item.nombresFamiliar + "</td><td>" + item.apellidosFamiliar + "</td><td>" + item.relacion + "</td><td><button type=\"button\" class=\"btn btn-danger\" onclick=\"perfilPacienteSalud.eliminarRelacion("+item.id+", "+item.idPaciente+", "+item.idFamiliar+")\">Eliminar</button></td></tr>";
        $("#tablaAceptadas").append(markup);
    }

    function inicializarElementosAceptadas(){
        $(".filasA").remove("tr");
    }
    
    function adicionarFilaBusqueda(item){
//        console.info(item);
        var markup = "<tr class=\"filasB\"><td>" + item.id + "</td><td>" + item.nombreUsuario + "</td><td>" + item.nombres + "</td><td>" + item.apellidos + "</td><td><select class=\"form-control\" id=\"relacion"+item.id+"\"><option selected>Neurólogo</option><option>Psicólogo</option><option>Psquiatra</option><option>Terapeuta</option><option>Médico General</option><option>Otros</option></select></td><td><button type=\"button\" class=\"btn btn-success\" onclick=\"perfilPacienteSalud.adicionarRelacion("+item.id+")\">Agregar</button></td></tr>";
        $("#idTablaBusqueda").append(markup);
    }

    function inicializarElementosBusqueda(){
        $(".filasB").remove("tr");
    }
    
 //Galeria Resultados   
    function adicionarFilaGaleriaResultado(item){
        var markup = "<tr class=\"filasGalRes\"><td>" + item.acertadas + "</td><td>" + item.erroneas + "</td><td>" + item.tiempo + "</td><td>" + item.nivelMaximo + "</td><td>" + item.fecha + "</td></tr>";
        $("#idTablaGResultados").append(markup);
    }

    function inicializarElementosGaleriaResultado(){
        $(".filasGalRes").remove("tr");
    }
//Calculemos
    function adicionarFilaCalculemosResultado(item){
        var markup = "<tr class=\"filasCalRes\"><td>" + item.acertadas + "</td><td>" + item.erroneas + "</td><td>" + item.tiempo + "</td><td>" + item.nivelMaximo + "</td><td>" + item.fecha + "</td></tr>";
        $("#idTablaCResultados").append(markup);
    }

    function inicializarElementosCalculemosResultado(){
        $(".filasCalRes").remove("tr");
    }
//Percepcion
    function adicionarFilaPercepcionResultado(item){
        var markup = "<tr class=\"filasPerRes\"><td>" + item.acertadas + "</td><td>" + item.erroneas + "</td><td>" + item.tiempo + "</td><td>" + item.nivelMaximo + "</td><td>" + item.fecha + "</td></tr>";
        $("#idTablaPResultados").append(markup);
    }

    function inicializarElementosPercepcionResultado(){
        $(".filasPerRes").remove("tr");
    }
//Atencion
    function adicionarFilaAtencionResultado(item){
        var markup = "<tr class=\"filasAteRes\"><td>" + item.acertadas + "</td><td>" + item.erroneas + "</td><td>" + item.tiempo + "</td><td>" + item.nivelMaximo + "</td><td>" + item.fecha + "</td></tr>";
        $("#idTablaAResultados").append(markup);
    }

    function inicializarElementosAtencionResultado(){
        $(".filasAteRes").remove("tr");
    }
//Formas 
    function adicionarFilaFormasResultado(item){
        var markup = "<tr class=\"filasForRes\"><td>" + item.acertadas + "</td><td>" + item.erroneas + "</td><td>" + item.tiempo + "</td><td>" + item.nivelMaximo + "</td><td>" + item.fecha + "</td></tr>";
        $("#idTablaFResultados").append(markup);
    }

    function inicializarElementosFormasResultado(){
        $(".filasForRes").remove("tr");
    }

var perfilPacienteSalud = (function () {
    return{
        cargarInformacionPacientes(){
            if ("undefined" === sessionStorage.getItem("id") || null === sessionStorage.getItem("id")) {
                //no inicio sesion
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "iniciarSesion.html";
            }
            else{
                //si inicio sesion
                $("#idNombreUsu").text(sessionStorage.getItem("nombres")+" "+sessionStorage.getItem("apellidos"));
                perfilPacienteSalud.cargarSolicitudes();          
            }
        },
        cargarSolicitudes(){
            var id = sessionStorage.getItem("id");
            var nombres = sessionStorage.getItem("nombres");
            var apellidos = sessionStorage.getItem("apellidos");
            var documentoIdentidad = sessionStorage.getItem("documentoIdentidad");
            var nombreUsuario = sessionStorage.getItem("nombreUsuario");
            var tipoDocumento = sessionStorage.getItem("tipoDocumento");
            var correo = sessionStorage.getItem("correo");
            var promesaConsulta = apiclientPerfilPacienteSalud.getSolicitudesPendientes(id,nombres,apellidos,documentoIdentidad,nombreUsuario,tipoDocumento,correo);
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
                    var promesaConsulta = apiclientPerfilPacienteSalud.getSolicitudesAceptadas(id,nombres,apellidos,documentoIdentidad,nombreUsuario,tipoDocumento,correo);
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
        consultarPersonalSalud(){
            var buscar = $("#idBusqueda").val();
            if(buscar===""){
                alert("Para realizar la búsqueda debe ingresar un dato");
            }
            else{
                var promesaConsulta = apiclientPerfilPacienteSalud.getBusquedaPersonalSalud(buscar);
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
        aceptarSolicitud(id, idPaciente, idFamiliar){
            var promesaConsulta = apiclientPerfilPacienteSalud.aceptarSolicitud(id, idPaciente, idFamiliar);
            promesaConsulta.then(
                function () { 
                    inicializarElementosAceptadas();
                    inicializarElementosPendientes();
                    perfilPacienteSalud.cargarSolicitudes();
                    alert("Se ha aceptado la solicitud!!");
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        rechazarSolicitud(id, idPaciente, idFamiliar){
            var promesaConsulta = apiclientPerfilPacienteSalud.eliminarSolicitud(id, idPaciente, idFamiliar);
            promesaConsulta.then(
                function () { 
                    inicializarElementosAceptadas();
                    inicializarElementosPendientes();
                    perfilPacienteSalud.cargarSolicitudes();
                    alert("Se ha rechazado la solicitud del Paciente!!");
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        eliminarRelacion(id, idPaciente, idFamiliar){
            var promesaConsulta = apiclientPerfilPacienteSalud.eliminarSolicitud(id, idPaciente, idFamiliar);
            promesaConsulta.then(
                function () { 
                    inicializarElementosAceptadas();
                    inicializarElementosPendientes();
                    perfilPacienteSalud.cargarSolicitudes();
                    alert("Se ha eliminado la relación con el Paciente");
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        adicionarRelacion(idFamiliar){
            var relacion = $("select#relacion"+idFamiliar).val();
            var idPaciente = sessionStorage.getItem("id");
            var promesaConsulta = apiclientPerfilPacienteSalud.adicionarSolicitud(idPaciente, idFamiliar, relacion);
            promesaConsulta.then(
                function () { 
                    inicializarElementosAceptadas();
                    inicializarElementosPendientes();
                    perfilPacienteSalud.cargarSolicitudes();
                    alert("Se ha enviado la solicitud");
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        buscarResultadosGaleria(){
            var fechaIni = $('#idFechaIG').val();
            var fechaFin = $('#idFechaFG').val();
            var idPac = sessionStorage.getItem("idPacienteConsultaPS");
            var tip = $("select#idComboGaleria").val();
            var promesa;
            if(fechaIni==="" || fechaIni === null){
                alert("La fecha inicial no puede ir vacia");
            }
            else if(fechaFin==="" || fechaFin === null){
                alert("La fecha final no puede ir vacia");
            }
            else if("D" === tip){
                promesa = apiclientResultados.getResultadosGaleriaDia(idPac, fechaIni, fechaFin);
            }
            else if("M" === tip){
                promesa = apiclientResultados.getResultadosGaleriaMes(idPac, fechaIni, fechaFin);
            }
            else if("A" === tip){
                promesa = apiclientResultados.getResultadosGaleriaAnual(idPac, fechaIni, fechaFin);
            }
            promesa.then(
                function (datos) { 
                    var acertadas = [];
                    var fecha = [];
                    var erroneas = [];
                    var tiempo = [];
                    var nivel = [];
                    for(var i = 0; i<datos.length; i++){
                       acertadas[i] = datos[i].acertadas;
                       fecha[i] = datos[i].fecha;
                       erroneas[i] = datos[i].erroneas;
                       tiempo[i] = datos[i].tiempo;
                       nivel[i] = datos[i].nivelMaximo;
                    }
                    inicializarElementosGaleriaResultado();
                    datos.map(adicionarFilaGaleriaResultado);
                    diagramaGaleria.cargarAcertadas(acertadas, fecha);
                    diagramaGaleria.cargarErroneas(erroneas, fecha);
                    diagramaGaleria.cargarTiempo(tiempo, fecha);
                    diagramaGaleria.cargarNivelMaximo(nivel, fecha);
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        buscarResultadosCalculemos(){
            var fechaIni = $('#idFechaIC').val();
            var fechaFin = $('#idFechaFC').val();
            var idPac = sessionStorage.getItem("idPacienteConsultaPS");
            var tip = $("select#idComboCalculo").val();
            var promesa;
            if(fechaIni==="" || fechaIni === null){
                alert("La fecha inicial no puede ir vacia");
            }
            else if(fechaFin==="" || fechaFin === null){
                alert("La fecha final no puede ir vacia");
            }
            else if("D" === tip){
                promesa = apiclientResultados.getResultadosCalculemosDia(idPac, fechaIni, fechaFin);
            }
            else if("M" === tip){
                promesa = apiclientResultados.getResultadosCalculemosMes(idPac, fechaIni, fechaFin);
            }
            else if("A" === tip){
                promesa = apiclientResultados.getResultadosCalculemosAnual(idPac, fechaIni, fechaFin);
            }
            promesa.then(
                function (datos) { 
                    var acertadas = [];
                    var fecha = [];
                    var erroneas = [];
                    var tiempo = [];
                    var nivel = [];
                    for(var i = 0; i<datos.length; i++){
                       acertadas[i] = datos[i].acertadas;
                       fecha[i] = datos[i].fecha;
                       erroneas[i] = datos[i].erroneas;
                       tiempo[i] = datos[i].tiempo;
                       nivel[i] = datos[i].nivelMaximo;
                    }
                    inicializarElementosCalculemosResultado();
                    datos.map(adicionarFilaCalculemosResultado);
                    diagramaCalculemos.cargarAcertadas(acertadas, fecha);
                    diagramaCalculemos.cargarErroneas(erroneas, fecha);
                    diagramaCalculemos.cargarTiempo(tiempo, fecha);
                    diagramaCalculemos.cargarNivelMaximo(nivel, fecha);
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        buscarResultadosPercepcion(){
            var fechaIni = $('#idFechaIP').val();
            var fechaFin = $('#idFechaFP').val();
            var idPac = sessionStorage.getItem("idPacienteConsultaPS");
            var tip = $("select#idComboPercepcion").val();
            var promesa;
            if(fechaIni==="" || fechaIni === null){
                alert("La fecha inicial no puede ir vacia");
            }
            else if(fechaFin==="" || fechaFin === null){
                alert("La fecha final no puede ir vacia");
            }
            else if("D" === tip){
                promesa = apiclientResultados.getResultadosPercepcionDia(idPac, fechaIni, fechaFin);
            }
            else if("M" === tip){
                promesa = apiclientResultados.getResultadosPercepcionMes(idPac, fechaIni, fechaFin);
            }
            else if("A" === tip){
                promesa = apiclientResultados.getResultadosPercepcionAnual(idPac, fechaIni, fechaFin);
            }
            promesa.then(
                function (datos) { 
                    var acertadas = [];
                    var fecha = [];
                    var erroneas = [];
                    var tiempo = [];
                    var nivel = [];
                    for(var i = 0; i<datos.length; i++){
                       acertadas[i] = datos[i].acertadas;
                       fecha[i] = datos[i].fecha;
                       erroneas[i] = datos[i].erroneas;
                       tiempo[i] = datos[i].tiempo;
                       nivel[i] = datos[i].nivelMaximo;
                    }
                    inicializarElementosPercepcionResultado();
                    datos.map(adicionarFilaPercepcionResultado);
                    diagramaPercepcion.cargarAcertadas(acertadas, fecha);
                    diagramaPercepcion.cargarErroneas(erroneas, fecha);
                    diagramaPercepcion.cargarTiempo(tiempo, fecha);
                    diagramaPercepcion.cargarNivelMaximo(nivel, fecha);
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        buscarResultadosAtencion(){
            var fechaIni = $('#idFechaIA').val();
            var fechaFin = $('#idFechaFA').val();
            var idPac = sessionStorage.getItem("idPacienteConsultaPS");
            var tip = $("select#idComboAtencion").val();
            var promesa;
            if(fechaIni==="" || fechaIni === null){
                alert("La fecha inicial no puede ir vacia");
            }
            else if(fechaFin==="" || fechaFin === null){
                alert("La fecha final no puede ir vacia");
            }
            else if("D" === tip){
                promesa = apiclientResultados.getResultadosAtencionDia(idPac, fechaIni, fechaFin);
            }
            else if("M" === tip){
                promesa = apiclientResultados.getResultadosAtencionMes(idPac, fechaIni, fechaFin);
            }
            else if("A" === tip){
                promesa = apiclientResultados.getResultadosAtencionAnual(idPac, fechaIni, fechaFin);
            }
            promesa.then(
                function (datos) { 
                    var acertadas = [];
                    var fecha = [];
                    var erroneas = [];
                    var tiempo = [];
                    var nivel = [];
                    for(var i = 0; i<datos.length; i++){
                       acertadas[i] = datos[i].acertadas;
                       fecha[i] = datos[i].fecha;
                       erroneas[i] = datos[i].erroneas;
                       tiempo[i] = datos[i].tiempo;
                       nivel[i] = datos[i].nivelMaximo;
                    }
                    inicializarElementosAtencionResultado();
                    datos.map(adicionarFilaAtencionResultado);
                    diagramaAtencion.cargarAcertadas(acertadas, fecha);
                    diagramaAtencion.cargarErroneas(erroneas, fecha);
                    diagramaAtencion.cargarTiempo(tiempo, fecha);
                    diagramaAtencion.cargarNivelMaximo(nivel, fecha);
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        buscarResultadosFormas(){
            var fechaIni = $('#idFechaIF').val();
            var fechaFin = $('#idFechaFF').val();
            var idPac = sessionStorage.getItem("idPacienteConsultaPS");
            var tip = $("select#idComboFormas").val();
            var promesa;
            if(fechaIni==="" || fechaIni === null){
                alert("La fecha inicial no puede ir vacia");
            }
            else if(fechaFin==="" || fechaFin === null){
                alert("La fecha final no puede ir vacia");
            }
            else if("D" === tip){
                promesa = apiclientResultados.getResultadosFormasDia(idPac, fechaIni, fechaFin);
            }
            else if("M" === tip){
                promesa = apiclientResultados.getResultadosFormasMes(idPac, fechaIni, fechaFin);
            }
            else if("A" === tip){
                promesa = apiclientResultados.getResultadosFormasAnual(idPac, fechaIni, fechaFin);
            }
            promesa.then(
                function (datos) { 
                    var acertadas = [];
                    var fecha = [];
                    var erroneas = [];
                    var tiempo = [];
                    var nivel = [];
                    for(var i = 0; i<datos.length; i++){
                       acertadas[i] = datos[i].acertadas;
                       fecha[i] = datos[i].fecha;
                       erroneas[i] = datos[i].erroneas;
                       tiempo[i] = datos[i].tiempo;
                       nivel[i] = datos[i].nivelMaximo;
                    }
                    inicializarElementosFormasResultado();
                    datos.map(adicionarFilaFormasResultado);
                    diagramaFormas.cargarAcertadas(acertadas, fecha);
                    diagramaFormas.cargarErroneas(erroneas, fecha);
                    diagramaFormas.cargarTiempo(tiempo, fecha);
                    diagramaFormas.cargarNivelMaximo(nivel, fecha);
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        }
    };
}());



