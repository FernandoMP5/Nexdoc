/** @author Sena */
package co.edu.sena.Nexdoc.persistencia.dao;

import co.edu.sena.Nexdoc.persistencia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistencia.vo.personaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class personaDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    private String sql = "";
    private final ArrayList<personaVO> lista = new ArrayList<>();
    int r;

    public personaDAO(Connection con) {
        this.con = con;
    }

    public int validar(personaVO personaVO) throws Exception {
        r = 0;
        sql = "SELECT * FROM persona WHERE usuario='" + personaVO.getUsuario() + "' AND clave='" + personaVO.getClave() + "'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.absolute(1)) {
                ++r;
                personaVO.setNumeroIdentificacion(rs.getString("numeroIdentificacion"));
                personaVO.setTipoIdentificacion(rs.getInt("tipoIdentifcicacion"));
                personaVO.setNombre(rs.getString("nombre"));
                personaVO.setApellido(rs.getString("apellido"));
                personaVO.setCorreo(rs.getString("correo"));
                personaVO.setTelefonoFijo(rs.getDouble("telefonoFijo"));
                personaVO.setTelefonoCelular(rs.getDouble("telefonoCelular"));
                personaVO.setDireccion(rs.getString("direccion"));
                personaVO.setRol(rs.getInt("rol"));
                personaVO.setUsuario(rs.getString("usuario"));
                personaVO.setClave(rs.getString("clave"));
                personaVO.setOficina(rs.getInt("oficina"));
                if (r == 1) {
                    break;
                }
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            throw new Exception("Error al validar usuario" + e);
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    public boolean agregarPersona(personaVO personaVO) throws Exception {
        try {
            sql = "INSERT INTO persona(numeroIdentificacion,tipoIdentifcicacion,nombre,apellido,correo,telefonoFijo,telefonoCelular,direccion,rol,usuario,clave,oficina)"
                    + "VALUES('" + personaVO.getNumeroIdentificacion() + "',"
                    + "" + personaVO.getTipoIdentificacion() + ","
                    + "'" + personaVO.getNombre() + "',"
                    + "'" + personaVO.getApellido() + "',"
                    + "'" + personaVO.getCorreo() + "',"
                    + "" + personaVO.getTelefonoFijo() + ","
                    + "" + personaVO.getTelefonoCelular() + ","
                    + "'" + personaVO.getDireccion() + "',"
                    + "" + personaVO.getRol() + ","
                    + "'" + personaVO.getUsuario() + "',"
                    + "'" + personaVO.getClave() + "',"
                    + "" + personaVO.getOficina() + ")";
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return false;
        } catch (Exception e) {
            throw new Exception("Error al agregar a la persona");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    public boolean actualizarPersona(String numeroIdentificacion, personaVO personaVO) throws Exception {
        try {
            sql = "UPDATE persona SET"
                    + "numeroIdentificacion = '" + personaVO.getNumeroIdentificacion() + "',"
                    + "tipoIdentifcicacion = " + personaVO.getTipoIdentificacion() + ","
                    + "nombre = '" + personaVO.getNombre() + "',"
                    + "apellido = '" + personaVO.getApellido() + "',"
                    + "correo = '" + personaVO.getCorreo() + "',"
                    + "telefonoFijo = " + personaVO.getTelefonoFijo() + ","
                    + "telefonoCelular = " + personaVO.getTelefonoCelular() + ","
                    + "direccion = '" + personaVO.getDireccion() + "',"
                    + "rol = " + personaVO.getRol() + ","
                    + "usuario = '" + personaVO.getUsuario() + "',"
                    + "clave = '" + personaVO.getClave() + "',"
                    + "oficina = " + personaVO.getOficina() + ""
                    + "WHERE numeroIdentificacion=" + numeroIdentificacion;
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return false;
        } catch (Exception e) {
            throw new Exception("Error al actualizar a la persona");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

}//fin clase personaDAO
