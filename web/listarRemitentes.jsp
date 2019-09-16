<%-- 
    Document   : listarRemitentes
    Created on : 30/08/2019, 09:43:27 PM
    Author     : Familia Moreno
--%>

<%@page import="co.edu.sena.Nexdoc.persistencia.dao.tipoIdentificacionDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.vo.tipoIdentificacionVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.conexion.Conexion"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.personaDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.vo.personaVO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Listar Remitentes</title>
 </head>
 <body>
  <%
   HttpSession misession = (HttpSession) request.getSession();
   personaVO persona = (personaVO) misession.getAttribute("personaVO");
  %>
  <h1 style="text-align: center;">Seleccione el remitente 
   <%
    if (persona.getRol() == 2) {
   %>
   <input type="button" class="btn btn-warning" value="Registrar" style="padding: 5px; width: 60px; margin-left: 25%">
   <%}%></h1><br>

  <table class="table table-hover table-striped">
   <thead>
    <tr>
     <th>Nombre</th>
     <th>Documento</th>
     <th>Correo</th>
     <th>Direccion</th>
     <th>Telefon Celular</th>
      <%
       if (persona.getRol() == 2) {
      %>
     <th>Actualizar</th>
      <%}%>
    </tr>
   </thead>
   <tbody>
    <%
     Conexion cn = new Conexion();
     personaDAO personaDAO = new personaDAO(cn.conectar());
     List<personaVO> listarRemitentes = personaDAO.listarRemitentes();
     Iterator<personaVO> iteraRemitentes = listarRemitentes.iterator();
     personaVO personaVO = null;
     while (iteraRemitentes.hasNext()) {
      personaVO = iteraRemitentes.next();
    %>
   <tr class="seleccionar" value="<%=personaVO.getNumeroIdentificacion()%>" style="cursor: pointer" onclick="seleccionarRemitente(<%=personaVO.getNumeroIdentificacion()%>)">
     <td><%=personaVO.getNombre()%></td>
     <td><%=personaVO.getNumeroIdentificacion()%></td>
     <td><%=personaVO.getCorreo()%></td>
     <td><%=personaVO.getDireccion()%></td>
     <td><%=personaVO.getTelefonoCelular()%></td>
     <%
      if (persona.getRol() == 2) {
     %>
     <td><button type="button" class="btn btn-danger" value="<%=personaVO.getNumeroIdentificacion()%>" style="padding: 5px">Modificar</button></td>
     <%}%>

    </tr>
    <%}%>
   </tbody>
  </table>
  <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
  <script>
    </script>
 </body>
</html>