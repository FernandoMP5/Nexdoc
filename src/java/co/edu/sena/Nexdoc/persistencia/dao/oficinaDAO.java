/** @author Sena */
package co.edu.sena.Nexdoc.persistensia.dao;

import co.edu.sena.Nexdoc.persistensia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistensia.vo.documentoVO;
import co.edu.sena.Nexdoc.persistensia.vo.oficinaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class oficinaDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    private String sql = "";
    private ArrayList<oficinaVO> lista = new ArrayList<>();

    public oficinaDAO(Connection con) {
        this.con=con;
    }

    public List listarOficina() throws Exception {
        sql = "SELECT * FROM oficina";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                oficinaVO oficinaVO = new oficinaVO();
                oficinaVO.setIdOficina(rs.getInt("idOficina"));
                oficinaVO.setNombreOficina(rs.getString("nombreOficina"));
                oficinaVO.setTelefonoOficina(rs.getDouble("telefonoOficina"));
                lista.add(oficinaVO);
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception("Error al listar oficina");
        }
    }

    public boolean agregarOficina(oficinaVO oficinaVO) throws Exception {
        sql = "INSERT INTO oficina VALUES (" + oficinaVO.getIdOficina() + ",'" + oficinaVO.getNombreOficina() + "'," + oficinaVO.getTelefonoOficina() + ")";
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return false;
        } catch (SQLException e) {
            throw new Exception("Error al registrar oficina");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

}//fin clase oficinaDAO
