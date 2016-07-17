<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
   int n1, n2, suma;
%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SUMAR</title>
</head>
<body>

  <%@ include file="cabecera.jsp" %>


  <h1>SUMAR</h1>
  
  <form method="post" action="index.jsp">
    NÚMERO 1:<input type="text" name="n1"/><br/>  
    NÚMERO 2:<input type="text" name="n2"/><br/>  
    <input type="submit" value="Procesar" name="btnProcesar" />
  </form>

  <% if( request.getParameter("btnProcesar") != null ) { %>

	  <%
	    n1 = Integer.parseInt(request.getParameter("n1"));
	    n2 = Integer.parseInt(request.getParameter("n2"));
	  %>
	  
	  <h2>RESULTADO</h2>
	  <p>Número 1: <%=n1%></p>
	  <p>Número 2: <%=n2%></p>
	  
	  <%
	  
	   Thread.currentThread().sleep(1000);
	  
	  
	    suma = n1 + n2;
	  %>
	  
	  <p>Suma: <%=suma%></p>
	  
  
  <% } %>
  

</body>
</html>