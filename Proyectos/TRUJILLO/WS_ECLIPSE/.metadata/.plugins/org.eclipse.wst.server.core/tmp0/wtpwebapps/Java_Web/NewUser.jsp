<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo_Usuario</title>
</head>
<body>
<h1>Crear Usuario</h1>
 <form method="post" action="ServletNewUser">
  <table ><tr>
  	<td>Nombre :</td>
  	<td><input type="text" id="name" name="name"><br/>
  <tr>
 <tr>
  	<td>Apellidos :</td>
  	<td><input type="text" id="apellido" name="apellido"><br/>
  <tr>
  <tr>
  	<td>Correo Electr�nico :</td>
  	<td><input type="email" id="email" name="email"><br/>
  <tr>
  <tr>
  	<td>Usuario :</td>
  	<td><input type="text" id="user" name="user"><br/>
  <tr><tr>
  	<td>Clave :</td>
  	<td><input type="password" id="clave" name="clave"><br/>
  
  </table>
  <tr>
  <input type="submit" value="Crear Usuario">
  </tr>
 </form>
</body>
</html>