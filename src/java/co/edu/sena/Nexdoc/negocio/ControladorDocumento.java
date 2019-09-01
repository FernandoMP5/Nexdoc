package co.edu.sena.Nexdoc.negocio;

import co.edu.sena.Nexdoc.persistencia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistencia.dao.documentoDAO;
import co.edu.sena.Nexdoc.persistencia.dao.personaDAO;
import co.edu.sena.Nexdoc.persistencia.vo.documentoVO;
import co.edu.sena.Nexdoc.persistencia.vo.personaVO;
import co.edu.sena.Nexdoc.persistensia.vo.oficinaVO;
import co.edu.sena.Nexdoc.persistensia.vo.tipoDocumentoVO;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/Upload")
@MultipartConfig(maxFileSize = 16177215)

public class ControladorDocumento extends HttpServlet {

  Connection con;
  Conexion cn = new Conexion();
  documentoVO documentoVO = new documentoVO();
  tipoDocumentoVO tipoDocumentoVO = new tipoDocumentoVO();
  oficinaVO oficinaVO = new oficinaVO();
  personaVO personaVO = new personaVO();
  documentoDAO documentoDAO = new documentoDAO(con);
  personaDAO personaDAO = new personaDAO(con);

  public ControladorDocumento() throws Exception {
    this.documentoDAO = new documentoDAO(cn.conectar());
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet ControladorDocumento</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet ControladorDocumento at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
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
    HttpSession misession = request.getSession(true);
//    misession.getAttribute("personaVO");
    personaVO persona= (personaVO) misession.getAttribute("personaVO");
    String acceso = "";
    String accion = request.getParameter("accion");
    String prueba = "login.jsp";
    switch (accion) {
      case "Radicar Documento":
        String remitente = request.getParameter("txtremitente");
        int idtipodocumento = Integer.parseInt(request.getParameter("cbotipodocumento"));
        String destinatario = request.getParameter("cbodestinatario");
        int idoficina = Integer.parseInt(request.getParameter("cbooficina"));
        int prioridad = Integer.parseInt(request.getParameter("rbprioridad"));
        String idRecepcionista = persona.getNumeroIdentificacion();
        InputStream inputStream = null;
        try {
          Part filePart = request.getPart("documento");
          if (filePart.getSize() > 0) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            inputStream = filePart.getInputStream();
          }
        } catch (Exception ex) {
          System.out.println("documento: " + ex.getMessage());
        }
        documentoVO.setIdRemitente(remitente);
        documentoVO.setIdtipoDocumento(idtipodocumento);
        documentoVO.setIdDestinatario(destinatario);
        documentoVO.setIdRecepcionista(idRecepcionista);
        documentoVO.setIdOficina(idoficina);
        documentoVO.setIdPrioridad(prioridad);
        if (inputStream != null) {
          documentoVO.setDocumentoPDF(inputStream);
        }
        try {
          documentoDAO.radicarDocumento(documentoVO);
        } catch (Exception ex) {
          Logger.getLogger(ControladorDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
        break;
      default:
        throw new AssertionError();
    }
//    RequestDispatcher vista = request.getRequestDispatcher(acceso);
//    vista.forward(request, response);
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }

}
