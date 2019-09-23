function listarFuncionario(numeroIdentificacion) {
 console.log("Cargando formulario actualizar funcionario");
 $("#contenido").load("registrarFuncionario.jsp");
 $.ajax({
  url: 'ControladorPersona',
  type: 'post',
  data: {numeroIdentificacion: numeroIdentificacion, path: "/seleccionarFuncionario"},
  success: function (resultado) {
   alert(resultado.numeroIdentificacion,resultado.nombre);
   $("#titulo").load("Actualizar Funcionario");
//   $("input[name=txtnombre]").val(nombre);
//   $("input[name=txtapellido]").val(resultado);
//   $("input[name=cbotipoidentificacion]").val(resultado);
//   $("input[name=txtnumeroIdentificacion]").val(resultado);
//   $("input[name=Modificar]").click(function () {
//    console.log('desde init actualizar funcionario'),
//            actualizarFuncionario.validarCampos();
//   });
  }
 });
}
var actualizarFuncionario = {
 init: function () {

  $('#formRegistrarFuncionario').submit(function () {
   return false;
  });
  $("input[name=Modificar]").click(function () {
   console.log('desde init actualizar funcionario'),
           actualizarFuncionario.validarCampos();
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
            actualizarFuncionario.actualizarFuncionario();
   }
  });

 },
 actualizarFuncionario: function () {
  $.ajax({
   url: 'ControladorPersona',
   type: 'post',
   data: {nombre: $("#txtnombre").val(), apellido: $("#txtapellido").val(), tipoIdentificacion: $("#cbotipoidentificacion").val(), numeroIdentificacion: $("#numeroIdentificacion").val(), correo: $("#txtcorreo").val(), telefonoFijo: $("#txttelefonoFijo").val(), telefonoCelular: $("#txttelefonoCelular").val(), direccion: $("#txtdireccion").val(), usuario: $("#txtusuario").val(), rol: $("#cborol").val(), oficina: $("#cbooficina").val(), path: "/actualizarFuncionario"},
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
actualizarFuncionario.init();


