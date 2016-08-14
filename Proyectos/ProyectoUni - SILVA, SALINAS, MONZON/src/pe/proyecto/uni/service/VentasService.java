package pe.proyecto.uni.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pe.proyecto.uni.db.AccesoDB;
import pe.proyecto.uni.domain.Empleado;
import pe.proyecto.uni.domain.Venta;

public class VentasService {

	public boolean RegistrarVenta(String idEmpleado,String NomCliente,String xmlDetalle) {
	    Connection cn = null;
	    try {
	      // Conexión con la BD
	      cn = AccesoDB.getConnection();
	      // Realiza consulta
	      String sql = "{call spPV_Venta_Registrar(?,?,?)}";
	      PreparedStatement pstm = cn.prepareStatement(sql);
	      pstm.setString(1, idEmpleado);
	      pstm.setString(2, NomCliente);
	      pstm.setString(3, xmlDetalle);
	      pstm.executeUpdate();
	      pstm.close();
		    return true;
	    } catch (Exception e) {
	      System.err.println(e.getMessage());
		  return false;
	    } finally {
	      try {
	        cn.close();
	      } catch (Exception e) {
	  	    return false;
	      }
	    }

	  }
	
	public ArrayList<Venta> ListarVenta(int idVenta,String NomCliente) {
	    Connection cn = null;
	    Venta DatosVenta = null;
	    ArrayList<Venta> bean = new ArrayList<Venta>();
	    try {
	      // Conexión con la BD
	      cn = AccesoDB.getConnection();
	      // Realiza consulta
	      String sql = "{call spPV_Venta_Listar(?,?)}";
	      PreparedStatement pstm = cn.prepareStatement(sql);
	      pstm.setInt(1, idVenta);
	      pstm.setString(2, NomCliente);
	      ResultSet rs = pstm.executeQuery();
	      
	      while (rs.next())
	      {
	    	  	DatosVenta = new Venta();
	    	  	DatosVenta.setIdVenta(rs.getInt("idventa"));
	    	  	DatosVenta.setCliente(rs.getString("cliente"));
	    	  	DatosVenta.setMetodoPago(rs.getString("MetodoPago"));
	    	  	DatosVenta.setSubTotal(rs.getDouble("subTotal"));
	    	  	DatosVenta.setIgv(rs.getDouble("igv"));
	    	  	DatosVenta.setImporte(rs.getDouble("importe"));
	    	  	DatosVenta.setUsuario(rs.getString("usuario"));
	    	  	DatosVenta.setFecha(rs.getDate("fecha"));
	    	  	bean.add(DatosVenta);
		   }
		      rs.close();
		      pstm.close();
		      
	    } catch (Exception e) {
	      System.err.println(e.getMessage());
	    } 
	    return bean;
	  }
}
