package servlet;

import java.io.IOException;
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
import logica.Odontologo;
import logica.Responsable;
@WebServlet(name = "ServletResponsable", urlPatterns = {"/ServletResponsable"})
public class ServletResponsable extends HttpServlet {
    ControladoraLogica CL  = new ControladoraLogica();
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
        response.sendRedirect("verResponsables.jsp");        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        String tipo = request.getParameter("tipo");
        
        Responsable responsable = new Responsable();        
        responsable.setNombre(nombre);
        responsable.setApellido(apellido);
        responsable.setTelefono(telefono);
        responsable.setDireccion(direccion);
        responsable.setFechaNacim(fechaNacim);
        responsable.setTipo(tipo);

        CL.crearResponsable(responsable);
        response.sendRedirect("index.jsp");        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
