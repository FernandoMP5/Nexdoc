<%-- 
    Document   : inicioRecpcionista
    Created on : 11/09/2019, 01:10:19 AM
    Author     : Familia Moreno
--%>

<%@page import="co.edu.sena.Nexdoc.persistencia.vo.oficinaVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.vo.tipoDocumentoVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.personaDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.vo.personaVO"%>
<%@page import="java.util.Iterator"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.conexion.Conexion"%> 
<%@page import="java.util.List"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.tipoDocumentoDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.oficinaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta charset="UTF-8">
  <title>Nexdoc</title>
  <link href="css/inicio.css" rel="stylesheet" type="text/css"/>
  <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
  <link src="recursos/modalRadicar.jsp"/>
 </head>
 <body>
  <%
   HttpSession misession = (HttpSession) request.getSession();
   personaVO usuario = (personaVO) misession.getAttribute("personaVO");
  %>
  <div class="Login">
   <nav>
    <ul>
     <div class="boton-menu">
      <a href="#"><img src="img/Encabezado.png" alt="Nexdoc" class="icon icon-menu" id="encabezado"/></a>
     </div>
     <li><a><%//=persona.getNombre()%></a>
      <div class="submenu">
       <div class="submenu-items">
        <p>Opciones</p> 
        <ul>
         <li><a href="index.jsp">Cerrar Sesion</a></li> 
        </ul>
       </div>
      </div>
     </li>
    </ul>
   </nav>
  </div>
  <header>
   <div class="navegacion">
    <nav>
     <ul class="menu">
      <%
       if (usuario.getRol() == 2) {
      %>
      <li><a href="#" data-toggle="modal" data-target="#exampleModal" class="radicar">Radicar<img src="img/radicar.png" class="icono"></a></li>
        <%}
         if (usuario.getRol() == 3) {
        %>
      <li><a href="#" id="listarRecibidos">Recibidos<img src="img/inbox.png" class="icono"></a></li>
        <%}
         if (usuario.getRol() == 2) {
        %>
      <li><a href="#" id="listarEnviados">Enviados<img src="img/enviados.png" class="icono"></a></li>
        <%}
         if (usuario.getRol() == 3 || usuario.getRol() == 2) {
        %>
      <li><a href="#">Consultar<img src="img/consultar.png" class="icono"></a></li>
        <%}
         if (usuario.getRol() == 4) {
        %>
      <li><a href="#" id="listarRemitentes">Administrar Remitentes<img src="img/registrar.png" class="icono"></a></li>
      <li><a href="#" id="listarFuncionarios">Administrar Funcionarios<img src="img/registrar.png" class="icono"></a></li>
      <li><a href="#" id="listarOficinas">Administrar Oficinas<img src="img/registrar.png" class="icono"></a></li>
        <%}%>
    </nav>
   </div>
  </header>
  <div class="contenido">
   <div id="contenido" >   
    <div class="text-center">
     <div class="spinner-border" style="width: 3rem; height: 3rem; margin-top: 20%;" role="status">
      <span class="sr-only">Loading...</span>
     </div>
    </div>
   </div>
  </div>
  <script src="js/jquery.js" type="text/javascript"></script>
  <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
  <script src="js/bootstrap.min.js" type="text/javascript"></script>
  <script src="js/MyScript.js" type="text/javascript"></script>
  <script>
   function seleccionarRemitente(idRemitente) {
    $.ajax({
     url: 'ControladorDocumento',
     data: {idRemitente: idRemitente, path: "/seleccionarRemitente"},
     type: 'post',
     datetype: 'json',
     success: function (resultado1) {
      console.log(resultado1);
      $("input[name=txtRemitente]").val(resultado1);
//      $("input[name='txtRemitente']").val(resultado);
     }
    });
   }
   function seleccionarOficina(idOficina) {
    $.ajax({
     url: 'ControladorDocumento',
     data: {idOficina: idOficina, path: "/seleccionarOficina"},
     type: 'post',
     datetype: 'json',
     success: function (resultado2) {
      console.log(resultado2);
      $("input[name='txtOficina']").val(resultado2);
//      $("input[name='txtOficina']").val(resultado);
     }
    });
   }
   function seleccionarDestinatario(idDestinatario) {
    $.ajax({
     url: 'ControladorDocumento',
     data: {idDestinatario: idDestinatario, path: "/seleccionarDestinatario"},
     type: 'post',
     datetype: 'json',
     success: function (resultado3) {
      console.log(resultado3);
      $("input[name='txtDestinatario']").val(resultado3);
//      $("input[name='txtRemitente']").val(resultado);
     }
    });
   }
  </script>
  <script src="js/menu.js" type="text/javascript"></script>
 </body>
</html>

<style type="text/css">
 .modal{
  top: 430px;
  right: 100px;
  bottom: -100px;
  left: 39%;
  z-index: 10040;
  overflow: auto;
  overflow-y: auto;
 }
 .modal-dialog {
  width: 300px;
  height: 300px;
 }
 .modal-header{
  background: #000;
  color:#fff;
  cursor: pointer;
 }
 .modal-body{
  padding: 0px;
 }
 .modal-body input,select{
  width: 100%;
  height: 100%;
  margin: 0px;
  padding: 10px;
  border: 0px;
 }
 .modal-body input[type=radio]{
  margin-left: 30px;
 }
</style>
<div class="modal fade" data-backdrop="static" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
 <div class="modal-dialog" role="document">
  <div class="modal-content">
   <form id="formRadicarDocumento">
    <div class="modal-header prueba">
     <h5 class="modal-title" id="exampleModalLabel">Nuevo Documento</h5>
     <button type="button" class="close" data-dismiss="modal" aria-label="Close">
      <span aria-hidden="true" style="color: white">&times;</span>
     </button>
    </div>
    <div class="modal-body">
     <input type="text" placeholder="Remitente" readonly="readonly" name="txtRemitente" id="listarRemitentes" value="">
     <input type="text" placeholder="Oficina" readonly="readonly" name="txtOficina" id="listarOficinas">
     <input type="text" placeholder="Destinatario" readonly="readonly" name="txtDestinatario" id="listarFuncionarios">
    </div>
    <select name="cboTipoDocumento" id="cboTipoDocumento">
     <option disabled selected>Tipo Documento</option>
     <option>Hoja de Vida</option>
     <option>Hoja de Vida</option>
     <option>Hoja de Vida</option>
    </select>
    <select name="cboPrioridad" id="cboPrioridad">
     <option disabled selected>Prioridad</option>
     <option>Maxima</option>
     <option>Madia</option>
     <option>Baja</option>
    </select>
    <input type="file" style="width: 100%;height: 100%;text-align: center;padding: 10px" name="documento">
    <div class="modal-footer">
     <input type="button" class="btn" value="Enviar" name="Enviar">
    </div>
   </form>
  </div>
 </div>
</div>

<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/radicarDocumento.js" type="text/javascript"></script>

