<%-- 
    Document   : recibidos
    Created on : 10-jul-2019, 15:35:30
    Author     : Familia Moreno
--%>

<%@page import="co.edu.sena.Nexdoc.persistencia.vo.personaVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.vo.documentoVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.documentoDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.conexion.Conexion"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Recibidos</title>
  <link rel="stylesheet" href="css/listar.css">
 </head>
 <body>
  <%
   HttpSession misession = (HttpSession) request.getSession();
   personaVO personaVO = (personaVO) misession.getAttribute("personaVO");
  %>
  <div class="cuerpo">
   <center>
    <div id="formContentrecibidos"><br>
     <form>
      <h1>Recibidos</h1><br>
      <table class="Recibidos">
       <thead>
        <tr>
         <th>Documento</th>
         <th>Tipo Documento</th>
         <th>Oficina</th>
         <th>Fecha Envio</th>
         <th>Remitente</th>
        </tr>
       </thead>
       <%
        Conexion cn = new Conexion();
        documentoDAO documentoDAO = new documentoDAO(cn.conectar());
        List<documentoVO> listarRecibidos = documentoDAO.recibidos(personaVO.getNumeroIdentificacion());
        Iterator<documentoVO> iteraRecibidos = listarRecibidos.iterator();
        documentoVO documentoVO = null;

        while (iteraRecibidos.hasNext()) {
         documentoVO = iteraRecibidos.next();
       %>
       <tbody>
        <tr>
         <td><a target="_blank" href="pdf?idDocumento=<%=documentoVO.getIdDocumento()%>"><img src="img/Rebisado.jpg" width="70px" height="70px"></a></td> 
         <td><%=documentoVO.getIdtipoDocumento()%></td> 
         <td><%=documentoVO.getIdOficina()%></td> 
         <td><%=documentoVO.getFechaRadicacion()%></td> 
         <td><%=documentoVO.getIdRemitente()%></td>
         <%}%>
        </tr>
       </tbody>
      </table>
     </form>
    </div>
   </center>
  </div>
  <script src="js/jquery.js" type="text/javascript"></script>
  <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
  <script src="js/MyScript.js" type="text/javascript"></script>
 </body>
</html>
