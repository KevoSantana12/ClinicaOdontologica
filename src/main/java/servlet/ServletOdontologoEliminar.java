package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;
@WebServlet(name = "ServletOdontologoEliminar", urlPatterns = {"/ServletOdontologoEliminar"})
public class ServletOdontologoEliminar extends HttpServlet {
    ControladoraLogica CL = new ControladoraLogica();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        int id = Integer.parseInt(request.getParameter("Eliminar"));
        CL.eliminarOdontologo(id);
        response.sendRedirect("ServletOdontologoVer"); 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
