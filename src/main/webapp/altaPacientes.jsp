<%-- 
    Agregar el arrayList de Citas
    Document   : newjsp
    Created on : Jan 3, 2024, 6:53:03 PM
    Author     : Klins
--%>
<%@page import="logica.Horario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.Responsable"%>
<%ArrayList<Responsable> Responsables = (ArrayList<Responsable>)request.getSession().getAttribute("Responsables");
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
                    <h1>Agregar Paciente</h1>
                    <form class="user" action="ServletPaciente" method="POST"></a>
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
<!--                                <div class="form-group">
                                    <input type="email" class="form-control form-control-user" id="exampleInputEmail"
                                        placeholder="Email Address">
                                </div>-->
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="date" class="form-control form-control-user"
                                               id="fechaNac" placeholder="Fecha de Nacimiento" name="fechaNac">
                                    </div>
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                               id="tipoSangre" placeholder="Tipo de sangre" name="tipoSangre">
                                    </div>                                     
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6">
                                    <legend>Responsable</legend>
                                        <select name="Resposable" class="form-control">
                                            <%for (Responsable respo: Responsables){%>
                                            <option value="<%=respo.getId()%>"><%=respo.getTipo()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="col-sm-6">
                                    <legend>Tiene seguro?</legend>                                        
                                        <select class="form-control"name="tiene_OS">
                                            <option value="true">Sí</option>
                                            <option value="false">No</option>
                                        </select>
                                    </div>                                          
                                </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                        Crear Paciente
                                </button>
                        </form>
            <!-- End of Main Content -->
        <!-- Footer -->
        <%@include file ="includes/footer.jsp" %>
    </body>

</html>