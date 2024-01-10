/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Usuario;

@WebServlet(name = "ServletUsuarioEditar", urlPatterns = {"/ServletUsuarioEditar"})
public class ServletUsuarioEditar extends HttpServlet {
    ControladoraLogica CL = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int id = Integer.parseInt(request.getParameter("Editar"));
        Usuario usuario = CL.findUsuario(id);
        HttpSession miSeccion = request.getSession();
        miSeccion.setAttribute("Usuario", usuario);
        response.sendRedirect("editarUsuarios.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombreUsuario = request.getParameter("nombreUsuario");
        String rol = request.getParameter("rol");
        String password = request.getParameter("password");
        
        
        Usuario usuario = new Usuario();
        usuario.setId_usuario(id);
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setContrasena(password);
        usuario.setRol(rol);
        
        CL.editarUsuario(usuario);
        response.sendRedirect("ServletUsuario");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
