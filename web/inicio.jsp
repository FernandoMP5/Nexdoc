<%-- 
    Document   : inicio
    Created on : 10-jul-2019, 15:29:45
    Author     : Familia Moreno
--%>

<%@page import="co.edu.sena.Nexdoc.persistencia.vo.oficinaVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.vo.tipoDocumentoVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.personaDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.vo.personaVO"%>
<%@page import="java.util.Iterator"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.conexion.Conexion"%> 
<%@page import="java.util.List"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.tipoDocumentoDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.oficinaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
 <head>
  <meta charset="UTF-8">
  <title>Nexdoc</title>
  <link href="css/inicio.css" rel="stylesheet" type="text/css"/>
  <link href="css/vistaDocumento.css" rel="stylesheet" type="text/css"/>
  <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
 </head>
 <body>
  <%
   HttpSession misession = (HttpSession) request.getSession();
   personaVO persona = (personaVO) misession.getAttribute("personaVO");
  %>
  <div class="Login">
   <nav>
    <ul>
     <img src="img/Encabezado.png" alt="Nexdoc" class="encabezado"/>
     <li><a><%//=persona.getNombre()%></a>
      <div class="submenu">
       <div class="submenu-items">
        <p>Opciones</p> 
        <ul>
         <li><a href="index.jsp">Cerrar Sesion</a></li> 
        </ul>
       </div>
      </div>
     </li>
    </ul>
   </nav>
  </div>
  <header>
   <div class="navegacion">
    <div class="boton-menu">
     <a class="icon icon-menu"></a>
    </div>
    <nav>
     <ul class="menu">
      <li><a href="#" id="radicar">Radicar<img src="img/radicar.png" class="icono"></a></li>
      <li><a href="#" id="listarRecibidos">Recibidos<img src="img/inbox.png" class="icono"></a></li>
      <li><a href="#" id="listarEnviados">Enviados<img src="img/enviados.png" class="icono"></a></li>
      <li><a href="#">Consultar<img src="img/consultar.png" class="icono"></a></li>
      <li><a href="#" id="listarFuncionarios">Registrar<img src="img/registrar.png" class="icono"></a></li>
     </ul>
    </nav>
   </div>
  </header>
  <div id="contenido">
   <div class="text-center">
    <div class="spinner-border" style="width: 3rem; height: 3rem; margin-top: 20%;" role="status">
     <span class="sr-only">Loading...</span>
    </div>
   </div>
  </div>
  <script src="js/jquery.js" type="text/javascript"></script>
  <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
  <script src="js/bootstrap.min.js" type="text/javascript"></script>
  <script src="js/MyScript.js" type="text/javascript"></script>
  <script src="js/menu.js" type="text/javascript"></script>
 </body>
 <div class="pie">Designed by Nexdoc | © Copyright 2019 | All Rights Reserved</div>
</html>
