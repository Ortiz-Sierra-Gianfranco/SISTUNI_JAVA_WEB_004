<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<title>Ingreso al Sistema</title>
<style type="text/css">

#EGCC_LOGON{
  width: 400px;
  margin: 10px auto;
  padding: 10px;
  background-color: white;
}

</style>
</head>
<body>
<div id="EGCC_LOGON">
  <img alt="" src="img/logo.jpg"><br/>
  <h1>INGRESO AL SISTEMA</h1>
  
  <c:if test="${requestScope.error != null }">
    <p class="egcc_error">${requestScope.error}</p>
  </c:if>
  
  <form method="post" action="LogonIngreso">
    <table>
      <tr>
        <td rowspan="3"><img src="img/user_login.png" /></td>
        <td>Usuario:</td>
        <td><input type="text" name="usuario"/> </td>
      </tr>
      <tr>
        <td>Clave:</td>
        <td><input type="password" name="clave"/> </td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="Ingresar"/> </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>