package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import dominio.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.SQLException;

public class EmpleadoDAO {

    //VARIABLES
    private static final String SQL_SELECT = "SELECT * FROM empleado";
    private static final String SQL_INSERT = "INSERT INTO empleado (nombre, apellido1, apellido2, dni, email, cat) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE empleado SET nombre = ? , apellido1 = ? , apellido2 = ? , dni = ? ,  email = ?, cat = ? WHERE idEmpleado = ? ";
    private static final String SQL_SELECT_ID = "SELECT * FROM empleado WHERE idEmpleado= ? ";
    private static final String SQL_DELETE = "DELETE FROM empleado WHERE idEmpleado = ?";
    private static final String SQL_ORDER = "SELECT * FROM empleado ORDER BY nombre";
    private static final String SQL_INNER = "SELECT * FROM empleado INNER JOIN categoria ON empleado.cat = categoria.idCategoria WHERE  categoria.idCategoria = 3;";

    public List<EmpleadoDTO> listar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<EmpleadoDTO> empelados = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEmpleado = rs.getInt("idEmpleado");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String dni = rs.getString("dni");
                String email = rs.getString("email");
                int cat  = rs.getInt("cat");

                empelados.add(new EmpleadoDTO(idEmpleado, nombre, apellido1, apellido2, dni, email, cat));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);

        }
        return empelados;
    }

    public int insertar(EmpleadoDTO empleado){

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido1());
            stmt.setString(3, empleado.getApellido2());
            stmt.setString(4, empleado.getDni());
            stmt.setString(5, empleado.getEmail());
            stmt.setInt(6, empleado.getCat());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }

    public int actualizar(EmpleadoDTO empleado){

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido1());
            stmt.setString(3, empleado.getApellido2());
            stmt.setString(4, empleado.getDni());
            stmt.setString(5, empleado.getEmail());
            stmt.setInt(6, empleado.getCat());
            stmt.setInt(7, empleado.getIdEmpleado());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }

    public int eliminar(EmpleadoDTO empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            //borrar por id
            stmt.setInt(1, empleado.getIdEmpleado());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }

    public List<EmpleadoDTO> ordenar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<EmpleadoDTO> empleados = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_ORDER);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEmpleado = rs.getInt("idEmpleado");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String dni = rs.getString("dni");
                String email = rs.getString("email");
                int cat = rs.getInt("cat");

                empleados.add(new EmpleadoDTO(idEmpleado, nombre, apellido1, apellido2, dni, email, cat));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);

        }
        return empleados;
    }

    public List<EmpleadoDTO> empleadoCategoriaBase() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<EmpleadoDTO> empleados = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INNER);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEmpleado = rs.getInt("idEmpleado");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String dni = rs.getString("dni");
                String email = rs.getString("email");
                int cat = rs.getInt("cat");

                empleados.add(new EmpleadoDTO(idEmpleado, nombre, apellido1, apellido2, dni, email, cat));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);

        }
        return empleados;
    }
    
    public EmpleadoDTO buscar(EmpleadoDTO empleado) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<EmpleadoDTO> emplados = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, empleado.getIdEmpleado());//1: primer interrogante, le asignas el valor del cliente
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEmpleado = rs.getInt("idEmpleado");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String dni = rs.getString("dni");
                String email = rs.getString("email");
                int cat = rs.getInt("cat");

                
                
                empleado.setNombre(nombre);
                empleado.setApellido1(apellido1);
                empleado.setApellido2(apellido2);
                empleado.setDni(dni);
                empleado.setEmail(email);
                empleado.setCat(cat);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return empleado;
    }

}
