<%-- 
    Document   : listaroficinas
    Created on : 10-jul-2019, 17:03:05
    Author     : Familia Moreno
--%>

<%@page import="co.edu.sena.Nexdoc.persistensia.vo.oficinaVO"%>
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
    <link rel="stylesheet" href="css/tablas.css">
  </head>
  <body>
    <div class="cuerpo">
      <center>                
        <div id="formContentrecibidos"></br>
          <form action="ControladorOficina">
            <h1>Oficinas</h1><br>
            <div class="buscar">
              <labe><b>Buscar:</b></labe>
              <input type="text" placeholder="Nombre Oficina">
              <a type="button" href="">Buscar</a>
            </div>
            <div class="agregar">
              <a type="button" href="">+ Agregar</a>
            </div>
            <table class="Recibidos">
              <thead>
                <tr>
                  <th>Nombre</th>
                  <th>Telefono-Extencion</th>
                  <th>Acciones</th>
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
                <tr>
                  <td><%=oficinaVO.getNombreOficina()%></td>
                  <td><%=oficinaVO.getTelefonoOficina()%></td> 
                  <td>
                    <a type="button" id="EditarOficina">Editar</a>
                    <a type="button">Eliminar</a>
                  </td>
                </tr>
                <%}%>
              </tbody>
            </table>
          </form>
        </div>
      </center>
    </div>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
  </body>
</html>
