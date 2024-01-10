<%-- 
    Document   : newjsp
    Created on : Jan 3, 2024, 6:53:03 PM
    Author     : Klins
--%>

<%@page import="logica.Usuario"%>
<%Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario"); %>
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
                    <form class="user" action="ServletUsuarioEditar" method="POST"></a>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="nombreUsuario"
                                               placeholder=<%=usuario.getNombreUsuario()%> name="nombreUsuario">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="rol"
                                               placeholder=<%=usuario.getRol()%> name="rol">
                                    </div>
                                </div>
                    
                                <div class="form-group">
                                    <input type="password" class="form-control form-control-user" id="password"
                                           placeholder=<%=usuario.getContrasena()%> name="password">
                                </div>
<!--                                Aca va todo lo relacionado con altad y usuarios-->
                                <input type="hidden" name="id" value="<%=usuario.getId_usuario()%>">
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                        Editar Usuario
                                </button>
                        </form>                
            <!-- End of Main Content -->
        <!-- Footer -->
        <%@include file ="includes/footer.jsp" %>
    </body>

</html>