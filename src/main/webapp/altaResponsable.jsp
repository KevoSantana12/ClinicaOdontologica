<%-- 
    Document   : newjsp
    Created on : Jan 3, 2024, 6:53:03 PM
    Author     : Klins
--%>
<%@page import="logica.Responsable"%>

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
                    <h1>Agregar Responsable</h1>
                    <form class="user" action="ServletResponsable" method="POST"></a>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="nombre"
                                               placeholder="Nombre" name="nombre">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="apellido"
                                               placeholder="Apellido" name="apellido">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="telefono"
                                               placeholder="Telefono" name="telefono">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="direccion"
                                            placeholder="Direccion" name="direccion">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="date" class="form-control form-control-user"
                                               id="fechaNac" placeholder="Fecha de Nacimiento" name="fechaNac">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user"
                                               id="tipo" placeholder="Tipo" name="tipo">
                                    </div>                                   
                                </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                        Crear Responsable
                                </button>
                        </form>
            <!-- End of Main Content -->
        <!-- Footer -->
        <%@include file ="includes/footer.jsp" %>
    </body>

</html>