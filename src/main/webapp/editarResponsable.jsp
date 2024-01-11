<%-- 
    Document   : newjsp
    Created on : Jan 3, 2024, 6:53:03 PM
    Author     : Klins
--%>
<%@page import="logica.Responsable"%>
<*<!-- Falta agregar list para citas  -->

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Odontologo"%>
<%@page import="logica.Horario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.Usuario"%>
<%Responsable responsable = (Responsable)request.getSession().getAttribute("Responsable");
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
                                               placeholder="<%=responsable.getNombre()%>" name="nombre">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="apellido"
                                               placeholder="<%=responsable.getApellido()%>"name="apellido">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="telefono"
                                               placeholder="<%=responsable.getTelefono()%>" name="telefono">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="direccion"
                                            placeholder="<%=responsable.getDireccion()%>" name="direccion">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="date" class="form-control form-control-user"
                                               id="fechaNac" placeholder=""<%=new SimpleDateFormat("dd/MM/yyyy").format(responsable.getFechaNacim())%>" name="fechaNac">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user"
                                               id="especialidad" placeholder="<%=responsable.getTipo()%>" name="especialidad">
                                    </div>                                   
                                </div>    
                                        
                                    <input name="Id" type="hidden" value="<%=responsable.getId()%>">
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                        Editar Responsable
                                </button>
                        </form>
            <!-- End of Main Content -->
        <!-- Footer -->
        <%@include file ="includes/footer.jsp" %>
    </body>

</html>