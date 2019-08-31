$(document).ready(function () {
  $('#listarRecibidos').click(function () {
    console.log("Cargando recibidos");
    $("#contenido").load("listarRecibidos.jsp");
  });
  $('#listarOficina').click(function () {
    console.log("Cargando oficinas");
    $("#contenido").load("listarO ficinas.jsp");
  });
  $('#listarFuncionario').click(function () {
    console.log("Cargando funcionarios");
    $("#contenido").load("listarFuncionario.jsp");
  });
  $('#listarRemitente').click(function () {
    console.log("Cargando remitentes");
    $("#contenido").load("listarRemitentes.jsp");
  });
  $('#VistaDoc').click(function () {
    console.log("Cargando documento");
    $("#contenido").load("vistaDocumento.jsp");
  });
});
function validar() {
  $.ajax({
    method: "post",
    url: 'ControladorPersona',
    data: {usuario: $("input[name='txtusuario']").val(), clave: $("input[name='txtclave']"), accion: $("Ingresar")},
    type: 'post'
  });
}
//function controlador() {
//  $.ajax({
//    method: "post",
//    url: "Controlador",
//    data: {correo: $("#txtcorreo").val(), asunto: $("#txtasunto").val(), descripcion: $("#txtdescripcion").val()}
//  })
//          .done(function (result) {
//            $("#interesados").html(result);
//          });
//}