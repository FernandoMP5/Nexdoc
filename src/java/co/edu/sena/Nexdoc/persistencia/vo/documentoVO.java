/** @author Sena*/
package co.edu.sena.Nexdoc.persistensia.vo;

import java.io.InputStream;
import java.sql.Date;


public class documentoVO {
    
    private int idDocumento;
    private byte[] documentoPDF;
    private InputStream documentoPDFmostrar;
    private int visualizaciones;
    private String idRemitente;
    private String idDestinatario;
    private String idRecepcionista;
    private byte[] respuestaPDF;
    private InputStream respuestaPDFmostrar;
    private String respuestaComen;
    private int idEstado;
    private int idPrioridad;
    private Date fechaRadicacion;
    private int idOficina;
    private int idtipoDocumento;

    public documentoVO() {
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public byte[] getDocumentoPDF() {
        return documentoPDF;
    }

    public void setDocumentoPDF(byte[] documentoPDF) {
        this.documentoPDF = documentoPDF;
    }

    public InputStream getDocumentoPDFmostrar() {
        return documentoPDFmostrar;
    }

    public void setDocumentoPDFmostrar(InputStream documentoPDFmostrar) {
        this.documentoPDFmostrar = documentoPDFmostrar;
    }

    public int getVisualizaciones() {
        return visualizaciones;
    }

    public void setVisualizaciones(int visualizaciones) {
        this.visualizaciones = visualizaciones;
    }

    public String getIdRemitente() {
        return idRemitente;
    }

    public void setIdRemitente(String idRemitente) {
        this.idRemitente = idRemitente;
    }

    public String getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(String idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    public String getIdRecepcionista() {
        return idRecepcionista;
    }

    public void setIdRecepcionista(String idRecepcionista) {
        this.idRecepcionista = idRecepcionista;
    }

    public byte[] getRespuestaPDF() {
        return respuestaPDF;
    }

    public void setRespuestaPDF(byte[] respuestaPDF) {
        this.respuestaPDF = respuestaPDF;
    }

    public InputStream getRespuestaPDFmostrar() {
        return respuestaPDFmostrar;
    }

    public void setRespuestaPDFmostrar(InputStream respuestaPDFmostrar) {
        this.respuestaPDFmostrar = respuestaPDFmostrar;
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

    public int getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(int idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public Date getFechaRadicacion() {
        return fechaRadicacion;
    }

    public void setFechaRadicacion(Date fechaRadicacion) {
        this.fechaRadicacion = fechaRadicacion;
    }

    public int getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
    }

    public int getIdtipoDocumento() {
        return idtipoDocumento;
    }

    public void setIdtipoDocumento(int idtipoDocumento) {
        this.idtipoDocumento = idtipoDocumento;
    }

}//fin clase documentoVO
