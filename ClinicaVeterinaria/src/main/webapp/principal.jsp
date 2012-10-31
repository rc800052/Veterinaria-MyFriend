<%@include file="ValidarSession.jsp"%>
<%@include file="cabecera.jsp"%>

Bienvenido al sistema:
<b>${sessionScope.USUARIO_ACTUAL.nombre }
	${sessionScope.USUARIO_ACTUAL.apellido }</b>
<br />
<a href="rolBuscar.jsp">Mantenimiento de Roles</a>
<br />
<a href="LogoutServlet">Salir del sistema</a>
<%@include file="pie.jsp"%>