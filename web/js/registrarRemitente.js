var registrarRemitente = {
 init: function () {

  $('#formRegistrarPersona').submit(function () {
   return false;
  });
  $("input[name=Registrar]").click(function () {
   console.log('desde init registrar Remitente'),
           registrarRemitente.validarCampos();
  });
 },
 validarCampos: function () {
  $('#formRegistrarPersona').validate({
   rules: {
    txtnombre: {
     required: true
    },
    txtapellido: {
     required: true
    },
    cbotipoidentificacion: {
     required: true
    },
    txtnumeroIdentificacion: {
     required: true
    },
    txtcorreo: {
     required: true
    },
    txttelefonoFijo: {
     required: true
    },
    txttelefonoCelular: {
     required: true
    },
    txtdireccion: {
     required: true
    }
   },
   messages: {
    txtnombre: {
     required: "Campo obligatorio"
    },
    txtapellido: {
     required: "Campo obligatorio"
    },
    cbotipoidentificacion: {
     required: "Campo obligatorio"
    },
    txtnumeroIdentificacion: {
     required: "Campo obligatorio"
    },
    txtcorreo: {
     required: "Campo obligatorio"
    },
    txttelefonoFijo: {
     required: "Campo obligatorio"
    },
    txttelefonoCelular: {
     required: "Campo obligatorio"
    },
    txtdireccion: {
     required: "Campo obligatorio"
    }
   },
   submitHandler: function () {
    console.log('formulario validado'),
            registrarRemitente.registrarRemitente();
   }
  });

 },
 registrarRemitente: function () {
  $.ajax({
   url: 'ControladorPersona',
   type: 'post',
   data: {nombre: $("#txtnombre").val(), apellido: $("#txtapellido").val(), tipoIdentificacion: $("#cbotipoidentificacion").val(), numeroIdentificacion: $("#txtnumeroIdentificacion").val(), correo: $("#txtcorreo").val(), telefonoFijo: $("#txttelefonoFijo").val(), telefonoCelular: $("#txttelefonoCelular").val(), direccion: $("#txtdireccion").val(), path: "/registrarRemitente"},
   datetype: 'json',
   success: function (resultado) {
    console.log(resultado);
    if (resultado === 'true') {
     console.log("Cargando remitentes");
     $("#contenido").load("listarRemitentes.jsp");
    } else {
     alert("Error");
    }
   },
   error: function (error) {
    console.warn(error);
   }
  });
 }
};
registrarRemitente.init();



