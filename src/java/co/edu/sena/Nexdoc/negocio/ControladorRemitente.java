package co.edu.sena.Nexdoc.negocio;

import co.edu.sena.Nexdoc.persistensia.dao.PersonaDAO;
import co.edu.sena.Nexdoc.persistensia.dao.RemitenteDAO;
import co.edu.sena.Nexdoc.persistensia.vo.Persona;
import co.edu.sena.Nexdoc.persistensia.vo.Remitente;
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

public class ControladorRemitente extends HttpServlet {

    Connection con;
    Remitente rem = new Remitente();
    Persona per = new Persona();
    RemitenteDAO daoRem = new RemitenteDAO(con);
    PersonaDAO daoPer = new PersonaDAO(con);
    String respuesta = "EnvioExitoso.jsp";
    String editar = "EditarRem.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorRemitente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorRemitente at " + request.getContextPath() + "</h1>");
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
        if (accion.equalsIgnoreCase("Registrar Remitente")) {
            String nombre = request.getParameter("txtnombre");
            String apellido = request.getParameter("txtapellido");
            int tipoidentificacion = Integer.parseInt(request.getParameter("cbotipoidentificacion"));
            String documento = request.getParameter("txtdocumento");
            String correo = request.getParameter("txtcorreo");
            int telefono = Integer.parseInt(request.getParameter("txttelefono"));
            int municipio = Integer.parseInt(request.getParameter("cbomunicipio"));
            String direccion = request.getParameter("txtdireccion");
            rem.setIdPersona(documento);
            per.setNombre(nombre);
            per.setApellido(apellido);
            per.setTipoIdentificacion(tipoidentificacion);
            per.setIdPersona(documento);
            per.setCorreo(correo);
            per.setTelefono(telefono);
            per.setIdMunicipio(municipio);
            per.setDireccion(direccion);
            try {
                daoPer.add(per);
            } catch (Exception ex) {
                Logger.getLogger(ControladorRemitente.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                daoRem.add(rem);
            } catch (Exception ex) {
                Logger.getLogger(ControladorRemitente.class.getName()).log(Level.SEVERE, null, ex);
            }
            acceso=respuesta;
        } else if (accion.equalsIgnoreCase("Editar")) {
            request.setAttribute("IdRemitente", request.getParameter("IdRemitente"));
            request.setAttribute("IdPersona", request.getParameter("IdPersona"));
            acceso = editar;
        } else if (accion.equalsIgnoreCase("Editar Funcionario")) {
            int IdRemitente = Integer.parseInt(request.getParameter("txtidremitente"));
            String IdPersona = request.getParameter("txtidpersona");
            String nombre = request.getParameter("txtnombre");
            String apellido = request.getParameter("txtapellido");
            int tipoidentificacion = Integer.parseInt(request.getParameter("cbotipoidentificacion"));
            String documento = request.getParameter("txtdocumento");
            String correo = request.getParameter("txtcorreo");
            int telefono = Integer.parseInt(request.getParameter("txttelefono"));
            int municipio = Integer.parseInt(request.getParameter("cbomunicipio"));
            String direccion = request.getParameter("txtdireccion");
            rem.setIdRemitente(IdRemitente);
            per.setIdPersona(IdPersona);
            per.setNombre(nombre);
            per.setApellido(apellido);
            per.setTipoIdentificacion(tipoidentificacion);
            per.setIdPersona(documento);
            per.setCorreo(correo);
            per.setTelefono(telefono);
            per.setIdMunicipio(municipio);
            per.setDireccion(direccion);
            try {
                daoPer.edit(per);
            } catch (Exception ex) {
                Logger.getLogger(ControladorRemitente.class.getName()).log(Level.SEVERE, null, ex);
            }
            acceso = respuesta;
        } else if (accion.equalsIgnoreCase("Eliminar")) {
            int IdRemitente = Integer.parseInt(request.getParameter("IdRemitente"));
            rem.setIdRemitente(IdRemitente);
            try {
                daoRem.delete(IdRemitente);
            } catch (Exception ex) {
                Logger.getLogger(ControladorRemitente.class.getName()).log(Level.SEVERE, null, ex);
            }
            acceso = respuesta;
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
