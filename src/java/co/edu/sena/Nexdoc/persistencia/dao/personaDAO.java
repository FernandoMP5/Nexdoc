/** @author Sena */
package co.edu.sena.Nexdoc.persistensia.dao;

import java.sql.Connection;

public class personaDAO {

    Connection con;

    public personaDAO(Connection con) {
        this.con = con;
    }

}//fin clase personaDAO
