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
                    <h1>Crea el horario</h1>
                    <form class="user" action="ServletHorario" method="POST"></a>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="horaEntrada"
                                            placeholder="Hora de entrada" name="horaEntrada">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user" id="horaSalida"
                                           placeholder="Hora de Salidad" name="horaSalida">
                                    </div>                                    
                                </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                        Crear horario
                                </button>
                        </form>
        <%@include file ="includes/footer.jsp" %>
    </body>

</html>
