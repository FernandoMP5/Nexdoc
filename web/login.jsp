<%-- 
    Document   : login
    Created on : 27/07/2019, 01:38:13 PM
    Author     : Familia Moreno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nexdoc</title>
        <link rel="stylesheet" href="css/login.css"/>
    </head>
    <body><br><br><br><br><br><br><br><br><br>
        <section>
            <div class="wrapper fadeInDown">
                <div id="formContent"><br>
                    <img src="img/Encabezado.png" width="366px" height="150px">
                    <form action="ControladorFuncionario" method="post">
                        <input type="text" name="txtusuario" placeholder="Usuario" autocomplete="off">
                        <input type="password" name="txtclave" placeholder="Contraseña">
                        <br>
                        <input type="submit" class="fadeIn fourth" value="Ingresar" name="accion">
                    </form>
                    <div id="formFooter">
                        <a class="underlineHover" href="#">Restablecer Contraseña</a>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
