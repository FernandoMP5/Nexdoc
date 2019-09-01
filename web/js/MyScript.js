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
  $('#VistaDoc').click(function () {
    console.log("Cargando documento");
    $("#contenido").load("vistaDocumento.jsp");
  });
});


$("input[name=Ingresar]").click(function () {
  $.ajax({
    method: "post",
    url: 'ControladorPersona',
    data: {usuario: $("#txtusuario").val(), clave: $("#txtclave").val(), accion: $("#btningresar").val()}
  })
          .done(function (result) {
            $("login.jsp").html(result);
          });
});

listarFuncionariosPorOficina();
function listarFuncionariosPorOficina() {
  $.ajax({
    method: "post",
    url: "ControladorPersona",
    data: {idOficina: $("#cbooficina").val(), accion: $("listar")}
  })
          .done(function (result) {
            $("#cbodestinatario").html(result);
          });
}