$(document).ready(function () {
 $('#radicar').click(function () {
  console.log("Cargando formulario radicar");
  $("#contenido").load("radicarDocumento.jsp");
 });
 $('#listarFuncionarios').click(function () {
  console.log("Cargando funcionarios");
  $("#contenido").load("listarFuncionarios.jsp");
 });
 $('#listarRemitentes').click(function () {
  console.log("Cargando remitentes");
  $("#contenido").load("listarRemitentes.jsp");
 });
 $('#listarOficinas').click(function () {
  console.log("Cargando Oficinas");
  $("#contenido").load("listarOficinas.jsp");
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


function mostrarPDF(idDocumento) {
 $.ajax({
  method: "post",
  url: 'ControladorDocumento',
  data: {idDocumento: idDocumento, path: "/seleccionarDocumento"}
 })
         .done(function (result) {
          console.log("Cargando documento seleccionado");
          $("#contenido").html(result);
         });
}
;