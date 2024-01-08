package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Usuario;

@WebServlet(name = "ServletUsuario", urlPatterns = {"/ServletUsuario"})
public class ServletUsuario extends HttpServlet {
    ControladoraLogica CL = new ControladoraLogica();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Usuario> usuarios = CL.findUsuarios();
        HttpSession mySeccion = request.getSession();
        mySeccion.setAttribute("usuarios", usuarios);
        
        System.out.print(usuarios.get(0));
        response.sendRedirect("verUsuarios.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String nombreUsuario = request.getParameter("nombreUsuario");
        String rol = request.getParameter("rol");
        String password = request.getParameter("password");
        
        
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setContrasena(password);
        usuario.setRol(rol);
        
        CL.crearUsuarios(usuario);
        response.sendRedirect("index.jsp");
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
