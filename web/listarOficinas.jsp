<%-- 
    Document   : listaroficinas
    Created on : 10-jul-2019, 17:03:05
    Author     : Familia Moreno
--%>

<%@page import="co.edu.sena.Nexdoc.persistencia.vo.personaVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.vo.usuarioVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.vo.oficinaVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.oficinaDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.conexion.Conexion"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Listar Área</title>
 </head>
 <body>
  <%
   HttpSession misession = (HttpSession) request.getSession();
   usuarioVO usuario = (usuarioVO) misession.getAttribute("usuarioVO");
   if (usuario.getRol() == 2) {
  %>
  <h1 style="text-align: center;">Seleccione la oficina</h1><br>
   <%} else if (usuario.getRol() == 4) {%>
  <h1 style="text-align: center;">Oficinas
   <input type="button" class="btn btn-warning" value="Registrar" style="float:right;margin: 5px;margin-right: 35px;"></h1><br>
   <%}%>
  <table class="table table-hover">
   <thead class="thead-dark">
    <tr>
     <th>Nombre</th>
     <th>Telefono-Extencion</th>      
      <%if (usuario.getRol() == 4) {%>
     <th>Acciones</th>
      <%}%>
    </tr>
   </thead>
   <%
    Conexion cn = new Conexion();
    oficinaDAO oficinaDAO = new oficinaDAO(cn.conectar());
    List<oficinaVO> listarOficinas = oficinaDAO.listarOficina();
    Iterator<oficinaVO> iteraOficinas = listarOficinas.iterator();
    oficinaVO oficinaVO = null;
    while (iteraOficinas.hasNext()) {
     oficinaVO = iteraOficinas.next();
   %>
   <tbody>
    <tr class="seleccionar" value="<%=oficinaVO.getIdOficina()%>" style="cursor: pointer" onclick="seleccionarOficina(<%=oficinaVO.getIdOficina()%>)">
     <td><%=oficinaVO.getNombreOficina()%></td>
     <td><%=oficinaVO.getTelefonoOficina()%></td>
     <%if (usuario.getRol() == 4) {%>
     <td><button type="button" class="btn btn-warning" value="<%=oficinaVO.getIdOficina()%>" style="padding: 5px">Modificar</button>
      <button type="submit" class="btn btn-danger" value="<%=oficinaVO.getIdOficina()%>" style="padding: 5px">Inhabilitar</button></td>
      <%}%>
    </tr>
    <%}%>
   </tbody>
  </table>
 </body>
</html>
