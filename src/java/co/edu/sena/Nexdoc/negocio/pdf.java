/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.Nexdoc.negocio;

import co.edu.sena.Nexdoc.persistencia.conexion.Conexion;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Familia Moreno
 */
@WebServlet(name = "pdf", urlPatterns = {"/pdf"})
public class pdf extends HttpServlet {

 /**
  * Processes requests for both HTTP
  * <code>GET</code> and
  * <code>POST</code> methods.
  *
  * @param request servlet request
  * @param response servlet response
  * @throws ServletException if a
  * servlet-specific error occurs
  * @throws IOException if an I/O error
  * occurs
  */
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

 // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
 /**
  * Handles the HTTP <code>GET</code>
  * method.
  *
  * @param request servlet request
  * @param response servlet response
  * @throws ServletException if a
  * servlet-specific error occurs
  * @throws IOException if an I/O error
  * occurs
  */
 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  processRequest(request, response);
 }

 /**
  * Handles the HTTP <code>POST</code>
  * method.
  *
  * @param request servlet request
  * @param response servlet response
  * @throws ServletException if a
  * servlet-specific error occurs
  * @throws IOException if an I/O error
  * occurs
  */
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  processRequest(request, response);
 }
 String a = "\"pdf?sancionId=\"";

 /**
  * Returns a short description of the
  * servlet.
  *
  * @return a String containing servlet
  * description
  */
 @Override
 public String getServletInfo() {
  return "Short description";
 }// </editor-fold>

}
