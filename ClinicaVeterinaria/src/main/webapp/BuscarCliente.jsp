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