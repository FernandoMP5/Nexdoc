package co.edu.sena.Nexdoc.persistensia.vo;

import java.io.InputStream;
import java.sql.Date;

public class Documento {

    private int idDocumento;
    private String idTipoDocumento;
    private String destinatario;
    private String remitente;
    private String idOficina;
    private Date fechaEnvio;
    private InputStream archivopdf;
    private byte[] archivopdf2;

    public Documento() {
    }

    public Documento(int idDocumento, String idTipoDocumento, String destinatario, String remitente, String idOficina, Date fechaEnvio, InputStream archivopdf, byte[] archivopdf2) {
        this.idDocumento = idDocumento;
        this.idTipoDocumento = idTipoDocumento;
        this.destinatario = destinatario;
        this.remitente = remitente;
        this.idOficina = idOficina;
        this.fechaEnvio = fechaEnvio;
        this.archivopdf = archivopdf;
        this.archivopdf2 = archivopdf2;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(String idOficina) {
        this.idOficina = idOficina;
    }
    
    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public InputStream getArchivopdf() {
        return archivopdf;
    }

    public void setArchivopdf(InputStream archivopdf) {
        this.archivopdf = archivopdf;
    }

    public byte[] getArchivopdf2() {
        return archivopdf2;
    }

    public void setArchivopdf2(byte[] archivopdf2) {
        this.archivopdf2 = archivopdf2;
    }

}
