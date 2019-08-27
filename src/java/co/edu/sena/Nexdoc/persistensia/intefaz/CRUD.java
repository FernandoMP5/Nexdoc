
package co.edu.sena.Nexdoc.persistensia.intefaz;

import java.util.List;


public interface CRUD {

    public List listar() throws Exception;
    public boolean add() throws Exception;
    public boolean edit() throws Exception;
    public boolean delete(int Id) throws Exception;
    
}
