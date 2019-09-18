package co.edu.sena.Nexdoc.persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexion {

 public static Connection conectar() throws Exception {
  try {
   Class.forName("com.mysql.jdbc.Driver");
   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nexdoc", "root", "");
   return con;
  } catch (Exception e) {
   e.printStackTrace();
   throw new Exception("Error al conectar a la Base de Datos" + e);
  }
 } // fin conectar

 public static void cerrar(PreparedStatement ps, ResultSet rs, Connection con) {
  try {
   if (rs != null) {
    rs.close();
   }
   if (ps != null) {
    ps.close();
   }
   if (con != null) {
    con.close();
   }
  } catch (Exception e) {
   e.printStackTrace();
  }
 } // fin cerrar

 public static void cerrar(PreparedStatement ps, ResultSet rs) {
  cerrar(ps, rs, null);
 }

 public static void cerrar(PreparedStatement ps) {
  cerrar(ps, null, null);
 }

 public static void cerrar(Connection con) {
  cerrar(null, null, con);
 }
}
