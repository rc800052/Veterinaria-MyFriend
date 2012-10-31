<%@taglib uri="http://displaytag.sf.net" prefix="display"%><%@ page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="f1" action="ClienteServlet" method="post">
		<table>
			<tr>
				<td>Nombre del Cliente :</td>
				<td><input type="text" name="nombre"></td>
				<td><input type="submit" value="Buscar"></td>
			</tr>
			<tr>
				<td>Codigo</td>
				<td>Nombre</td>
				<td>Direccion</td>
			</tr>
			<c:forEach items="${RESULTADO}" var="r" varStatus="i">
				<tr>
					<td>${r.idCliente}</td>
					<td>${r.nombre}</td>
					<td>${r.direccion}</td>
				</tr>
			</c:forEach>

		</table>
	</form>
</body>
</html>