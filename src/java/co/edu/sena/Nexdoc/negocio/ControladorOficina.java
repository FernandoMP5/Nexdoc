package co.edu.sena.Nexdoc.negocio;

import co.edu.sena.Nexdoc.persistensia.dao.OficinaDAO;
import co.edu.sena.Nexdoc.persistensia.vo.Oficina;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorOficina extends HttpServlet {

    Oficina ofi = new Oficina();
    Connection con ;
    OficinaDAO ofiDao = new OficinaDAO(con);
    String editar="EditarOfi.jsp";
    String respuesta = "../jsp/editarOfi.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorOficina</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorOficina at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String acceso = "";
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Agregar Oficina")) {
            String nombre = request.getParameter("txtnombre");
            String telefono = request.getParameter("txttelefono");
            String sede = request.getParameter("cbosede");
            ofi.setNombre(nombre);
            ofi.setTelefonoExtencion(telefono);
            ofi.setIdSede(sede);
            try {
                ofiDao.add(ofi);
            } catch (Exception ex) {
                Logger.getLogger(ControladorOficina.class.getName()).log(Level.SEVERE, null, ex);
            }
            acceso = respuesta;
        } else if (accion.equalsIgnoreCase("Editar")) {
            request.setAttribute("IdOficina",request.getParameter("IdOficina"));
            acceso = respuesta;
        }
        if (accion.equalsIgnoreCase("Editar Oficina")) {
            int IdOficina = Integer.parseInt(request.getParameter("txtidoficina"));
            String nombre = request.getParameter("txtnombre");
            String telefono = request.getParameter("txttelefono");
            String sede = request.getParameter("cbosede");
            ofi.setIdOficina(IdOficina);
            ofi.setNombre(nombre);
            ofi.setTelefonoExtencion(telefono);
            ofi.setIdSede(sede);
            try {
                ofiDao.edit(ofi);
            } catch (Exception ex) {
                Logger.getLogger(ControladorOficina.class.getName()).log(Level.SEVERE, null, ex);
            }
            acceso = respuesta;
        }else if (accion.equalsIgnoreCase("Eliminar")){
            int IdOficina = Integer.parseInt(request.getParameter("IdOficina"));
            ofi.setIdOficina(IdOficina);
            try {
                ofiDao.delete(IdOficina);
            } catch (Exception ex) {
                Logger.getLogger(ControladorOficina.class.getName()).log(Level.SEVERE, null, ex);
            }
            acceso=respuesta;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
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
        processRequest(request, response);
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
