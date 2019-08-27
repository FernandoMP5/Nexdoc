package co.edu.sena.Nexdoc.negocio;

import co.edu.sena.Nexdoc.persistensia.dao.DocumentoDAO;
import co.edu.sena.Nexdoc.persistensia.dao.FuncionarioDAO;
import co.edu.sena.Nexdoc.persistensia.vo.Documento;
import co.edu.sena.Nexdoc.persistensia.vo.Funcionario;
import co.edu.sena.Nexdoc.persistensia.vo.Oficina;
import co.edu.sena.Nexdoc.persistensia.vo.Tipo_Documento;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorDocumento extends HttpServlet {

    Connection con;
    Funcionario f = new Funcionario();
    Documento Doc = new Documento();
    Tipo_Documento tipo = new Tipo_Documento();
    Oficina ofi = new Oficina();
    DocumentoDAO daoDoc = new DocumentoDAO(con);
    FuncionarioDAO daoFun = new FuncionarioDAO(con);
    String repuesta = "EnvioExitoso.jsp";
    String inicio = "Inicio.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");

        response.setContentType("application/pdf");
        String acceso = "";
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Radicar")) {
            byte[] b = null;
            String remitente = ((String) request.getParameter("txtremitente"));
            String idtipodocumento = request.getParameter("cbotipodocumento");
            String destinatario = request.getParameter("cbodestinatario");
            String idoficina = request.getParameter("cbooficina");
            b documento = request.getParameter("documento");
            Doc.setIdTipoDocumento(idtipodocumento);
            Doc.setRemitente(remitente);
            Doc.setIdOficina(idoficina);
            Doc.setIdOficina(destinatario);
            Doc.setArchivopdf2(documento);
            daoDoc.add(Doc);
            acceso = repuesta;
        } else if (accion.equalsIgnoreCase("Continuar")) {
            acceso = inicio;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ControladorDocumento.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ControladorDocumento.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
