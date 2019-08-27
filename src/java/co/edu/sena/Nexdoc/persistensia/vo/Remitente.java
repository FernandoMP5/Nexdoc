
package co.edu.sena.Nexdoc.persistensia.vo;


public class Remitente {
    private int IdRemitente;
    private String IdPersona;

    public Remitente() {
    }

    public Remitente(int IdRemitente, String IdPersona) {
        this.IdRemitente = IdRemitente;
        this.IdPersona = IdPersona;
    }
    
    public int getIdRemitente() {
        return IdRemitente;
    }

    public void setIdRemitente(int IdRemitente) {
        this.IdRemitente = IdRemitente;
    }

    public String getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(String IdPersona) {
        this.IdPersona = IdPersona;
    }
    
}