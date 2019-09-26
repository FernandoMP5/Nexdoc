<%-- 
    Document   : vistaDocumento
    Created on : 24/08/2019, 06:22:32 PM
    Author     : Familia Moreno
--%>

<%@page import="java.io.InputStream"%>
<%@page import="java.util.Iterator"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.vo.historialVO"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.historialDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.vo.documentoVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.documentoDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Vista Documento</title>
  <link href="css/vistaDocumento.css" rel="stylesheet" type="text/css"/>
 </head>
 <body>
  <%
   Conexion cn = new Conexion();
   documentoDAO documentoDAO = new documentoDAO(cn.conectar());
   int idDocumento = Integer.parseInt((String) request.getAttribute("IdOficina"));
   documentoVO documentoVO = (documentoVO) documentoDAO.listarDocumento(idDocumento);
  %>
  <div id="documento">
   <object data="pdf?idDocumento=<%=documentoVO.getIdDocumento()%>" type="application/pdf"></object>
  </div>
  <h3 style="text-align: center">Datos del documento</h3></br>
  <div id="info">
   <label><b>Id Documento</b></label><br>
   <label><%=documentoVO.getIdDocumento()%></label><br> 
   <label><b>Remitente</b></label><br>
   <label><%=documentoVO.getIdRemitente().getNombre()%></label><br>
   <label><b>Prioridad</b></label><br>
   <label><%=documentoVO.getIdPrioridad().getDescripcion()%></label><br>  
   <label><b>Fecha Radicacion</b></label><br>
   <label><%=documentoVO.getFechaRadicacion()%></label><br>
  </div>
  <div>
   <table class="table table-hover">
    <thead class="thead-dark">
     <tr>
      <th>Fecha Respuesta</th>
      <th>Respuesta escrita</th>
      <th>PDF</th>
     </tr>
    </thead>
    <tbody>
     <%
      historialDAO historialDAO = new historialDAO(cn.conectar());
      List<historialVO> listaHistorial = historialDAO.listarHistorial(documentoVO.getIdDocumento());
      InputStream inputStream = null;
      Iterator<historialVO> iteraHistorial = listaHistorial.iterator();
      historialVO historialVO = null;
      while (iteraHistorial.hasNext()) {
       historialVO = iteraHistorial.next();
     %>
     <tr>     
      <td><%=historialVO.getFechaHistoria()%></td> 
      <td><%=historialVO.getRespuestaComen()%></td> 
      <%if (historialVO.getRespuestaPDF() == inputStream) {%>        
      <td>Sin PDF</td>
      <%} else {%>
      <td><a>Ver PDF</a></td>
      <%}%>
     </tr>
     <%}%> 
    </tbody>
   </table>
  </div>
  <div class="respuesta">
   <button type="submit" class="btn btn-warning" name="respuesta" id="respuesta" >Redactar respuesta</button>
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
<div class="modal fade" data-backdrop="static" id="modalRespuesta" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
 <div class="modal-dialog" role="document">
  <div class="modal-content">
   <form id="formRadicarRespuesta" enctype="multipart/form-data" method="post">
    <div class="prueba" id="prueba">
     <div class="modal-header">
      <h5 class="modal-title" id="titulo">Nuevo Respuesta</h5>
      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
       <span aria-hidden="true" style="color: white">&times;</span>
      </button>
     </div>
    </div>
    <div class="modal-body">
     <input type="hidden"readonly="readonly" id="idDocumento" name="idDocumento" value="<%=documentoVO.getIdDocumento()%>">
     <label style="margin: 2px;margin-left: 5px;"><b>Respuesta escrita</b></label>
     <textarea placeholder="Ingrese la respuesa escrita" name="respuestaComen" id="respuestaComen" class="form-control" rows="6" style="border-top:none; border-bottom: none"></textarea>
     <select name="proceso" class="form-control">
      <option disabled selected>Siguiente paso</option>
      <option value="1">Reenviar a recepcion</option>
      <option value="2">Enviar a archivo</option>
     </select>
     <label style="margin: 2px;margin-left: 5px;"><b>Documento como respuesta</b></label>
     <input type="file" style="width: 100%;height: 100%;text-align: center;padding: 10px" name="documento" id="documento">
     <input type="hidden" readonly="readonly" id="path" name="path" value="/radicarRespuesta">
    </div>
    <div class="modal-footer">
     <input type="submit" class="btn btn-warning" value="Enviar" name="Enviar">
    </div>
   </form>
  </div>
 </div>
</div>
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/radicarRespuesta.js" type="text/javascript"></script>
<script src="js/MyScript.js" type="text/javascript"></script>