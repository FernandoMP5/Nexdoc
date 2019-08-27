<%-- 
    Document   : listaroficinas
    Created on : 10-jul-2019, 17:03:05
    Author     : Familia Moreno
--%>

<%@page import="co.edu.sena.Nexdoc.persistensia.dao.SedeDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.dao.OficinaDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.vo.Oficina"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.vo.Sede"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.conexion.Conexion"%>
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
                                    <th>Sede</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <%
                                Conexion cn = new Conexion();
                                OficinaDAO OficinaDAO = new OficinaDAO(cn.conectar());
                                List<Oficina> listarOficina = OficinaDAO.listar();
                                Iterator<Oficina> iteraOficina = listarOficina.iterator();
                                Oficina Oficina = null;

                                while (iteraOficina.hasNext()) {
                                    Oficina = iteraOficina.next();
                            %>
                            <tbody>
                                <tr>
                                    <td><%=Oficina.getNombre()%></td>
                                    <td><%=Oficina.getTelefonoExtencion()%></td> 
                                    <td><%=Oficina.getIdSede()%></td>
                                    <td>
                                        <a type="button" href="ControladorOficina?accion=Editar&IdOficina=<%=Oficina.getIdOficina()%>" id="EditarOficina">Editar</a>
                                        <a type="button" href="ControladorOficina?accion=Eliminar&IdOficina=<%=Oficina.getIdOficina()%>">Eliminar</a>
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
