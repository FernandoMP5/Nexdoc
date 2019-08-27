package co.edu.sena.Nexdoc.persistensia.dao;

import co.edu.sena.Nexdoc.persistensia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistensia.vo.Remitente;
import co.edu.sena.Nexdoc.persistensia.vo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RemitenteDAO {

    private Connection con;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    ArrayList<Remitente> list = new ArrayList<>();
    Remitente rem = new Remitente();
    Persona per = new Persona();

    public RemitenteDAO(Connection con) {
        this.con = con;
    }

    public List listar() throws Exception {
        try {
            sql = "SELECT * FROM remitente";
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Remitente rem = new Remitente();
                rem.setIdRemitente(rs.getInt("IdRemitente"));
                rem.setIdPersona(rs.getString("IdPersona"));
                list.add(rem);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al listar los remitentes");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    public boolean add(Remitente rem) throws Exception {
        try {
            sql = "INSERT INTO remitente(IdPersona) VALUES('" + rem.getIdPersona() + "')";
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al agregar al remitente");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    public boolean edit(Remitente rem) throws Exception {
        try {
            sql = "UPDATE remitente SET IdPersona=" + rem.getIdPersona();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al editar el remitente");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    public boolean delete(int IdRemitente) throws Exception {
        try {
            sql = "DELETE FROM remitente WHERE IdRemitente='" + IdRemitente + "'";
            ps = con.prepareCall(sql);
            ps.executeUpdate();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al deshabilitar al remitente");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    public Remitente List(int IdRemitente) throws Exception {
        try {
            sql = "SELECT * FROM remitente WHERE IdRemitente=" + IdRemitente;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                rem.setIdRemitente(rs.getInt("IdRemitente"));
                rem.setIdPersona(rs.getString("IdPersona"));
            }
        return rem;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al listar el remitente");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }
}
