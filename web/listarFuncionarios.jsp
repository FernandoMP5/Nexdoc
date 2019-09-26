<%-- 
    Document   : listarFuncionario
    Created on : 31/07/2019, 07:25:21 PM
    Author     : Familia Moreno
--%>

<%@page import="co.edu.sena.Nexdoc.persistencia.conexion.Conexion"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.vo.usuarioVO"%>
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
   usuarioVO usuario = (usuarioVO) misession.getAttribute("usuarioVO");
   if (usuario.getRol() == 2) {
  %>
  <h1 style="text-align: center">Seleccione el destinatario</h1><br>
  <%} else if (usuario.getRol() == 4) {%>
  <h1 style="text-align: center;">Funcionarios
   <input type="button" class="btn btn-warning" value="Registrar" id="registrarFuncionario" style="float:right;margin: 5px;margin-right: 35px;"></h1><br>
   <%}%>
  <table class="table table-hover">
   <thead class="thead-dark">
    <tr>
     <th>Nombre</th>
     <th>Documento</th>
     <th>Correo</th>
     <th>Oficina</th>
     <th>Telefon Celular</th>
      <%
       if (usuario.getRol() == 4) {%>
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
    <%
      if (usuario.getRol() == 2) {%> 
    <tr class="seleccionar" value="<%=personaVO.getNumeroIdentificacion()%>" style="cursor: pointer" onclick="seleccionarDestinatario(<%=personaVO.getNumeroIdentificacion()%>)">
     <td><%=personaVO.getNombre()%></td>
     <td><%=personaVO.getNumeroIdentificacion()%></td>
     <td><%=personaVO.getCorreo()%></td>
     <td><%=personaVO.getOficina().getNombreOficina()%></td>
     <td><%=personaVO.getTelefonoCelular()%></td>
     <%}
      if (usuario.getRol() == 4) {%>
    <tr class="seleccionar" value="<%=personaVO.getNumeroIdentificacion()%>" style="cursor: pointer">
     <td><%=personaVO.getNombre()%></td>
     <td><%=personaVO.getNumeroIdentificacion()%></td>
     <td><%=personaVO.getCorreo()%></td>
     <td><%=personaVO.getOficina().getNombreOficina()%></td>
     <td><%=personaVO.getTelefonoCelular()%></td>
     <td><button type="submit" class="btn btn-warning" style="padding: 5px" onclick="listarFuncionario(<%=personaVO.getNumeroIdentificacion()%>)">Modificar</button>
      <button type="submit" class="btn btn-danger" value="<%=personaVO.getNumeroIdentificacion()%>" style="padding: 5px">Inhabilitar</button></td>
      <%}%>
    </tr>
    <%}%>
   </tbody>
  </table>
 </div>
</center>
</div>
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/actualizarFuncionario.js" type="text/javascript"></script>
<script src="js/MyScript.js" type="text/javascript"></script>
</body>
</html>
