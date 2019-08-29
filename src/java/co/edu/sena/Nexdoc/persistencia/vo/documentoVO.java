/** @author Sena*/
package co.edu.sena.Nexdoc.persistencia.vo;

import java.io.InputStream;
import java.sql.Date;


public class documentoVO {
    
    private int idDocumento;
    private InputStream documentoPDF;
    private byte[] documentoPDFmostrar;
    private int visualizaciones;
    private String idRemitente;
    private String idDestinatario;
    private String idRecepcionista;
    private InputStream respuestaPDF;
    private byte[] respuestaPDFmostrar;
    private String respuestaComen;
    private int idEstado;
    private int idPrioridad;
    private Date fechaRadicacion;
    private int idOficina;
    private int idtipoDocumento;

    public documentoVO() {
    }

    public documentoVO(int idDocumento, byte[] documentoPDFmostrar, int visualizaciones, String idRemitente, String idDestinatario, String idRecepcionista, byte[] respuestaPDFmostrar, String respuestaComen, int idEstado, int idPrioridad, Date fechaRadicacion, int idOficina, int idtipoDocumento) {
        this.idDocumento = idDocumento;
        this.documentoPDFmostrar = documentoPDFmostrar;
        this.visualizaciones = visualizaciones;
        this.idRemitente = idRemitente;
        this.idDestinatario = idDestinatario;
        this.idRecepcionista = idRecepcionista;
        this.respuestaPDFmostrar = respuestaPDFmostrar;
        this.respuestaComen = respuestaComen;
        this.idEstado = idEstado;
        this.idPrioridad = idPrioridad;
        this.fechaRadicacion = fechaRadicacion;
        this.idOficina = idOficina;
        this.idtipoDocumento = idtipoDocumento;
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
