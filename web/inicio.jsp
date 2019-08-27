<%-- 
    Document   : inicio
    Created on : 10-jul-2019, 15:29:45
    Author     : Familia Moreno
--%>

<%@page import="java.util.Iterator"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.conexion.Conexion"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.dao.Tipo_DocumentoDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.vo.Tipo_Documento"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.dao.OficinaDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.vo.Oficina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Nexdoc</title>
        <link href="css/inicio.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="Login">
            <nav>
                <ul>
                    <li><a href="">Login<img src="img/login.png"></a>
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
                        <li><a id="Recibidos">Recibidos</a></li>
                        <li>
                            <a>Administrar</a>
                            <div class="submenu">
                                <div class="submenu-items">
                                    <p>Opciones</p>
                                    <ul>
                                        <li><a id="ListarOfi" href="#">Área</a></li>
                                        <li><a href="">Remitente</a></li>
                                        <li><a id="ListarFun" href="#">Funcionario</a></li>
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
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/MyScript.js" type="text/javascript"></script>
    </body>
</html>
<div class="modal fade" id="Radicar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" id="modal2R">
        <form action="ControladorDocumento">
            <div class="modal-content"><br>
                <div class="modal-body"><br>
                    <h1>Radicar Documento</h1><br>
                    <label>Id Remitente</label><br/>
                    <input type="text" id="IdRemitente" class="texto1" autocomplete="off" name="txtremitente"><br/>
                    <label>Tipo Documento</label><br/>
                    <select class="texto1" name="cbotipodocumento">
                        <%
                            Conexion cn = new Conexion();
                            Tipo_DocumentoDAO Tipo_DocumentoDAO = new Tipo_DocumentoDAO(cn.conectar());
                            List<Tipo_Documento> listarTipo_Documento = Tipo_DocumentoDAO.listarTipoDoc();
                            Iterator<Tipo_Documento> iteraTipo_Documento = listarTipo_Documento.iterator();
                            Tipo_Documento Tipo_Documento = null;
                            while (iteraTipo_Documento.hasNext()) {
                                Tipo_Documento = iteraTipo_Documento.next();
                        %>
                        <option value="<%=Tipo_Documento.getIdTipo_Documento()%>"><%=Tipo_Documento.getDescripcion()%></option>
                        <%}%>
                    </select><br/>
                    <label>Oficina</label><br/>
                    <select class="texto1" name="cbooficina">
                        <%
                            OficinaDAO OficinaDAO = new OficinaDAO(cn.conectar());
                            List<Oficina> listarOficina = OficinaDAO.listar();
                            Iterator<Oficina> iteraOficina = listarOficina.iterator();
                            Oficina Oficina = null;
                            while (iteraOficina.hasNext()) {
                                Oficina = iteraOficina.next();
                        %>
                        <option value="<%=Oficina.getIdOficina()%>"><%=Oficina.getNombre()%></option>
                        <%}%>
                    </select><br/>
                    <label>Destinatario</label><br/>
                    <select>
                        <option></option>
                    </select>
                    <input type="file" name="documento"><br><br>
                    <input type="submit" value="Radicar" name="accion">
                </div>
            </div>
        </form>
    </div>
</div>