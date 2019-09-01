<%-- 
    Document   : inicio
    Created on : 10-jul-2019, 15:29:45
    Author     : Familia Moreno
--%>

<%@page import="co.edu.sena.Nexdoc.persistencia.vo.personaVO"%>
<%@page import="java.util.Iterator"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.conexion.Conexion"%> 
<%@page import="java.util.List"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.tipoDocumentoDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.oficinaDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.vo.tipoDocumentoVO"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.vo.oficinaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Nexdoc</title>
    <link href="css/inicio.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <%
      HttpSession misession = (HttpSession) request.getSession();
      personaVO personaVO = (personaVO) misession.getAttribute("personaVO");
    %>
    <div class="Login">
      <nav>
        <ul>
          <li><a><img src="img/login.png"></a> 
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
      <div class="navegacion" align="center">
        <nav>
          <ul>
            <img src="img/Encabezado.png"> 
            <li><a>Perfil</a></li>	 
            <li><a data-toggle="modal" data-target="#Radicar">Radicar</a></li>
            <li><a id="listarRecibidos">Recibidos</a></li>
            <li>
              <a>Administrar</a>
              <div class="submenu">
                <div class="submenu-items">
                  <p>Opciones</p>
                  <ul>
                    <li><a id="listarOficinas">Área</a></li>
                    <li><a id="listarRemitentes">Remitente</a></li>
                    <li><a id="listarFuncionarios">Funcionario</a></li>
                  </ul>
                </div>
              </div>
            </li>
          </ul>
        </nav>
      </div>
    </header><br>
    <div id="contenido">
    </div>
    <footer>
      <div class="datos">
        <p>
          COLOMBIA</br>
          CLL 72 B Sur # 89 A 01</br>
          Bogotá. Colombia</br>
          Phone: +57 - 373 64 37
        </p></br>
        <p>
          CONTACTOS</br>
          Tel: 322 313 3251
        </p>
      </div>
      <div class="redes">
        <a href="https://www.facebook.com/"><img src="img/facebook-logo-button.png" class="logos"></a>
        <a href=""><img src="img/twitter-logo-button.png" class="logos"></a>
        <a href=""><img src="img/google-plus-logo-button.png" class="logos"></a>
      </div>
    </footer>
    <div class="pie">Designed by Nexdoc | © Copyright 2019 | All Rights Reserved</div>
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/MyScript.js" type="text/javascript"></script>
  </body>
</html>
<div class="modal fade" id="Radicar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" id="modal2R">
    <form action="ControladorDocumento" method="post" enctype="multipart/form-data">
      <div class="modal-content"><br>
        <div class="modal-body"><br>
          <h1>Radicar Documento</h1><br>
          <label>Id Remitente</label><br/>
          <input type="text" id="IdRemitente" class="texto1" autocomplete="off" name="txtremitente"><br/>
          <label>Tipo Documento</label><br/>
          <select class="texto1" name="cbotipodocumento">
            <%
              Conexion cn = new Conexion();
              tipoDocumentoDAO tipoDocumentoDAO = new tipoDocumentoDAO(cn.conectar());
              List<tipoDocumentoVO> listartipoDocumento = tipoDocumentoDAO.listartipoDoc();
              Iterator<tipoDocumentoVO> iteratipoDocumento = listartipoDocumento.iterator();
              tipoDocumentoVO tipoDocumentoVO = null;
              while (iteratipoDocumento.hasNext()) {
                tipoDocumentoVO = iteratipoDocumento.next();
            %>
            <option value="<%=tipoDocumentoVO.getIdtipoDocumento()%>"><%=tipoDocumentoVO.getDescripcion()%></option>
            <%}%>
          </select><br/>
          <label>Oficina</label><br/>
          <select class="texto1" name="cbooficina">
            <%
              oficinaDAO oficinaDAO = new oficinaDAO(cn.conectar());
              List<oficinaVO> listaroficina = oficinaDAO.listarOficina();
              Iterator<oficinaVO> iteraoficinaVO = listaroficina.iterator();
              oficinaVO oficinaVO = null;
              while (iteraoficinaVO.hasNext()) {
                oficinaVO = iteraoficinaVO.next();
            %>
            <option value="<%=oficinaVO.getIdOficina()%>"><%=oficinaVO.getNombreOficina()%></option> 
            <%}%>
          </select><br/>
          <label>Destinatario</label><br/>
          <select name="cbodestinatario">
            <option value="1">Manuel Sebastian</option>
          </select><br/>
          <label>Nivel de Prioridad</label></br>
          <div class="radio">
            <input type="radio" name="rbprioridad" value="1"/> Maximo</br>
            <input type="radio" name="rbprioridad" value="2"/> Medion</br>
            <input type="radio" name="rbprioridad" value="3"/> Bajonn</br>
          </div>
          <input type="file" name="documento"><br><br>
          <input type="submit" value="Radicar Documento" name="accion">
        </div>
      </div>
    </form>
  </div>
</div>