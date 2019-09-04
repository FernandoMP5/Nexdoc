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
  <link rel="stylesheet" href="css/tablas.css">
 </head>
 <body>
  <div class="cuerpo">
   <center>                
    <div id="formContentrecibidos"></br>
     <h1>Remitentes</h1><br>
     <div class="buscar">
      <labe><b>Buscar:</b></labe>
      <input type="text" placeholder="Documento">
      <a type="button" href="">Buscar</a>
     </div>
     <div class="agregar">
      <a type="button" id="Agregar" type="button" data-toggle="modal" data-target="#AgregarRemitente">+ Agregar</a>
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
</div><div class="modal fade" id="AgregarRemitente" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 <div class="modal-dialog" id="modal2R">
  <form action="ControladorPersona">
   <div class="modal-content"><br>
    <div class="modal-body"><br>
     <h1>Registro Remitentes</h1><br>
     <div class="Personales">
      <label>Nombre(s)</label><br>
      <input type="text" name="txtnombre" autocomplete="off"><br>
      <label>Apellido(s)</label><br>
      <input type="text" name="txtapellido" autocomplete="off"><br>
      <label>Tipo Documento</label><br>
      <select class="texto1" name="cbotipoidentificacion">
       <%
        tipoIdentificacionDAO tipoIdentificacionDAO = new tipoIdentificacionDAO(cn.conectar()); 
        List<tipoIdentificacionVO> listartipoIdentificacionVO = tipoIdentificacionDAO.listartipoIdentificacion(); 
        Iterator<tipoIdentificacionVO> iteratipoIdentificacionVO = listartipoIdentificacionVO.iterator();
        tipoIdentificacionVO tipoIdentificacionVO = null;
        while (iteratipoIdentificacionVO.hasNext()) {
         tipoIdentificacionVO = iteratipoIdentificacionVO.next();
       %>
       <option value="<%=tipoIdentificacionVO.getIdtipoIdentificacion()%>"><%=tipoIdentificacionVO.getDescripcion()%></option>
       <%}%>
      </select><br>
      <label>Documento</label><br>
      <input type="text" name="txtdocumento" autocomplete="off"><br>
      <label>Correo</label><br>
      <input type="email" name="txtcorreo" autocomplete="off"><br>
      <label>Telefono</label><br>
      <input type="tel" name="txttelefono" autocomplete="off"><br>
     </div>
     <div class="Ubicacion">
      <label>Dirrecion</label><br>
      <input type="text" name="txtdirrecion" autocomplete="off"><br>
     </div>
    </div>
    <input type="submit" name="accion" value="Registrar Funcionario">
   </div>
  </form>
 </div>
</div>