<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>VeterinariaGozus</title>
<style type="text/css">
#apDiv2 {
	position: absolute;
	left: 0;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 2;
	background-color: #D1E09D;
}
-->
</style>
</head>
<body>
	<div id="apDiv2">


		<%@include file="cabecera.jsp"%>
		<c:out value="${requestScope.MSJ_ERROR_LOGIN }" /> <a href="login.jsp">Regresar</a>
		<%@include file="pie.jsp"%>


	</div>
</body>
</html>

