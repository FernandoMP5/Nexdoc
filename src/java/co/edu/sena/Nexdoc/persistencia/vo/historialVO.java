/** @author Sena*/
package co.edu.sena.Nexdoc.persistencia.vo;

import java.io.InputStream;
import java.sql.Date;


public class historialVO {

    private int idHistotia;
    private int idDocumento;
    private Date fechaHistoria;
    private InputStream respuestaPDF;
    private byte[] respuestaPDFmostrar;
    private String respuestaComen;
    private int idDestinatario;

    public historialVO() {
    }

    public int getIdHistotia() {
        return idHistotia;
    }

    public void setIdHistotia(int idHistotia) {
        this.idHistotia = idHistotia;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Date getFechaHistoria() {
        return fechaHistoria;
    }

    public void setFechaHistoria(Date fechaHistoria) {
        this.fechaHistoria = fechaHistoria;
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

    public int getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(int idDestinatario) {
        this.idDestinatario = idDestinatario;
    }
    
    
}//fin clase historialVO
