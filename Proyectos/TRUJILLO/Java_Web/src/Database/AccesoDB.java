package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDB {
	
    public AccesoDB() {
    }

    public static Connection getConnection() throws Exception {
        Connection cn;
        try {
            // carga driver en memoria
            Class.forName("oracle.jdbc.OracleDriver");
            // url de la base de datos
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            // obtener la conexion a la base de datos
            cn = DriverManager.getConnection(url, "ventas", "ventas");           
        } catch (SQLException e) {
            throw e;
        }
         return cn;
    }
}
