package co.edu.sena.Nexdoc.persistencia.vo;

import java.io.InputStream;
import java.sql.Date;

public class documentoVO {

 private int idDocumento;
 private InputStream documentoPDF;
 private byte[] documentoPDFmostrar;
 private int visualizaciones;
 private personaVO idRemitente;
 private personaVO idDestinatario;
 private personaVO idRecepcionista;
 private InputStream respuestaPDF;
 private byte[] respuestaPDFmostrar;
 private String respuestaComen;
 private int idEstado;
 private prioridadVO idPrioridad;
 private Date fechaRadicacion;
 private oficinaVO idOficina;
 private tipoDocumentoVO idtipoDocumento;

 public documentoVO() {
 }

 public documentoVO(int idDocumento, InputStream documentoPDF, byte[] documentoPDFmostrar, int visualizaciones, personaVO idRemitente, personaVO idDestinatario, personaVO idRecepcionista, InputStream respuestaPDF, byte[] respuestaPDFmostrar, String respuestaComen, int idEstado, prioridadVO idPrioridad, Date fechaRadicacion, oficinaVO idOficina, tipoDocumentoVO idtipoDocumento) {
  this.idDocumento = idDocumento;
  this.documentoPDF = documentoPDF;
  this.documentoPDFmostrar = documentoPDFmostrar;
  this.visualizaciones = visualizaciones;
  this.idRemitente = idRemitente;
  this.idDestinatario = idDestinatario;
  this.idRecepcionista = idRecepcionista;
  this.respuestaPDF = respuestaPDF;
  this.respuestaPDFmostrar = respuestaPDFmostrar;
  this.respuestaComen = respuestaComen;
  this.idEstado = idEstado;
  this.idPrioridad = idPrioridad;
  this.fechaRadicacion = fechaRadicacion;
  this.idOficina = idOficina;
  this.idtipoDocumento = idtipoDocumento;
 }

 public personaVO getIdRemitente() {
  return idRemitente;
 }

 public void setIdRemitente(personaVO idRemitente) {
  this.idRemitente = idRemitente;
 }

 public personaVO getIdDestinatario() {
  return idDestinatario;
 }

 public void setIdDestinatario(personaVO idDestinatario) {
  this.idDestinatario = idDestinatario;
 }

 public personaVO getIdRecepcionista() {
  return idRecepcionista;
 }

 public void setIdRecepcionista(personaVO idRecepcionista) {
  this.idRecepcionista = idRecepcionista;
 }

 public int getIdDocumento() {
  return idDocumento;
 }

 public void setIdDocumento(int idDocumento) {
  this.idDocumento = idDocumento;
 }

 public byte[] getDocumentoPDFmostrar() {
  return documentoPDFmostrar;
 }

 public void setDocumentoPDFmostrar(byte[] documentoPDFmostrar) {
  this.documentoPDFmostrar = documentoPDFmostrar;
 }

 public InputStream getDocumentoPDF() {
  return documentoPDF;
 }

 public void setDocumentoPDF(InputStream documentoPDF) {
  this.documentoPDF = documentoPDF;
 }

 public int getVisualizaciones() {
  return visualizaciones;
 }

 public void setVisualizaciones(int visualizaciones) {
  this.visualizaciones = visualizaciones;
 }

 public byte[] getRespuestaPDFmostrar() {
  return respuestaPDFmostrar;
 }

 public void setRespuestaPDFmostrar(byte[] respuestaPDFmostrar) {
  this.respuestaPDFmostrar = respuestaPDFmostrar;
 }

 public InputStream getRespuestaPDF() {
  return respuestaPDF;
 }

 public void setRespuestaPDFmostrar(InputStream respuestaPDF) {
  this.respuestaPDF = respuestaPDF;
 }

 public String getRespuestaComen() {
  return respuestaComen;
 }

 public void setRespuestaComen(String respuestaComen) {
  this.respuestaComen = respuestaComen;
 }

 public int getIdEstado() {
  return idEstado;
 }

 public void setIdEstado(int idEstado) {
  this.idEstado = idEstado;
 }

 public prioridadVO getIdPrioridad() {
  return idPrioridad;
 }

 public void setIdPrioridad(prioridadVO idPrioridad) {
  this.idPrioridad = idPrioridad;
 }

 public Date getFechaRadicacion() {
  return fechaRadicacion;
 }

 public void setFechaRadicacion(Date fechaRadicacion) {
  this.fechaRadicacion = fechaRadicacion;
 }

 public oficinaVO getIdOficina() {
  return idOficina;
 }

 public void setIdOficina(oficinaVO idOficina) {
  this.idOficina = idOficina;
 }

 public tipoDocumentoVO getIdtipoDocumento() {
  return idtipoDocumento;
 }

 public void setIdtipoDocumento(tipoDocumentoVO idtipoDocumento) {
  this.idtipoDocumento = idtipoDocumento;
 }

}//fin clase documentoVO
