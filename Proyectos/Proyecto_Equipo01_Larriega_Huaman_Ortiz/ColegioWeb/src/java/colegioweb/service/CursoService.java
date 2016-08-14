package colegioweb.service;

import colegioweb.db.AccesoDB;
import colegioweb.domain.Cursos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoService {

    private final Connection cn;

    private static final String SQL_INSERT = "INSERT INTO curso VALUES(?,?)";
    private static final String SQL_DELETE = "DELETE FROM curso WHERE codigo=?";
    private static final String SQL_UPDATE = "UPDATE curso SET nombre=? WHERE codigo=?";
    private static final String SQL_READ = "SELECT * FROM curso WHERE codigo=?";
    private static final String SQL_READALL = "SELECT * FROM curso";

    public CursoService() throws ClassNotFoundException {
        this.cn = AccesoDB.getConnection();
    }

    public boolean create(Cursos o) throws SQLException {
        try {
            PreparedStatement psd = cn.prepareStatement(SQL_INSERT);
            psd.setString(1, o.getCodigo());
            psd.setString(2, o.getNombre());
            if (psd.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            cn.close();
        }
        return false;
    }

    public boolean delete(Object key) throws SQLException {
        try {
            PreparedStatement psd = cn.prepareStatement(SQL_DELETE);
            psd.setString(1, key.toString());
            if (psd.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            cn.close();
        }
        return false;
    }

    public boolean update(Cursos o) throws SQLException {
        try {
            PreparedStatement psd = cn.prepareStatement(SQL_UPDATE);
            psd.setString(1, o.getNombre());
            psd.setString(2, o.getCodigo());
            if (psd.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            cn.close();
        }
        return false;
    }

    public Cursos read(Object key) throws SQLException {
        Cursos curso = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = cn.prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                curso = new Cursos(rs.getString(1), rs.getString(2));
            }
            return curso;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            cn.close();
        }
    }

    public List<Cursos> readAll() throws SQLException, ClassNotFoundException {
        Connection con=AccesoDB.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Cursos> lista = new ArrayList();
        try {
            ps = con.prepareStatement(SQL_READALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Cursos(rs.getString(1), rs.getString(2)));
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            con.close();
        }
    }

}
