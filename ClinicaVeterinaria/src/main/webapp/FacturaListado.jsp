<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

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
	<form  name="f1" action="FacturaBuscarServlet" method="post">
		<table>
			<tr>
				<td>Fecha Inicio :</td>
				<td><input type="text" name="inicio"></td>
				<td>Fecha Fin :</td>
				<td><input type="text" name="fin"></td>
				<td><input type="submit" value="Buscar"></td>
			</tr>
			<tr>
			<td>Factura ID</td>
			<td>Serie </td>
			<td>Numero</td>
			<td>Fecha </td>
			<td>Cliente</td>
			</tr>
			<c:forEach items="${RESULTADO}" var="r" varStatus="i">
			<tr>
				<td>${r.idFactura}</td>
				<td>${r.serie}</td>
				<td>${r.numero}</td>
				<td>${r.fch_Factura}</td>
				<td>${r.ClienteNombre}</td>
			</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>