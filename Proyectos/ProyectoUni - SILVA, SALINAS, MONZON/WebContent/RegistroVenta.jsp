<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    
    <script src="js/jquery-1.10.2.js"></script>
<SCRIPT language="javascript">

		$(function () {
		   $("#btnRegistrar").click(function () {
		        var xml = '<?xml version="1.0"?><rows>';
		        $("#TablaDetalle tr").each(function () {
		            var cells = $("td", this);
		            if (cells.length > 0) {
		                xml += "<row>\n";
		                for (var i = 1; i < cells.length; ++i) {
		                    xml += "\t<data"+ i +">" + cells.eq(i).text() + "</data"+ i +">\n";
		                }
		                xml += "</row>\n";
		            }
		        });
		        xml += '</rows>';
		        
		        document.getElementById("hxml").value=xml;
		        Validar();
		        //window.alert(xml);
		        //here you can rewrite the xmlstring to a new document
		        //or use the hidden control to store the xml text, call the text in code behind.
		        //also, you can call ajax to excuet codebehind and sava the xml file
		       
		    });
		})
		function Validar() {
			if (document.getElementById("NomCliente").value == "")
				{
					alert("Debe Ingresar el campo de cliente")
					return false;
				}
			if (document.getElementById("cantidad").value == "")
			{
				alert("Debe Ingresar el campo de Cantidad")
				return false;
			}
			if (document.getElementById("precio").value == "")
			{
				alert("Debe Ingresar el campo de Precio")
				return false;
			}
			return true;
		}
	
		// Solo permite ingresar numeros.
		function soloNumeros(e){
			var key = window.Event ? e.which : e.keyCode
			return (key >= 48 && key <= 57)
		}
	

          function addRow(tableID) {
					if(document.getElementById("Cantidad").value == "" || document.getElementById("Precio").value == "")
						{
						alert("Debe ingresar llenar todos los datos");
						return false;
						}
					if (validarReptidas() == false)
						{
						 return false;						
						}
               var table = document.getElementById(tableID);
               var rowCount = table.rows.length;
               var row = table.insertRow(rowCount);
               var cell1 = row.insertCell(0);
               var element1 = document.createElement("input");
               element1.type = "checkbox";
               cell1.appendChild(element1);
               var cell2 = row.insertCell(1);
               var cell3 = row.insertCell(2);
               var cell4 = row.insertCell(3);
               var cell5 = row.insertCell(4);
               var combo = document.getElementById("SelProducto");
               var selected = combo.options[combo.selectedIndex].text;
               cell2.innerHTML = document.getElementById("SelProducto").value;
               cell3.innerHTML = selected;
               cell4.innerHTML = document.getElementById("Cantidad").value;
               cell5.innerHTML = document.getElementById("Precio").value;
          }
          
          function deleteRow(tableID) {
				try {
               var table = document.getElementById(tableID);
               var rowCount = table.rows.length;
               for(var i=0; i<rowCount; i++) {
                    var row = table.rows[i];
                    var chkbox = row.cells[0].childNodes[0];
                    if(null != chkbox && true == chkbox.checked) {
                         table.deleteRow(i);
                         rowCount--;
                         i--;
                    }
               }
               }catch(e) {
                    alert(e);
               }
          }
          
          function validarReptidas() {
				try {
             var table = document.getElementById("TablaDetalle");
             var rowCount = table.rows.length;
             for(var i=0; i<rowCount; i++) {
                  var row = table.rows[i];
                  var valor = row.cells[1].innerHTML;
                  if (valor==document.getElementById("SelProducto").value)
                	  {
                	  		var ValorExistente = row.cells[4].innerHTML;
                	  		var NuevoValor = document.getElementById("Cantidad").value;
                	  		row.cells[4].innerHTML =  (parseFloat(ValorExistente) + parseFloat(NuevoValor));
                	  		return false;
                	  }                 
             }
             }catch(e) {
                  alert(e);
             }
        }
