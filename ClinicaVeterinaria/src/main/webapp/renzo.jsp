<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>VeterinariaGozus</title>
</head>
<body>
<%
clinicaveterinaria.modelo.Doctor d = (clinicaveterinaria.modelo.Doctor) session.getAttribute("USUARIO_ACTUAL");
%>
Nombre: <%=d.getNombre() %> 
<br />
Apellido: <c:out value="${USUARIO_ACTUAL.nombre} "></c:out>
<br />
${USUARIO_ACTUAL.nombre}
<br /><br />
<c:out value="${'<tag> , &'}"/>
</body>
</html>