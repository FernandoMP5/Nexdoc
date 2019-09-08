$(document).ready(function () {
 console.log("Cargando recibidos");
 $("#contenido").load("listarRecibidos.jsp");
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
 $('#listarRecibidos').click(function () {
  console.log("Cargando recibidos");
  $("#contenido").load("listarRecibidos.jsp");
 });
 $('#listarEnviados').click(function () {
  console.log("Cargando enviados");
  $("#contenido").load("listarEnviados.jsp");
 });
});

$("tr[name=idDocumento]").click(function () {
 $.ajax({
  method: "post",
  url: 'ControladorDocumento',
  data: {idDocumento: $("#idDocumento").val(), accion: "Mostrar"}
 })
         .done(function (result) {
          console.log("Cargando documento seleccionado");
          $("#contenido").html(result);
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