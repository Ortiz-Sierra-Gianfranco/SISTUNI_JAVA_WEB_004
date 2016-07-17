<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
  <%@ include file="cabecera.jsp" %>
  
  <c:set var="n" value="6"/>
  <c:forEach var="i" begin="1" end="6">
    <h${n}>ALIANZA CAMPEON</h${n}>
    <c:set var="n" value="${n - 1}" />
  </c:forEach>
  
</body>
</html>