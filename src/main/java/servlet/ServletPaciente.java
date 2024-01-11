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
import logica.Paciente;
import logica.Responsable;
import logica.Usuario;


@WebServlet(name = "ServletPaciente", urlPatterns = {"/ServletPaciente"})
public class ServletPaciente extends HttpServlet {
    ControladoraLogica CL = new ControladoraLogica();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        ArrayList<Responsable> Responsables = CL.findResponsables();
        HttpSession miSession = request.getSession();
        miSession.setAttribute("Responsables", Responsables);
        response.sendRedirect("altaPacientes.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        Paciente paciente = new Paciente();
        
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
        String tipoSangre = request.getParameter("tipoSangre");
        String tieneOSString = request.getParameter("tiene_OS");
        boolean tieneOS = Boolean.parseBoolean(tieneOSString);        
        
        //OneToOne
        int idUsuario = Integer.parseInt(request.getParameter("Resposable"));
        Responsable respo = CL.findResponsable(idUsuario);
     
        
        
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setTelefono(telefono);
        paciente.setDireccion(direccion);
        paciente.setFechaNacim(fechaNacim);
        paciente.setTiene_OS(tieneOS);
        paciente.setResponsable(respo);
        paciente.setTipo_Sangre(tipoSangre);
        
        CL.crearPaciente(paciente);
        response.sendRedirect("index.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
