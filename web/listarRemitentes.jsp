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
<%@page import="co.edu.sena.Nexdoc.persistencia.vo.usuarioVO"%>
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
   usuarioVO usuario = (usuarioVO) misession.getAttribute("usuarioVO");
   if (usuario.getRol() == 2) {
  %>
  <h1 style="text-align: center;">Seleccione el remitente
   <input type="button" class="btn btn-warning" value="Registrar"  id="registrarRemitente" style="float:right;margin: 5px;margin-right: 35px;"></h1><br>
   <%} else if (usuario.getRol() == 4) {%>
  <h1 style="text-align: center;">Remitentes
   <input type="button" class="btn btn-warning" value="Registrar"  id="registrarRemitente" style="float:right;margin: 5px;margin-right: 35px;"></h1><br>
   <%}%>
  <table class="table table-hover">
   <thead class="thead-dark">
    <tr>
     <th>Nombre</th>
     <th>Documento</th>
     <th>Correo</th>
     <th>Direccion</th>
     <th>Telefon Celular</th>
      <%
       if (usuario.getRol() == 2) {
      %>
     <th>Actualizar</th>
      <%} else if (usuario.getRol() == 4) {%>
     <th>Acciones</th>
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
      if (usuario.getRol() == 2) {
     %>
     <td><button type="button" class="btn btn-warning" value="<%=personaVO.getNumeroIdentificacion()%>" style="padding: 5px">Modificar</button></td>
     <%} else if (usuario.getRol() == 4) {%>
     <td><button type="button" class="btn btn-warning" value="<%=personaVO.getNumeroIdentificacion()%>" style="padding: 5px">Modificar</button>
      <button type="submit" class="btn btn-danger" value="<%=personaVO.getNumeroIdentificacion()%>" style="padding: 5px">Inhabilitar</button></td>
      <%}%>
    </tr>
    <%}%>
   </tbody>
  </table>
  <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
  <script src="js/MyScript.js" type="text/javascript"></script>
  <script>
  </script>
 </body>
</html>