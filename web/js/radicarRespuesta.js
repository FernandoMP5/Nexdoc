$('#respuesta').click(function () {
 console.log("Cargando formulario radicar respuesta");
 $("#modalRespuesta").modal('show');
});
var radicarRespuesta = {
 init: function () {
  $('#formRadicarRespuesta').submit(function () {
   return false;
  });
  $("input[name=Enviar]").click(function () {
   console.log('Radicar Respuesta'),
           radicarRespuesta.validarCampos();
  });
 },
 validarCampos: function () {
  $('#formRadicarRespuesta').validate({
   rules: {
    respuestaComen: {
     required: true
    },
    proceso: {
     required: true
    },
    documento: {
     required: true
    }
   },
   messages: {
    respuestaComen: {
     required: "Campo obligatorio"
    },
    proceso: {
     required: "Campo obligatorio"
    },
    documento: {
     required: "Campo obligatorio"
    }
   },
   submitHandler: function () {
    console.log('formulario validado'),
            radicarRespuesta.radicarRespuesta();
   }
  });
 },
 radicarRespuesta: function () {
  $(function () {
   var formData = new FormData(document.getElementById("formRadicarRespuesta"));
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
      $("#modalRespuesta").hide();
     }
    },
    error: function (error) {
     console.warn(error);
    }
   });
  });
 }
};
radicarRespuesta.init();