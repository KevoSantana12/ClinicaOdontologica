<%-- 
    Document   : newjsp
    Created on : Jan 3, 2024, 6:53:03 PM
    Author     : Klins
--%>

<%@page import="logica.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getSession().getAttribute("usuarios"); %>
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
<div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Lista de Usuarios</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id Usuario</th>
                                            <th>Nombre Usuario</th>
                                            <th>Rol</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id Usuario</th>
                                            <th>Nombre Usuario</th>
                                            <th>Rol</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <%for(Usuario usuario : usuarios) { %>
                                        <tr>
                                            <td><%=usuario.getId_usuario()%></td>
                                            <td><%=usuario.getNombreUsuario()%></td>
                                            <td><%=usuario.getRol()%></td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            <!-- End of Main Content -->
        <!-- Footer -->
        <%@include file ="includes/footer.jsp" %>
    </body>

</html>