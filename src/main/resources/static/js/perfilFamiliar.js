/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    function adicionarFilaPendientes(item){
        var markup = "<tr class=\"filasP\"><td>" + item.id + "</td><td>" + item.nombresPaciente + "</td><td>" + item.apellidosPaciente + "</td><td>" + item.relacion + "</td><td><button type=\"button\" class=\"btn btn-success\" onclick=\"perfilFamiliar.aceptarSolicitud("+item.id+", "+item.idPaciente+", "+item.idFamiliar+")\">Aceptar</button><button type=\"button\" class=\"btn btn-danger\" onclick=\"perfilFamiliar.rechazarSolicitud("+item.id+", "+item.idPaciente+", "+item.idFamiliar+")\">Rechazar</button></td></tr>";
        $("#tablaPendientes").append(markup);
    }

    function inicializarElementosPendientes(){
        $(".filasP").remove("tr");
    }
    
    function adicionarFilaAceptadas(item){
        var markup = "<tr class=\"filasA\"><td>" + item.id + "</td><td>" + item.nombresPaciente + "</td><td>" + item.apellidosPaciente + "</td><td>" + item.relacion + "</td><td><button type=\"button\" class=\"btn btn-primary\" onclick=\"\">Consultar</button><button type=\"button\" class=\"btn btn-danger\" onclick=\"perfilFamiliar.eliminarRelacion("+item.id+", "+item.idPaciente+", "+item.idFamiliar+")\">Eliminar</button></td></tr>";
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
        }
    };
}());



