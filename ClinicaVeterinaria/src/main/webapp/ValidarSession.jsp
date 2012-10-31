
<%@page import="clinicaveterinaria.modelo.Doctor"%>
<%

Doctor usuario_actual = (Doctor)session.getAttribute("USUARIO_ACTUAL");
if (usuario_actual == null){
	request.getRequestDispatcher("error.jsp").forward(request, response);
	return;
}

%>

