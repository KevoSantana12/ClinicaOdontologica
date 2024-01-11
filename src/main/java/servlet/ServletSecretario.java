
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Horario;
import logica.Odontologo;
import logica.Secretario;
import logica.Usuario;


@WebServlet(name = "ServletSecretario", urlPatterns = {"/ServletSecretario"})
public class ServletSecretario extends HttpServlet {
    ControladoraLogica CL = new ControladoraLogica();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response); 
        HttpSession miSession = request.getSession();
        
        ArrayList<Usuario> Usuario = CL.findUsuarios();
        miSession.setAttribute("Usuarios", Usuario);
        
        response.sendRedirect("altaSecretario.jsp");        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        Secretario secre = new Secretario();
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String fechaNac = request.getParameter("fechaNac");
        
        Date fechaNacim = null;
        System.out.print(fechaNac);
        try {
            fechaNacim = new SimpleDateFormat("YYYY-MM-DD").parse(fechaNac);
        } catch (ParseException ex) {
            Logger.getLogger(ServletOdontologo.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sector = request.getParameter("sector");
        
        //OneToOne
        int idUsuario = Integer.parseInt(request.getParameter("Usuario"));
        Usuario usuario = CL.findUsuario(idUsuario);
        
        secre.setNombre(nombre);
        secre.setApellido(apellido);
        secre.setTelefono(telefono);
        secre.setDireccion(direccion);
        secre.setFechaNacim(fechaNacim);
        secre.setSector(sector);
        secre.setUsuario(usuario);
        
        CL.crearSecretario(secre);
        response.sendRedirect("index.jsp");        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
