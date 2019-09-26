
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.vo.tipoDocumentoVO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.dao.tipoDocumentoDAO"%>
<%@page import="co.edu.sena.Nexdoc.persistencia.conexion.Conexion"%>
<!--<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>-->
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
<p>Prueba</p>
<style type="text/css">
 .modal{
  top: 430px;
  right: 100px;
  bottom: -100px;
  left: 39%;
  z-index: 10040;
  overflow: auto;
  overflow-y: auto;
 }
 .modal-dialog {
  width: 300px;
  height: 300px;
 }
 .modal-header{
  color:#fff;
  cursor: pointer;
 }
 .modal-header{
  background: #000;
 }
 .modal-body{
  padding: 0px;
 }
 .modal-body input,select{
  width: 100%;
  height: 100%;
  margin: 0px;
  padding: 10px;
  border: 0px;
 }
 .modal-body input[type=radio]{
  margin-left: 30px;
 }
</style>
<div class="modal fade" data-backdrop="static" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
 <div class="modal-dialog" role="document">
  <div class="modal-content">
   <form id="formRadicarDocumento" enctype="multipart/form-data" method="post">
    <div class="prueba" id="prueba">
     <div class="modal-header">
      <h5 class="modal-title" id="titulo">Nuevo Documento</h5>
      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
       <span aria-hidden="true" style="color: white">&times;</span>
      </button>
     </div>
    </div>
    <div class="modal-body">
     <input type="text" placeholder="Remitente" readonly="readonly" name="txtRemitente" id="listarRemitentes">
     <input type="hidden" readonly="readonly" id="idRemitente" name="idRemitente"> 
     <input type="text" placeholder="Oficina" readonly="readonly" name="txtOficina" id="listarOficinas">
     <input type="hidden"readonly="readonly" id="idOficina" name="idOficina"> 
     <input type="hidden"readonly="readonly" id="path" name="path" value="/radicarDocumento"> 
     <input type="text" placeholder="Destinatario" readonly="readonly" name="txtDestinatario" id="listarFuncionarios">
     <input type="hidden"readonly="readonly" id="idDestinatario" name="idDestinatario">
    </div>
    <select name="cboTipoDocumento" id="cboTipoDocumento">
     <option disabled selected>Tipo Documento</option>
     <%
      Conexion cn = new Conexion();
      tipoDocumentoDAO tipoDocumentoDAO = new tipoDocumentoDAO(cn.conectar());
      List<tipoDocumentoVO> listatipoDocumento = tipoDocumentoDAO.listartipoDoc();
      Iterator<tipoDocumentoVO> iteratipoDocumento = listatipoDocumento.iterator();
      tipoDocumentoVO tipoDocumentoVO = null;
      while (iteratipoDocumento.hasNext()) {
       tipoDocumentoVO = iteratipoDocumento.next();
     %>
     <option value="<%=tipoDocumentoVO.getIdtipoDocumento()%>"><%=tipoDocumentoVO.getDescripcion()%></option>  
     <%}%>
    </select>
    <select name="cboPrioridad" id="cboPrioridad">
     <option disabled selected>Prioridad</option>
     <option value="1">Maxima</option>
     <option value="2">Media</option>
     <option value="3">Baja</option>
    </select>
    <input type="file" style="width: 100%;height: 100%;text-align: center;padding: 10px" name="documento" id="documento">
    <div class="modal-footer">
     <input type="submit" class="btn btn-warning" value="Enviar" name="Enviar">
    </div>
   </form>
  </div>
 </div>
</div>
<script src="../js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="../js/jquery.js" type="text/javascript"></script>
<script src="../js/bootstrap.js" type="text/javascript"></script>
<script src="../js/menu.js" type="text/javascript"></script>
<script src="../js/radicarRespuesta.js" type="text/javascript"></script>
<script>
 $(document).ready(function () {
   $("#exampleModal").modal('show');
   $("#titulo").html('Nueva Respuesta');
   $(".modal-body").html("<textarea id='respuestaComen'></textarea>");
   $("#respuestaComen").css({'width': '299px'});
   $("#respuestaComen").css({'height': '170px'});
   $("#respuestaComen").css({'border': 'none'});
   $("#respuestaComen").css({'background': '#fff'});
   $("#cboPrioridad").css({'display': 'none'});
   $("#cboTipoDocumento").css({'display': 'none'});
   $("#modal-footer").css({'height': '70px'});
 })
</script>