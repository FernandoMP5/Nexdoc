package co.edu.sena.Nexdoc.persistensia.dao;

import co.edu.sena.Nexdoc.persistensia.vo.Funcionario;
import co.edu.sena.Nexdoc.persistensia.vo.Cargo;
import co.edu.sena.Nexdoc.persistensia.vo.Oficina;
import co.edu.sena.Nexdoc.persistensia.vo.Persona;
import co.edu.sena.Nexdoc.persistensia.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Funcionario fun = new Funcionario();
    private String sql = null;
    private ArrayList<Funcionario> list = new ArrayList<>();
    private int r;

    public FuncionarioDAO(Connection con) {
        this.con = con;
    }

    public int validar(Funcionario fun) throws Exception {
        r = 0;
        try {
            sql = "SELECT * FROM funcionario WHERE Usuario='" + fun.getUsuario() + "' AND Clave='" + fun.getContraseña() + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.absolute(1)) {
                ++r;
                fun.setUsuario(rs.getString("Usuario"));
                fun.setContraseña(rs.getString("Clave"));
                if (r == 1) {
                    break;
                }
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al validar usuario");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    public List listar() throws Exception {
        try {
            sql = "SELECT F.IdPersona,F.Clave,F.IdFuncionario,CONCAT((P.Nombre),' ',P.Apellido)Nombre,C.Descripcion,O.Nombre FROM funcionario F INNER JOIN cargo C ON F.IdCargo=C.IdCargo INNER JOIN oficina O ON F.IdOficina=O.IdOficina INNER JOIN persona P ON P.IdPersona=F.IdPersona";
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario fun = new Funcionario();
                Cargo car = new Cargo();
                Oficina ofi = new Oficina();
                Persona per = new Persona();
                fun.setId(rs.getInt("F.IdFuncionario"));
                per.setNombre(rs.getString("Nombre"));
                fun.setUsuario(per.getNombre());
                fun.setContraseña(rs.getString("F.Clave"));
                car.setDescripcion(rs.getString("C.Descripcion"));
                fun.setIdCargo(car.getDescripcion());
                fun.setIdPersona(rs.getString("F.IdPersona"));
                ofi.setNombre(rs.getString("O.Nombre"));
                fun.setIdOficina(ofi.getNombre());
                list.add(fun);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al listar los funcionarios");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    public boolean add(Funcionario fun) throws Exception {
        try {
            sql = "INSERT INTO funcionario(Usuario,Clave,IdCargo,IdPersona,IdOficina)"
                    + "VALUES('" + fun.getUsuario() + "','" + fun.getContraseña() + "','" + fun.getIdCargo() + "','" + fun.getIdPersona() + "','" + fun.getIdOficina() + "')";
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al agregar un funcionario");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    public boolean edit(Funcionario fun) throws Exception {
        try {
            sql = "UPDATE funcionario SET Usuario='" + fun.getUsuario() + "',Clave='" + fun.getContraseña() + "',IdCargo='" + fun.getIdCargo() + "',IdOficina='" + fun.getIdOficina() + "' WHERE IdFuncionario=" + fun.getId();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al editar un funcionario");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    public boolean delete(int IdFuncionario) throws Exception {
        try {
            sql = "DELETE FROM funcionario WHERE IdFuncionario=" + IdFuncionario;
            ps = con.prepareCall(sql);
            ps.executeUpdate();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al eliminar a un funcionario");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    public Funcionario List(int IdFuncionario) throws Exception {
        try {
            sql = "SELECT * FROM funcionario WHERE IdFuncionario=" + IdFuncionario;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                fun.setId(rs.getInt("IdFuncionario"));
                fun.setUsuario(rs.getString("Usuario"));
                fun.setIdCargo(rs.getString("IdCargo"));
                fun.setIdOficina(rs.getString("IdOficina"));
            }
            return fun;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al listar un funcionario");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }
}
