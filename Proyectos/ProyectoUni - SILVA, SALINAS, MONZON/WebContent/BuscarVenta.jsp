<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Los import -->
<%@ page language="java" %>
<%@ page import = "pe.proyecto.uni.domain.Venta"%> 
<%@ page import = "pe.proyecto.uni.controller.ListarVentaController"%> 
<%@ page import = "java.util.ArrayList"%> 

<jsp:include page="seguro.jsp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="css/sb-admin.css" rel="stylesheet">
</head>
<body>
	<c:if test="${requestScope.error != null }">
    <p class="egcc_error">${requestScope.error}</p>
  	</c:if>
    
    <div id="wrapper">
          <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">Sistema de Ventas</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> Perfil de Usuario</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Configuración</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.jsp"><i class="fa fa-sign-out fa-fw"></i> Cerrar Sesión</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default navbar-static-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="side-menu">
                        <!-- <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                        </li>-->
                      
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> Ventas<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="RegistroVenta.jsp">Nueva Venta</a>
                                </li>
                                <li>
                                    <a href="BuscarVenta.jsp">Buscar Ventas</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Reportes<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="ReporteVenta.jsp">Reporte de Ventas</a>
                                </li>                         
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                    <!-- /#side-menu -->
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">BUSQUEDA DE VENTAS</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Ingresar Informacón de Venta
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form method="post" action="ListarVenta">
                                    	<div class="form-group">
                                            <label>Numero de Venta</label>
                                            <input name="NumVenta" class="form-control" placeholder="Ingrese Número de Venta">
                                        </div>
                                        <div class="form-group">
                                            <label>Nombre de Cliente</label>
                                            <input name="NomCliente" class="form-control" placeholder="Ingrese Nombre de Cliente">
                                        </div>                                        
                                        <div class="form-group">
                                            <label>Forma de Pago: </label>
                                            <label class="checkbox-inline">
                                                <input type="checkbox" name="chkcontado">Al Contado
                                            </label>
                                            <label class="checkbox-inline">
                                                <input type="checkbox" name="chkcredito">Crédito
                                            </label>
                                        </div>
                                        <input class="btn btn-primary" name="btnBuscar" type="submit" value="Buscar"/>
                                        <br/>
				                        <hr/>
                                    </form>
                                </div>
                            </div>
                            <!-- /.row (nested) -->
                            <div class="panel panel-default">
				                        <div class="panel-heading">
				                            Lista de Ventas
				                        </div>
				                        <!-- /.panel-heading -->
				                        <div class="panel-body">
				                            <div class="table-responsive">
				                                <table class="table table-striped table-bordered table-hover">
				                                    <thead>
				                                        <tr>
				                                            <th>Codigo.</th>
				                                            <th>Cliente</th>
				                                            <th>Metodo de Pago</th>
				                                            <th>Sub Total</th>
				                                            <th>IGV</th>
				                                            <th>Total</th>
				                                            <th>Vendedor</th>
				                                            <th>Fecha</th>
				                                        </tr>
				                                    </thead>
				                                    <tbody>
				                                        <%
														ArrayList<Venta> lista = (ArrayList<Venta>)request.getAttribute("ListaVentas");
														for (int i=0;i<lista.size();i++)
														{
														   out.println("<tr>");
														   out.println("<td>"+lista.get(i).getIdVenta()+"</td>");
														   out.println("<td>"+lista.get(i).getCliente()+"</td>");
														   out.println("<td>"+lista.get(i).getMetodoPago()+"</td>");
														   out.println("<td>"+lista.get(i).getSubTotal()+"</td>");
														   out.println("<td>"+lista.get(i).getIgv()+"</td>");
														   out.println("<td>"+lista.get(i).getImporte()+"</td>");
														   out.println("<td>"+lista.get(i).getUsuario()+"</td>");
														   out.println("<td>"+lista.get(i).getFecha()+"</td>");
														   out.println("</tr>");
														}
														%>
				                                    </tbody>
				                                </table>
				                            </div>
				                            <!-- /.table-responsive -->
				                        </div>
				                        <!-- /.panel-body -->
				                    </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <!-- Core Scripts - Include with every page -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <!-- Page-Level Plugin Scripts - Dashboard -->
    <script src="js/plugins/morris/raphael-2.1.0.min.js"></script>
    <script src="js/plugins/morris/morris.js"></script>
    <!-- SB Admin Scripts - Include with every page -->
    <script src="js/sb-admin.js"></script>
    <!-- Page-Level Demo Scripts - Dashboard - Use for reference -->
    <script src="js/demo/dashboard-demo.js"></script>
</body>
</html>