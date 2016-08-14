/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegioweb.service;

import colegioweb.db.AccesoDB;
import colegioweb.domain.Matriculados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class MatriculadosService {
    public List<Matriculados> leerDatos() throws SQLException {
        Connection cn=null;
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Matriculados> lista = new ArrayList();
        try {
            cn=AccesoDB.getConnection();
            ps = cn.prepareStatement("Select * from matriculados m"
                    + " INNER JOIN alumnos a"
                    + " ON a.usuario=m.usuario");
            rs = ps.executeQuery();
            while (rs.next()) {
                Matriculados m=new Matriculados();
                m.setCodigo(rs.getString("m.codigoMatricula"));
                m.setUsuario(rs.getString("m.usuario"));
                m.setGrado(rs.getString("m.grado"));
                m.setAnio(rs.getString("m.anio"));
                m.setNombres(rs.getString("a.nombres"));
                m.setApellidos(rs.getString("a.apellidos"));
                lista.add(m);
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            cn.close();
        }	
    }
}
