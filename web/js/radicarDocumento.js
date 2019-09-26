function seleccionarRemitente(idRemitente) {
 $.ajax({
  url: 'ControladorDocumento',
  data: {idRemitente: idRemitente, path: "/seleccionarRemitente"},
  type: 'post',
  datetype: 'json',
  success: function (resultado) {
   $('input[name=txtRemitente]').val(resultado.nombre + " " + resultado.apellido);
   $("input[name='idRemitente']").val(resultado.numeroIdentificacion);
  }
 });
}
function seleccionarOficina(idOficina) {
 $.ajax({
  url: 'ControladorDocumento',
  data: {idOficina: idOficina, path: "/seleccionarOficina"},
  type: 'post',
  datetype: 'json',
  success: function (resultado) {
   $("input[name='txtOficina']").val(resultado.nombreOficina);
   $("input[name='idOficina']").val(resultado.idOficina);
  }
 });
}
function seleccionarDestinatario(idDestinatario) {
 $.ajax({
  url: 'ControladorDocumento',
  data: {idDestinatario: idDestinatario, path: "/seleccionarDestinatario"},
  type: 'post',
  datetype: 'json',
  success: function (resultado) {
   $("input[name='txtDestinatario']").val(resultado.nombre + " " + resultado.apellido);
   $("input[name='idDestinatario']").val(resultado.numeroIdentificacion);
  }
 });
}
var radicarDocumento = {
 init: function () {

  $('#formRadicarDocumento').submit(function () {
   return false;
  });
  $("input[name=Enviar]").click(function () {
   console.log('Radicar Documento'),
           radicarDocumento.validarCampos();
  });
 },
 validarCampos: function () {
  $('#formRadicarDocumento').validate({
   rules: {
    txtRemitente: {
     required: true
    },
    txtOficina: {
     required: true
    },
    txtDestinatario: {
     required: true
    },
    cboTipoDocumento: {
     required: true
    },
    cboPrioridad: {
     required: true
    },
    documento: {
     required: true
    }
   },
   messages: {
    txtRemitente: {
     required: "Campo obligatorio"
    },
    txtOficina: {
     required: "Campo obligatorio"
    },
    txtDestinatario: {
     required: "Campo obligatorio"
    },
    cboTipoDocumento: {
     required: "Campo obligatorio"
    },
    cboPrioridad: {
     required: "Campo obligatorio"
    },
    documento: {
     required: "Campo obligatorio"
    }
   },
   submitHandler: function () {
    console.log('formulario validado'),
            radicarDocumento.radicarDocumento();
   }
  });
 },
 radicarDocumento: function () {
  $(function () {
   var formData = new FormData(document.getElementById("formRadicarDocumento"));
   $.ajax({
    url: 'ControladorDocumento',
    type: 'post',
    datetype: 'json',
    data: formData,
    cache: false,
    contentType: false,
    processData: false,
    success: function (resultado) {
     console.log(resultado);
     if (resultado === true) {
//      $("#modalRespuesta").modal('show');
//      $("#titulo").html('Envio Exitoso');
//      $(".modal-body").html("<textarea id='respuestaComen'></textarea>");
//      $("#respuestaComen").css({'width': '299px'});
//      $("#respuestaComen").css({'height': '170px'});
//      $("#respuestaComen").css({'border': 'none'});
//      $("#respuestaComen").css({'background': '#fff'});
//      $("#cboPrioridad").css({'display': 'none'});
//      $("#cboTipoDocumento").css({'display': 'none'});
//      $("#modal-footer").css({'height': '70px'});
      $("#modalRadicacion").hide();
      console.log("Cargando enviados");
      $("#contenido").load("listarEnviados.jsp");
     }
    },
    error: function (error) {
     console.warn(error);
    }
   });
  });
 }
}
radicarDocumento.init();


//  formData.append("documento", "documento");
//formData.append(f.attr("name"), $(this)[0].files[0]);


//   data: {idRemitente: $("#idRemitente").val(), idOficina: $("#idOficina").val(), idDestinatario: $("#idDestinatario").val(), tipoDocumento: $("#cboTipoDocumento").val(), prioridad: $("#cboPrioridad").val(), documento: formData, path: "/radicarDocumento"},

