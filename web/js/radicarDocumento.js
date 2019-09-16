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
    documento:{
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
    documento:{
     required: "Campo obligatorio"
    }
   },
   submitHandler: function () {
    console.log('formulario validado'),
            radicarDocumento.radicarDocumento();
   }
  });
  $('#formRadicarDocumento').submit();

 },
 radicarDocumento: function () {
  $.ajax({
   url: 'ControladorDocumento',
   type: 'post',
   data: {idRemitente: $("#listarRemitentes").val(), idOficina: $("#listarOficinas").val(), idDestinatario: $("#listarFuncionarios").val(), tipoDocumento: $("#cboTipoDocumento").val(), prioridad: $("cboPrioridad").val(), documento: $("#documento").val(),path: "/radicarDocumento"},
   datetype: 'json',
   success: function (resultado) {
    alert(resultado);
   },
   error: function (error) {
    console.warn(error);
   }
  });
 }
};
radicarDocumento.init();

