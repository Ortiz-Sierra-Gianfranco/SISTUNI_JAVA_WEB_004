package pe.proyecto.uni.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class AccesoDB {
	private AccesoDB() {
	  }

	  public static Connection getConnection() throws SQLException {
	    Connection cn = null;
	    try {
	    	DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
	      // Paso 1: Cargar el driver a memoria 
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	      // Paso 2: Obtener el objeto Connection 
	    	String url = "jdbc:sqlserver://localhost;databaseName=BDPROYECTOVENTAS";
	    	//String url = "jdbc:sqlserver://tracetop.no-ip.org:40000;databaseName=BDPROYECTOVENTAS";
	    	Properties properties = new Properties();
	    	properties.put("user", "uni");
	    	properties.put("password", "proyectouni");
	    	cn = DriverManager.getConnection(url, properties);
	    	
	    	//String url = "jdbc:oracle:thin:@172.17.2.164:1521:XE";
	        //cn = DriverManager.getConnection(url, "eureka", "admin");
	    } catch (SQLException e) {
	      throw e;
	    } catch (ClassNotFoundException e) {
	      throw new SQLException("No se encontró el driver de la base de datos.");
	    } catch (Exception e) {
	      throw new SQLException("No se puede establecer la conexión con la BD.");
	    }
	    return cn;
	  }
}
