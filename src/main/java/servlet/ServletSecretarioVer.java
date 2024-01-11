
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Secretario;

@WebServlet(name = "ServletSecretarioVer", urlPatterns = {"/ServletSecretarioVer"})
public class ServletSecretarioVer extends HttpServlet {
    ControladoraLogica CL = new ControladoraLogica();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        ArrayList<Secretario> Secretarios = CL.findSecretarios();
        HttpSession miSession = request.getSession();
        miSession.setAttribute("Secretarios", Secretarios);
        response.sendRedirect("verSecretarios.jsp");          
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
