package co.edu.sena.Nexdoc.negocio;

import co.edu.sena.Nexdoc.persistencia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistencia.dao.documentoDAO;
import co.edu.sena.Nexdoc.persistencia.dao.oficinaDAO;
import co.edu.sena.Nexdoc.persistencia.dao.personaDAO;
import co.edu.sena.Nexdoc.persistencia.vo.documentoVO;
import co.edu.sena.Nexdoc.persistencia.vo.personaVO;
import co.edu.sena.Nexdoc.persistencia.vo.oficinaVO;
import co.edu.sena.Nexdoc.persistencia.vo.prioridadVO;
import co.edu.sena.Nexdoc.persistencia.vo.tipoDocumentoVO;
import co.edu.sena.Nexdoc.persistencia.vo.usuarioVO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
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
  personaDAO personaDAO = new personaDAO(con);
  oficinaDAO oficinaDAO = new oficinaDAO(con);
  Gson json = new Gson();
  String gson;
  PrintWriter out;

  public ControladorDocumento() throws Exception {
    this.documentoDAO = new documentoDAO(cn.conectar());
    this.personaDAO = new personaDAO(cn.conectar());
    this.oficinaDAO = new oficinaDAO(cn.conectar());
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, Exception {
    response.setContentType("application/json");
    String path = request.getParameter("path");
    switch (path) {
      case "/seleccionarRemitente":
        seleccionarRemitente(request, response);
        break;
      case "/seleccionarOficina":
        seleccionarOficina(request, response);
        break;
      case "/seleccionarDestinatario":
        seleccionarDestinatario(request, response);
        break;
      case "/seleccionarDocumento":
        seleccionarDocumento(request, response);
        break;
      case "/radicarDocumento":
        radicarDocumento(request, response);
        break;
      default:
        throw new AssertionError();
    }
    out = response.getWriter();
    out.print(gson);
    out.flush();
  }

  public void seleccionarRemitente(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, Exception {
  personaVO persona = new personaVO();
    String id = request.getParameter("idRemitente");
    List lista = null;
    try {
      persona = personaDAO.listar1Persona(id);
      gson = json.toJson(persona);
    } catch (Exception ex) {
      Logger.getLogger(ControladorDocumento.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void seleccionarOficina(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, Exception {
    String id = request.getParameter("idOficina");
    try {
      oficinaVO = oficinaDAO.listar1Oficina(id);
      gson = json.toJson(oficinaVO);
    } catch (Exception ex) {
      Logger.getLogger(ControladorDocumento.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void seleccionarDestinatario(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, Exception {
  personaVO persona = new personaVO();
    String id = request.getParameter("idDestinatario");
    List lista = null;
    try {
      persona = personaDAO.listar1Persona(id);
      gson = json.toJson(persona);
    } catch (Exception ex) {
      Logger.getLogger(ControladorDocumento.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void seleccionarDocumento(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, Exception {
    String acceso = "";
    String vistaDoc = "vistaDocumento.jsp";
    int id = Integer.parseInt(request.getParameter("idDocumento"));
    request.setAttribute("id", request.getParameter("idDocumento"));
    request.setAttribute("IdOficina", request.getParameter("idDocumento"));
    acceso = vistaDoc;
    try {
//   gson = json.toJson(id);
    } catch (Exception ex) {
      Logger.getLogger(ControladorDocumento.class.getName()).log(Level.SEVERE, null, ex);
    }
    RequestDispatcher vista = request.getRequestDispatcher(acceso);
    vista.forward(request, response);
  }

  public void radicarDocumento(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    HttpSession misession = (HttpSession) request.getSession();
    usuarioVO usuario = (usuarioVO) misession.getAttribute("usuarioVO");
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
    String remitente = request.getParameter("idRemitente");
    int idoficina = Integer.parseInt(request.getParameter("idOficina"));
    String destinatario = request.getParameter("idDestinatario");
    int prioridad = Integer.parseInt(request.getParameter("cboPrioridad"));
    int idtipodocumento = Integer.parseInt(request.getParameter("cboTipoDocumento"));
    String idRecepcionista = usuario.getNumeroIdentificacion();

//    personaVO.setNumeroIdentificacion(remitente);
//    documentoVO.setIdRemitente(personaVO);

    tipoDocumentoVO.setIdtipoDocumento(idtipodocumento);
    documentoVO.setIdtipoDocumento(tipoDocumentoVO);

//    personaVO.setNumeroIdentificacion(destinatario);
//    documentoVO.setIdDestinatario(personaVO);
//
//    personaVO.setNumeroIdentificacion(idRecepcionista);
//    documentoVO.setIdRecepcionista(personaVO);

    oficinaVO.setIdOficina(idoficina);
    documentoVO.setIdOficina(oficinaVO);

    prioridadVO.setIdPrioridad(prioridad);
    documentoVO.setIdPrioridad(prioridadVO);
    if (inputStream != null) {
      documentoVO.setDocumentoPDF(inputStream);
    }
    try {
      documentoDAO.radicarDocumento(documentoVO,destinatario,remitente,idRecepcionista);
    } catch (Exception ex) {
      Logger.getLogger(ControladorDocumento.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (Exception ex) {
      Logger.getLogger(ControladorDocumento.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (Exception ex) {
      Logger.getLogger(ControladorDocumento.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }

}
