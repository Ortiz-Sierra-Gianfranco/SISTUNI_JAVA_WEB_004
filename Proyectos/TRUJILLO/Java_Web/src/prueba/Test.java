
package prueba;

import Database.AccesoDB;
import java.sql.Connection;


public class Test {

   
    public static void main(String[] args) {
      
        try {
            Connection cn= AccesoDB.getConnection();
            System.out.println("Conexion conforme...");
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
    }
}
