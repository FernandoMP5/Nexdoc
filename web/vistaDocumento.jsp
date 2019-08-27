<%-- 
    Document   : vistaDocumento
    Created on : 24/08/2019, 06:22:32 PM
    Author     : Familia Moreno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vista Documento</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/vistaDocumento.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center>
        <div>
            <img src="img/documento.png">
        </div>
    </center>
    <input type="button" name="" value="Crear Respuesta" data-toggle="modal" data-target="#generarRespuesta">
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
<div class="modal fade" id="generarRespuesta" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" id="modal2">
        <div class="modal-content">
            <div class="modal-body"><br>
                <h1>Respuesta</h1>
                <textarea></textarea>
                <input type="file">
                <input type="button" value="Enviar" id="enviar">
            </div>
        </div>
    </div>
</div>