</SCRIPT>    
</head>
<body>
	<c:if test="${requestScope.error != null }">
    <p class="egcc_error">${requestScope.error}</p>
  	</c:if>
	<% 
		String msg= (String)request.getAttribute("correcto");
		if(msg == "Ejecutado")
		{
			String mensaje="<script language='javascript'>alert('Se registró correctamente');</script>"; 
			out.println(mensaje); 	
		}
	%> 
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
                    <h1 class="page-header">REGISTRO DE VENTAS</h1>
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
                                     <form method="post" action="RegistroVenta">
                                    	<div class="form-group">
                                            <label>Número de Venta</label>
                                            <input name="NomCliente" class="form-control" disabled="">
                                        </div>
                                        <div class="form-group">
                                            <label>Nombre de Cliente</label>
                                            <input name="NomCliente" id="NomCliente" class="form-control" placeholder="Ingrese Nombre de Cliente">
                                        </div>
                                        <div class="form-group">
                                            <label>Forma de Pago</label>
                                            <label class="checkbox-inline">
                                                <input type="checkbox" name="chkContado" check="true">Al Contado
                                            </label>
                                            <label class="checkbox-inline">
                                                <input type="checkbox" name="chkCredito">Crédito
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <label>Producto</label>
                                            <select class="form-control" id="SelProducto" name="SelProducto">
                                                <option value="1">Zapatillas</option>
                                                <option value="2">Polo</option>
                                                <option value="3">Camisa</option>
                                                <option value="4">Zapatos</option>
                                                <option value="5">Jeans</option>
                                            </select>
                                        </div>
                                        <label>Cantidad</label>
                                     	<div class="form-group input-group">
                                            <input type="text" id="Cantidad" onKeyPress="return soloNumeros(event)" class="form-control" name="Cantidad">
                                            <span class="input-group-addon">.00</span>
                                        </div>
                                        <label>Precio</label>
                                        <div class="form-group input-group">
                                            <input type="text" id="Precio" class="form-control" name="Precio">
                                            <span class="input-group-addon">.00</span>
                                        </div>
                                        <INPUT type="button" class="btn btn-default" value="Agregar" name="btnAgregar" onclick="addRow('TablaDetalle');" />
                                        <INPUT type="button" class="btn btn-default" value="Eliminar" name="btnEliminar" onclick="deleteRow('TablaDetalle');" />
                                        <INPUT type="button" class="btn btn-default" value="XML" name="btnXML" id="btnXML" />
                                        <input type="hidden" name="hxml" value="" id="hxml">
                                        <input type="hidden" name="hcodigo" value=${sessionScope.codigo} id="hcodigo">
                                        
                                        <br/>
				                        <hr/>
                                        <div class="panel panel-default">
				                        <div class="panel-heading">
				                            Lista de Productos
				                        </div>
				                        <!-- /.panel-heading -->
				                        <div class="panel-body">
				                            <div class="table-responsive" >
				                                <table id="TablaDetalle" class="table table-striped table-bordered table-hover">
				                                    <thead>
				                                        <tr>
				                                        	  <th>Selec.</th>
				                                            <th>Codigo</th>
				                                            <th>Cantidad</th>
				                                            <th>Producto</th>
				                                            <th>Precio Unitario</th>
				                                        </tr>
				                                    </thead>
				                                    <tbody>
				                                        
				                                    </tbody>
				                                </table>
				                            </div>
				                            <!-- /.table-responsive -->
				                        </div>
				                        <!-- /.panel-body -->
				                    </div>
                                        <input class="btn btn-primary" name="btnRegistrar" id="btnRegistrar" type="submit" value="Registrar Venta"/>
                                </form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                                <div class="col-lg-6">
                                    <h1>DATOS DEL VENDEDOR</h1>
                                    <form role="form">
                                        <fieldset disabled="">
                                            <div class="form-group">
                                                <label for="disabledSelect">Vendedor</label>
                                                <input class="form-control" id="disabledInput" name="NomVendedor" type="text" disabled="" value=${sessionScope.usuario}>
                                                <label for="disabledSelect">Tienda</label>
                                                <input class="form-control" id="disabledInput" name="Tienda" type="text" disabled="" value="Tienda Central"/>
                                            </div>
                                        </fieldset>
                                        <div class="checkbox">
                                                <label>
                                                    <input type="checkbox">Modificar
                                                </label>
                                       	</div>
                                    </form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
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