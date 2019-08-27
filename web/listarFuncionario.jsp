<%-- 
    Document   : listarFuncionario
    Created on : 31/07/2019, 07:25:21 PM
    Author     : Familia Moreno
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.conexion.Conexion"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.dao.FuncionarioDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistensia.vo.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Funcionario</title>
        <link rel="stylesheet" href="css/tablas.css">
    </head>
    <body>
        <div class="cuerpo">
            <center>                
                <div id="formContentrecibidos"></br>
                    <h1>Funcionarios</h1><br>
                    <div class="buscar">
                        <labe><b>Buscar:</b></labe>
                        <input type="text" placeholder="IdFuncionario">
                        <a type="button" href="">Buscar</a>
                    </div>
                    <div class="agregar">
                        <a type="button" href="" id="Agregar">+ Agregar</a>
                    </div>
                    <form action="ControladorFuncionario">
                        <table border="0" class="Recibidos">
                            <thead>
                                <tr>
                                    <th>Usuario</th>
                                    <th>Cargo</th>
                                    <th>Oficina</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <%
                                Conexion cn = new Conexion();
                                FuncionarioDAO FuncionarioDAO = new FuncionarioDAO(cn.conectar());
                                List<Funcionario> listarFuncionario = FuncionarioDAO.listar();
                                Iterator<Funcionario> iteraFuncionario = listarFuncionario.iterator();
                                Funcionario Funcionario = null;
                                while (iteraFuncionario.hasNext()) {
                                    Funcionario = iteraFuncionario.next();
                            %>
                            <tbody>
                                <tr>
                                    <td><%=Funcionario.getUsuario()%></td>
                                    <td><%=Funcionario.getIdCargo()%></td>
                                    <td><%=Funcionario.getIdOficina()%></td>
                                    <td>
                                        <a type="button" href="ControladorFuncionario?accion=Editar&IdFuncionario=<%=Funcionario.getId()%>" id="EditarOficina">Editar</a>
                                        <a type="button" href="ControladorFuncionario?accion=Eliminar&IdFuncionario=<%=Funcionario.getId()%>">Eliminar</a>
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
        <script>
            $(document).ready(function () {
                $('#Agregar').click(function () {
                    $("#cuerpo").load("agregarOficina.jsp");
                });
            });
        </script>
    </body>
</html>
