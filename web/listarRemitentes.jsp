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
  <h1 style="text-align: center">Remitentes</h1><br>
  <table class="table table-hover table-striped">
   <thead>
    <tr>
     <th>Nombre</th>
     <th>Documento</th>
     <th>Correo</th>
     <th>Direccion</th>
     <th>Telefon Fijo</th>
     <th>Telefon Celular</th>
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
    <tr id="idRemitente" name="idRemitente" value="<%=personaVO.getNumeroIdentificacion()%>" style="cursor: pointer" onclick="radicar()">
    <td><%=personaVO.getNombre()%></td>
    <td><%=personaVO.getNumeroIdentificacion()%></td>
    <td><%=personaVO.getCorreo()%></td>
    <td><%=personaVO.getDireccion()%></td>
    <td><%=personaVO.getTelefonoFijo()%></td>
    <td><%=personaVO.getTelefonoCelular()%></td>
  </tr>
  <%}%>
 </tbody>
</table>
</body>
</html>