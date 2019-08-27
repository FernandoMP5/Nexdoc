package co.edu.sena.Nexdoc.persistensia.dao;

import co.edu.sena.Nexdoc.persistensia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistensia.vo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PersonaDAO {

    private Connection con;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    ArrayList<Persona> list = new ArrayList<>();
    Persona per = new Persona();

    public PersonaDAO(Connection con) {
        this.con = con;
    }

    public boolean add(Persona per) throws Exception {
        try {
            sql = "INSERT INTO persona(IdPersona,Nombre,Apellido,Correo,Telefono,IdTipoIdentificacion,Direccion,IdMunicipio)"
                    + "VALUES('" + per.getIdPersona() + "','" + per.getNombre() + "','" + per.getApellido() + "','" + per.getCorreo() + "'," + per.getTelefono() + ",'" + per.getTipoIdentificacion() + "','" + per.getDireccion() + "','" + per.getIdMunicipio() + "')";
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al agregar a la persona");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    public Persona List(String IdPersona) throws Exception {
        try {
            sql = "SELECT * FROM persona WHERE IdPersona='" + IdPersona + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                per.setIdPersona(rs.getString("IdPersona"));
                per.setNombre(rs.getString("Nombre"));
                per.setApellido(rs.getString("Apellido"));
                per.setCorreo(rs.getString("Correo"));
                per.setDireccion(rs.getString("Direccion"));
                per.setTelefono(rs.getInt("Telefono"));
                per.setIdMunicipio(rs.getInt("IdMunicipio"));
                per.setTipoIdentificacion(rs.getInt("IdTipoIdentificacion"));
            }
            return per;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al listar a la persona");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    public boolean edit(Persona per) throws Exception {
        try {
            sql = "UPDATE persona SET Nombre='" + per.getNombre() + "',Apellido='" + per.getApellido() + "',Correo='" + per.getCorreo() + "',Direccion='" + per.getDireccion() + "',Telefono='" + per.getTelefono() + "',IdMunicipio='" + per.getIdMunicipio() + "',IdTipoIdentificacion='" + per.getTipoIdentificacion() + "' WHERE IdPersona='" + per.getIdPersona() + "'";
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al editar a la persona");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }
}
