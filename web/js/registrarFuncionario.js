var registrarFuncionario = {
 init: function () {

  $('#formRegistrarFuncionario').submit(function () {
   return false;
  });
  $("input[name=Registrar]").click(function () {
   console.log('desde init registrar funcionario'),
           registrarFuncionario.validarCampos();
  });
 },
 validarCampos: function () {
  $('#formRegistrarFuncionario').validate({
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
    },
    txtusuario: {
     required: true
    },
    cborol: {
     required: true
    },
    cbooficina: {
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
    },
    txtusuario: {
     required: "Campo obligatorio"
    },
    cborol: {
     required: "Campo obligatorio"
    },
    cbooficina: {
     required: "Campo obligatorio"
    }
   },
   submitHandler: function () {
    console.log('formulario validado'),
            registrarFuncionario.registrarFuncionario();
   }
  });

 },
 registrarFuncionario: function () {
  $.ajax({
   url: 'ControladorPersona',
   type: 'post',
   data: {nombre: $("#txtnombre").val(), apellido: $("#txtapellido").val(), tipoIdentificacion: $("#cbotipoidentificacion").val(), numeroIdentificacion: $("#txtnumeroIdentificacion").val(), correo: $("#txtcorreo").val(), telefonoFijo: $("#txttelefonoFijo").val(), telefonoCelular: $("#txttelefonoCelular").val(), direccion: $("#txtdireccion").val(), usuario: $("#txtusuario").val(), rol: $("#cborol").val(), oficina: $("#cbooficina").val(), path: "/registrarFuncionario"},
   datetype: 'json',
   success: function (resultado) {
    console.log(resultado);
    if (resultado === 'true') {
     console.log("Cargando funcionarios");
     $("#contenido").load("listarFuncionarios.jsp");
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
registrarFuncionario.init();



