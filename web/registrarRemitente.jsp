<%-- 
    Document   : registrarRemitente
    Created on : 20/09/2019, 07:00:38 PM
    Author     : Familia Moreno
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.vo.tipoIdentificacionVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.tipoIdentificacionDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Registro Remitente</title>
 </head>
 <body>
 <center>
  <h1>Registro Remitente</h1></br>
  <form id="formRegistrarPersona">
   <div class="Personales">      
    <div class="form-group">
     <label>Nombre(s)</label></br>
     <input type="text" name="txtnombre" id="txtnombre" autocomplete="off" class="form-control">
    </div>
    <div class="form-group">
     <label>Apellido(s)</label></br>
     <input type="text" name="txtapellido" id="txtapellido" autocomplete="off" class="form-control">
    </div>
    <div class="form-group">
     <label>Tipo Documento</label></br>
     <select class="form-control" name="cbotipoidentificacion" id="cbotipoidentificacion">
      <option disabled selected>Seleccionar</option>
      <%
       Conexion cn = new Conexion();
       tipoIdentificacionDAO tipoIdentificacionDAO = new tipoIdentificacionDAO(cn.conectar());
       List<tipoIdentificacionVO> listarTipoIdentificacion = tipoIdentificacionDAO.listartipoIdentificacion();
       Iterator<tipoIdentificacionVO> iteraTipoIdentificacion = listarTipoIdentificacion.iterator();
       tipoIdentificacionVO tipoIdentificacionVO = null;
       while (iteraTipoIdentificacion.hasNext()) {
        tipoIdentificacionVO = iteraTipoIdentificacion.next();

      %>
      <option value="<%=tipoIdentificacionVO.getIdtipoIdentificacion()%>"><%=tipoIdentificacionVO.getDescripcion()%></option>  
      <%}%>
     </select>
    </div>  
    <div class="form-group">
     <label>Documento</label></br>
     <input type="text" name="txtnumeroIdentificacion" id="txtnumeroIdentificacion" autocomplete="off" class="form-control">
    </div>
    <div class="form-group">
     <label>Correo</label></br>
     <input type="email" name="txtcorreo" id="txtcorreo" autocomplete="off" class="form-control">
    </div>
    <div class="form-group">
     <label>Telefono Fijo</label></br>
     <input type="number" name="txttelefonoFijo" id="txttelefonoFijo" autocomplete="off" class="form-control">
    </div>
    <div class="form-group">
     <label>Telefono Celular</label></br>
     <input type="number" name="txttelefonoCelular" id="txttelefonoCelular" autocomplete="off" class="form-control">
    </div>
    <div class="form-group">
     <label>Direccion</label></br>
     <input type="text" name="txtdireccion" id="txtdireccion" autocomplete="off" class="form-control">
    </div>
   </div>
   <input type="submit" name="Registrar" value="Registrar Remitente" class="btn btn-warning">
  </form>
  <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
  <script src="js/jquery.validate.js" type="text/javascript"></script>
  <script src="js/registrarRemitente.js" type="text/javascript"></script>
 </center>
</body>
</html>
