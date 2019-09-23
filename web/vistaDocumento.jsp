<%-- 
    Document   : vistaDocumento
    Created on : 24/08/2019, 06:22:32 PM
    Author     : Familia Moreno
--%>

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
   int idDocumento = Integer.parseInt((String)request.getAttribute("IdOficina"));
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
     </tr>
    </thead>
    <tbody>
     <tr>
      <td></td>
     </tr>
    </tbody>
   </table>
  </div>
  <div class="respuesta">
    <input type="button" value="Redactar respuesta" class="btn">
  </div>
 </body>
</html>