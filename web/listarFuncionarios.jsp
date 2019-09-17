<%-- 
    Document   : listarFuncionario
    Created on : 31/07/2019, 07:25:21 PM
    Author     : Familia Moreno
--%>

<%@page import="co.edu.sena.Nexdoc.persistencia.conexion.Conexion"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.vo.personaVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.personaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Listar Funcionario</title>
 </head>
 <body>
  <%
   HttpSession misession = (HttpSession) request.getSession();
   personaVO persona = (personaVO) misession.getAttribute("personaVO");
   if (persona.getRol() == 2) {
  %>
  <h1 style="text-align: center">Seleccione el destinatario</h1><br>
  <%} else if (persona.getRol() == 4) {%>
  <h1 style="text-align: center;">Funcionarios
   <input type="button" class="btn" value="Registrar" style="float:right;margin: 5px;margin-right: 35px;"></h1><br>
   <%}%>
  <table class="table table-hover table-striped">
   <thead>
    <tr>
     <th>Nombre</th>
     <th>Documento</th>
     <th>Correo</th>
     <th>Direccion</th>
     <th>Telefon Celular</th>
      <%
      if (persona.getRol() == 4) {%>
     <th>Acciones</th>
      <%}%>
    </tr>
   </thead>
   <%
    Conexion cn = new Conexion();
    personaDAO personaDAO = new personaDAO(cn.conectar());
    List<personaVO> listarFuncionarios = personaDAO.listarFuncionarios();
    Iterator<personaVO> iteraFuncionarios = listarFuncionarios.iterator();
    personaVO personaVO = null;
    while (iteraFuncionarios.hasNext()) {
     personaVO = iteraFuncionarios.next();
   %>
   <tbody>
    <tr class="seleccionar" value="<%=personaVO.getNumeroIdentificacion()%>" style="cursor: pointer" onclick="seleccionarDestinatario(<%=personaVO.getNumeroIdentificacion()%>)">
     <td><%=personaVO.getNombre()%></td>
     <td><%=personaVO.getNumeroIdentificacion()%></td>
     <td><%=personaVO.getCorreo()%></td>
     <td><%=personaVO.getDireccion()%></td>
     <td><%=personaVO.getTelefonoCelular()%></td>
     <%
      if (persona.getRol() == 4) {%>
     <td><button type="button" class="btn" value="<%=personaVO.getNumeroIdentificacion()%>" style="padding: 5px">Modificar</button>
      <button type="submit" class="btn" value="<%=personaVO.getNumeroIdentificacion()%>" style="padding: 5px">Inhabilitar</button></td>
      <%}%>
    </tr>
    <%}%>
   </tbody>
  </table>
 </div>
</center>
</div>
</body>
</html>
