
package co.edu.sena.Nexdoc.negocio;

import co.edu.sena.Nexdoc.persistencia.conexion.Conexion;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "pdf", urlPatterns = {"/pdf"})
public class pdf extends HttpServlet {

 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

  response.setContentType("application/pdf");

  Conexion cn = new Conexion();
  Connection con = null;
  PreparedStatement ps = null;
  ResultSet rs = null;
  byte[] b = null;

  try {
   int idDocumento = Integer.parseInt(request.getParameter("idDocumento"));
   String sql = "SELECT documentoPDF FROM documento WHERE idDocumento = " + idDocumento;
   ps = cn.conectar().prepareStatement(sql);
   rs = ps.executeQuery();
   while (rs.next()) {
    b = rs.getBytes("documentoPDF");
   }
   InputStream bos = new ByteArrayInputStream(b);

   int tamanoInput = bos.available();
   byte[] datosPDF = new byte[tamanoInput];
   bos.read(datosPDF, 0, tamanoInput);

   response.getOutputStream().write(datosPDF);
   bos.close();
   cn.cerrar(ps, rs, con);

  } catch (Exception ex) {
   System.out.println(ex.getMessage());
  }
 }

 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  processRequest(request, response);
 }

 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  processRequest(request, response);
 }
 String a = "\"pdf?sancionId=\"";

 @Override
 public String getServletInfo() {
  return "Short description";
 }// </editor-fold>

}
