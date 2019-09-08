package co.edu.sena.Nexdoc.negocio;

import co.edu.sena.Nexdoc.persistencia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistencia.dao.documentoDAO;
import co.edu.sena.Nexdoc.persistencia.vo.documentoVO;
import co.edu.sena.Nexdoc.persistencia.vo.personaVO;
import co.edu.sena.Nexdoc.persistencia.vo.oficinaVO;
import co.edu.sena.Nexdoc.persistencia.vo.prioridadVO;
import co.edu.sena.Nexdoc.persistencia.vo.tipoDocumentoVO;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
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
 prioridadVO prioridadVO = new prioridadVO();
 documentoDAO documentoDAO = new documentoDAO(con);
 String oficinas = "listarOficinas.jsp";

 public ControladorDocumento() throws Exception {
  this.documentoDAO = new documentoDAO(cn.conectar());
 }

 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  response.setContentType("text/html;charset=UTF-8");
  doPost(request, response);
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
  personaVO persona = (personaVO) misession.getAttribute("personaVO");
  String acceso = "";
  String accion = request.getParameter("accion");
  switch (accion) {
   case "Radicar Documento":
    String remitente = request.getParameter("idRemitente");
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

    personaVO.setNumeroIdentificacion(remitente);
    documentoVO.setIdRemitente(personaVO);

    tipoDocumentoVO.setIdtipoDocumento(idtipodocumento);
    documentoVO.setIdtipoDocumento(tipoDocumentoVO);

    personaVO.setNumeroIdentificacion(destinatario);
    documentoVO.setIdDestinatario(personaVO);

    personaVO.setNumeroIdentificacion(idRecepcionista);
    documentoVO.setIdRecepcionista(personaVO);

    oficinaVO.setIdOficina(idoficina);
    documentoVO.setIdOficina(oficinaVO);

    prioridadVO.setIdPrioridad(prioridad);
    documentoVO.setIdPrioridad(prioridadVO);
    if (inputStream != null) {
     documentoVO.setDocumentoPDF(inputStream);
    }
    try {
     documentoDAO.radicarDocumento(documentoVO);
    } catch (Exception ex) {
     Logger.getLogger(ControladorDocumento.class.getName()).log(Level.SEVERE, null, ex);
    }
    break;
   case "Mostrar":
    String vistaDocumento = "vistaDocumento.jsp";
    request.setAttribute("idDocumento", request.getParameter("idDocumento"));
    acceso = vistaDocumento;
    break;
   default:
    throw new AssertionError();
  }
  RequestDispatcher vista = request.getRequestDispatcher(acceso);
  vista.forward(request, response);
 }

 @Override
 public String getServletInfo() {
  return "Short description";
 }

}
