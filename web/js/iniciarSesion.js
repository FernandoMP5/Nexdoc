var iniciarSesion = {
 init: function () {

  $('#formIniciarSesion').submit(function () {
   return false;
  });
  $("input[name=Ingresar]").click(function () {
   console.log('desde init iniciar sesion'),
           iniciarSesion.validarCampos();
  });
 },
 validarCampos: function () {
  $('#formIniciarSesion').validate({
   rules: {
    txtusuario: {
     required: true
    },
    txtclave: {
     required: true
    }
   },
   messages: {
    txtusuario: {
     required: "Campo obligatorio"
    },
    txtclave: {
     required: "Campo obligatorio"
    }
   },
   submitHandler: function () {
    console.log('formulario validado'),
            iniciarSesion.validarUsuario();
   }
  });

 },
 validarUsuario: function () {
  $.ajax({
   url: 'ControladorPersona',
   type: 'post',
   data: {usuario: $("#txtusuario").val(), clave: $("#txtclave").val(), path: "/iniciarSesion"},
   datetype: 'json',
   success: function (resultado) {
    if (resultado === 2 || resultado === 3 || resultado === 4) {
     window.location.href = "inicio.jsp";
    } else{
     alert("Error");
    }
   },
   error: function (error) {
    console.warn(error);
   }
  });
 }
};
iniciarSesion.init();
