$(document).ready(function () {
    $('#Recibidos').click(function () {
        console.log("Cargando recibidos");
        $("#contenido").load("recibidos.jsp");
    });
    $('#ListarOfi').click(function () {
        console.log("Cargando oficinas");
        $("#contenido").load("listaroficinas.jsp");
    });
    $('#ListarFun').click(function () {
        console.log("Cargando funcionarios");
        $("#contenido").load("listarFuncionario.jsp");
    });
    $('#VistaDoc').click(function () {
        console.log("Cargando documento");
        $("#contenido").load("vistaDocumento.jsp");
    });
});


