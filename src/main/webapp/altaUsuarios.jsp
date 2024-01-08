<%-- 
    Document   : newjsp
    Created on : Jan 3, 2024, 6:53:03 PM
    Author     : Klins
--%>

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
                    <h1>Crear Usuario</h1>
                    <form class="user" action="ServletUsuario" method="POST"></a>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="nombreUsuario"
                                            placeholder="nombreUsuario" name="nombreUsuario">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="rol"
                                               placeholder="rol" name="rol">
                                    </div>
                                </div>
                    
                                <div class="form-group">
                                    <input type="password" class="form-control form-control-user" id="password"
                                           placeholder="Contrasena" name="password">
                                </div>
<!--                                Aca va todo lo relacionado con altad y usuarios-->

                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                        Registrarse
                                </button>
                        </form>
            <!-- End of Main Content -->
        <!-- Footer -->
        <%@include file ="includes/footer.jsp" %>
    </body>

</html>