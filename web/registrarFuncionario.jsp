<%-- 
    Document   : registrarFuncionario
    Created on : 19/09/2019, 03:40:24 PM
    Author     : Familia Moreno
--%>

<%@page import="co.edu.sena.Nexdoc.persistencia.vo.oficinaVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.oficinaDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.vo.rolVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.rolDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.vo.tipoIdentificacionVO"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.conexion.Conexion"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.tipoIdentificacionDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Registrar Funcionario</title>
 </head>
 <style>
   .Personales{
    float: left;
    margin-left: 27%;
   }
   .Cuenta{
    float:right;
    margin-right: 25%;
   }
   .error{
    color: red;
   }
  </style>
 <body>
  <h1 style="text-align: center;" id="titulo">Registro Funcionario</h1></br>
  <form id="formRegistrarFuncionario">
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
      <option  disabled selected>Seleccionar</option>
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
   <div class="Cuenta">
    <div class="form-group">
     <label>Usuario</label></br>
     <input type="text" name="txtusuario" id="txtusuario" autocomplete="off" class="form-control">
    </div>
    <div class="form-group">
     <label>Cargo</label></br>
     <select class="form-control" name="cborol" id="cborol">
      <option  disabled selected>Seleccionar</option>
      <%
       rolDAO rolDAO = new rolDAO(cn.conectar());
       List<rolVO> listarRol = rolDAO.listarRol();
       Iterator<rolVO> iteraRol = listarRol.iterator();
       rolVO rolVO = null;
       while (iteraRol.hasNext()) {
        rolVO = iteraRol.next();
      %>
      <option value="<%=rolVO.getIdRol()%>"><%=rolVO.getDescripcion()%></option>
      <%}%>
     </select><br>
    </div>
    <div class="form-group">
     <label>Oficina</label></br>
     <select class="form-control" name="cbooficina" id="cbooficina">
      <option  disabled selected>Seleccionar</option>
      <%
       oficinaDAO oficinaDAO = new oficinaDAO(cn.conectar());
       List<oficinaVO> listarOficina = oficinaDAO.listarOficina();
       Iterator<oficinaVO> iteraOficina = listarOficina.iterator();
       oficinaVO oficinaVO = null;
       while (iteraOficina.hasNext()) {
        oficinaVO = iteraOficina.next();
      %>
      <option value="<%=oficinaVO.getIdOficina()%>"><%=oficinaVO.getNombreOficina()%></option>  
      <%}%>
     </select>
    </div>
    <input type="submit" name="Registrar" value="Registrar Funcionario" class="btn btn-warning">
   </div>
  </form>
 <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
 <script src="js/jquery.validate.js" type="text/javascript"></script>
 <script src="js/registrarFuncionario.js" type="text/javascript"></script>
</body>
</html>
