/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var registrarPersonalSalud = (function () {
    var nombres;
    var apellidos;
    var tipoDocumento;
    var documentoIdentidad;
    var nombreUsuario;
    var password;
    var passwordConfirmar;
    var correo;
    var rol;
    return {
        registrarPersonalSalud() {
            var valido = true;
            var passVal = true;
            var mensaje = "";
            nombres = $("#nombres").val();
            apellidos = $("#apellidos").val();
            tipoDocumento = $("select#tipoDoc").val();
            documentoIdentidad = $("#documento").val();
            correo = $("#idCorreo").val();
            nombreUsuario = $("#nombreUsuario").val();
            password = $("#password").val();
            passwordConfirmar = $("#passwordconfirmar").val();
            rol = $("select#listaRol").val();

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
            
            if (rol === "") {
                valido = false;
                mensaje = mensaje + "Rol.";
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
                    var promesa = apiclientRegistrarPersonalSalud.adicionarPersonalSalud(nombres,apellidos,tipoDocumento,documentoIdentidad,nombreUsuario,password,correo,rol); 
                    promesa.then(
                    function(){
                        alert("Se ha registrado con exito el personal de la salud!");
                        window.location.href = "iniciarSesion.html";
                    },
                    function(){
                        $("#mensajeFaltaProm").text(promesa.responseText); 
                        $("#divProm").show();
                    });
                }
            }



        }
    };
}());
