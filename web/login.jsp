<%-- 
    Document   : login
    Created on : 27/07/2019, 01:38:13 PM
    Author     : Familia Moreno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html id="prueba">
<html lang="en">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Nexdoc</title>
  <link rel="stylesheet" href="css/login.css"/>
 </head>
 <body>
 <center>
  <div class="wrapper fadeInDown">
   <div id="formContent"><br/>
    <img src="img/Encabezado.png" width="266px" height="120px">
    <form id="formIniciarSesion">
     <center>
      <input type="text" name="txtusuario" id="txtusuario" placeholder="Usuario" autocomplete="off">
      <input type="password" name="txtclave" id="txtclave" placeholder="Contraseña"><br/>
     </center>
     <input type="submit"name="Ingresar" value="Ingresar">
    </form>
    <div id="formFooter">
     <a class="underlineHover" href="#">Restablecer Contraseña</a>
    </div>
   </div>
  </div>
 </center>
 <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
 <script src="js/jquery.validate.js" type="text/javascript"></script>
 <script src="js/iniciarSesion.js" type="text/javascript"></script>
</body>
</html>
