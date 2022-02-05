package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import dominio.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {

    private static final String SQL_SELECT = "SELECT * FROM admin WHERE usuario = ? AND clave = ?";

    int r = 0;

    public int validarLogin(AdminDTO admin) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, admin.getUsuario());
            stmt.setString(2, admin.getClave());
            rs = stmt.executeQuery();

            while (rs.next()) {
                r = r + 1;

                admin.setUsuario(rs.getString("usuario"));
                admin.setUsuario(rs.getString("clave"));

            }
            if(r == 1){
                return 1;          
            }else{
                return 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return 0;
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }
        
    }
}
