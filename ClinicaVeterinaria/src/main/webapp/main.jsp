<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>VeterinariaGozus</title>

<script type="text/javascript" src="css/jquery-latest.pack.js"></script>
<script type="text/javascript">
$(document).ready(function(){
   $("#nav a").each(function(){
      var href = $(this).attr("href");
      $(this).attr({ href: "#"});
      $(this).click(function(){
         $("#show").load(href);
      });
   });
});
</script>
<script>
	function validar(){
		
		var x = document.f1.txtUsuario.value;
		var y = document.f1.txtClave.value;
		
		if (x == "") {
			alert("Ingrese Usuario");
			return false;
		}
		
		if (y == "") {
			alert("Ingrese Clave");
			return false;
		}
		
		return true;
	
	}

</script>

<style type="text/css">
<!--
#cabecera {
	position: absolute;
	left: 294px;
	top: 167px;
	width: 100%;
	height: 20%;
	z-index: 1;
}

<!--
#show {
	position: absolute;
	left: 0;
	top: 35%;
	width: 100%;
	height: 85%;
	z-index: 2;
	background-color: #D1E09D;
}

#apDiv4 {
	position: absolute;
	left: 190px;
	top: 0px;
	width: 831px;
	height: 20%;
	z-index: 4;
	background-color: #D1E09D;
}

#cabecera_izq {
	position: absolute;
	left: 0;
	top: 0;
	width: 25%;
	height: 15%;
	z-index: 3;
}

#cabecera_der {
	position: absolute;
	left: 25%;
	top: 0;
	width: 75%;
	height: 15%;
	z-index: 4;
}

#nav {
	position: absolute;
	left: 0;
	top: 15%;
	width: 100%;
	height: 20%;
	z-index: 1;
	background-color: #D1E09D;
	overflow: automatico;
}

.Estilo1 {
	color: #003399;
	font-weight: bold;
}

.Estilo2 {
	color: #FFFFFF
}

#f_agregar {
	position: absolute;
	left: 0;
	top: 33%;
	width: 100%;
	height: 67%;
	z-index: 6;
}

.Estilo3 {
	color: #3366CC;
	font-weight: bold;
}
#apDiv1 {
	position:absolute;
	left:0;
	top:15%;
	width:100%;
	height:16%;
	z-index:5;
}
-->
</style>
</head>
<body bgcolor = #D1E09D link="#3366CC" vlink="#ffffff">
<font face="Verdana" size="2" color="">
<div id="apDiv1">
  <table width="100%" border="0">
    <tr>
      <td height="35" colspan="6"><div align="right">
      
      <span class="Estilo3">
      <c:out value="${sessionScope.MSJ_EXITO_LOGIN }" /> 
      </span><b> 
      <!--  
      <c:out value="${sessionScope.USUARIO_ACTUAL.nombre }" />
      -->
      </b> <span class="Estilo3">| <a href="LogoutServlet" class="Estilo3">Salir del sistema</a> </b></span> </div></td>
    </tr>
    <tr>
      <td height="26" colspan="6"><div align="center" class="Estilo3">BIENVENIDO</div></td>
    </tr>
    <tr>
      <td bgcolor="#6699FF"><div align="center"><span class="Estilo2"><a href="clientes.jsp">Cliente</a></span></div></td>
      <td bgcolor="#6699FF"><div align="center"><span class="Estilo2"><a href="Paciente.jsp">Paciente</a></span></div></td>
      <td bgcolor="#6699FF"><div align="center"><span class="Estilo2"><a href="ProductoBuscar.jsp">Productos</a></span></div></td>
      <td bgcolor="#6699FF"><div align="center"><span class="Estilo2"><a href="Factura.jsp">Factura</a></span></div></td>
      <td bgcolor="#6699FF"><div align="center"><span class="Estilo2"><a href="Prospecto.jsp">Prospecto</a></span></div></td>
      <td bgcolor="#6699FF"><div align="center"><span class="Estilo2"><a href="Doctor.jsp">Doctor</a></span></div></td>
    </tr>
  </table>
</div>
</font>
<div id="apDiv98"></div>
<div id="cabecera_izq">
		<a href="main.jsp"><img src="img/veterinariaGozus.jpg" alt="a"
			width="100%" height="96%" /></a>
</div>
	<div id="cabecera_der">
<img src="img/veterinariaGozus1.jpg" alt="a" width="100%"
			height="100%" /></div>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    </body>
</html>
