
<style type="text/css">
 .modal{
  top: 300px;
  right: 100px;
  bottom: -100px;
  left: 350px;
  z-index: 10040;
  overflow: auto;
  overflow-y: auto;
 }
 .modal-dialog {
  width: 300px;
  height: 300px;
 }
 .modal-header{
  background: #000;
  color:#fff;
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
   <div class="modal-header">
    <h5 class="modal-title" id="exampleModalLabel">Nuevo Documento</h5>
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
     <span aria-hidden="true">&times;</span>
    </button>
   </div>
   <div class="modal-body">
    <input type="text" placeholder="Remitente" readonly="readonly">
    <input type="text" placeholder="Oficina" readonly="readonly">
    <input type="text" placeholder="Destinatario" readonly="readonly">
    <select>
     <option disabled selected>Tipo Documento</option>
     <option>Hoja de Vida</option>
     <option>Hoja de Vida</option>
     <option>Hoja de Vida</option>
    </select>
    <select>
     <option disabled selected>Prioridad</option>
     <option>Maxima</option>
     <option>Madia</option>
     <option>Baja</option>
    </select>
    <input type="file" placeholder="Examinar">
   </div>
   <div class="modal-footer">
    <button type="button" class="btn btn-primary">Enviar</button>
   </div>
  </div>
 </div>
</div>




<li id="formulario" class="formulario">
 <div style="padding: 20px; height: 450px">
  <h3>Radicar Documento</h3>
  <div class="form-group">
   <label>Remitente</label>
   <input type="text" class="form-control" name="txtRemitente"  id="listarRemitentes" readonly="readonly" value="">
   <input type="hidden" name="txtidRemitente">
   <input type="hidden" name="txtrolRemitente">
   <input type="hidden" name="txtoficinaRemitente">
   <input type="hidden" name="txttipoIdentificacionRemitente">
  </div>
  <div class="form-group">
   <label>Oficina</label>
   <input type="text" class="form-control" name="txtOficina" id="listarOficinas" readonly="readonly" value="">
  </div>
  <div class="form-group">
   <label>Destinatario</label>
   <input type="text" class="form-control" name="txtDextinatario" id="listarFuncionarios" readonly="readonly" value="">
  </div>
  <div class="form-group">
   <label>Tipo Documento</label></br>
   <select class="form-control">
    <option>Hoja de vida</option>
    <option>Hoja de vida</option>
    <option>Hoja de vida</option>
   </select>
  </div>
  <div class="form-group">
   <label>Prioridad</label></br>
   <input type="radio" name="rbPrioridad">Maxima </br>
   <input type="radio" name="rbPrioridad">Media </br>
   <input type="radio" name="rbPrioridad">Baja </br>
  </div>
  <div id="divFile" class="btn btn-warning">
   <p id="texto">Añadir documento</p>
   <input type="file" id="documento">
  </div>
  <input type="button" name="Radicar" id="radicar" class="btn btn-info" value="Radicar">
 </div>
</li>
</ul>
</nav>
</div>