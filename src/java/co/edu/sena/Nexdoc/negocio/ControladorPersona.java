/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.Nexdoc.negocio;

import co.edu.sena.Nexdoc.persistencia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistencia.dao.personaDAO;
import co.edu.sena.Nexdoc.persistencia.vo.personaVO;
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

public class ControladorPersona extends HttpServlet {

    Connection con;
    Conexion cn = new Conexion();
    personaVO personaVO = new personaVO();
    personaDAO personaDAO = new personaDAO(con);
    int r;

    public ControladorPersona() throws Exception {
        this.personaDAO = new personaDAO(cn.conectar());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorPersona</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorPersona at " + request.getContextPath() + "</h1>");
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
        r = 0;
        String acceso = "";
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Ingresar")) {
            try {
                String usuario = request.getParameter("txtusuario");
                String contraseña = request.getParameter("txtclave");
                personaVO.setUsuario(usuario);
                personaVO.setClave(contraseña);
                r = personaDAO.validar(personaVO);
                if (r == 1) {
                    try (PrintWriter out = response.getWriter()) {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet ControladorPersona</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Servlet ControladorPersona at " + request.getContextPath() + "</h1>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                } else {
                    request.getRequestDispatcher("inicio.jsp").forward(request, response);
                }
            } catch (Exception ex) {
                Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        if (accion.equalsIgnoreCase("Registrar Persona")) {
//            String nombre = request.getParameter("txtnombre");
//            String apellido = request.getParameter("txtapellido");
//            int tipoIdentificacion = Integer.parseInt(request.getParameter("cbotipoidentificacion"));
//            String numeroIdentificacion = request.getParameter("txtdocumento");
//            String correo = request.getParameter("txtcorreo");
//            double telefonoFijo = Integer.parseInt(request.getParameter("txttelefonoFijo"));
//            double telefonoCelular = Integer.parseInt(request.getParameter("txttelefonoCelular"));
//            String direccion = request.getParameter("txtdireccion");
//            int rol = Integer.parseInt(request.getParameter("cbocargo"));
//            int idOficina = Integer.parseInt(request.getParameter("cbooficina"));
//            String usuario = request.getParameter("txtusuario");
//            String clave = request.getParameter("txtclave");
//            personaVO.setNumeroIdentificacion(numeroIdentificacion);
//            personaVO.setTipoIdentificacion(tipoIdentificacion);
//            personaVO.setNombre(nombre);
//            personaVO.setApellido(apellido);
//            personaVO.setCorreo(correo);
//            personaVO.setTelefonoFijo(telefonoFijo);
//            personaVO.setTelefonoCelular(telefonoCelular);
//            personaVO.setDireccion(direccion);
//            personaVO.setRol(rol);
//            personaVO.setUsuario(usuario);
//            personaVO.setClave(clave);
//            personaVO.setOficina(idOficina);
//            try {
//                personaDAO.agregarPersona(personaVO);
//            } catch (Exception ex) {
//                Logger.getLogger(ControladorFuncionario.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else if (accion.equalsIgnoreCase("Editar Funcionario")) {
//            String nombre = request.getParameter("txtnombre");
//            String apellido = request.getParameter("txtapellido");
//            int tipoIdentificacion = Integer.parseInt(request.getParameter("cbotipoidentificacion"));
//            String numeroIdentificacion = request.getParameter("txtdocumento");
//            String correo = request.getParameter("txtcorreo");
//            double telefonoFijo = Integer.parseInt(request.getParameter("txttelefonoFijo"));
//            double telefonoCelular = Integer.parseInt(request.getParameter("txttelefonoCelular"));
//            String direccion = request.getParameter("txtdireccion");
//            int rol = Integer.parseInt(request.getParameter("cbocargo"));
//            int idOficina = Integer.parseInt(request.getParameter("cbooficina"));
//            String usuario = request.getParameter("txtusuario");
//            String clave = request.getParameter("txtclave");
//            personaVO.setNumeroIdentificacion(numeroIdentificacion);
//            personaVO.setTipoIdentificacion(tipoIdentificacion);
//            personaVO.setNombre(nombre);
//            personaVO.setApellido(apellido);
//            personaVO.setCorreo(correo);
//            personaVO.setTelefonoFijo(telefonoFijo);
//            personaVO.setTelefonoCelular(telefonoCelular);
//            personaVO.setDireccion(direccion);
//            personaVO.setRol(rol);
//            personaVO.setUsuario(usuario);
//            personaVO.setClave(clave);
//            personaVO.setOficina(idOficina);
//            try {
//                personaDAO.actualizarPersona(numeroIdentificacion,personaVO);
//            } catch (Exception ex) {
//                Logger.getLogger(ControladorFuncionario.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        RequestDispatcher vista = request.getRequestDispatcher(acceso);
//        vista.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
