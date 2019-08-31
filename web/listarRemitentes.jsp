<%-- 
    Document   : listarRemitentes
    Created on : 30/08/2019, 09:43:27 PM
    Author     : Familia Moreno
--%>

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
    <link rel="stylesheet" href="css/tablas.css">
  </head>
  <body>
    <div class="cuerpo">
      <center>                
        <div id="formContentrecibidos"></br>
          <h1>Funcionarios</h1><br>
          <div class="buscar">
            <labe><b>Buscar:</b></labe>
            <input type="text" placeholder="Documento">
            <a type="button" href="">Buscar</a>
          </div>
          <div class="agregar">
            <a type="button" href="" id="Agregar">+ Agregar</a>
          </div>
          <table border="0" class="Recibidos">
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
            <%
              Conexion cn = new Conexion();
              personaDAO personaDAO = new personaDAO(cn.conectar());
              List<personaVO> listarRemitentes = personaDAO.listarRemitentes();
              Iterator<personaVO> iteraRemitentes = listarRemitentes.iterator();
              personaVO personaVO = null;
              while (iteraRemitentes.hasNext()) {
                personaVO = iteraRemitentes.next();
            %>
            <tbody>
              <tr>
                <td><%=personaVO.getNombre()%></td>
                <td><%=personaVO.getNumeroIdentificacion()%></td>
                <td><%=personaVO.getCorreo()%></td>
                <td><%=personaVO.getDireccion()%></td>
                <td><%=personaVO.getTelefonoFijo()%></td>
                <td><%=personaVO.getTelefonoCelular()%></td>
                <td>
                  <a type="button" id="EditarOficina">Editar</a>
                  <a type="button">Eliminar</a>
                </td>
              </tr>
              <%}%>
            </tbody>
          </table>
        </div>
      </center>
    </div>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script src="js/MyScript.js" type="text/javascript"></script>
  </body>
</html>
