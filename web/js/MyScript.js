$(document).ready(function () {
 $('#listarRecibidos').click(function () {
  console.log("Cargando recibidos");
  $("#contenido").load("listarRecibidos.jsp");
 });
 $('#listarOficinas').click(function () {
  console.log("Cargando oficinas");
  $("#contenido").load("listarOficinas.jsp");
 });
 $('#listarFuncionarios').click(function () {
  console.log("Cargando funcionarios");
  $("#contenido").load("listarFuncionarios.jsp");
 });
 $('#listarRemitentes').click(function () {
  console.log("Cargando remitentes");
  $("#contenido").load("listarRemitentes.jsp");
 });
  $('#documento').click(function () {
    console.log("Cargando documento");
    $("#contenido").load("http://localhost:8086/Nexdoc/pdf?idDocumento=2");
  });
});

















//$("input[name=Ingresar]").click(function () {
// $.ajax({
//  method: "post",
//  url: 'ControladorPersona',
//  data: {usuario: $("#txtusuario").val(), clave: $("#txtclave").val(), accion: $("#btningresar").val()}
// })
//         .done(function (result) {
//          $("login.jsp").html(result);
//         });
//});
//
//$("input[name=idDocumento]").click(function () {
// $.ajax({
//  method: "post",
//  url: 'pdf',
//  data: {idDocumento: $("#idDocumento").val()}
// })
//         .done(function (result) {
//          console.log("Cargando documento seleccionado");
//          $("#contenido").load(result);
//         });
//});
//listarFuncionariosPorOficina();
//function listarFuncionariosPorOficina() {
//  $.ajax({
//    method: "post",
//    url: "ControladorPersona",
//    data: {idOficina: $("#cbooficina").val(), accion: $("listar")}
//  })
//          .done(function (result) {
//            $("#cbodestinatario").html(result);
//          });
//}