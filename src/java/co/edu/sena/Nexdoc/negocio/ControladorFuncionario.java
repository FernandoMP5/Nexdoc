package co.edu.sena.Nexdoc.negocio;

import co.edu.sena.Nexdoc.persistensia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistensia.dao.PersonaDAO;
import co.edu.sena.Nexdoc.persistensia.dao.FuncionarioDAO;
import co.edu.sena.Nexdoc.persistensia.vo.Funcionario;
import co.edu.sena.Nexdoc.persistensia.vo.Persona;
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

public class ControladorFuncionario extends HttpServlet {

    private Connection con;
    private Funcionario fun = new Funcionario();
    private Persona per = new Persona();
    private Conexion cn = new Conexion();
    private FuncionarioDAO daoFun = new FuncionarioDAO(con);
    private PersonaDAO daoPer = new PersonaDAO(con);
    int r;

    public ControladorFuncionario() throws Exception {
        this.daoFun = new FuncionarioDAO(cn.conectar());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorFuncionario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorFuncionario at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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
        String acceso = "";
        String accion = request.getParameter("accion");
        if (accion.equals("Ingresar")) {
            try {
                String usuario = request.getParameter("txtusuario");
                String contraseña = request.getParameter("txtclave");
                fun.setUsuario(usuario);
                fun.setContraseña(contraseña);
                r = daoFun.validar(fun);
                if (r == 1) {
                    request.getRequestDispatcher("inicio.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } catch (Exception ex) {
                Logger.getLogger(ControladorFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (accion.equalsIgnoreCase("Registrar Funcionario")) {
            String nombre = request.getParameter("txtnombre");
            String apellido = request.getParameter("txtapellido");
            int tipoidentificacion = Integer.parseInt(request.getParameter("cbotipoidentificacion"));
            String documento = request.getParameter("txtdocumento");
            String correo = request.getParameter("txtcorreo");
            int telefono = Integer.parseInt(request.getParameter("txttelefono"));
            int municipio = Integer.parseInt(request.getParameter("cbomunicipio"));
            String direccion = request.getParameter("txtdireccion");
            String usuario = request.getParameter("txtusuario");
            String clave = request.getParameter("txtclave");
            String idcargo = request.getParameter("cbocargo");
            String idoficina = request.getParameter("cbooficina");
            fun.setUsuario(usuario);
            fun.setContraseña(clave);
            fun.setIdCargo(idcargo);
            fun.setIdPersona(documento);
            fun.setIdOficina(idoficina);
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
                Logger.getLogger(ControladorFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                daoFun.add(fun);
            } catch (Exception ex) {
                Logger.getLogger(ControladorFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (accion.equalsIgnoreCase("Editar")) {
            request.setAttribute("IdFuncionario", request.getParameter("IdFuncionario"));
            request.setAttribute("IdPersona", request.getParameter("IdPersona"));
        } else if (accion.equalsIgnoreCase("Editar Funcionario")) {
            int IdFuncionario = Integer.parseInt(request.getParameter("txtidfuncionario"));
            String IdPersona = request.getParameter("txtidpersona");
            String nombre = request.getParameter("txtnombre");
            String apellido = request.getParameter("txtapellido");
            int tipoidentificacion = Integer.parseInt(request.getParameter("cbotipoidentificacion"));
            String documento = request.getParameter("txtdocumento");
            String correo = request.getParameter("txtcorreo");
            int telefono = Integer.parseInt(request.getParameter("txttelefono"));
            int municipio = Integer.parseInt(request.getParameter("cbomunicipio"));
            String direccion = request.getParameter("txtdireccion");
            String usuario = request.getParameter("txtusuario");
            String clave = request.getParameter("txtclave");
            String idcargo = request.getParameter("cbocargo");
            String idoficina = request.getParameter("cbooficina");
            fun.setId(IdFuncionario);
            fun.setUsuario(usuario);
            fun.setContraseña(clave);
            fun.setIdCargo(idcargo);
            fun.setIdPersona(documento);
            fun.setIdOficina(idoficina);
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
                daoFun.edit(fun);
            } catch (Exception ex) {
                Logger.getLogger(ControladorFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                daoPer.edit(per);
            } catch (Exception ex) {
                Logger.getLogger(ControladorFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (accion.equalsIgnoreCase("Eliminar")) {
            int IdFuncionario = Integer.parseInt(request.getParameter("IdFuncionario"));
            fun.setId(IdFuncionario);
            try {
                daoFun.delete(IdFuncionario);
            } catch (Exception ex) {
                Logger.getLogger(ControladorFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
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
