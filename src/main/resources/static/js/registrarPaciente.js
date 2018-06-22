/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var registrarPaciente = (function () {
    var nombres;
    var apellidos;
    var tipoDocumento;
    var documentoIdentidad;
    var fechaNacimiento;
    var genero;
    var pais;
    var ciudad;
    var nombreUsuario;
    var password;
    var passwordConfirmar;
    var direccion;
    var correo;
    return {
        registrarPaciente() {
            var valido = true;
            var passVal = true;
            var mensaje = "";
            nombres = $("#nombres").val();
            apellidos = $("#apellidos").val();
            tipoDocumento = $("select#tipoDoc").val();
            documentoIdentidad = $("#documento").val();
            fechaNacimiento = $("#fechaNacimiento").val();
            genero = $("select#genero").val();
            pais = $("#idPais").val();
            ciudad = $("#idCiudad").val();
            direccion = $("#idDireccion").val();
            correo = $("#idCorreo").val();
            nombreUsuario = $("#nombreUsuario").val();
            password = $("#password").val();
            passwordConfirmar = $("#passwordconfirmar").val();

            if (nombres === "") {
                valido = false;
                mensaje = "Nombres.";
            }

            if (apellidos === "") {
                valido = false;
                mensaje = mensaje + "Apellidos.";
            }

            if (tipoDocumento === "") {
                valido = false;
                mensaje = mensaje + "Tipo de Documento.";
            }

            if (documentoIdentidad === "") {
                valido = false;
                mensaje = mensaje + "Documento de Identidad.";
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

            if (correo === "") {
                valido = false;
                mensaje = mensaje + "Correo.";
            }

            if (nombreUsuario === "") {
                valido = false;
                mensaje = mensaje + "Nombre de usuario.";
            }

            if (password === "") {
                valido = false;
                mensaje = mensaje + "Contraseña.";
            }

            if (passwordConfirmar === "") {
                valido = false;
                mensaje = mensaje + "Confirmacion contraseña.";
            }


            if (password !== passwordConfirmar) {
                passVal = false;
            }

            if (!valido) {
                $("#mensajeFalta").text(mensaje);
                $("#divError").show();
            } else {
                if (!passVal) {
                    $("#divPass").show();
                } else {
                    $("#botonRegistro").attr('disabled', true);
                    var promesa = apiclientRegistrarPaciente.adicionarPaciente(nombres,apellidos,tipoDocumento,documentoIdentidad,fechaNacimiento,genero,pais,ciudad,nombreUsuario,password,direccion,correo); 
                    promesa.then(
                    function(){
                        alert("Se ha registrado con exito el paciente!");
                        window.location.href = "iniciarSesion.html";
                        $("#botonRegistro").attr('disabled', false);
                    },
                    function(){
                        $("#mensajeFaltaProm").text(promesa.responseText); 
                        $("#divProm").show();
                        $("#botonRegistro").attr('disabled', false);
                    });
                }
            }



        }
    };
}());
