<%-- 
    Document   : newjsp
    Created on : Jan 3, 2024, 6:53:03 PM
    Author     : Klins
--%>

<%@page import="logica.Odontologo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ArrayList<Odontologo> Odontologos = (ArrayList<Odontologo>) request.getSession().getAttribute("Odontologos"); %>
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
                            <h6 class="m-0 font-weight-bold text-primary">Lista de Odontologos</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id Odontologo</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Telefono</th>
                                            <th>Usuario</th>                                            
                                            <th style="width: 210px">Accion</th>                                            
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id Odontologo</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Telefono</th>
                                            <th>Usuario</th> 
                                            <th style="width: 210px">Accion</th>                                            
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        
                                        <%for(Odontologo odonto : Odontologos) { 
                                        %>
                                        <tr>
                                            <td><%=odonto.getId()%></td>
                                            <td><%=odonto.getNombre()%></td>
                                            <td><%=odonto.getApellido()%></td>
                                            <td><%=odonto.getTelefono()%></td>
                                            <td><%=odonto.getUsuario().getId_usuario()%></td>                                            
                                            <td style="display: flex; width: 230px;">
                                                <form name= "editar" action="ServletOdontologoEditar" method="GET">
                                                        <button type="submit" style="background-color: #4e73df; margin-right: 5px;"> 
                                                            <i class="fas fa-trash-alt">Editar</i>    
                                                        </button>                                                    
                                                    <input type="hidden" name="Editar" value="<%=odonto.getId()%>">
                                                </form>
                                                
                                                <form name= "eliminar" action="ServletOdontologoEliminar" method="POST">
                                                        <button type="submit" style="background-color: #e74a3b; margin-right: 5px;"> 
                                                            <i class="fas fa-pencil-alt">Eliminar</i>    
                                                        </button>                                                    
                                                    <input type="hidden" name="Eliminar" value="<%=odonto.getId()%>">
                                                </form>                                                
                                            </td>
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