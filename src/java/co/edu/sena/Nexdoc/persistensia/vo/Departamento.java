
package co.edu.sena.Nexdoc.persistensia.vo;


public class Departamento {
    private int IdDepartamento;
    private String Departamento;

    public Departamento() {
    }

    public Departamento(int IdDepartamento, String Departamento) {
        this.IdDepartamento = IdDepartamento;
        this.Departamento = Departamento;
    }

    public int getIdDepartamento() {
        return IdDepartamento;
    }

    public void setIdDepartamento(int IdDepartamento) {
        this.IdDepartamento = IdDepartamento;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }
    
}
