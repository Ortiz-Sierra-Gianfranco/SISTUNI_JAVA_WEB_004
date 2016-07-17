<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>V E N T A</title>
</head>
<body>
  <h1>VENTA</h1>
  <form method="post" action="VentaController">
    <p>
      Precio: <input type="text" name="precio" />
    </p>
    <p>
      Cantidad: <input type="text" name="cant" />
    </p>    
    <p>
      <input type="submit" value="Procesar" />
    </p>
  </form>
  
  <c:if test="${dto != null}">
	  <h2>RESULTADO</h2>
	  <table>
	    <tr>
	      <td>Precio:</td>
	      <td>${dto.precio}</td>
	    </tr>
	    <tr>
	      <td>Cantidad:</td>
	      <td>${dto.cant}</td>
	    </tr>
	    <tr>
	      <td>Importe:</td>
	      <td>${dto.importe}</td>
	    </tr>
	    <tr>
	      <td>Impuesto:</td>
	      <td>${dto.impuesto}</td>
	    </tr>
	    <tr>
	      <td>Total:</td>
	      <td>${dto.total}</td>
	    </tr>  
	  </table>
	</c:if>
</body>
</html>