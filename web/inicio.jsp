<%-- 
    Document   : inicioRecpcionista
    Created on : 11/09/2019, 01:10:19 AM
    Author     : Familia Moreno
--%>

<%@page import="co.edu.sena.Nexdoc.persistencia.vo.oficinaVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.vo.tipoDocumentoVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.personaDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.vo.usuarioVO"%>
<%@page import="java.util.Iterator"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.conexion.Conexion"%> 
<%@page import="java.util.List"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.tipoDocumentoDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.oficinaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
 <head>
  <meta charset="UTF-8">
  <title>Nexdoc</title>
  <link href="css/inicio.css" rel="stylesheet" type="text/css"/>
  <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
 </head>
 <body>
  <%
   HttpSession misession = (HttpSession) request.getSession();
   usuarioVO usuario = (usuarioVO) misession.getAttribute("usuarioVO");
  %>
  <div class="Login">
   <input type="hidden" readonly="readonly" value="<%=usuario.getRol()%>" id="rol">
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
      <li><a href="#" class="radicar" id="radicar">Radicar<img src="img/radicar.png" class="icono"></a></li>
        <%}
         if (usuario.getRol() == 3 || usuario.getRol() == 2) {
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
  color:#fff;
  cursor: pointer;
 }
 .modal-header{
  background: #000;
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
<div class="modal fade" data-backdrop="static" id="modalRadicacion" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
 <div class="modal-dialog" role="document">
  <div class="modal-content">
   <form id="formRadicarDocumento" enctype="multipart/form-data" method="post">
    <div class="prueba" id="prueba">
     <div class="modal-header">
      <h5 class="modal-title" id="titulo">Nuevo Documento</h5>
      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
       <span aria-hidden="true" style="color: white">&times;</span>
      </button>
     </div>
    </div>
    <div class="modal-body">
     <input type="text" placeholder="Remitente" readonly="readonly" name="txtRemitente" id="listarRemitentes">
     <input type="hidden" readonly="readonly" id="idRemitente" name="idRemitente"> 
     <input type="text" placeholder="Oficina" readonly="readonly" name="txtOficina" id="listarOficinas">
     <input type="hidden"readonly="readonly" id="idOficina" name="idOficina"> 
     <input type="hidden" readonly="readonly" id="path" name="path" value="/radicarDocumento"> 
     <input type="text" placeholder="Destinatario" readonly="readonly" name="txtDestinatario" id="listarFuncionarios">
     <input type="hidden"readonly="readonly" id="idDestinatario" name="idDestinatario">
    </div>
    <select name="cboTipoDocumento" id="cboTipoDocumento">
     <option disabled selected>Tipo Documento</option>
     <%
      Conexion cn = new Conexion();
      tipoDocumentoDAO tipoDocumentoDAO = new tipoDocumentoDAO(cn.conectar());
      List<tipoDocumentoVO> listatipoDocumento = tipoDocumentoDAO.listartipoDoc();
      Iterator<tipoDocumentoVO> iteratipoDocumento = listatipoDocumento.iterator();
      tipoDocumentoVO tipoDocumentoVO = null;
      while (iteratipoDocumento.hasNext()) {
       tipoDocumentoVO = iteratipoDocumento.next();
     %>
     <option value="<%=tipoDocumentoVO.getIdtipoDocumento()%>"><%=tipoDocumentoVO.getDescripcion()%></option>  
     <%}%>
    </select>
    <select name="cboPrioridad" id="cboPrioridad">
     <option disabled selected>Prioridad</option>
     <option value="1">Maxima</option>
     <option value="2">Media</option>
     <option value="3">Baja</option>
    </select>
    <input type="file" style="width: 100%;height: 100%;text-align: center;padding: 10px" name="documento" id="documento">
    <div class="modal-footer">
     <input type="submit" class="btn btn-warning" value="Enviar" name="Enviar">
    </div>
   </form>
  </div>
 </div>
</div>

<!--<div class="modal fade" id="modalRespuesta" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
 <div class="modal-dialog modal-dialog-centered" role="document">
  <div class="modal-content">
   <div class="modal-header">
    <h5 class="modal-title" id="titulo">Modal title</h5>
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
     <span aria-hidden="true">&times;</span>
    </button>
   </div>
   <div class="modal-body">
    ...
   </div>
   <div class="modal-footer">
    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
    <button type="button" class="btn btn-primary">Save changes</button>
   </div>
  </div>
 </div>
</div>-->

<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/radicarDocumento.js" type="text/javascript"></script>
<script src="js/MyScript.js" type="text/javascript"></script>
<script src="js/menu.js" type="text/javascript"></script>
<script>
 $(document).ready(function () {
  $('#radicar').click(function () {
   console.log("Cargando formulario radicar documento");
   $("#modalRadicacion").modal('show');
  });
 })
</script>
<%
 if (usuario.getRol() == 2) {
%>
<script>
 $(document).ready(function () {
  console.log("Cargando enviados");
  $("#contenido").load("listarEnviados.jsp");
 });
</script>
<%}
 if (usuario.getRol() == 3) {
%>
<script>
 $(document).ready(function () {
  console.log("Cargando recibidos");
  $("#contenido").load("listarRecibidos.jsp");
 });
</script>
<%}
 if (usuario.getRol() == 4) {
%>
<script>
 $(document).ready(function () {

 });
</script>
<%}%>