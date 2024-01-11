<%-- 
    Document   : newjsp
    Created on : Jan 3, 2024, 6:53:03 PM
    Author     : Klins
--%>
<*<!-- Falta agregar list para citas  -->

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Odontologo"%>
<%@page import="logica.Horario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.Usuario"%>
<%ArrayList<Usuario> Usuarios = (ArrayList<Usuario>)request.getSession().getAttribute("Usuario");
  ArrayList<Horario> Horarios = (ArrayList<Horario>)request.getSession().getAttribute("Horario");
  Odontologo odontologo = (Odontologo)request.getSession().getAttribute("Odontologo");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file = "includes/header.jsp" %>
    <body id="page-top">
        <div id="wrapper">
        <!--Sidebar -->
        <%@include file="includes/sidebar.jsp"%>
            <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
            <div id="content">
                <!-- topbar -->
                <%@include file="includes/topbar.jsp" %>
            <div class="container-fluid">
                <!-- Page Heading -->
                    <h1>Editar Odontologo</h1>
                    <form class="user" action="ServletOdontologoEditar" method="POST">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="nombre"
                                               placeholder="<%=odontologo.getNombre()%>" name="nombre">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="apellido"
                                               placeholder="<%=odontologo.getApellido()%>"name="apellido">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="telefono"
                                               placeholder="<%=odontologo.getTelefono()%>" name="telefono">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="direccion"
                                            placeholder="<%=odontologo.getDireccion()%>" name="direccion">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="date" class="form-control form-control-user"
                                               id="fechaNac" placeholder=""<%=new SimpleDateFormat("dd/MM/yyyy").format(odontologo.getFechaNacim())%>" name="fechaNac">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user"
                                               id="especialidad" placeholder="<%=odontologo.getEspecialidad()%>" name="especialidad">
                                    </div>                                   
                                </div>   
                                <div class="form-group row">
                                    <div class="col-sm-6">
                                    <legend>Usuario</legend>
                                        <select name="Usuario" class="form-control">
                                            <%for (Usuario usu: Usuarios){%>
                                            <option value="<%=usu.getId_usuario()%>"><%=usu.getNombreUsuario()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="col-sm-6">
                                    <legend>Horario</legend>
                                        <select name="Horario" class="form-control">
                                            <%for (Horario hora: Horarios){%>
                                            <option value="<%=hora.getId_horario()%>"><%=hora.getHora_entrada()%>:00am - <%=hora.getHora_salidad()%>:00pm</option>
                                            <%}%>
                                        </select>
                                    </div>  
                                </div>
                                        
                                        
                                <input name="Id" value="<%=odontologo.getId()%>">
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                        Editar Odontologo
                                </button>
                        </form>
            <!-- End of Main Content -->
        <!-- Footer -->
        <%@include file ="includes/footer.jsp" %>
    </body>

</html>