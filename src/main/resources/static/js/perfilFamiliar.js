/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    /* global apiclientResultados, diagramaGaleria, diagramaCalculemos */

function adicionarFilaPendientes(item){
        var markup = "<tr class=\"filasP\"><td>" + item.id + "</td><td>" + item.nombresPaciente + "</td><td>" + item.apellidosPaciente + "</td><td>" + item.relacion + "</td><td><button type=\"button\" class=\"btn btn-success\" onclick=\"perfilFamiliar.aceptarSolicitud("+item.id+", "+item.idPaciente+", "+item.idFamiliar+")\">Aceptar</button><button type=\"button\" class=\"btn btn-danger\" onclick=\"perfilFamiliar.rechazarSolicitud("+item.id+", "+item.idPaciente+", "+item.idFamiliar+")\">Rechazar</button></td></tr>";
        $("#tablaPendientes").append(markup);
    }

    function inicializarElementosPendientes(){
        $(".filasP").remove("tr");
    }
    
    function adicionarFilaAceptadas(item){
        var markup = "<tr class=\"filasA\"><td>" + item.id + "</td><td>" + item.nombresPaciente + "</td><td>" + item.apellidosPaciente + "</td><td>" + item.relacion + "</td><td><button type=\"button\" class=\"btn btn-primary\" onclick=\"perfilFamiliar.irAConsultarPaciente("+item.idPaciente+",' "+item.nombresPaciente +" "+item.apellidosPaciente+"',' "+item.relacion+"')\">Consultar</button><button type=\"button\" class=\"btn btn-danger\" onclick=\"perfilFamiliar.eliminarRelacion("+item.id+", "+item.idPaciente+", "+item.idFamiliar+")\">Eliminar</button></td></tr>";
        $("#tablaAceptadas").append(markup);
    }

    function inicializarElementosAceptadas(){
        $(".filasA").remove("tr");
    }
    
    function adicionarFilaBusqueda(item){
        console.info(item);
        var markup = "<tr class=\"filasB\"><td>" + item.id + "</td><td>" + item.nombreUsuario + "</td><td>" + item.nombres + "</td><td>" + item.apellidos + "</td><td><select class=\"form-control\" id=\"relacion"+item.id+"\"><option>Padres</option><option>Tios</option><option>Hermanos</option><option>Abuelos</option><option selected>Sobrinos</option><option selected>Otros</option></select></td><td><button type=\"button\" class=\"btn btn-success\" onclick=\"perfilFamiliar.adicionarRelacion("+item.id+")\">Agregar</button></td></tr>";
        $("#idTablaBusqueda").append(markup);
    }

    function inicializarElementosBusqueda(){
        $(".filasB").remove("tr");
    }
    
    function adicionarFilaMensajes(item){
        var markup = "<tr class=\"filasMen\"><td>" + item.id + "</td><td>" + item.fecha + "</td><td>" + item.mensaje + "</td><td>" + item.tipo + "</td><td>" + item.nombreRemitente + "</td><td>" + item.rol + "</td><td><input type=\"checkbox\" disabled  "+item.checkBox+"></td></tr>";
        $("#tablaMensajes").append(markup);
    }

    function inicializarElementosMensajes(){
        $(".filasMen").remove("tr");
    }
    
    
    function adicionarFilaHistorialMedico(item){
        var markup = "<tr class=\"filasHM\"><td>" + item.id + "</td><td>" + item.enfermedad.codigo + "</td><td>" + item.enfermedad.nombre + "</td><td>" + item.fecha + "</td><td>" + item.nombresPersonalSalud + "</td><td>" + item.rol + "</td></tr>";
        $("#idTablaHistorialM").append(markup);
    }

    function inicializarElementosHistorialMedico(){
        $(".filasHM").remove("tr");
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
var perfilFamiliar = (function () {
    return{    
        init(){
            if ("undefined" === sessionStorage.getItem("id") || null === sessionStorage.getItem("id")) {
                //no inicio sesion
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "iniciarSesion.html";
            }else{
                 //si6 inicio sesion
                $("#idNombreUsu").text(sessionStorage.getItem("nombres")+" "+sessionStorage.getItem("apellidos"));
                
                $("#nombre").val(sessionStorage.getItem("nombres"));
                $("#apellido").val(sessionStorage.getItem("apellidos"));
                $("#documento").val(sessionStorage.getItem("documentoIdentidad"));
                $("#usuario").val(sessionStorage.getItem("nombreUsuario"));
                $("#correo").val(sessionStorage.getItem("correo"));
                $('select[name="tipoDocu"]').val(sessionStorage.getItem("tipoDocumento"));
            }
        },
        cargarInformacionFamiliares(){
            if ("undefined" === sessionStorage.getItem("id") || null === sessionStorage.getItem("id")) {
                //no inicio sesion
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "iniciarSesion.html";
            }
            else{
                //si inicio sesion
                $("#idNombreUsu").text(sessionStorage.getItem("nombres")+" "+sessionStorage.getItem("apellidos"));
                perfilFamiliar.cargarSolicitudes();          
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
            var promesaConsulta = apiclientPerfilFamiliar.getSolicitudesPendientes(id,nombres,apellidos,documentoIdentidad,nombreUsuario,tipoDocumento,correo);
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
                    var promesaConsulta = apiclientPerfilFamiliar.getSolicitudesAceptadas(id,nombres,apellidos,documentoIdentidad,nombreUsuario,tipoDocumento,correo);
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
        consultarPacientes(){
            var buscar = $("#idBusqueda").val();
            if(buscar===""){
                alert("Para realizar la búsqueda debe ingresar un dato");
            }
            else{
                var promesaConsulta = apiclientPerfilFamiliar.getBusquedaPacientes(buscar);
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
            var promesaConsulta = apiclientPerfilFamiliar.aceptarSolicitud(id, idPaciente, idFamiliar);
            promesaConsulta.then(
                function () { 
                    inicializarElementosAceptadas();
                    inicializarElementosPendientes();
                    perfilFamiliar.cargarSolicitudes();
                    alert("Se ha aceptado la solicitud!!");
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        rechazarSolicitud(id, idPaciente, idFamiliar){
            var promesaConsulta = apiclientPerfilFamiliar.eliminarSolicitud(id, idPaciente, idFamiliar);
            promesaConsulta.then(
                function () { 
                    inicializarElementosAceptadas();
                    inicializarElementosPendientes();
                    perfilFamiliar.cargarSolicitudes();
                    alert("Se ha rechazado la solicitud del Paciente!!");
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        eliminarRelacion(id, idPaciente, idFamiliar){
            var promesaConsulta = apiclientPerfilFamiliar.eliminarSolicitud(id, idPaciente, idFamiliar);
            promesaConsulta.then(
                function () { 
                    inicializarElementosAceptadas();
                    inicializarElementosPendientes();
                    perfilFamiliar.cargarSolicitudes();
                    alert("Se ha eliminado la relación con el Paciente");
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        adicionarRelacion(idPaciente){
            var relacion = $("select#relacion"+idPaciente).val();
            var idFamiliar = sessionStorage.getItem("id");
            var promesaConsulta = apiclientPerfilFamiliar.adicionarSolicitud(idPaciente, idFamiliar, relacion);
            promesaConsulta.then(
                function () { 
                    inicializarElementosAceptadas();
                    inicializarElementosPendientes();
                    perfilFamiliar.cargarSolicitudes();
                    alert("Se ha enviado la solicitud");
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        irAConsultarPaciente(idPaciente, nombrePaciente, rol){
            sessionStorage.setItem("idPacienteConsultaPS", idPaciente);
            sessionStorage.setItem("nombrePacienteConsultaPS", nombrePaciente);
            sessionStorage.setItem("rolMensaje", rol);
            window.location.href = "perfilFamiliarConsultarFamiliares.html";
        },
        initConsultarPaciente(){
            if ("undefined" === sessionStorage.getItem("id") || null === sessionStorage.getItem("id")) {
                //no inicio sesion
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "iniciarSesion.html";
            }else{
                if ("undefined" === sessionStorage.getItem("idPacienteConsultaPS") || null === sessionStorage.getItem("idPacienteConsultaPS")) {
                    alert("Para esta función, debe seleccionar un paciente.");
                    window.location.href = "perfilPersonalSaludPaciente.html";
                }
                else{
                    $("#idNombreUsu").text(sessionStorage.getItem("nombres")+" "+sessionStorage.getItem("apellidos"));
                    $("#idNombrePaciente").text(sessionStorage.getItem("nombrePacienteConsultaPS"));
                    perfilFamiliar.cargarMensajes();
                    //Cargar Historial Medico
                    perfilFamiliar.cargarHistorialMedico();
                    
                }
            }
        },
        cargarMensajes(){
            var promesaConsulta = apiclientPerfilFamiliar.getTodosMensajes(sessionStorage.getItem("idPacienteConsultaPS"));
            promesaConsulta.then(
                function (datos) { 
                    console.info(datos)
                    inicializarElementosMensajes();
                    datos.map(adicionarFilaMensajes);
                },
                function (dato) {
                    alert(dato.responseText);
                }
            );
        },
        cargarHistorialMedico(){
            var idPaciente = sessionStorage.getItem("idPacienteConsultaPS");
            var promesaConsulta = apiclientPerfilFamiliar.getHistorialMedico(idPaciente);
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
        initEnviarMensaje(){
            if ("undefined" === sessionStorage.getItem("id") || null === sessionStorage.getItem("id")) {
                //no inicio sesion
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "iniciarSesion.html";
            }else{
                if ("undefined" === sessionStorage.getItem("idPacienteConsultaPS") || null === sessionStorage.getItem("idPacienteConsultaPS")) {
                    alert("Para esta función, debe seleccionar un paciente.");
                    window.location.href = "perfilFamiliarPaciente.html";
                }
                else{
                    $("#idNombreUsu").text(sessionStorage.getItem("nombres")+" "+sessionStorage.getItem("apellidos"));
                    $("#idNombrePaciente").text(sessionStorage.getItem("nombrePacienteConsultaPS"));
                }
            }
        },
        enviarMensaje(){
            var idPaciente = sessionStorage.getItem("idPacienteConsultaPS");
            var idFamiliar = sessionStorage.getItem("id");
            var fecha = $("#fecha").val();
            var mensaje = $("#mensaje").val();
            var tipo = "Familiar";
            var rol = sessionStorage.getItem("rolMensaje");
            var puedeVerPaciente = "N";
            if($('#puedeVerPaciente').is(':checked')===true){
                puedeVerPaciente = "S";
            }
            
            
            if(fecha==="" || fecha === null){
                alert("La fecha no puede ir vacia");
            }
            else if(mensaje==="" || mensaje === null){
                alert("El mensaje no puede ir vacio!");
            }
            else{
                var promesaConsulta = apiclientPerfilFamiliar.enviarMensaje(idPaciente, idFamiliar, fecha, mensaje, tipo, rol, puedeVerPaciente,"", "");
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
        initPersonalizarGaleria(){
            if ("undefined" === sessionStorage.getItem("id") || null === sessionStorage.getItem("id")) {
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "iniciarSesion.html";
            }else{
                if ("undefined" === sessionStorage.getItem("idPacienteConsultaPS") || null === sessionStorage.getItem("idPacienteConsultaPS")) {
                    alert("Para esta función, debe seleccionar un paciente.");
                    window.location.href = "perfilFamiliarFamiliares.html";
                }
                else{
                    $("#idNombreUsu").text(sessionStorage.getItem("nombres")+" "+sessionStorage.getItem("apellidos"));
                    console.info(sessionStorage.getItem("nombrePacienteConsultaPS"));
                    $("#idNombrePaciente").text(sessionStorage.getItem("nombrePacienteConsultaPS"));
                    appGaleria.cargarParaEditar();
                }
            }
        },
        initPersonalizarAtencion(){
            if ("undefined" === sessionStorage.getItem("id") || null === sessionStorage.getItem("id")) {
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "iniciarSesion.html";
            }else{
                if ("undefined" === sessionStorage.getItem("idPacienteConsultaPS") || null === sessionStorage.getItem("idPacienteConsultaPS")) {
                    alert("Para esta función, debe seleccionar un paciente.");
                    window.location.href = "perfilFamiliarFamiliares.html";
                }
                else{
                    $("#idNombreUsu").text(sessionStorage.getItem("nombres")+" "+sessionStorage.getItem("apellidos"));
                    console.info(sessionStorage.getItem("nombrePacienteConsultaPS"));
                    $("#idNombrePaciente").text(sessionStorage.getItem("nombrePacienteConsultaPS"));
                    appAtencion.cargarParaEditar();
                }
            }
        },
        initPersonalizarCalculemos(){
            if ("undefined" === sessionStorage.getItem("id") || null === sessionStorage.getItem("id")) {
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "iniciarSesion.html";
            }else{
                if ("undefined" === sessionStorage.getItem("idPacienteConsultaPS") || null === sessionStorage.getItem("idPacienteConsultaPS")) {
                    alert("Para esta función, debe seleccionar un paciente.");
                    window.location.href = "perfilFamiliarFamiliares.html";
                }
                else{
                    $("#idNombreUsu").text(sessionStorage.getItem("nombres")+" "+sessionStorage.getItem("apellidos"));
                    console.info(sessionStorage.getItem("nombrePacienteConsultaPS"));
                    $("#idNombrePaciente").text(sessionStorage.getItem("nombrePacienteConsultaPS"));
                    appCalculemos.cargarParaEditar();
                }
            }
        },
        initPersonalizarFormas(){
            if ("undefined" === sessionStorage.getItem("id") || null === sessionStorage.getItem("id")) {
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "iniciarSesion.html";
            }else{
                if ("undefined" === sessionStorage.getItem("idPacienteConsultaPS") || null === sessionStorage.getItem("idPacienteConsultaPS")) {
                    alert("Para esta función, debe seleccionar un paciente.");
                    window.location.href = "perfilFamiliarFamiliares.html";
                }
                else{
                    $("#idNombreUsu").text(sessionStorage.getItem("nombres")+" "+sessionStorage.getItem("apellidos"));
                    console.info(sessionStorage.getItem("nombrePacienteConsultaPS"));
                    $("#idNombrePaciente").text(sessionStorage.getItem("nombrePacienteConsultaPS"));
                    appFormas.cargarParaEditar();
                }
            }
        },
        initPersonalizarPercepcion(){
            if ("undefined" === sessionStorage.getItem("id") || null === sessionStorage.getItem("id")) {
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "iniciarSesion.html";
            }else{
                if ("undefined" === sessionStorage.getItem("idPacienteConsultaPS") || null === sessionStorage.getItem("idPacienteConsultaPS")) {
                    alert("Para esta función, debe seleccionar un paciente.");
                    window.location.href = "perfilFamiliarFamiliares.html";
                }
                else{
                    $("#idNombreUsu").text(sessionStorage.getItem("nombres")+" "+sessionStorage.getItem("apellidos"));
//                    console.info(sessionStorage.getItem("nombrePacienteConsultaPS"));
                    $("#idNombrePaciente").text(sessionStorage.getItem("nombrePacienteConsultaPS"));
                    appPercepcion.cargarParaEditar();
                }
            }
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
        }
        
    };
}());



