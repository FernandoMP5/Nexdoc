<%-- 
    Document   : listaroficinas
    Created on : 10-jul-2019, 17:03:05
    Author     : Familia Moreno
--%>

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
  <h1 style="text-align: center">Oficinas</h1><br>
  <table class="table table-hover table-striped">
   <thead>
    <tr>
     <th>Nombre</th>
     <th>Telefono-Extencion</th>
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
    </tr>
    <%}%>
   </tbody>
  </table>
 </body>
</html>
