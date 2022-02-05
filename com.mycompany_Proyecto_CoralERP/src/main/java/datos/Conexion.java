
package datos;

import java.sql.*;
import java.util.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;


public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db_erp?"
                +"useSSL=false&useTimezone=true&serverTimezone=UTC&"
                +"allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = ""; 
    
            //MÉTODO PARA ESTABLECER LA CONEXIÓN
    
    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        ds.setInitialSize(50);
        
        return ds;
    }
    
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();     
    }
    
    
                //MÉTODOS CLOSE DE LA CONEXIÓN
   public static void close(ResultSet rs){
        try{
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace(System.out);
        }
    }
    //*************
      public static void close(PreparedStatement stmt){
        try{
            stmt.close();
        }catch(Exception ex){
            ex.printStackTrace(System.out);
        }
    } 
      
      //*************
      public static void close(Connection conn){
        try{
            conn.close();
        }catch(Exception ex){
            ex.printStackTrace(System.out);
        }
    }
    
    
    
}
