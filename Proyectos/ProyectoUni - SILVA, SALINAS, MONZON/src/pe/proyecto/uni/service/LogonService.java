package pe.proyecto.uni.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.proyecto.uni.domain.Empleado;
import pe.proyecto.uni.db.AccesoDB;

public class LogonService {

	public Empleado validar(String usuario, String clave){
	    Empleado bean = null;
	    Connection cn = null;    
	    try {
	      cn = AccesoDB.getConnection();
	      String sql = "{call spPV_Usuario_ObtenerInicioSession(?,?)}";
	      PreparedStatement pstm = cn.prepareStatement(sql);
	      pstm.setString(1, usuario);
	      pstm.setString(2, clave);
	      ResultSet rs = pstm.executeQuery();
	      if(rs.next()){
	        bean = new Empleado();
	        bean.setCodigo(rs.getString("iCodUsu"));
	        bean.setUsuario(rs.getString("vLogUsu"));
	        bean.setNombre(rs.getString("vNomUsu"));
	        bean.setPaterno(rs.getString("vApeMat"));
	      } else {
	        throw new RuntimeException("Datos incorrectos.");
	      }
	      rs.close();
	      pstm.close();
	    } catch (Exception e) {
	      throw new RuntimeException(e.getMessage());
	    } finally{
	      try {
	        cn.close();
	      } catch (Exception e) {
	      }
	    }
	    return bean;
	  }
	
}
