<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Renzo</title>
</head>
<body>
<%
clinicaveterinaria.modelo.Doctor d = (clinicaveterinaria.modelo.Doctor) session.getAttribute("USUARIO_ACTUAL");
%>
Nombre: <%=d.getNombre() %> 
<br />
Apellido: <c:out value="${sessionScope[USUARIO_ACTUAL].nombre} "></c:out>
<br /><br />
<c:out value="${'<tag> , &'}"/>
</body>
</html>