<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Nuevo Producto</h1>
	</div>
	<form method="post" action="ServletNewProducto">
		<table>
		<tr>
		 <td>Descripcion :</td>
		 <td><input type="text" id="descr" name="descr"></td>
		</tr>
		<tr>
		 <td>Id Linea :</td>
		 <td><input type="text" id="linea" name="linea"></td>
		</tr>
		<tr>
		 <td>Precio Compra :</td>
		 <td><input type="text" id="compra" name="compra"></td>
		</tr>
		<tr>
		 <td>Precio Venta :</td>
		 <td><input type="text" id="venta" name="venta"></td>
		</tr>
			<tr>
		 		<td>Stock :</td>
		 		<td><input type="text" id="stock" name="stock"></td>
			</tr>
		</table>
		  <tr>
  		<input type="submit" value="Ingresar Producto">
  </tr>
	</form>
</body>
</html>