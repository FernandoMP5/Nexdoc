<%-- 
    Document   : recibidos
    Created on : 10-jul-2019, 15:35:30
    Author     : Familia Moreno
--%>

<%@page import="co.edu.sena.Nexdoc.persistensia.conexion.Conexion"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.dao.DocumentoDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.vo.Documento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recibidos</title>
        <link rel="stylesheet" href="css/listar.css">
    </head>
    <body>
        <div class="cuerpo">
            <center>
                <div id="formContentrecibidos"><br>
                    <form action="#">
                        <h1>Recibidos</h1><br>
                        <table class="Recibidos">
                            <thead>
                                <tr>
                                    <th>Documento</th>
                                    <th>Tipo Documento</th>
                                    <th>Oficina</th>
                                    <th>Fecha Envio</th>
                                    <th>Remitente</th>
                                </tr>
                            </thead>
                            <%
                                Conexion cn = new Conexion();
                                DocumentoDAO DocumentoDAO = new DocumentoDAO(cn.conectar());
                                List<Documento> listarDocumento = DocumentoDAO.listar();
                                Iterator<Documento> iteraDocumento = listarDocumento.iterator();
                                Documento Documento = null;

                                while (iteraDocumento.hasNext()) {
                                    Documento = iteraDocumento.next();
                            %>
                            <tbody>
                                <tr>
                                    <td><a id="VistaDoc" href="#">Abrir</a></td>
                                    <td><%=Documento.getIdTipoDocumento()%></td>
                                    <td><%=Documento.getIdOficina()%></td>
                                    <td><%=Documento.getFechaEnvio()%></td>
                                    <td><%=Documento.getRemitente()%></td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </form>
                </div>
            </center>
        </div>
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/MyScript.js" type="text/javascript"></script>
    </body>
</html>
