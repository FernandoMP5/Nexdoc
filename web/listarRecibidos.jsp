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
 </head>
 <body>
  <%
   HttpSession misession = (HttpSession) request.getSession();
   personaVO personaVO = (personaVO) misession.getAttribute("personaVO");
  %>
  <div id="recibidos">
   <form>
    <h1 style="text-align: center">Recibidos</h1><br>
    <table class="table table-hover table-striped">
     <thead>
      <tr>
       <th scope="col">Tipo Documento</th>
       <th scope="col">Remitente</th>
       <th scope="col">Oficina</th>
       <th scope="col">Fecha Envio</th>
       <th scope="col">Prioridad</th>
      </tr>
     </thead>
     <tbody>
      <%
       Conexion cn = new Conexion();
       documentoDAO documentoDAO = new documentoDAO(cn.conectar());
       List<documentoVO> listarRecibidos = documentoDAO.recibidos(personaVO.getNumeroIdentificacion());
       Iterator<documentoVO> iteraRecibidos = listarRecibidos.iterator();
       documentoVO documentoVO = null;
       int i = 0;
       while (iteraRecibidos.hasNext()) {
        documentoVO = iteraRecibidos.next();
        if (documentoVO.getVisualizaciones() == 0) {%>
      <tr id="idDocumento" name="idDocumento" value="<%=documentoVO.getIdDocumento()%>" style="cursor: pointer "> 
       <td><b><%=documentoVO.getIdtipoDocumento().getDescripcion()%></b></td> 
       <td><b><%=documentoVO.getIdRemitente().getNombre()%></b></td>
       <td><b><%=documentoVO.getIdOficina().getNombreOficina()%></b></td> 
       <td><b><%=documentoVO.getFechaRadicacion()%></b></td>  
       <td><b><%=documentoVO.getIdPrioridad().getDescripcion()%></b></td>
      </tr>
      <%} else {%>
      <tr> 
       <td><%=documentoVO.getIdtipoDocumento().getDescripcion()%></td> 
       <td><%=documentoVO.getIdRemitente().getNombre()%></td>
       <td><%=documentoVO.getIdOficina().getNombreOficina()%></td> 
       <td><%=documentoVO.getFechaRadicacion()%></td>  
       <td><%=documentoVO.getIdPrioridad().getDescripcion()%></td>
      </tr>
      <%}
       }%>
     </tbody>
    </table>
   </form>
  </div>
 </body>
</html>
