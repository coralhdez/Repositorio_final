package web;

import datos.*;
import dominio.*;
import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


         
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarEmpleado(request, response);
                    break;         
                case "eliminar":
                    this.eliminarEmpleado(request, response);
                    break;    
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response); //INSERTAR
        }

    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Obtenemos el listado de los empleados
        List<EmpleadoDTO> empleados = new EmpleadoDAO().listar();

        //double saldoTotal = calcularTotal(empleados); //-> es lo mismo que llamarlo directamente debajo
        System.out.println("empleados = " + empleados);

        //2. DEFINIMOS UN OBJESO SESSION PARA COMPARTIR NUESTROS ATRIBUTOS EN UN CONTEXTO MAS AMPLIO
        HttpSession sesion = request.getSession();

        //3. COMPARTIMOS EN EL NUEVO ALCANCE LOS ATRIBUTO 
        sesion.setAttribute("empleados", empleados);
        sesion.setAttribute("totalEmpleados", empleados.size());

        //4. REDIRECCIONAMOS EL FLUJO DESDE EL CONTROLADOR A UNA NUEVA PÁGINA JSP //PROPAGAMOS
        //redireccionar a una nueva pag: getRequestDispatcher - sendRedirect
        response.sendRedirect("empleados.jsp");
        //request.getRequestDispatcher("empleados.jsp").forward(request, response);
    }

    //DOPOST PARA PROCESAR EL FORMULARIO ENVIADO POR POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1. LEEMOS LOS PARÁMETROS DE NUESTRO REQUEST
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarEmpleado(request, response);
                case "modificar":
                    this.modificarEmpleado(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }

    }

    protected void insertarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1. RECUPERAMOS LOS PARAMETOS DEL REQUEST
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String dni = request.getParameter("dni");
        String email = request.getParameter("email");
        String categoriaString = request.getParameter("cat");
        int categoria = 0;

        if (categoriaString != null && !"".equals(categoriaString)) {
            categoria = Integer.parseInt(categoriaString);
        }

        //2. CREAMOS EL OBJETO EMPLEADO
        EmpleadoDTO empleado = new EmpleadoDTO(nombre, apellido1, apellido2, dni, email, categoria);

        //3. INSERTAMOS EL OBJETO EN LA BASE DE DATOS
        int registroModificado = new EmpleadoDAO().insertar(empleado);
        System.out.println("registrosModificados: " + registroModificado);

        //4. REDIRIGIMOS A LA ACCIÓN POR DEFECTO
        //this.accionDefault(request, response);
    }
    
    
    protected void editarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //1. RECUPERAMOS LOS PARÁMETROS
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        
        //2. INVOCAMOS EL MÉTODO DE BUSCAR
        EmpleadoDTO empleado = new EmpleadoDAO().buscar(new EmpleadoDTO(idEmpleado));
        
        //3. COMPARTIMOS EL EMPLEADO EN EL ALCANCE DE REQUEST PARA EDITARLO
        request.setAttribute("empleado", empleado);
        String jspeditar = "/WEB-INF/paginas/empleados/editarEmpleado.jsp";
        
        //4. REDIRIGIMOS Y PROPAGAMOS
        request.getRequestDispatcher(jspeditar).forward(request, response);
    

    }
    
    private void modificarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1. RECUPERAMOS LOS PARAMETOS DEL REQUEST
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String dni = request.getParameter("dni");
        String email = request.getParameter("email");
        String categoriaString = request.getParameter("cat");
        int categoria = 0;

        if (categoriaString != null && !"".equals(categoriaString)) {
            categoria = Integer.parseInt(categoriaString);
        }

        EmpleadoDTO empleado = new EmpleadoDTO(idEmpleado, nombre, apellido1, apellido2, dni, email, categoria);
        
        int registroModificado = new EmpleadoDAO().actualizar(empleado);
        System.out.println("registrosModificados: " + registroModificado);
        //OBTENEMOS EL LISTADO DE LOS EMPLEADOS
        this.accionDefault(request, response);

    }
    
    private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));

        EmpleadoDTO empleado = new EmpleadoDTO(idEmpleado);
        
        int registrosModificados = new EmpleadoDAO().eliminar(empleado);
        //Redireccionamos a la pagina en la que se va a visualizar
        System.out.println("registros" + registrosModificados);
       
        this.accionDefault(request, response);

    }


}
