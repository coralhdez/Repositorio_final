package web;

import datos.*;
import dominio.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;

@WebServlet("/LoginControlador")
public class LoginControlador extends HttpServlet {

    LoginDAO login = new LoginDAO();
    AdminDTO admin = new AdminDTO();
    int r;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        if (accion.equals("Ingresar")) {
            String usuario = request.getParameter("txtusuario");
            String clave = request.getParameter("txtclave");
            admin.setUsuario(usuario);
            admin.setClave(clave);

            r = login.validarLogin(admin);
            if (r == 1) {
                request.getSession().setAttribute("usuario", usuario);
                request.getSession().setAttribute("clave", clave);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        }

    }
}
