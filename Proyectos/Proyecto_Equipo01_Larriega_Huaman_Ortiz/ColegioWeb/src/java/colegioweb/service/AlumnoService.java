package colegioweb.service;

import colegioweb.db.AccesoDB;
import colegioweb.domain.Alumnos;
import colegioweb.domain.Matriculados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlumnoService {

    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE usuario=?";

    public String insertar(Alumnos bean) {
        String rpta = "";
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "INSERT INTO alumnos (usuario,nombres,apellidos,email"
                    + ",password,matriculado) VALUES (?,?,?,?,?,?)";
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, bean.getUsuario());
            psd.setString(2, bean.getNombres());
            psd.setString(3, bean.getApellidos());
            psd.setString(4, bean.getEmail());
            psd.setString(5, bean.getPassword());
            psd.setString(6, "no");
            int n1 = psd.executeUpdate();
            if (n1 > 0) {
                rpta = "OK";
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }

    public String actualizar(Alumnos bean) {
        String rpta = "";
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "UPDATE alumnos SET nombres=?,apellidos=?,email=? WHERE usuario=?";
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, bean.getNombres());
            psd.setString(2, bean.getApellidos());
            psd.setString(3, bean.getEmail());
            psd.setString(4, bean.getUsuario());
            int n1 = psd.executeUpdate();
            if (n1 > 0) {
                rpta = "OK";
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }

    public String cambiarContraseña(String pass, String usuario) {
        String rpta = "";
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "UPDATE alumnos SET password=? WHERE usuario=?";
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, pass);
            psd.setString(2, usuario);
            int n = psd.executeUpdate();
            if (n > 0) {
                rpta = "OK";
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }

    public String EstaMatriculado(String usuario) {
        Connection cn = null;
        String matriculado = "";
        try {
            cn = AccesoDB.getConnection();
            String sql = "Select * from alumnos where usuario=?";
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, usuario);
            ResultSet rs = psd.executeQuery();
            rs.next();
            matriculado = rs.getString("matriculado");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return matriculado;
    }

    public void matricularse(Matriculados bean) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "INSERT INTO matriculados (codigoMatricula,usuario,grado,anio)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, bean.getCodigo());
            psd.setString(2, bean.getUsuario());
            psd.setString(3, bean.getGrado());
            psd.setString(4, bean.getAnio());
            int n1 = psd.executeUpdate();
            if (n1 > 0) {

            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }

    public void matricularseCurso(Matriculados bean) {

        Connection cn = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            cn = AccesoDB.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery("Select * from curso");
            PreparedStatement psd = null;
            String codigoCurso;
            while (rs.next()) {
                codigoCurso = rs.getString("codigo");
                try {
                    psd = cn.prepareStatement("INSERT INTO matriculadoscurso (codigoMatricula,codigoCurso,registroNotas)"
                            + " values (?,?,?)");
                    psd.setString(1, bean.getCodigo());
                    psd.setString(2, codigoCurso);
                    psd.setString(3, "no");
                    psd.executeUpdate();
                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    try {
                        if (psd != null) {
                            psd.close();
                        }
                    } catch (SQLException sqle) {
                    }
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException sqle) {
            }
        }

    }

    public String actualizarEstadoMatricula(String usuario) {
        String rpta = "";
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "UPDATE alumnos SET matriculado=? WHERE usuario=?";
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, "si");
            psd.setString(2, usuario);
            int n1 = psd.executeUpdate();
            if (n1 > 0) {
                rpta = "OK";
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }

    public List<Alumnos> leerDatos() throws SQLException {
        Connection cn = null;
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Alumnos> lista = new ArrayList();
        try {
            cn = AccesoDB.getConnection();
            ps = cn.prepareStatement("Select * from alumnos");
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Alumnos(rs.getString("nombres"), rs.getString("apellidos"), rs.getString("email"),
                        rs.getString("usuario"), rs.getString("password"), rs.getString("matriculado")));
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            cn.close();
        }
    }

    public boolean delete(Object key) throws SQLException {
        Connection cn = null;
        PreparedStatement psd;
        try {
            cn = AccesoDB.getConnection();
            psd = cn.prepareStatement(SQL_DELETE);
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
}
