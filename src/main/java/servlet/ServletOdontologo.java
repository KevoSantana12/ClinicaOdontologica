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
import logica.Usuario;
@WebServlet(name = "ServletOdontologo", urlPatterns = {"/ServletOdontologo"})
public class ServletOdontologo extends HttpServlet {
    ControladoraLogica CL = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession miSession = request.getSession();
        ArrayList<Horario> Horario = CL.findHorarios();
        miSession.setAttribute("Horario", Horario);
        
        ArrayList<Usuario> Usuario = CL.findUsuarios();
        miSession.setAttribute("Usuario", Usuario);
        
        response.sendRedirect("altaOdontologos.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        Odontologo odontologo = new Odontologo();
        
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
        String especialidad = request.getParameter("especialidad");
        
        //OneToOne
        int idUsuario = Integer.parseInt(request.getParameter("Usuario"));
        Usuario usuario = CL.findUsuario(idUsuario);
        
        int idHorario = Integer.parseInt(request.getParameter("Horario"));
        Horario horario = CL.findHorario(idHorario);        
        
        
        odontologo.setNombre(nombre);
        odontologo.setApellido(apellido);
        odontologo.setTelefono(telefono);
        odontologo.setDireccion(direccion);
        odontologo.setFechaNacim(fechaNacim);
        odontologo.setEspecialidad(especialidad);
        odontologo.setUsuario(usuario);
        odontologo.setHorario(horario);
        
        CL.crearOdontologo(odontologo);
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
