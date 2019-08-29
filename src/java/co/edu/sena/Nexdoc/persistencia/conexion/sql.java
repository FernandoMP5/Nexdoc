package co.edu.sena.Nexdoc.persistencia.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class sql {

    Connection con;

    public int auto_increm(String sql) throws Exception {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        return id;
        } catch (Exception ex) {
            throw new Exception("Error al incrementar el id" + ex);
        }
    }

    public static void main(String[] args) throws Exception {
        sql s = new sql();
        int a = s.auto_increm("SELECT MAX(idEmpleado) FROM empleado;");
        System.out.println(a);
    }

}
