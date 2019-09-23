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
  $('#formRadicarDocumento').submit();
 }
};
$(function () {
 $("#formRadicarDocumento").on("submit", function (e) {
  e.preventDefault();
  var f = $(this);
  var formData = getFormData(document.getElementById("formRadicarDocumento"));
  $.ajax({
   url: 'ControladorDocumento',
   type: 'post',
   datetype: 'json',
   data: {formData, path: "/radicarDocumento"},
   cache: false,
   contentType: false,
   processData: false,
   success: function (resultado) {
    alert(resultado);
   },
   error: function (error) {
    console.warn(error);
   }
  });
 });
});
radicarDocumento.init();


//  formData.append("documento", "documento");
//formData.append(f.attr("name"), $(this)[0].files[0]);


//   data: {idRemitente: $("#idRemitente").val(), idOficina: $("#idOficina").val(), idDestinatario: $("#idDestinatario").val(), tipoDocumento: $("#cboTipoDocumento").val(), prioridad: $("#cboPrioridad").val(), documento: formData, path: "/radicarDocumento"},

