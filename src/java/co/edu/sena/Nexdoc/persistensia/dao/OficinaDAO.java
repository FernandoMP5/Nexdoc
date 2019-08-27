package co.edu.sena.Nexdoc.persistensia.dao;

import co.edu.sena.Nexdoc.persistensia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistensia.vo.Oficina;
import co.edu.sena.Nexdoc.persistensia.vo.Sede;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OficinaDAO {

    private final Connection con;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    private final ArrayList<Oficina> list = new ArrayList<>();

    public OficinaDAO(Connection con) {
        this.con = con;
    }

    public List listar() throws Exception {
        try {
            sql = "SELECT O.Nombre,O.IdOficina,O.Telefono_Extencion,S.Nombre FROM oficina O INNER JOIN sede S ON O.IdSede=S.IdSede ORDER BY O.Nombre ASC";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Oficina ofi = new Oficina();
                Sede sede = new Sede();
                ofi.setIdOficina(rs.getInt("O.IdOficina"));
                ofi.setNombre(rs.getString("O.Nombre"));
                ofi.setTelefonoExtencion(rs.getString("O.Telefono_Extencion"));
                sede.setNombre(rs.getString("S.Nombre"));
                ofi.setIdSede(sede.getNombre());
                list.add(ofi);
            }
            return list;
        } catch (SQLException e) {
            throw new Exception("Error al listar las oficinas" + e);
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    Oficina ofi = new Oficina();

    public boolean add(Oficina ofi) throws Exception {
        try {
            sql = "INSERT INTO oficina(Nombre,Telefono_Extencion,IdSede) VALUES('" + ofi.getNombre() + "','" + ofi.getTelefonoExtencion() + "'," + ofi.getIdSede() + ")";
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return false;
        } catch (SQLException e) {
            throw new Exception("Error al agregar la oficina" + e);
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    public boolean edit(Oficina ofi) throws Exception {
        try {
            sql = "UPDATE oficina SET Nombre='" + ofi.getNombre() + "',Telefono_Extencion='" + ofi.getTelefonoExtencion() + "',IdSede=" + ofi.getIdSede() + " WHERE IdOficina=" + ofi.getIdOficina();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return false;
        } catch (SQLException e) {
            throw new Exception("Error al actualizar la oficina" + e);
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    public boolean delete(int IdOficina) throws Exception {
        try {
            sql = "DELETE FROM oficina WHERE IdOficina=" + IdOficina;
            ps = con.prepareCall(sql);
            ps.executeUpdate();
            return false;
        } catch (SQLException e) {
            throw new Exception("Error al deshabilitar la oficina" + e);
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }
}
